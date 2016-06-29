package com.b2c.mapper;

import com.b2c.pojo.Order;
import com.b2c.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    int countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tb_order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tb_order (payment, payment_type, ",
        "post_fee, status, ",
        "create_time, update_time, ",
        "payment_time, consign_time, ",
        "end_time, close_time, ",
        "shipping_name, shipping_code, ",
        "user_id, buyer_message, ",
        "buyer_nick, buyer_rate)",
        "values (#{payment,jdbcType=VARCHAR}, #{paymentType,jdbcType=INTEGER}, ",
        "#{postFee,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{paymentTime,jdbcType=TIMESTAMP}, #{consignTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{shippingName,jdbcType=VARCHAR}, #{shippingCode,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=BIGINT}, #{buyerMessage,jdbcType=VARCHAR}, ",
        "#{buyerNick,jdbcType=VARCHAR}, #{buyerRate,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="orderId", before=false, resultType=String.class)
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "order_id, payment, payment_type, post_fee, status, create_time, update_time, ",
        "payment_time, consign_time, end_time, close_time, shipping_name, shipping_code, ",
        "user_id, buyer_message, buyer_nick, buyer_rate",
        "from tb_order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.b2c.mapper.OrderMapper.BaseResultMap")
    Order selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order
     *
     * @mbggenerated
     */
    @Update({
        "update tb_order",
        "set payment = #{payment,jdbcType=VARCHAR},",
          "payment_type = #{paymentType,jdbcType=INTEGER},",
          "post_fee = #{postFee,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "consign_time = #{consignTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "close_time = #{closeTime,jdbcType=TIMESTAMP},",
          "shipping_name = #{shippingName,jdbcType=VARCHAR},",
          "shipping_code = #{shippingCode,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "buyer_message = #{buyerMessage,jdbcType=VARCHAR},",
          "buyer_nick = #{buyerNick,jdbcType=VARCHAR},",
          "buyer_rate = #{buyerRate,jdbcType=INTEGER}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Order record);
}