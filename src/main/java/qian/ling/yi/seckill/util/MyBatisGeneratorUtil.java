package qian.ling.yi.seckill.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MyBatis Generator
 *
 * @date: 2019/6/11.
 * @author: guobin.liu@holaverse.com
 */

public class MyBatisGeneratorUtil {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        Configuration config = new Configuration();
        Context context = new Context(ModelType.CONDITIONAL);
//        context.setTargetRuntime("MyBatis3Simple");
        context.setTargetRuntime("MyBatis3");
        context.setId("defaultContext");
        //自动识别数据库关键字，默认false，如果设置为true，
        //根据SqlReservedWords中定义的关键字列表；一般保留默认值，遇到数据库关键字（Java关键字），
        //使用columnOverride覆盖
        context.addProperty("autoDelimitKeywords", "true");
        //生成的Java文件的编码
        context.addProperty("javaFileEncoding", "utf-8");
        context.addProperty("beginningDelimiter", "`");
        context.addProperty("endingDelimiter", "`");
        //格式化java代码
        context.addProperty("javaFormatter", "org.mybatis.generator.api.dom.DefaultJavaFormatter");
        //格式化xml代码
        context.addProperty("xmlFormatter", "org.mybatis.generator.api.dom.DefaultXmlFormatter");

        //格式化信息
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.SerializablePlugin");
        pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.ToStringPlugin");
        context.addPluginConfiguration(pluginConfiguration);


        //设置是否生成注释
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        //设置连接数据库
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass("com.mysql.cj.jdbc.Driver");
        jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8");
        jdbcConnectionConfiguration.setPassword("liudebin-1990");
        jdbcConnectionConfiguration.setUserId("root");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);


        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        //是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.）
        javaTypeResolverConfiguration.addProperty("forceBigDecimals", "false");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);


        //生成实体类的地址
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage("qian.ling.yi.seckill.model");
        javaModelGeneratorConfiguration.setTargetProject("src/main/java");
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "false");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        //生成的xml的地址
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject("src/main/resources");
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages", "false");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        sqlMapGeneratorConfiguration.addProperty("ignoreColumn", "true");

        //生成mapxml对应client，也就是接口dao
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetPackage("qian.ling.yi.seckill.mapper");
        javaClientGeneratorConfiguration.setTargetProject("src/main/java");
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.addProperty("enableSubPackages", "false");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);


        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName("trd_order");
//        tableConfiguration.setCountByExampleStatementEnabled(true);
//        tableConfiguration.setUpdateByExampleStatementEnabled(true);
//        tableConfiguration.setDeleteByExampleStatementEnabled(true);
        tableConfiguration.setInsertStatementEnabled(true);
        tableConfiguration.setDeleteByPrimaryKeyStatementEnabled(true);
        tableConfiguration.setSchema("test");
        GeneratedKey generatedKey = new GeneratedKey("id", "MySql", true, null);
        tableConfiguration.setGeneratedKey(generatedKey);
        context.addTableConfiguration(tableConfiguration);

        config.addContext(context);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException | InterruptedException | IOException |
                SQLException e) {
            e.printStackTrace();
        }
    }
}
