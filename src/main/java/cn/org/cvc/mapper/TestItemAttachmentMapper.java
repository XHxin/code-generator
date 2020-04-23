package cn.org.cvc.mapper;

import cn.org.cvc.model.TestItemAttachment;
import cn.org.cvc.model.TestItemAttachmentExample;
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

public interface TestItemAttachmentMapper {
    @SelectProvider(type=TestItemAttachmentSqlProvider.class, method="countByExample")
    long countByExample(TestItemAttachmentExample example);

    @DeleteProvider(type=TestItemAttachmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestItemAttachmentExample example);

    @Delete({
        "delete from test_item_attachment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into test_item_attachment (id, file_name, ",
        "url, case_test_item_id, ",
        "pass, del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{fileName,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{caseTestItemId,jdbcType=INTEGER}, ",
        "#{pass,jdbcType=BIT}, #{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(TestItemAttachment record);

    @InsertProvider(type=TestItemAttachmentSqlProvider.class, method="insertSelective")
    int insertSelective(TestItemAttachment record);

    @SelectProvider(type=TestItemAttachmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="case_test_item_id", property="caseTestItemId", jdbcType=JdbcType.INTEGER),
        @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TestItemAttachment> selectByExample(TestItemAttachmentExample example);

    @Select({
        "select",
        "id, file_name, url, case_test_item_id, pass, del, gmt_create, gmt_modify",
        "from test_item_attachment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="file_name", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="case_test_item_id", property="caseTestItemId", jdbcType=JdbcType.INTEGER),
        @Result(column="pass", property="pass", jdbcType=JdbcType.BIT),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    TestItemAttachment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TestItemAttachmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TestItemAttachment record, @Param("example") TestItemAttachmentExample example);

    @UpdateProvider(type=TestItemAttachmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TestItemAttachment record, @Param("example") TestItemAttachmentExample example);

    @UpdateProvider(type=TestItemAttachmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TestItemAttachment record);

    @Update({
        "update test_item_attachment",
        "set file_name = #{fileName,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "case_test_item_id = #{caseTestItemId,jdbcType=INTEGER},",
          "pass = #{pass,jdbcType=BIT},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TestItemAttachment record);
}