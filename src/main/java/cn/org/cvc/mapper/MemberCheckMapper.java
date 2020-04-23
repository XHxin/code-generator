package cn.org.cvc.mapper;

import cn.org.cvc.model.MemberCheck;
import cn.org.cvc.model.MemberCheckExample;
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

public interface MemberCheckMapper {
    @SelectProvider(type=MemberCheckSqlProvider.class, method="countByExample")
    long countByExample(MemberCheckExample example);

    @DeleteProvider(type=MemberCheckSqlProvider.class, method="deleteByExample")
    int deleteByExample(MemberCheckExample example);

    @Delete({
        "delete from member_check",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into member_check (id, member_id, ",
        "manager_id, mobile, ",
        "company_id, company_num, ",
        "company_name, son_id, ",
        "manager_name, name, ",
        "check_status, reason, ",
        "del, gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{memberId,jdbcType=INTEGER}, ",
        "#{managerId,jdbcType=INTEGER}, #{mobile,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=INTEGER}, #{companyNum,jdbcType=VARCHAR}, ",
        "#{companyName,jdbcType=VARCHAR}, #{sonId,jdbcType=INTEGER}, ",
        "#{managerName,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{checkStatus,jdbcType=TINYINT}, #{reason,jdbcType=VARCHAR}, ",
        "#{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(MemberCheck record);

    @InsertProvider(type=MemberCheckSqlProvider.class, method="insertSelective")
    int insertSelective(MemberCheck record);

    @SelectProvider(type=MemberCheckSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="company_num", property="companyNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="son_id", property="sonId", jdbcType=JdbcType.INTEGER),
        @Result(column="manager_name", property="managerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_status", property="checkStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MemberCheck> selectByExample(MemberCheckExample example);

    @Select({
        "select",
        "id, member_id, manager_id, mobile, company_id, company_num, company_name, son_id, ",
        "manager_name, name, check_status, reason, del, gmt_create, gmt_modify",
        "from member_check",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="company_num", property="companyNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="son_id", property="sonId", jdbcType=JdbcType.INTEGER),
        @Result(column="manager_name", property="managerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_status", property="checkStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    MemberCheck selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MemberCheckSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MemberCheck record, @Param("example") MemberCheckExample example);

    @UpdateProvider(type=MemberCheckSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MemberCheck record, @Param("example") MemberCheckExample example);

    @UpdateProvider(type=MemberCheckSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MemberCheck record);

    @Update({
        "update member_check",
        "set member_id = #{memberId,jdbcType=INTEGER},",
          "manager_id = #{managerId,jdbcType=INTEGER},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "company_num = #{companyNum,jdbcType=VARCHAR},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "son_id = #{sonId,jdbcType=INTEGER},",
          "manager_name = #{managerName,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "check_status = #{checkStatus,jdbcType=TINYINT},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MemberCheck record);
}