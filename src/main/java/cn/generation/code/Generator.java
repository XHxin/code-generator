package cn.generation.code;


import cn.generation.code.util.MybatisGeneratorUtil;
import cn.generation.code.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码生成类
 * Created by nelson on 2019/11/10.
 */
public class Generator {

    //是否添加其他辅助模块
    private static Boolean SWAGGER2 = true;
    private static Boolean REDIS = true;
    private static Boolean SHIRO = true;


    // 根据命名规范，只修改此常量值即可
    private static String MODULE = "";//本身就是一个模块，这里就不要再写了
    private static String DATABASE = "emc_fault_diagnosis";
    private static String TABLE_PREFIX = "";//没有就不写
    private static String PACKAGE_NAME = "cn.org.cvc";
    private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.driver");
    private static String JDBC_URL = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.url");
    private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.username");
    private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.password");
    // 需要insert后返回主键的表配置，key:表名,value:主键名
    private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();

    static {
        LAST_INSERT_ID_TABLES.put("upms_user", "user_id");
    }

    /**
     * 自动代码生成
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        MybatisGeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_PREFIX, PACKAGE_NAME, LAST_INSERT_ID_TABLES);
    }

}
