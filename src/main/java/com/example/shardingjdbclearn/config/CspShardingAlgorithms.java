package com.example.shardingjdbclearn.config;

import org.apache.shardingsphere.infra.datanode.DataNodeInfo;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * @author jiancheng
 */
public class CspShardingAlgorithms implements StandardShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        String cspId = preciseShardingValue.getValue().substring(0, 3);
        String tableName = logicTableName + "_" + cspId;
        collection.add(tableName);
        return tableName;
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<String> rangeShardingValue) {
        return collection;
    }

    @Override
    public void init(Properties properties) {

    }

    @Override
    public Properties getProps() {
        return null;
    }
}
