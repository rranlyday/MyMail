package service;

import model.ReceiverRemark;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface ReceiverRemarkService {

    int buildReceiverRemark(Integer mailId,Integer grade,String remark,String photo);

    List<ReceiverRemark>  searchReceiverRemarkOrderByTime(int curPage,int pageSie);

    ReceiverRemark getReceiverRemarkByMailId(Integer mailId);
}
