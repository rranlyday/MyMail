package util;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/4 0004.
 */
public class Main {

    public static  void  main(String[] args) throws Exception{
        String time = "2016-05-12 45:12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(time);
        System.out.println(date);
    }

}
