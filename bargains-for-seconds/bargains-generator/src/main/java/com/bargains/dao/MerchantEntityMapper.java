package com.bargains.dao;

import com.bargains.entity.MerchantEntity;
import com.bargains.entity.MerchantEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MerchantEntityMapper {
    int countByExample(MerchantEntityExample example);

    int deleteByExample(MerchantEntityExample example);

    @Delete({
        "delete from merchant",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into merchant (name, shop_name, ",
        "account, password, ",
        "run_scope)",
        "values (#{name,jdbcType=VARCHAR}, #{shopName,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{runScope,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(MerchantEntity record);

    int insertSelective(MerchantEntity record);

    List<MerchantEntity> selectByExample(MerchantEntityExample example);

    @Select({
        "select",
        "id, name, shop_name, account, password, run_scope",
        "from merchant",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.bargains.dao.MerchantEntityMapper.BaseResultMap")
    MerchantEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantEntity record, @Param("example") MerchantEntityExample example);

    int updateByExample(@Param("record") MerchantEntity record, @Param("example") MerchantEntityExample example);

    int updateByPrimaryKeySelective(MerchantEntity record);

    @Update({
        "update merchant",
        "set name = #{name,jdbcType=VARCHAR},",
          "shop_name = #{shopName,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "run_scope = #{runScope,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MerchantEntity record);
}