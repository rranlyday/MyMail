package service;

import model.Message;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface MessageService {

    int buildMessage(Integer senderId, Integer receiverId,String content);

    List<Message> searchNotReadMessageByReceiverId(int receiverId);

    int updateMessageToReadById(int messageId);
}
