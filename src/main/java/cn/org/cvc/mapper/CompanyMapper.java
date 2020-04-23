package cn.org.cvc.mapper;

import cn.org.cvc.model.Company;
import cn.org.cvc.model.CompanyExample;
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

public interface CompanyMapper {
    @SelectProvider(type=CompanySqlProvider.class, method="countByExample")
    long countByExample(CompanyExample example);

    @DeleteProvider(type=CompanySqlProvider.class, method="deleteByExample")
    int deleteByExample(CompanyExample example);

    @Delete({
        "delete from company",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into company (id, company_name, ",
        "company_num, del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{companyName,jdbcType=VARCHAR}, ",
        "#{companyNum,jdbcType=VARCHAR}, #{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Company record);

    @InsertProvider(type=CompanySqlProvider.class, method="insertSelective")
    int insertSelective(Company record);

    @SelectProvider(type=CompanySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_num", property="companyNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Company> selectByExample(CompanyExample example);

    @Select({
        "select",
        "id, company_name, company_num, del, gmt_create, gmt_modify",
        "from company",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_num", property="companyNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Company selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CompanySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    @UpdateProvider(type=CompanySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    @UpdateProvider(type=CompanySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Company record);

    @Update({
        "update company",
        "set company_name = #{companyName,jdbcType=VARCHAR},",
          "company_num = #{companyNum,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Company record);
}