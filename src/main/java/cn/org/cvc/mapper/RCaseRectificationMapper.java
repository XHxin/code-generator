package cn.org.cvc.mapper;

import cn.org.cvc.model.RCaseRectification;
import cn.org.cvc.model.RCaseRectificationExample;
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

public interface RCaseRectificationMapper {
    @SelectProvider(type=RCaseRectificationSqlProvider.class, method="countByExample")
    long countByExample(RCaseRectificationExample example);

    @DeleteProvider(type=RCaseRectificationSqlProvider.class, method="deleteByExample")
    int deleteByExample(RCaseRectificationExample example);

    @Delete({
        "delete from r_case_rectification",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into r_case_rectification (id, case_id, ",
        "rectification_id, del, ",
        "gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{caseId,jdbcType=INTEGER}, ",
        "#{rectificationId,jdbcType=INTEGER}, #{del,jdbcType=BIT}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(RCaseRectification record);

    @InsertProvider(type=RCaseRectificationSqlProvider.class, method="insertSelective")
    int insertSelective(RCaseRectification record);

    @SelectProvider(type=RCaseRectificationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="case_id", property="caseId", jdbcType=JdbcType.INTEGER),
        @Result(column="rectification_id", property="rectificationId", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RCaseRectification> selectByExample(RCaseRectificationExample example);

    @Select({
        "select",
        "id, case_id, rectification_id, del, gmt_create, gmt_modify",
        "from r_case_rectification",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="case_id", property="caseId", jdbcType=JdbcType.INTEGER),
        @Result(column="rectification_id", property="rectificationId", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    RCaseRectification selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RCaseRectificationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RCaseRectification record, @Param("example") RCaseRectificationExample example);

    @UpdateProvider(type=RCaseRectificationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RCaseRectification record, @Param("example") RCaseRectificationExample example);

    @UpdateProvider(type=RCaseRectificationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RCaseRectification record);

    @Update({
        "update r_case_rectification",
        "set case_id = #{caseId,jdbcType=INTEGER},",
          "rectification_id = #{rectificationId,jdbcType=INTEGER},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RCaseRectification record);
}