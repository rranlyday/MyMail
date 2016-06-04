package controller;

import model.Mail;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.MailService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/24 0024.
 */

@Controller
@RequestMapping("/mailController")
public class MailController {

    @Autowired
    MailService mailService;

    //�����ʵ�
    @RequestMapping(value="/publishMail",method = RequestMethod.POST)
    public ModelAndView publishMail(String aimLinkman, String aimPhone, String aimAddress,Integer goodsTypeId,
                                    String goodsSize, String goodsWeight, Integer goodsNum,Date aimTime, Date pickUpTime,
                                    String pickUpLinkman, String pickUpPhone,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            System.out.println("hello world!");
            User user =  (User)request.getSession().getAttribute("user");
            int userId = user.getId();
           int mailId =  mailService.publishMail(userId,aimLinkman,aimPhone,aimAddress,
                   goodsTypeId,goodsSize,goodsWeight,goodsNum,aimTime,pickUpTime,
                   pickUpLinkman,pickUpPhone);
            if (mailId > 0 ){
                map.put("result", Boolean.TRUE);
                map.put("message", "�����ʵ��ɹ���");
            }else{
                map.put("result", Boolean.FALSE);
                map.put("message", "�����ʵ�ʧ�ܣ�");
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    //δ���ʵ�
    @RequestMapping(value="/searchNotTakedMail",method = RequestMethod.POST)
    public ModelAndView searchNotTakedMail(int curPage,int pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<Mail> mailList =  mailService.searchNotTakedMailByTime(curPage, pageSize);

            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
            map.put("message", "ִ�г��ֳ���");
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //�����ʵ�
    @RequestMapping(value="/searchMail",method = RequestMethod.POST)
    public ModelAndView searchMail(int curPage,int pageSize,String searchCondition) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<Mail> mailList =  mailService.searchMailByCondition(curPage, pageSize, searchCondition);

            map.put("mailList",mailList);
            map.put("result", Boolean.TRUE);
            map.put("message", "ִ�г��ֳ���");
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //�ҷ���δ���ʵ�
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
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //�ҷ����ѽ��ʵ�
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
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //�ҷ��ѽ��ʵ�
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
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    //�ҷ�δ���ʵ���ҳ��
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
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //δ���ʵ���ҳ��
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
            map.put("message", "ִ�г��ֳ���");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
