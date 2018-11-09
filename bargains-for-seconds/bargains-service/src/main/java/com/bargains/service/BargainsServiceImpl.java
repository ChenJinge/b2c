package com.bargains.service;

import com.bargains.dao.BargainsDao;
import com.bargains.enity.BargainsEntity;
import com.bargains.vo.bargains.BargainsVo;
import com.bargains.vo.bargains.CustomBargains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BargainsServiceImpl implements BargainsService {

    @Autowired
    BargainsDao bargainsDao;

    public void applyProduct(BargainsEntity bargainsEntity) {

        String startTime = bargainsEntity.getStartTime().toString();
        String endTime = bargainsEntity.getEndTime().toString();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startTimeDate = dateformat.parse(startTime);
            bargainsEntity.setStartTime(startTimeDate);
            Date endTimeDate = dateformat.parse(endTime);
            bargainsEntity.setEndTime(endTimeDate);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bargainsEntity.setApplyDate(new Date());
        bargainsEntity.setAuditStatus(1);

        bargainsDao.applyBargains(bargainsEntity);
    }

    public List<BargainsEntity> listProduct(BargainsVo bargainsVo) {
        return bargainsDao.listBargains(bargainsVo);
    }

    public BargainsEntity queryProductById(int id) {
        return bargainsDao.queryBargainsById(id);
    }

    public void deleteProductById(int id) {
        bargainsDao.deleteBargainsById(id);
    }

    public void updateProduct(BargainsEntity bargainsEntity) {

        String startTime = bargainsEntity.getStartTime().toString();
        String endTime = bargainsEntity.getEndTime().toString();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date startTimeDate = dateformat.parse(startTime);
            bargainsEntity.setStartTime(startTimeDate);
            Date endTimeDate = dateformat.parse(endTime);
            bargainsEntity.setEndTime(endTimeDate);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bargainsDao.updateBargains(bargainsEntity);
    }

    public void updateProductState(int id, int state) {

        BargainsVo bargainsVo = new BargainsVo();
        CustomBargains customBargains = new CustomBargains();

        customBargains.setId(id);
        customBargains.setAuditStatus(state);
        bargainsVo.setCustomBargains(customBargains);

        bargainsDao.updateBargainsStatus(bargainsVo);
    }


}
