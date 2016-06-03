package service.impl;

import dao.OrderReciveMapper;
import model.OrderRecive;
import org.springframework.beans.factory.annotation.Autowired;
import service.OrderReciveService;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class OrderReciveServiceImpl implements OrderReciveService{

    @Autowired
    OrderReciveMapper orderReciveMapper;

    public int recive(Integer mailId, Integer mailmanId) {
        OrderRecive orderRecive = new OrderRecive();
        orderRecive.setMailId(mailId);
        orderRecive.setMailmanId(mailmanId);
        orderReciveMapper.insertSelective(orderRecive);
        return 0;
    }

}
