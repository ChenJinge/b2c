package com.b2c.mapper;

import com.b2c.pojo.ItemParamItem;
import com.b2c.pojo.ItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ItemParamItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int countByExample(ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int deleteByExample(ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tb_item_param_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tb_item_param_item (item_id, created, ",
        "updated, param_data)",
        "values (#{itemId,jdbcType=BIGINT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP}, #{paramData,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int insertSelective(ItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    List<ItemParamItem> selectByExampleWithBLOBs(ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    List<ItemParamItem> selectByExample(ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, item_id, created, updated, param_data",
        "from tb_item_param_item",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.b2c.mapper.ItemParamItemMapper.ResultMapWithBLOBs")
    ItemParamItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ItemParamItem record, @Param("example") ItemParamItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    @Update({
        "update tb_item_param_item",
        "set item_id = #{itemId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "param_data = #{paramData,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ItemParamItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param_item
     *
     * @mbggenerated
     */
    @Update({
        "update tb_item_param_item",
        "set item_id = #{itemId,jdbcType=BIGINT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ItemParamItem record);
}