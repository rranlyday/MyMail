package controller;

import DTO.MailPushMessageDTO;
import model.MailPush;
import model.MailPushUser;
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

    //邮单推送
    @RequestMapping(value="/mailPushMessage",method = RequestMethod.POST)
    public ModelAndView mailPushMessage(int userId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        System.out.println(" I am coming!!!");
        try {
            List<MailPushUser> mailPushUserList = mailPushUserService.selectNotArriveMailPushUserByUserId(userId);
            List<MailPushMessageDTO> mailPushMessageDTOList = new ArrayList<MailPushMessageDTO>();
            for (MailPushUser mailPushUser:mailPushUserList){

                MailPush mailPush = mailPushService.selectMailPushById(mailPushUser.getMailPushId());

                MailPushMessageDTO mailPushMessageDTO = new MailPushMessageDTO();
                mailPushMessageDTO.setMailPush(mailPush);
                mailPushMessageDTO.setMailPushUser(mailPushUser);

                mailPushMessageDTOList.add(mailPushMessageDTO);
            }
            map.put("result", Boolean.TRUE);
            map.put("message", "推送成功！");
            map.put("mailPushMessageDTOList",mailPushMessageDTOList);
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
