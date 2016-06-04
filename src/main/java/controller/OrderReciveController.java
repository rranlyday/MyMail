package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.OrderReciveService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
@Controller
@RequestMapping("/orderReciveController")
public class OrderReciveController {

    @Autowired
    OrderReciveService orderReciveService;

    //发送消息
    @RequestMapping(value="/recive",method = RequestMethod.POST)
    public ModelAndView recive(Integer mailId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        User user = (User)request.getSession().getAttribute("user");
        int mailmanId = user.getId();
        try {
            if(orderReciveService.recive(mailId,mailmanId)>0){
                map.put("result", Boolean.TRUE);
            }else{
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


}
