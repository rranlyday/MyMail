package controller;

import model.Mail;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.MailService;
import service.OrderReciveService;
import service.ReceiverRemarkService;
import service.SenderRemarkService;
import util.StringUtil;
import util.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Administrator on 2016/5/24 0024.
 */

@Controller
@RequestMapping("/mailController")
public class MailController {

    @Autowired
    MailService mailService;

    @Autowired
    OrderReciveService orderReciveService;

    @Autowired
    SenderRemarkService senderRemarkService;

    @Autowired
    ReceiverRemarkService receiverRemarkService;

    //发布邮单
    @RequestMapping(value="/publishMail",method = RequestMethod.POST)
    public ModelAndView publishMail(String aimLinkman, String aimPhone, String aimAddress,Integer goodsTypeId,
                                    String goodsSize, String goodsWeight, Integer goodsNum,String aimTime, String pickUpTime,
                                    String pickUpLinkman, String pickUpPhone,String reward,String pickUpAddress, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            System.out.println("hello world!");
            System.out.println("aimTime: "+aimTime);
            System.out.println("pickUpTime: "+pickUpTime);
            System.out.println("reward: "+reward);
            System.out.println("pickUpAddress: "+pickUpAddress);
           User user =  (User)request.getSession().getAttribute("user");
            int userId = user.getId();
           int mailId =  mailService.publishMail(userId,aimLinkman,aimPhone,aimAddress,
                   goodsTypeId,goodsSize,goodsWeight,goodsNum, TimeUtil.strToDate(aimTime),TimeUtil.strToDate(pickUpTime),
                   pickUpLinkman,pickUpPhone,Long.parseLong(reward),pickUpAddress);
            if (mailId > 0 ){
                map.put("result", Boolean.TRUE);
                map.put("mailId",mailId);
                map.put("message", "发布邮;单成功！");
            }else{
                map.put("result", Boolean.FALSE);
                map.put("message", "发布邮单失败！");
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @RequestMapping(value="/uploadMailPhoto",method = RequestMethod.POST)
    public ModelAndView uploadMailPhoto(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        System.out.println("comeig on!1111");
        try {
            for (int modelAndView = 0; modelAndView < files.length; ++modelAndView) {
                System.out.println("fileName---------->" + files[modelAndView].getOriginalFilename());
                String photoPath = null;
                if (!files[modelAndView].isEmpty()) {
                    try {
                        String fileName = StringUtil.refileName() + files[modelAndView].getOriginalFilename();
                        String filePath = "/mailPic/" + fileName;
                        photoPath = filePath;
                        System.out.println(filePath);
                        String serverPath = request.getSession().getServletContext().getRealPath("/") +"mailPic/" + fileName;
                        FileOutputStream os = new FileOutputStream(StringUtil.getSysPath() + filePath);
                        FileOutputStream server = new FileOutputStream(serverPath);
                        FileInputStream in = (FileInputStream) files[modelAndView].getInputStream();
                        int b = 0;
                        while ((b = in.read()) != -1) {
                            os.write(b);
                            server.write(b);
                        }
                        os.flush();
                        os.close();
                        server.flush();
                        server.close();
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw  new Exception(e);
                    }
                }
            }
        } catch (Exception e) {
            map.put("result",Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //未接邮单
    @RequestMapping(value="/searchNotTakedMail",method = RequestMethod.POST)
    public ModelAndView searchNotTakedMail(int curPage,int pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            System.out.println("search not take mail!!");
            List<Mail> mailList =  mailService.searchNotTakedMailByTime(curPage, pageSize);

            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
            map.put("message", "执行出现出错！");
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //搜索邮单
    @RequestMapping(value="/searchMail",method = RequestMethod.POST)
    public ModelAndView searchMail(int curPage,int pageSize,String searchCondition) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            System.out.println("take mail!!");
            List<Mail> mailList =  mailService.searchMailByCondition(curPage, pageSize, searchCondition);

            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
            map.put("message", "执行出现出错！");
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //我发布未接邮单
    @RequestMapping(value="/searchMyPushNotPickUpMail",method = RequestMethod.POST)
    public ModelAndView searchMyPushNotPickUpMail(int curPage,int pageSize,HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            List<Mail> mailList = mailService.searchMyPushMailNotPickUpByUserId(userId, curPage, pageSize);
            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //我发的已接邮单
    @RequestMapping(value="/searchMyPushPickedMail",method = RequestMethod.POST)
    public ModelAndView searchMyPushPickedMail(int curPage,int pageSize,HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            List<Mail> mailList = mailService.searchMyPushMailPickdeByUserId(userId, curPage, pageSize);
            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //我发已接邮单
    @RequestMapping(value="/searchAllMyPushMail",method = RequestMethod.POST)
    public ModelAndView searchAllMyPushMail(int curPage,int pageSize,HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            List<Mail> mailList = mailService.searchAllMyPushMailUserId(userId, curPage, pageSize);
            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    //我发未接邮单总页数
    @RequestMapping(value="/searchNotPickUpdeMailPageNumByUserId",method = RequestMethod.POST)
    public ModelAndView searchNotPickUpdeMailPageNumByUserId(int pageSize,HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            Integer pageNum = mailService.searchhMyPushMailNotPickUpPageNumByUserId(userId,pageSize);
            map.put("pageNum",pageNum);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //未接邮单总页数
    @RequestMapping(value="/searchNotPickUpdeMailPageNum",method = RequestMethod.POST)
    public ModelAndView searchNotPickUpdeMailPageNum(int pageSize){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            Integer pageNum = mailService.searchhMyPushMailNotPickUpPageNum(pageSize);
            map.put("pageNum",pageNum);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
    //获取邮单ById
    @RequestMapping(value="/searchMailById",method = RequestMethod.POST)
    public ModelAndView searchMailById(Integer mailId){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            Mail mail = mailService.searchMailById(mailId);
            map.put("result", Boolean.TRUE);
            map.put("mail", mail);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //完成邮单
    @RequestMapping(value="/completeMailById",method = RequestMethod.POST)
    public ModelAndView completeMailById(Integer mailId){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
           if (mailService.completeMailById(mailId)>0){
               map.put("result", Boolean.TRUE);
           }else {
               map.put("result", Boolean.FALSE);
           }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //完成邮单
    @RequestMapping(value="/userMailType",method = RequestMethod.POST)
    public ModelAndView userMailType(Integer mailId,HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            Mail mail = mailService.searchMailById(mailId);
            Integer userType = 0;
            if (mail != null){
                if (mail.getUserId()==userId){
                    if (orderReciveService.getOrderReciveByMailmanIdAndMailId(mailId,userId) != null){
                        userType = 3;      //即使发单人也是接单人
                    }else {
                        userType = 1;     //发单人
                    }
                }else {
                    if(orderReciveService.getOrderReciveByMailmanIdAndMailId(mailId,userId) != null){
                        userType = 2;    //接单人
                    }else {
                        userType = 0 ;  //既不是发单人也不是接单人
                    }
                }
            }
           Boolean remarked = false;
            if (userType == 1 ||userType == 3){
                if (senderRemarkService.getSenderRemarkByMailId(mailId) !=null){
                    remarked = true ;
                }
            }else if (userType == 2){
                if (receiverRemarkService.getReceiverRemarkByMailId(mailId)!=null){
                    remarked = true;
                }
            }
            map.put("result", Boolean.TRUE);
            map.put("userType", userType);
            map.put("remarked", remarked);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
