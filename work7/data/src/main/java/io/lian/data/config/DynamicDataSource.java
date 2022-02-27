package io.lian.data.config;

import io.lian.data.handler.DynamicDataSourceHandler;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author m809745357
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHandler.getRouteKey();
    }
}
