package service;


import model.SenderRemark;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface SenderRemarkService {

    int buildSenderRemark(Integer mailId,Integer grade,String remark,String photo);

    List<SenderRemark> searchSenderRemarkOrderByTime(int curPage,int pageSie);

    SenderRemark getSenderRemarkByMailId(Integer mailId);

}
