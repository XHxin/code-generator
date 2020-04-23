package cn.org.cvc.mapper;

import cn.org.cvc.model.CaseTestItem;
import cn.org.cvc.model.CaseTestItemExample;
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

public interface CaseTestItemMapper {
    @SelectProvider(type=CaseTestItemSqlProvider.class, method="countByExample")
    long countByExample(CaseTestItemExample example);

    @DeleteProvider(type=CaseTestItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(CaseTestItemExample example);

    @Delete({
        "delete from case_test_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into case_test_item (id, case_id, ",
        "test_item_id, add_in_report, ",
        "pass, del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{caseId,jdbcType=INTEGER}, ",
        "#{testItemId,jdbcType=INTEGER}, #{addInReport,jdbcType=BIT}, ",
        "#{pass,jdbcType=BIT}, #{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(CaseTestItem record);

    @InsertProvider(type=CaseTestItemSqlProvider.class, method="insertSelective")
    int insertSelective(CaseTestItem record);

    @SelectProvider(type=CaseTestItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="case_id", property="caseId", jdbcType=JdbcType.INTEGER),
        @Result(column="test_item_id", property="testItemId", jdbcType=JdbcType.INTEGER),
        @Result(column="add_in_report", property="addInReport", jdbcType=JdbcType.BIT),
        @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CaseTestItem> selectByExample(CaseTestItemExample example);

    @Select({
        "select",
        "id, case_id, test_item_id, add_in_report, pass, del, gmt_create, gmt_modify",
        "from case_test_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="case_id", property="caseId", jdbcType=JdbcType.INTEGER),
        @Result(column="test_item_id", property="testItemId", jdbcType=JdbcType.INTEGER),
        @Result(column="add_in_report", property="addInReport", jdbcType=JdbcType.BIT),
        @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    CaseTestItem selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CaseTestItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CaseTestItem record, @Param("example") CaseTestItemExample example);

    @UpdateProvider(type=CaseTestItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CaseTestItem record, @Param("example") CaseTestItemExample example);

    @UpdateProvider(type=CaseTestItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CaseTestItem record);

    @Update({
        "update case_test_item",
        "set case_id = #{caseId,jdbcType=INTEGER},",
          "test_item_id = #{testItemId,jdbcType=INTEGER},",
          "add_in_report = #{addInReport,jdbcType=BIT},",
          "pass = #{pass,jdbcType=BIT},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CaseTestItem record);
}