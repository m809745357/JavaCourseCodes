表结构
```
create table `t_order`
(
    order_id    bigint auto_increment
        primary key,
    order_no    varchar(20)                                 not null comment '订单编号',
    user_id    bigint                                       not null comment '用户编号',
    order_price decimal(16, 2)  default 0.00                not null comment '订单价格',
    payment     decimal(16, 2)  default 0.00                not null comment '支付金额',
    order_state tinyint(3)      default 0                   not null comment '订单状态：1、待支付，2、已支付、3已发货、4已收货、5已取消',
    create_time timestamp       default CURRENT_TIMESTAMP   not null comment '创建时间',
    update_time timestamp                                   null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete   tinyint(1)      default 0                   null comment '是否删除0未删除1已删除'
)
    comment '订单表';
```
插入数据
```
insert into t_order (user_id,order_no,order_price,payment) values (1,123456789,100.00,1);
```