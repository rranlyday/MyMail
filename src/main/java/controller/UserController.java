package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.UserService;
import util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/16 0016.
 */
@RequestMapping("/userController")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView login(String loginName, String password,
                              HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        System.out.println(" I am coming!!!");
        try {
            User user = userService.login(loginName, password);
            if (user != null && user.getId() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
                map.put("user",user);
                System.out.println("登录成功！！");
            } else {
                map.put("result", Boolean.FALSE);
                map.put("message", "用户名或密码填写错误！");
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

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView register(String cellPhone, String password,
                                 String idcard,String fullName,
                               HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        System.out.println(" I am coming!!!register");
        try {
           int rs  = userService.register(cellPhone, password, idcard,fullName);
            if (rs > 0){
                map.put("result", Boolean.TRUE);
                map.put("message", "注册成功！");
            }
            else {
                map.put("result", Boolean.FALSE);
                map.put("message", "注册失败！");
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

    @RequestMapping(value="/loginOut",method = RequestMethod.POST)
    public ModelAndView loginOut(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            HttpSession session = request.getSession();
            session.invalidate();
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

}
