package service.impl;

import dao.OrderReciveMapper;
import model.OrderRecive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MailService;
import service.OrderReciveService;

import java.util.List;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
@Service("orderReciveService")
public class OrderReciveServiceImpl implements OrderReciveService{

    @Autowired
    OrderReciveMapper orderReciveMapper;

    @Autowired
    MailService mailService;

    public int recive(Integer mailId, Integer mailmanId) {
        OrderRecive orderRecive = new OrderRecive();
        orderRecive.setMailId(mailId);
        orderRecive.setMailmanId(mailmanId);
      if(orderReciveMapper.insertSelective(orderRecive)>0){
          mailService.recivedeMailById(mailId);
       }
        return 1;
    }

    public OrderRecive getOrderReciveByMailmanIdAndMailId(Integer mailId, Integer mailmanId) {
        return orderReciveMapper.getOrderReciveByMailmanIdAndMailId(mailId,mailmanId);
    }

    public List<OrderRecive> getOrderReciveByMailmanId(Integer mailmanId, int curPage, int pageSize) {
        int beginPos = curPage * pageSize;
        return orderReciveMapper.getOrderReciveByMailmanId(mailmanId,beginPos,pageSize);
    }

    public int getOrderReciveByMailmanIdPageNum(Integer mailmanId) {
        return orderReciveMapper.getOrderReciveByMailmanIdPageNum(mailmanId);
    }
}
