package controller;

import DTO.MailPushMessageDTO;
import model.MailPush;
import model.MailPushUser;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.MailPushService;
import service.MailPushUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
@Controller
@RequestMapping("/mailPushMessageController")
public class MailPushMessageController {

    @Autowired
    MailPushUserService mailPushUserService;

    @Autowired
    MailPushService mailPushService;

    //推送邮单消息
    @RequestMapping(value="/mailPushMessage",method = RequestMethod.POST)
    public ModelAndView mailPushMessage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            if (user != null){
                Integer userId = user.getId();
                List<MailPushUser> mailPushUserList = mailPushUserService.selectNotArriveMailPushUserByUserId(userId);
                List<MailPush> mailPushList = new ArrayList<MailPush>();
                for (MailPushUser mailPushUser:mailPushUserList){
                    MailPush mailPush = mailPushService.selectMailPushById(mailPushUser.getMailPushId());
                    mailPushList.add(mailPush);
                    mailPushUserService.readMailPushMessage(mailPushUser.getId());
                }
                if (!mailPushList.isEmpty()){
                    map.put("result", Boolean.TRUE);
                    map.put("mailPushList", mailPushList);
                }else{
                    map.put("result", Boolean.FALSE);
                }
            }else{
                map.put("result", Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行异常！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    //阅读邮单消息
    @RequestMapping(value="/readMailPushMessage",method = RequestMethod.POST)
    public ModelAndView readMailPushMessage(Integer mailPushUserId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (mailPushUserService.readMailPushMessage(mailPushUserId)>0){
                map.put("result", Boolean.TRUE);
            }else{
                map.put("result", Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行异常！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

}
