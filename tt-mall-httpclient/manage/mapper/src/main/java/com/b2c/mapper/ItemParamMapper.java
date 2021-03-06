package com.b2c.mapper;

import com.b2c.pojo.ItemParam;
import com.b2c.pojo.ItemParamExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ItemParamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int countByExample(ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int deleteByExample(ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tb_item_param",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tb_item_param (item_cat_id, created, ",
        "updated, param_data)",
        "values (#{itemCatId,jdbcType=BIGINT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP}, #{paramData,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int insertSelective(ItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    List<ItemParam> selectByExampleWithBLOBs(ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    List<ItemParam> selectByExample(ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, item_cat_id, created, updated, param_data",
        "from tb_item_param",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.b2c.mapper.ItemParamMapper.ResultMapWithBLOBs")
    ItemParam selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ItemParam record, @Param("example") ItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    @Update({
        "update tb_item_param",
        "set item_cat_id = #{itemCatId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "param_data = #{paramData,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated
     */
    @Update({
        "update tb_item_param",
        "set item_cat_id = #{itemCatId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemParam record);
}