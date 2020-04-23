package cn.org.cvc.mapper;

import cn.org.cvc.model.TestItem;
import cn.org.cvc.model.TestItemExample;
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

public interface TestItemMapper {
    @SelectProvider(type=TestItemSqlProvider.class, method="countByExample")
    long countByExample(TestItemExample example);

    @DeleteProvider(type=TestItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestItemExample example);

    @Delete({
        "delete from test_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into test_item (id, name, ",
        "del, gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(TestItem record);

    @InsertProvider(type=TestItemSqlProvider.class, method="insertSelective")
    int insertSelective(TestItem record);

    @SelectProvider(type=TestItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TestItem> selectByExample(TestItemExample example);

    @Select({
        "select",
        "id, name, del, gmt_create, gmt_modify",
        "from test_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    TestItem selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TestItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TestItem record, @Param("example") TestItemExample example);

    @UpdateProvider(type=TestItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TestItem record, @Param("example") TestItemExample example);

    @UpdateProvider(type=TestItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TestItem record);

    @Update({
        "update test_item",
        "set name = #{name,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TestItem record);
}