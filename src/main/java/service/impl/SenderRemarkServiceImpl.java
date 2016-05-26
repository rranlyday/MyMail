package service.impl;

import dao.SenderRemarkMapper;
import model.SenderRemark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SenderRemarkService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Service("senderRemarkService")
public class SenderRemarkServiceImpl implements SenderRemarkService {

    @Autowired
    SenderRemarkMapper senderRemarkMapper;

    public int buildSenderRemark(Integer mailId, Integer grade, String remark, String photo) {
        SenderRemark senderRemark = new SenderRemark();
        senderRemark.setMailId(mailId);
        senderRemark.setGrade(grade);
        senderRemark.setRemark(remark);
        senderRemark.setPhoto(photo);

        Date time = TimeUtil.getNowSysTime();
        senderRemark.setTime(time);

        int row = senderRemarkMapper.insertSelective(senderRemark);
        return  senderRemark.getId();
    }

    public List<SenderRemark> searchSenderRemarkOrderByTime(int curPage, int pageSie) {
        int beginPos = curPage*pageSie;
        return  senderRemarkMapper.searchSenderRemarkOrderByTime(beginPos,pageSie);
    }
}
