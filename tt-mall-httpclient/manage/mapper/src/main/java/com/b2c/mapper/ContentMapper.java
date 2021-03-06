package com.b2c.mapper;

import com.b2c.pojo.Content;
import com.b2c.pojo.ContentExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int countByExample(ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int deleteByExample(ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tb_content",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tb_content (category_id, title, ",
        "sub_title, title_desc, ",
        "url, pic, pic2, ",
        "created, updated, ",
        "content)",
        "values (#{categoryId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{subTitle,jdbcType=VARCHAR}, #{titleDesc,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{pic,jdbcType=VARCHAR}, #{pic2,jdbcType=VARCHAR}, ",
        "#{created,jdbcType=TIMESTAMP}, #{updated,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Content record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int insertSelective(Content record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    List<Content> selectByExampleWithBLOBs(ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    List<Content> selectByExample(ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, category_id, title, sub_title, title_desc, url, pic, pic2, created, updated, ",
        "content",
        "from tb_content",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.b2c.mapper.ContentMapper.ResultMapWithBLOBs")
    Content selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Content record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    @Update({
        "update tb_content",
        "set category_id = #{categoryId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "title_desc = #{titleDesc,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "pic2 = #{pic2,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Content record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_content
     *
     * @mbggenerated
     */
    @Update({
        "update tb_content",
        "set category_id = #{categoryId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "title_desc = #{titleDesc,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "pic = #{pic,jdbcType=VARCHAR},",
          "pic2 = #{pic2,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Content record);
}