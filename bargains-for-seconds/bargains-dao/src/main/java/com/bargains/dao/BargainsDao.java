package com.bargains.dao;

import com.bargains.entity.BargainsEntity;
import com.bargains.vo.bargains.BargainsVo;

import java.util.List;

public interface BargainsDao {
    void applyBargains(BargainsEntity bargainsEntity);

    List<BargainsEntity> listBargains(BargainsVo bargainsVo);

    BargainsEntity queryBargainsById(int id);

    void deleteBargainsById(int id);

    void updateBargains(BargainsEntity bargainsEntity);

    void updateBargainsStatus(BargainsVo bargainsVo);
}
