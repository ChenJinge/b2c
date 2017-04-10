package com.bdtrip.mobile.line.entity;

import java.util.Date;

public class LineGroupInfoEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.group_id
     *
     * @mbggenerated
     */
    private Long groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.line_id
     *
     * @mbggenerated
     */
    private Long lineId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.supplier_id
     *
     * @mbggenerated
     */
    private Long supplierId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.line_code
     *
     * @mbggenerated
     */
    private String lineCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.order_number
     *
     * @mbggenerated
     */
    private Integer orderNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.guest_type
     *
     * @mbggenerated
     */
    private Integer guestType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.guest_description
     *
     * @mbggenerated
     */
    private String guestDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.start_time
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.end_time
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.send_group_type
     *
     * @mbggenerated
     */
    private Integer sendGroupType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.send_group_time
     *
     * @mbggenerated
     */
    private String sendGroupTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.cost_includes
     *
     * @mbggenerated
     */
    private String costIncludes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.cost_uncludes
     *
     * @mbggenerated
     */
    private String costUncludes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.refund_notice
     *
     * @mbggenerated
     */
    private String refundNotice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.booking_notice
     *
     * @mbggenerated
     */
    private String bookingNotice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.audit_status
     *
     * @mbggenerated
     */
    private Integer auditStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.online_status
     *
     * @mbggenerated
     */
    private Integer onlineStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.create_by
     *
     * @mbggenerated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.update_by
     *
     * @mbggenerated
     */
    private Integer updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bd_business_line_group_info.deleted
     *
     * @mbggenerated
     */
    private Integer deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.group_id
     *
     * @return the value of bd_business_line_group_info.group_id
     *
     * @mbggenerated
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.group_id
     *
     * @param groupId the value for bd_business_line_group_info.group_id
     *
     * @mbggenerated
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.line_id
     *
     * @return the value of bd_business_line_group_info.line_id
     *
     * @mbggenerated
     */
    public Long getLineId() {
        return lineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.line_id
     *
     * @param lineId the value for bd_business_line_group_info.line_id
     *
     * @mbggenerated
     */
    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.supplier_id
     *
     * @return the value of bd_business_line_group_info.supplier_id
     *
     * @mbggenerated
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.supplier_id
     *
     * @param supplierId the value for bd_business_line_group_info.supplier_id
     *
     * @mbggenerated
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.line_code
     *
     * @return the value of bd_business_line_group_info.line_code
     *
     * @mbggenerated
     */
    public String getLineCode() {
        return lineCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.line_code
     *
     * @param lineCode the value for bd_business_line_group_info.line_code
     *
     * @mbggenerated
     */
    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.order_number
     *
     * @return the value of bd_business_line_group_info.order_number
     *
     * @mbggenerated
     */
    public Integer getOrderNumber() {
        return orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.order_number
     *
     * @param orderNumber the value for bd_business_line_group_info.order_number
     *
     * @mbggenerated
     */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.guest_type
     *
     * @return the value of bd_business_line_group_info.guest_type
     *
     * @mbggenerated
     */
    public Integer getGuestType() {
        return guestType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.guest_type
     *
     * @param guestType the value for bd_business_line_group_info.guest_type
     *
     * @mbggenerated
     */
    public void setGuestType(Integer guestType) {
        this.guestType = guestType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.guest_description
     *
     * @return the value of bd_business_line_group_info.guest_description
     *
     * @mbggenerated
     */
    public String getGuestDescription() {
        return guestDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.guest_description
     *
     * @param guestDescription the value for bd_business_line_group_info.guest_description
     *
     * @mbggenerated
     */
    public void setGuestDescription(String guestDescription) {
        this.guestDescription = guestDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.start_time
     *
     * @return the value of bd_business_line_group_info.start_time
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.start_time
     *
     * @param startTime the value for bd_business_line_group_info.start_time
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.end_time
     *
     * @return the value of bd_business_line_group_info.end_time
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.end_time
     *
     * @param endTime the value for bd_business_line_group_info.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.send_group_type
     *
     * @return the value of bd_business_line_group_info.send_group_type
     *
     * @mbggenerated
     */
    public Integer getSendGroupType() {
        return sendGroupType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.send_group_type
     *
     * @param sendGroupType the value for bd_business_line_group_info.send_group_type
     *
     * @mbggenerated
     */
    public void setSendGroupType(Integer sendGroupType) {
        this.sendGroupType = sendGroupType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.send_group_time
     *
     * @return the value of bd_business_line_group_info.send_group_time
     *
     * @mbggenerated
     */
    public String getSendGroupTime() {
        return sendGroupTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.send_group_time
     *
     * @param sendGroupTime the value for bd_business_line_group_info.send_group_time
     *
     * @mbggenerated
     */
    public void setSendGroupTime(String sendGroupTime) {
        this.sendGroupTime = sendGroupTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.cost_includes
     *
     * @return the value of bd_business_line_group_info.cost_includes
     *
     * @mbggenerated
     */
    public String getCostIncludes() {
        return costIncludes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.cost_includes
     *
     * @param costIncludes the value for bd_business_line_group_info.cost_includes
     *
     * @mbggenerated
     */
    public void setCostIncludes(String costIncludes) {
        this.costIncludes = costIncludes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.cost_uncludes
     *
     * @return the value of bd_business_line_group_info.cost_uncludes
     *
     * @mbggenerated
     */
    public String getCostUncludes() {
        return costUncludes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.cost_uncludes
     *
     * @param costUncludes the value for bd_business_line_group_info.cost_uncludes
     *
     * @mbggenerated
     */
    public void setCostUncludes(String costUncludes) {
        this.costUncludes = costUncludes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.refund_notice
     *
     * @return the value of bd_business_line_group_info.refund_notice
     *
     * @mbggenerated
     */
    public String getRefundNotice() {
        return refundNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.refund_notice
     *
     * @param refundNotice the value for bd_business_line_group_info.refund_notice
     *
     * @mbggenerated
     */
    public void setRefundNotice(String refundNotice) {
        this.refundNotice = refundNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.booking_notice
     *
     * @return the value of bd_business_line_group_info.booking_notice
     *
     * @mbggenerated
     */
    public String getBookingNotice() {
        return bookingNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.booking_notice
     *
     * @param bookingNotice the value for bd_business_line_group_info.booking_notice
     *
     * @mbggenerated
     */
    public void setBookingNotice(String bookingNotice) {
        this.bookingNotice = bookingNotice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.audit_status
     *
     * @return the value of bd_business_line_group_info.audit_status
     *
     * @mbggenerated
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.audit_status
     *
     * @param auditStatus the value for bd_business_line_group_info.audit_status
     *
     * @mbggenerated
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.online_status
     *
     * @return the value of bd_business_line_group_info.online_status
     *
     * @mbggenerated
     */
    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.online_status
     *
     * @param onlineStatus the value for bd_business_line_group_info.online_status
     *
     * @mbggenerated
     */
    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.create_by
     *
     * @return the value of bd_business_line_group_info.create_by
     *
     * @mbggenerated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.create_by
     *
     * @param createBy the value for bd_business_line_group_info.create_by
     *
     * @mbggenerated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.create_time
     *
     * @return the value of bd_business_line_group_info.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.create_time
     *
     * @param createTime the value for bd_business_line_group_info.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.update_by
     *
     * @return the value of bd_business_line_group_info.update_by
     *
     * @mbggenerated
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.update_by
     *
     * @param updateBy the value for bd_business_line_group_info.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.update_time
     *
     * @return the value of bd_business_line_group_info.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.update_time
     *
     * @param updateTime the value for bd_business_line_group_info.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bd_business_line_group_info.deleted
     *
     * @return the value of bd_business_line_group_info.deleted
     *
     * @mbggenerated
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bd_business_line_group_info.deleted
     *
     * @param deleted the value for bd_business_line_group_info.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}