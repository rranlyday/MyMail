package service;

import model.OrderRecive;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public interface OrderReciveService {
    int recive(Integer mailId,Integer mailmanId);

    OrderRecive getOrderReciveByMailmanIdAndMailId(Integer mailId,Integer mailmanId);
}
