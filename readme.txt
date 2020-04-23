code-generator项目用于代码自动生成

Gernerator.java类是程序的启动入口

使用方法：
第一步：修改generator.properties文件的数据库连接信息
第二步：把Generator.java中的PACKAGE_NAME和DATABASE属性为你的包名和数据库名称




<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.4</version>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.0</version>
</dependency>
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>4.1.6</version>
</dependency>






注意事项：
DTO的字段要与model中保持一致

数据库：
建立组合唯一索引
alter table t_aa add unique index(aa,bb);

