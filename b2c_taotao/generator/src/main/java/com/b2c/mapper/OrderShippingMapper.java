package com.b2c.mapper;

import com.b2c.pojo.OrderShipping;
import com.b2c.pojo.OrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface OrderShippingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    int countByExample(OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    int deleteByExample(OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tb_order_shipping",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tb_order_shipping (receiver_name, receiver_phone, ",
        "receiver_mobile, receiver_state, ",
        "receiver_city, receiver_district, ",
        "receiver_address, receiver_zip, ",
        "created, updated)",
        "values (#{receiverName,jdbcType=VARCHAR}, #{receiverPhone,jdbcType=VARCHAR}, ",
        "#{receiverMobile,jdbcType=VARCHAR}, #{receiverState,jdbcType=VARCHAR}, ",
        "#{receiverCity,jdbcType=VARCHAR}, #{receiverDistrict,jdbcType=VARCHAR}, ",
        "#{receiverAddress,jdbcType=VARCHAR}, #{receiverZip,jdbcType=VARCHAR}, ",
        "#{created,jdbcType=TIMESTAMP}, #{updated,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="orderId", before=false, resultType=String.class)
    int insert(OrderShipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    int insertSelective(OrderShipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    List<OrderShipping> selectByExample(OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "order_id, receiver_name, receiver_phone, receiver_mobile, receiver_state, receiver_city, ",
        "receiver_district, receiver_address, receiver_zip, created, updated",
        "from tb_order_shipping",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.b2c.mapper.OrderShippingMapper.BaseResultMap")
    OrderShipping selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderShipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_shipping
     *
     * @mbggenerated
     */
    @Update({
        "update tb_order_shipping",
        "set receiver_name = #{receiverName,jdbcType=VARCHAR},",
          "receiver_phone = #{receiverPhone,jdbcType=VARCHAR},",
          "receiver_mobile = #{receiverMobile,jdbcType=VARCHAR},",
          "receiver_state = #{receiverState,jdbcType=VARCHAR},",
          "receiver_city = #{receiverCity,jdbcType=VARCHAR},",
          "receiver_district = #{receiverDistrict,jdbcType=VARCHAR},",
          "receiver_address = #{receiverAddress,jdbcType=VARCHAR},",
          "receiver_zip = #{receiverZip,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(OrderShipping record);
}