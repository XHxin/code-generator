code-generator项目用于代码自动生成

Gernerator.java类是程序的启动入口

使用方法：
第一步：修改generator.properties文件的数据库连接信息
第二步：






注意事项：
DTO的字段要与model中保持一致

数据库：
建立组合唯一索引
alter table t_aa add unique index(aa,bb);

