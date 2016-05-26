package service.impl;

import dao.ReceiverRemarkMapper;
import model.ReceiverRemark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ReceiverRemarkService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Service("receiverRemarkService")
public class ReceiverRemarkServiceImpl implements ReceiverRemarkService {

    @Autowired
    ReceiverRemarkMapper receiverRemarkMapper;

    public int buildReceiverRemark(Integer mailId, Integer grade, String remark, String photo) {
        ReceiverRemark receiverRemark = new ReceiverRemark();
        receiverRemark.setPhoto(photo);
        receiverRemark.setRemark(remark);
        receiverRemark.setGrade(grade);
        receiverRemark.setMailId(mailId);

        Date time = TimeUtil.getNowSysTime();
        receiverRemark.setTime(time);

        int row =  receiverRemarkMapper.insertSelective(receiverRemark);
        return  receiverRemark.getId();
    }

    public List<ReceiverRemark> searchReceiverRemarkOrderByTime(int curPage, int pageSie) {
        int beginPos = curPage*pageSie;

        return receiverRemarkMapper.searchReceiverRemarkOrderByTime(beginPos,pageSie);
    }
}
