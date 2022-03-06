package com.example.xa.service;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author m809745357
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final JdbcTemplate jdbcTemplate;

    /**
     * 插入订单
     * 支持TransactionType.LOCAL, TransactionType.XA, TransactionType.BASE
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @ShardingSphereTransactionType(TransactionType.XA)
    public void insert() {
        jdbcTemplate.execute("INSERT INTO t_order (user_id, order_no, order_price, payment) VALUES (?, ?, ?, ?)", (PreparedStatementCallback<Object>) ps -> {
            ps.setObject(1, '1');
            ps.setObject(2, "123456789");
            ps.setObject(3, "100.00");
            ps.setObject(4, "1");
            ps.executeUpdate();
            return ps;
        });
    }

    public String createOrder() {
        this.insert();
        return "创建订单成功";
    }
}
