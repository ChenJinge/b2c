package com.bargains.dao;

import com.bargains.entity.ProductEntity;
import com.bargains.entity.ProductEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ProductEntityMapper {
    int countByExample(ProductEntityExample example);

    int deleteByExample(ProductEntityExample example);

    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product (product_id, merchant_id, ",
        "origin_place, name, ",
        "brand_name, weight, ",
        "specification, detail_picture)",
        "values (#{productId,jdbcType=INTEGER}, #{merchantId,jdbcType=INTEGER}, ",
        "#{originPlace,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{brandName,jdbcType=VARCHAR}, #{weight,jdbcType=VARCHAR}, ",
        "#{specification,jdbcType=VARCHAR}, #{detailPicture,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ProductEntity record);

    int insertSelective(ProductEntity record);

    List<ProductEntity> selectByExample(ProductEntityExample example);

    @Select({
        "select",
        "id, product_id, merchant_id, origin_place, name, brand_name, weight, specification, ",
        "detail_picture",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.bargains.dao.ProductEntityMapper.BaseResultMap")
    ProductEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductEntity record, @Param("example") ProductEntityExample example);

    int updateByExample(@Param("record") ProductEntity record, @Param("example") ProductEntityExample example);

    int updateByPrimaryKeySelective(ProductEntity record);

    @Update({
        "update product",
        "set product_id = #{productId,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=INTEGER},",
          "origin_place = #{originPlace,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "brand_name = #{brandName,jdbcType=VARCHAR},",
          "weight = #{weight,jdbcType=VARCHAR},",
          "specification = #{specification,jdbcType=VARCHAR},",
          "detail_picture = #{detailPicture,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductEntity record);
}