-- auto-generated definition
create table user
(
    user_id      bigint auto_increment comment '用户id'
        primary key,
    user_name    varchar(20)                               null comment '昵称',
    head_img_url varchar(255)                              null comment '头像',
    create_time  timestamp     default CURRENT_TIMESTAMP   not null comment '创建时间',
    update_time  timestamp                                 null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete    tinyint(3)    default 0                   not null comment '是否删除0未删除1删除'
)
    comment '用户表';

-- auto-generated definition
create table goods
(
    goods_id    bigint auto_increment comment '主键id'
        primary key,
    goods_name  varchar(255)                                not null comment '商品名称',
    goods_price decimal(16, 2) default 0.00                 null comment '商品价格',
    goods_stock int                                         not null comment '商品库存',
    create_time timestamp      default CURRENT_TIMESTAMP    not null comment '创建时间',
    update_time timestamp                                   null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete   tinyint(3)     default 0                    null comment '是否删除0未删除1已删除'
)
    comment '商品表';

-- auto-generated definition
create table `order`
(
    order_id    bigint auto_increment
        primary key,
    order_no    varchar(20)                                 not null comment '订单编号',
    order_price decimal(16, 2)  default 0.00                not null comment '订单价格',
    payment     decimal(16, 2)  default 0.00                not null comment '支付金额',
    order_state tinyint(3)      default 0                   not null comment '订单状态：1、待支付，2、已支付、3已发货、4已收货、5已取消',
    create_time timestamp       default CURRENT_TIMESTAMP   not null comment '创建时间',
    update_time timestamp                                   null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete   tinyint(1)      default 0                   null comment '是否删除0未删除1已删除'
)
    comment '订单表';

-- auto-generated definition
create table order_item
(
    order_item_id bigint auto_increment comment '订单商品id'
        primary key,
    order_id      bigint                                    not null comment '订单id',
    goods_id      bigint                                    not null comment '商品id',
    goods_name    varchar(20)                               not null comment '商品名称',
    item_num      int                                       not null comment '商品数量',
    goods_price   decimal(16, 2)                            not null comment '商品价格',
    payment       decimal(16, 2)                            not null comment '单品类商品总价',
    create_time   timestamp default CURRENT_TIMESTAMP       not null comment '创建时间',
    update_time   timestamp                                 null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint(1)                                not null comment '是否删除0未删除1已删除'
)
    comment '订单商品表';


