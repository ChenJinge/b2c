package com.bargains.dao;

import com.bargains.entity.UserEntity;
import com.bargains.entity.UserEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface UserEntityMapper {
    int countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (name, account, ",
        "password, sex, age, ",
        "address, email)",
        "values (#{name,jdbcType=VARCHAR}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
        "#{address,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    @Select({
        "select",
        "id, name, account, password, sex, age, address, email",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.bargains.dao.UserEntityMapper.BaseResultMap")
    UserEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "address = #{address,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserEntity record);
}