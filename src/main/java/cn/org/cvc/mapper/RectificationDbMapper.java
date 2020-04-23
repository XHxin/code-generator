package cn.org.cvc.mapper;

import cn.org.cvc.model.RectificationDb;
import cn.org.cvc.model.RectificationDbExample;
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

public interface RectificationDbMapper {
    @SelectProvider(type=RectificationDbSqlProvider.class, method="countByExample")
    long countByExample(RectificationDbExample example);

    @DeleteProvider(type=RectificationDbSqlProvider.class, method="deleteByExample")
    int deleteByExample(RectificationDbExample example);

    @Delete({
        "delete from rectification_db",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rectification_db (id, rectification_advice_num, ",
        "project_num, product_name, ",
        "test_item, pass, reason, ",
        "solutions, imgs, ",
        "del, gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{rectificationAdviceNum,jdbcType=VARCHAR}, ",
        "#{projectNum,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
        "#{testItem,jdbcType=VARCHAR}, #{pass,jdbcType=BIT}, #{reason,jdbcType=VARCHAR}, ",
        "#{solutions,jdbcType=VARCHAR}, #{imgs,jdbcType=VARCHAR}, ",
        "#{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(RectificationDb record);

    @InsertProvider(type=RectificationDbSqlProvider.class, method="insertSelective")
    int insertSelective(RectificationDb record);

    @SelectProvider(type=RectificationDbSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rectification_advice_num", property="rectificationAdviceNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_num", property="projectNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_item", property="testItem", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="solutions", property="solutions", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RectificationDb> selectByExample(RectificationDbExample example);

    @Select({
        "select",
        "id, rectification_advice_num, project_num, product_name, test_item, pass, reason, ",
        "solutions, imgs, del, gmt_create, gmt_modify",
        "from rectification_db",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rectification_advice_num", property="rectificationAdviceNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_num", property="projectNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="test_item", property="testItem", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="solutions", property="solutions", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    RectificationDb selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RectificationDbSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RectificationDb record, @Param("example") RectificationDbExample example);

    @UpdateProvider(type=RectificationDbSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RectificationDb record, @Param("example") RectificationDbExample example);

    @UpdateProvider(type=RectificationDbSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RectificationDb record);

    @Update({
        "update rectification_db",
        "set rectification_advice_num = #{rectificationAdviceNum,jdbcType=VARCHAR},",
          "project_num = #{projectNum,jdbcType=VARCHAR},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "test_item = #{testItem,jdbcType=VARCHAR},",
          "pass = #{pass,jdbcType=BIT},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "solutions = #{solutions,jdbcType=VARCHAR},",
          "imgs = #{imgs,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RectificationDb record);
}