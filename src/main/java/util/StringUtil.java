package util;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public class StringUtil {
    public  static  String refileName(){
        Long time = new Date().getTime();
        return  time.toString();
    }

    public static  String getSysPath(){
        String path =  "D:/myproject/MyMail/src/main/webapp";
        return  path;
    }
}
