package com.bdtrip.mobile.line.dao;

import com.bdtrip.mobile.line.entity.TagsRelateEntity;
import com.bdtrip.mobile.line.entity.TagsRelateEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface TagsRelateEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    int countByExample(TagsRelateEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    int deleteByExample(TagsRelateEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    @Delete({
        "delete from bd_business_tags_relate",
        "where relate_id = #{relateId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long relateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    @Insert({
        "insert into bd_business_tags_relate (supplier_id, target_value, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "deleted)",
        "values (#{supplierId,jdbcType=VARCHAR}, #{targetValue,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="relateId", before=false, resultType=Long.class)
    int insert(TagsRelateEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    int insertSelective(TagsRelateEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    List<TagsRelateEntity> selectByExample(TagsRelateEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "relate_id, supplier_id, target_value, create_by, create_time, update_by, update_time, ",
        "deleted",
        "from bd_business_tags_relate",
        "where relate_id = #{relateId,jdbcType=BIGINT}"
    })
    @ResultMap("com.bdtrip.mobile.line.dao.TagsRelateEntityMapper.BaseResultMap")
    TagsRelateEntity selectByPrimaryKey(Long relateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TagsRelateEntity record, @Param("example") TagsRelateEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TagsRelateEntity record, @Param("example") TagsRelateEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TagsRelateEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_tags_relate
     *
     * @mbggenerated
     */
    @Update({
        "update bd_business_tags_relate",
        "set supplier_id = #{supplierId,jdbcType=VARCHAR},",
          "target_value = #{targetValue,jdbcType=VARCHAR},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where relate_id = #{relateId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TagsRelateEntity record);
}