package job;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class MailPushJob extends  Thread{

    @Autowired
    private UserService userService;

    private static int PER_PAGE_SIZE = 100;        //每次查询用户数量

    //邮单消息队列，运用无界阻塞队列
    private LinkedBlockingQueue<Integer> mailPushTaskQueue = new LinkedBlockingQueue<Integer>();

    public  void init(){
        System.out.print("userService: " +userService);
        start();                    //开启job
        System.out.println("Start MailPushJob sucess");
    }

    public  void cleanUp(){      //清理工作

    }

    public void addTask(Integer mailPushId){
        try {
            mailPushTaskQueue.put(mailPushId);  //放入阻塞队列
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try {
                int mailPushId = mailPushTaskQueue.take();

                System.out.println("mailPushId: "+mailPushId +" push begin!");
                buldMailPushUserByMailPushId(mailPushId);
                System.out.println("mailPushId: "+mailPushId +" push over!");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void buldMailPushUserByMailPushId(int mailPushId){
        int curPosition = 0 ;
        List<User> userList = userService.getPushUserIdList(curPosition,PER_PAGE_SIZE);

        while (!userList.isEmpty()){
            MailPushTask mailPushTask = new MailPushTask();
            mailPushTask.setMailPushId(mailPushId);
            mailPushTask.setUserList(userList);
            mailPushTask.run();

            curPosition += userList.size();    //增加查询起始位置
            userList = userService.getPushUserIdList(curPosition,PER_PAGE_SIZE); //继续执行
        }
    }


}
