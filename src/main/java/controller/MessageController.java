package controller;

import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.MessageService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Controller
@RequestMapping("/messageController")
public class MessageController {

    @Autowired
    MessageService messageService;

    //������Ϣ
    @RequestMapping(value="/sendMessage",method = RequestMethod.POST)
    public ModelAndView sendMessage(int receiverId, String content,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        User user = (User)request.getSession().getAttribute("user");
        int senderId = user.getId();
        try {
            int messageId = messageService.buildMessage(senderId,receiverId,content);
            if (messageId > 0){
                map.put("result", Boolean.TRUE);
                map.put("message", "���ͳɹ���");
            }
            else{
                map.put("result", Boolean.FALSE);
                map.put("message", "����ʧ�ܣ�");
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


    //����δ����Ϣ
    @RequestMapping(value="/receiveMessage",method = RequestMethod.POST)
    public ModelAndView receiveMessage(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        User user = (User)request.getSession().getAttribute("user");
        int userId = user.getId();
        try {
            List<Message> messageList = messageService.searchNotReadMessageByReceiverId(userId);

            map.put("messageList",messageList);
            map.put("result", Boolean.TRUE);
            map.put("message", "��ѯ��Ϣ�ɹ���");
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

    //�����ϢΪ�Զ�״̬
    @RequestMapping(value="/readMessage",method = RequestMethod.POST)
    public ModelAndView readMessage(int messageId) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            int rs = messageService.updateMessageToReadById(messageId);
            if (rs > 0){
                map.put("result", Boolean.TRUE);
                map.put("message", "��ǳɹ���");
            }
            else{
                map.put("result", Boolean.FALSE);
                map.put("message", "���ʧ�ܣ�");
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
}
