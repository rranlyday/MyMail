package service.impl;

import dao.MessageMapper;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MessageService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageMapper messageMapper;

    public int buildMessage(Integer senderId, Integer receiverId, String content) {
        Message message = new Message();
        message.setContent(content);
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setLookUp(0);              //��Ϣ״̬Ϊδ�鿴
        Date sendTime = TimeUtil.getNowSysTime();
        message.setSendTime(sendTime);

        int row =  messageMapper.insertSelective(message);
        return  message.getId();
    }

    public List<Message> searchNotReadMessageByReceiverId(int receiverId) {

        return messageMapper.searchNotReadMessageByReceiverId(receiverId);
    }

    public int updateMessageToReadById(int messageId) {
        Message message = new Message();
        message.setId(messageId);
        message.setLookUp(1);   //������Ϣ״̬Ϊ�Ѷ�

        return messageMapper.updateByPrimaryKeySelective(message);
    }
}
