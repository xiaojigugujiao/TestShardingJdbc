package com.luxin.base.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingjdbc.core.api.config.strategy.ShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

//import io.shardingjdbc.core.api.ShardingDataSourceFactory;
//import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
//import io.shardingjdbc.core.api.config.TableRuleConfiguration;
//import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
//import io.shardingjdbc.core.api.config.strategy.ShardingStrategyConfiguration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luxinfl
 * @Date: 2019/12/28
 * @Description:
 */
@Configuration
public class ShardingConfig {

    @Autowired
    private DataSourceProperty property;


    @Bean
    public DataSource dataSource() throws SQLException {
        Map<String,DataSource> dataSourceMap = new HashMap<>();
        DataSource dataSource0 = dataSource1();
        DataSource dataSource1 = dataSource2();
        dataSourceMap.put("ds1",dataSource0);
        dataSourceMap.put("ds0",dataSource1);
        TableRuleConfiguration productRuleConfig = productRuleConfig();
        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.getTableRuleConfigs().add(productRuleConfig);
        Properties p = new Properties();
        p.setProperty("sql.show",Boolean.TRUE.toString());
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap,shardingRuleConfiguration,new ConcurrentHashMap<>(),p);
        return dataSource;
    }


    private HikariDataSource dataSource1(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(property.getUrl1());
        dataSource.setUsername(property.getUsername1());
        dataSource.setPassword(property.getPassword1());
        dataSource.setDriverClassName(property.getDriverClassName1());
        return dataSource;
    }

    private HikariDataSource dataSource2(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(property.getUrl2());
        dataSource.setUsername(property.getUsername2());
        dataSource.setPassword(property.getPassword2());
        dataSource.setDriverClassName(property.getDriverClassName2());
        return dataSource;
    }

    private TableRuleConfiguration productRuleConfig(){
        TableRuleConfiguration config = new TableRuleConfiguration();
        //逻辑表(数据库表)
        config.setLogicTable("product");
        //实际的数据节点(要分配的库，受控制的表)
        config.setActualDataNodes("ds${0..1}.product");
        config.setKeyGeneratorColumnName("id");
        //分库策略（inline表达式）
        ShardingStrategyConfiguration dataBaseStrategyConfiguration = new InlineShardingStrategyConfiguration("id","ds${id%2}") ;
        config.setDatabaseShardingStrategyConfig(dataBaseStrategyConfiguration);
        //分表策略（inline表达式）
//        ShardingStrategyConfiguration tableStrategyConfiguration = new InlineShardingStrategyConfiguration("type","product${id%2}") ;
//        config.setTableShardingStrategyConfig(tableStrategyConfiguration);

        return config;

    }


}
