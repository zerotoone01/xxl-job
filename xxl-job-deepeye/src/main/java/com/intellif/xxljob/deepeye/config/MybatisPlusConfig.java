package com.intellif.xxljob.deepeye.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;


@Configuration
public class MybatisPlusConfig {


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    /**
     * mybatis分页可能出现问题，后期出现问题可以参考本类以及博客：https://tomoya92.github.io/2019/01/03/spring-boot-flyway-mybatis-plus/
     * 日志可能不生效https://blog.csdn.net/keith003/article/details/84289638
     */
   /*@Bean("mybatisSqlSession")
    @DependsOn("flywayConfig") // 这里指定依赖于 flywayConfig 类
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        //*注册Map 下划线转驼峰*
        configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
        // 添加数据源，官方文档里没有下面这一行，启动一直报错，脑瓜疼。。。
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setConfiguration(configuration);
        // 添加分页插件，这里有个坑
        // 在没有配置Map 下划线转驼峰这个配置之前，配置了上面注释掉的分页插件配置，结果配置了这个之后，分页就失效了
        // 找了一圈，无解，只好自己尝试解决，这个配置里就用了两个类，MybatisSqlSessionFactoryBean，MybatisConfiguration
        // 先看一下分页插件是实现的哪个接口，没错就是这货 Interceptor
        // 逐个去上面两个配置类里找，还真在MybatisSqlSessionFactoryBean类里找到了，有个plugins的字段，类型正是 Interceptor
        // 然后尝试把分页插件设置进去，启动项目，问题解决
        // 官方文档太简陋，坑新手呀！！！！！！
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        sqlSessionFactory.setPlugins(new Interceptor[]{paginationInterceptor});
        return sqlSessionFactory.getObject();
    }*/


}
