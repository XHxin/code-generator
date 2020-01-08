package com.nelson.test.dao.mapper;

import com.nelson.test.dao.model.Member;
import com.nelson.test.dao.model.MemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MemberMapper {
    @SelectProvider(type=MemberSqlProvider.class, method="countByExample")
    long countByExample(MemberExample example);

    @DeleteProvider(type=MemberSqlProvider.class, method="deleteByExample")
    int deleteByExample(MemberExample example);

    @Delete({
        "delete from member",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into member (id, nick_name, ",
        "union_id, mobile, ",
        "passwd)",
        "values (#{id,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
        "#{unionId,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{passwd,jdbcType=VARCHAR})"
    })
    int insert(Member record);

    @InsertProvider(type=MemberSqlProvider.class, method="insertSelective")
    int insertSelective(Member record);

    @SelectProvider(type=MemberSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="union_id", property="unionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwd", property="passwd", jdbcType=JdbcType.VARCHAR)
    })
    List<Member> selectByExample(MemberExample example);

    @Select({
        "select",
        "id, nick_name, union_id, mobile, passwd",
        "from member",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="union_id", property="unionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwd", property="passwd", jdbcType=JdbcType.VARCHAR)
    })
    Member selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Member record);

    @Update({
        "update member",
        "set nick_name = #{nickName,jdbcType=VARCHAR},",
          "union_id = #{unionId,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "passwd = #{passwd,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Member record);
}