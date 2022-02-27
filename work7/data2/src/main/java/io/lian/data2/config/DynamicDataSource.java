package io.lian.data2.config;

import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author m809745357
 */
public class DynamicDataSource implements HintShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection<String> collection, ShardingValue shardingValue) {
        ListShardingValue<String> listShardingValue = (ListShardingValue<String>) shardingValue;
        return new ArrayList<>(listShardingValue.getValues());
    }
}
