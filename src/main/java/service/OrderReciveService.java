package service;

import model.OrderRecive;

import java.util.List;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public interface OrderReciveService {
    int recive(Integer mailId,Integer mailmanId);

    OrderRecive getOrderReciveByMailmanIdAndMailId(Integer mailId,Integer mailmanId);

    List<OrderRecive> getOrderReciveByMailmanId(Integer mailmanId,int curPage,int pageSize);

    int getOrderReciveByMailmanIdPageNum(Integer mailmanId);
}
