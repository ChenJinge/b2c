package com.bargains.dao;

import com.bargains.entity.OrderEntity;
import com.bargains.entity.OrderEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface OrderEntityMapper {
    int countByExample(OrderEntityExample example);

    int deleteByExample(OrderEntityExample example);

    @Delete({
        "delete from order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order (product_quantity, product_id, ",
        "pay_amount, user_id, ",
        "merchant_id, create_time, ",
        "pay_time, pay_type, ",
        "pay_status, receiving_address, ",
        "receiving_phone, receiving_name, ",
        "trade_serial_number)",
        "values (#{productQuantity,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{payAmount,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{merchantId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{payType,jdbcType=INTEGER}, ",
        "#{payStatus,jdbcType=INTEGER}, #{receivingAddress,jdbcType=VARCHAR}, ",
        "#{receivingPhone,jdbcType=VARCHAR}, #{receivingName,jdbcType=VARCHAR}, ",
        "#{tradeSerialNumber,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    List<OrderEntity> selectByExample(OrderEntityExample example);

    @Select({
        "select",
        "id, product_quantity, product_id, pay_amount, user_id, merchant_id, create_time, ",
        "pay_time, pay_type, pay_status, receiving_address, receiving_phone, receiving_name, ",
        "trade_serial_number",
        "from order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.bargains.dao.OrderEntityMapper.BaseResultMap")
    OrderEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderEntity record, @Param("example") OrderEntityExample example);

    int updateByExample(@Param("record") OrderEntity record, @Param("example") OrderEntityExample example);

    int updateByPrimaryKeySelective(OrderEntity record);

    @Update({
        "update order",
        "set product_quantity = #{productQuantity,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "pay_amount = #{payAmount,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "pay_type = #{payType,jdbcType=INTEGER},",
          "pay_status = #{payStatus,jdbcType=INTEGER},",
          "receiving_address = #{receivingAddress,jdbcType=VARCHAR},",
          "receiving_phone = #{receivingPhone,jdbcType=VARCHAR},",
          "receiving_name = #{receivingName,jdbcType=VARCHAR},",
          "trade_serial_number = #{tradeSerialNumber,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderEntity record);
}