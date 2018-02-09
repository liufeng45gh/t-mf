package com.lucifer.config;

import com.lucifer.annotation.ShopDb;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/12/23.
 */
@Configuration
@AutoConfigureAfter(MyBatisConfiguration.class)
public class MyBatisShopMapperScannerConfig {

    @Bean(name="shopMapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("shopSqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.lucifer.mapper");
        mapperScannerConfigurer.setAnnotationClass(ShopDb.class);
        return mapperScannerConfigurer;
    }
}
