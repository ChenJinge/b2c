package com.bargains.dao;

import com.bargains.entity.BargainsEntity;
import com.bargains.entity.BargainsEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface BargainsEntityMapper {
    int countByExample(BargainsEntityExample example);

    int deleteByExample(BargainsEntityExample example);

    @Delete({
        "delete from bargains",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into bargains (product_id, title, ",
        "picture, original_price, ",
        "bargains_price, merchant_id, ",
        "apply_date, audit_date, ",
        "audit_status, start_time, ",
        "end_time, count, ",
        "stock, description)",
        "values (#{productId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{picture,jdbcType=VARCHAR}, #{originalPrice,jdbcType=DECIMAL}, ",
        "#{bargainsPrice,jdbcType=DECIMAL}, #{merchantId,jdbcType=INTEGER}, ",
        "#{applyDate,jdbcType=TIMESTAMP}, #{auditDate,jdbcType=TIMESTAMP}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{count,jdbcType=INTEGER}, ",
        "#{stock,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(BargainsEntity record);

    int insertSelective(BargainsEntity record);

    List<BargainsEntity> selectByExample(BargainsEntityExample example);

    @Select({
        "select",
        "id, product_id, title, picture, original_price, bargains_price, merchant_id, ",
        "apply_date, audit_date, audit_status, start_time, end_time, count, stock, description",
        "from bargains",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.bargains.dao.BargainsEntityMapper.BaseResultMap")
    BargainsEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BargainsEntity record, @Param("example") BargainsEntityExample example);

    int updateByExample(@Param("record") BargainsEntity record, @Param("example") BargainsEntityExample example);

    int updateByPrimaryKeySelective(BargainsEntity record);

    @Update({
        "update bargains",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "picture = #{picture,jdbcType=VARCHAR},",
          "original_price = #{originalPrice,jdbcType=DECIMAL},",
          "bargains_price = #{bargainsPrice,jdbcType=DECIMAL},",
          "merchant_id = #{merchantId,jdbcType=INTEGER},",
          "apply_date = #{applyDate,jdbcType=TIMESTAMP},",
          "audit_date = #{auditDate,jdbcType=TIMESTAMP},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "count = #{count,jdbcType=INTEGER},",
          "stock = #{stock,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BargainsEntity record);
}