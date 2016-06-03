package service.impl;

import dao.OrderReciveMapper;
import model.OrderRecive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderReciveService;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
@Service("orderReciveService")
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
