package com.bdtrip.mobile.line.dao;

import com.bdtrip.mobile.line.entity.LineGroupInfoEntity;
import com.bdtrip.mobile.line.entity.LineGroupInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface LineGroupInfoEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    int countByExample(LineGroupInfoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    int deleteByExample(LineGroupInfoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    @Delete({
        "delete from bd_business_line_group_info",
        "where group_id = #{groupId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    @Insert({
        "insert into bd_business_line_group_info (line_id, supplier_id, ",
        "line_code, order_number, ",
        "guest_type, guest_description, ",
        "start_time, end_time, ",
        "send_group_type, send_group_time, ",
        "cost_includes, cost_uncludes, ",
        "refund_notice, booking_notice, ",
        "audit_status, online_status, ",
        "create_by, create_time, ",
        "update_by, update_time, ",
        "deleted)",
        "values (#{lineId,jdbcType=BIGINT}, #{supplierId,jdbcType=BIGINT}, ",
        "#{lineCode,jdbcType=VARCHAR}, #{orderNumber,jdbcType=INTEGER}, ",
        "#{guestType,jdbcType=INTEGER}, #{guestDescription,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=VARCHAR}, #{endTime,jdbcType=VARCHAR}, ",
        "#{sendGroupType,jdbcType=INTEGER}, #{sendGroupTime,jdbcType=VARCHAR}, ",
        "#{costIncludes,jdbcType=VARCHAR}, #{costUncludes,jdbcType=VARCHAR}, ",
        "#{refundNotice,jdbcType=VARCHAR}, #{bookingNotice,jdbcType=VARCHAR}, ",
        "#{auditStatus,jdbcType=INTEGER}, #{onlineStatus,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{deleted,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="groupId", before=false, resultType=Long.class)
    int insert(LineGroupInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    int insertSelective(LineGroupInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    List<LineGroupInfoEntity> selectByExample(LineGroupInfoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "group_id, line_id, supplier_id, line_code, order_number, guest_type, guest_description, ",
        "start_time, end_time, send_group_type, send_group_time, cost_includes, cost_uncludes, ",
        "refund_notice, booking_notice, audit_status, online_status, create_by, create_time, ",
        "update_by, update_time, deleted",
        "from bd_business_line_group_info",
        "where group_id = #{groupId,jdbcType=BIGINT}"
    })
    @ResultMap("com.bdtrip.mobile.line.dao.LineGroupInfoEntityMapper.BaseResultMap")
    LineGroupInfoEntity selectByPrimaryKey(Long groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") LineGroupInfoEntity record, @Param("example") LineGroupInfoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") LineGroupInfoEntity record, @Param("example") LineGroupInfoEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LineGroupInfoEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bd_business_line_group_info
     *
     * @mbggenerated
     */
    @Update({
        "update bd_business_line_group_info",
        "set line_id = #{lineId,jdbcType=BIGINT},",
          "supplier_id = #{supplierId,jdbcType=BIGINT},",
          "line_code = #{lineCode,jdbcType=VARCHAR},",
          "order_number = #{orderNumber,jdbcType=INTEGER},",
          "guest_type = #{guestType,jdbcType=INTEGER},",
          "guest_description = #{guestDescription,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=VARCHAR},",
          "end_time = #{endTime,jdbcType=VARCHAR},",
          "send_group_type = #{sendGroupType,jdbcType=INTEGER},",
          "send_group_time = #{sendGroupTime,jdbcType=VARCHAR},",
          "cost_includes = #{costIncludes,jdbcType=VARCHAR},",
          "cost_uncludes = #{costUncludes,jdbcType=VARCHAR},",
          "refund_notice = #{refundNotice,jdbcType=VARCHAR},",
          "booking_notice = #{bookingNotice,jdbcType=VARCHAR},",
          "audit_status = #{auditStatus,jdbcType=INTEGER},",
          "online_status = #{onlineStatus,jdbcType=INTEGER},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "deleted = #{deleted,jdbcType=INTEGER}",
        "where group_id = #{groupId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LineGroupInfoEntity record);
}