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

    private static int PER_PAGE_SIZE = 100;        //ÿ�β�ѯ�û�����

    //�ʵ���Ϣ���У������޽���������
    private LinkedBlockingQueue<Integer> mailPushTaskQueue = new LinkedBlockingQueue<Integer>();

    public  void init(){
        System.out.print("userService: " +userService);
        start();                    //����job
        System.out.println("Start MailPushJob sucess");
    }

    public  void cleanUp(){      //������

    }

    public void addTask(Integer mailPushId){
        try {
            mailPushTaskQueue.put(mailPushId);  //������������
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

            curPosition += userList.size();    //���Ӳ�ѯ��ʼλ��
            userList = userService.getPushUserIdList(curPosition,PER_PAGE_SIZE); //����ִ��
        }
    }


}
