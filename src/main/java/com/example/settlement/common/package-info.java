/**
 * 通用包，存放跨子域的共享配置，旨在重用，供多个子域共享
 * 包含：
 * 1. 基础类和接口：这些类和接口可以被多个子域共享，例如抽象基类、通用的数据传输对象（DTOs）和领域事件接口等。
 * 2. 异常类：用于存放跨子域的通用异常类，例如业务异常、验证异常等。
 * 3. 常量类：定义跨子域使用的通用常量，例如状态码、错误消息等。
 * 4. 配置类：存放通用的配置信息，例如数据库连接、消息队列设置、缓存设置等。
 * 5. 中间件或服务接口：例如用于集成第三方服务（如支付、地图、短信等）的接口和实现类。
 * 6. 安全相关：存放与身份验证和授权相关的代码，例如JWT处理、权限管理等。
 * @author yangwu_i
 * @date 2023/4/8 17:53
 */
package com.example.settlement.common;