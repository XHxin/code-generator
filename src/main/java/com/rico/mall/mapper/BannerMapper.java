package com.rico.mall.mapper;

import com.rico.mall.model.Banner;
import com.rico.mall.model.BannerExample;
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

public interface BannerMapper {
    @SelectProvider(type=BannerSqlProvider.class, method="countByExample")
    long countByExample(BannerExample example);

    @DeleteProvider(type=BannerSqlProvider.class, method="deleteByExample")
    int deleteByExample(BannerExample example);

    @Delete({
        "delete from banner",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into banner (id, cover, ",
        "location, information_id, ",
        "del, gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{cover,jdbcType=VARCHAR}, ",
        "#{location,jdbcType=INTEGER}, #{informationId,jdbcType=INTEGER}, ",
        "#{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Banner record);

    @InsertProvider(type=BannerSqlProvider.class, method="insertSelective")
    int insertSelective(Banner record);

    @SelectProvider(type=BannerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cover", property="cover", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="information_id", property="informationId", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Banner> selectByExample(BannerExample example);

    @Select({
        "select",
        "id, cover, location, information_id, del, gmt_create, gmt_modify",
        "from banner",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cover", property="cover", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.INTEGER),
        @Result(column="information_id", property="informationId", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Banner selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Banner record);

    @Update({
        "update banner",
        "set cover = #{cover,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=INTEGER},",
          "information_id = #{informationId,jdbcType=INTEGER},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Banner record);
}