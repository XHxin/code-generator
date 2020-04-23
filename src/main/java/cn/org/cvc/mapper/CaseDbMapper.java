package cn.org.cvc.mapper;

import cn.org.cvc.model.CaseDb;
import cn.org.cvc.model.CaseDbExample;
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

public interface CaseDbMapper {
    @SelectProvider(type=CaseDbSqlProvider.class, method="countByExample")
    long countByExample(CaseDbExample example);

    @DeleteProvider(type=CaseDbSqlProvider.class, method="deleteByExample")
    int deleteByExample(CaseDbExample example);

    @Delete({
        "delete from case_db",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into case_db (id, case_num, ",
        "status, project_num, ",
        "product_name, model, ",
        "order_time, buyer, ",
        "lab, company_address, ",
        "company_name, company_id, ",
        "last_editor, del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{caseNum,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{projectNum,jdbcType=VARCHAR}, ",
        "#{productName,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, ",
        "#{orderTime,jdbcType=TIMESTAMP}, #{buyer,jdbcType=VARCHAR}, ",
        "#{lab,jdbcType=VARCHAR}, #{companyAddress,jdbcType=VARCHAR}, ",
        "#{companyName,jdbcType=VARCHAR}, #{companyId,jdbcType=INTEGER}, ",
        "#{lastEditor,jdbcType=VARCHAR}, #{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(CaseDb record);

    @InsertProvider(type=CaseDbSqlProvider.class, method="insertSelective")
    int insertSelective(CaseDb record);

    @SelectProvider(type=CaseDbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="case_num", property="caseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="project_num", property="projectNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="buyer", property="buyer", jdbcType=JdbcType.VARCHAR),
        @Result(column="lab", property="lab", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_address", property="companyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_editor", property="lastEditor", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CaseDb> selectByExample(CaseDbExample example);

    @Select({
        "select",
        "id, case_num, status, project_num, product_name, model, order_time, buyer, lab, ",
        "company_address, company_name, company_id, last_editor, del, gmt_create, gmt_modify",
        "from case_db",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="case_num", property="caseNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="project_num", property="projectNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="orderTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="buyer", property="buyer", jdbcType=JdbcType.VARCHAR),
        @Result(column="lab", property="lab", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_address", property="companyAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="last_editor", property="lastEditor", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    CaseDb selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CaseDbSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CaseDb record, @Param("example") CaseDbExample example);

    @UpdateProvider(type=CaseDbSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CaseDb record, @Param("example") CaseDbExample example);

    @UpdateProvider(type=CaseDbSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CaseDb record);

    @Update({
        "update case_db",
        "set case_num = #{caseNum,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "project_num = #{projectNum,jdbcType=VARCHAR},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "order_time = #{orderTime,jdbcType=TIMESTAMP},",
          "buyer = #{buyer,jdbcType=VARCHAR},",
          "lab = #{lab,jdbcType=VARCHAR},",
          "company_address = #{companyAddress,jdbcType=VARCHAR},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "last_editor = #{lastEditor,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CaseDb record);
}