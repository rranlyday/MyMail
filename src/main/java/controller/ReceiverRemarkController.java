package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.ReceiverRemarkService;
import util.StringUtil;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Controller
@RequestMapping("/receiverRemarkController")
public class ReceiverRemarkController {

    @Autowired
    ReceiverRemarkService receiverRemarkService;

    //接单人评论 有图版
    @RequestMapping(value="/receiverRemark",method = RequestMethod.POST)
    public ModelAndView receiverRemark(Integer mailId,Integer grade,String remark,
                                     @RequestParam("file") CommonsMultipartFile[] files) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {

            for (int modelAndView = 0; modelAndView < files.length; ++modelAndView) {
                System.out.println("fileName---------->" + files[modelAndView].getOriginalFilename());
                if (!files[modelAndView].isEmpty()) {
                    int pre = (int) System.currentTimeMillis();
                    try {
                        String photoPath = "/picture/" + StringUtil.refileName() + files[modelAndView].getOriginalFilename();
                        System.out.println(photoPath);
                        FileOutputStream os = new FileOutputStream(StringUtil.getSysPath() + photoPath);
                        ByteArrayInputStream in = (ByteArrayInputStream) files[modelAndView].getInputStream();

                        int b = 0;
                        while ((b = in.read()) != -1) {
                            os.write(b);
                        }
                        os.flush();
                        os.close();
                        in.close();
                        int finaltime = (int) System.currentTimeMillis();
                        System.out.println(finaltime - pre);
                        int rs =  receiverRemarkService.buildReceiverRemark(mailId,grade,remark,photoPath);
                        if (rs > 0){
                            map.put("result", Boolean.TRUE);
                        }
                        else {
                            map.put("result", Boolean.FALSE);
                        }
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("�ϴ�����");
                    }
                }
            }
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //接单人评论 无图版
    @RequestMapping(value="/receiverRemarkNoPic",method = RequestMethod.POST)
    public ModelAndView receiverRemarkNoPic(Integer mailId,Integer grade,String remark) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
           int rs =  receiverRemarkService.buildReceiverRemark(mailId,grade,remark,null);
            if (rs > 0){
                map.put("result", Boolean.TRUE);
            }
            else {
                map.put("result", Boolean.FALSE);
            }
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
