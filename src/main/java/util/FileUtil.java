package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
public class FileUtil {
    private  static String IP;
    private  static String PORT;
    static {
        Properties prop = new Properties();
        try{
            //读取属性文件a.properties
            System.out.println();
            InputStream in = new BufferedInputStream(new FileInputStream(
                    Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath()+"filePath.properties"));
            prop.load(in);     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                if (key.equals("IP")){
                    IP = prop.getProperty(key);
                }
                if (key.equals("PORT")){
                    PORT = prop.getProperty(key);
                }
            }
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public  static String getIpPort(){
        return IP+":"+PORT ;
    }
}

