package cn.org.cvc.mapper;

import cn.org.cvc.model.EditHistory;
import cn.org.cvc.model.EditHistoryExample;
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

public interface EditHistoryMapper {
    @SelectProvider(type=EditHistorySqlProvider.class, method="countByExample")
    long countByExample(EditHistoryExample example);

    @DeleteProvider(type=EditHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(EditHistoryExample example);

    @Delete({
        "delete from edit_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into edit_history (id, manager_id, ",
        "name, case_id, del, ",
        "gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{managerId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{caseId,jdbcType=INTEGER}, #{del,jdbcType=BIT}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(EditHistory record);

    @InsertProvider(type=EditHistorySqlProvider.class, method="insertSelective")
    int insertSelective(EditHistory record);

    @SelectProvider(type=EditHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="case_id", property="caseId", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EditHistory> selectByExample(EditHistoryExample example);

    @Select({
        "select",
        "id, manager_id, name, case_id, del, gmt_create, gmt_modify",
        "from edit_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="manager_id", property="managerId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="case_id", property="caseId", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    EditHistory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EditHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EditHistory record, @Param("example") EditHistoryExample example);

    @UpdateProvider(type=EditHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EditHistory record, @Param("example") EditHistoryExample example);

    @UpdateProvider(type=EditHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EditHistory record);

    @Update({
        "update edit_history",
        "set manager_id = #{managerId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "case_id = #{caseId,jdbcType=INTEGER},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EditHistory record);
}