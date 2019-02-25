### API网关
* 身份验证和安全
* 审查和监测
* 动态路由
* 压力测试（适用于双十一场景）
* 负载均衡
* 静态相应处理

### 系统架构
![](/home/shuaijunlan/workspace/projects/cinema-platform/docs/images/Screenshot from 2018-12-28 21-24-54.png)

### 用户模块
> 使用ThreadLocal保存用户信息，会导致什么问题？提示：使用Tomcat的nio模型，会导致多个请求分配到同一个ThreadLocal，后面的信息会覆盖前面的信息，线程不安全。？？？？
### 影院模块
### 影片模块
### 订单模块


### 系统网关设计

#### 鉴权
#### 熔断降级
* https://blog.csdn.net/shilu89757/article/details/79363295

### 分布式事务解决方案

- [ ] [liuyangming/ByteTCC](https://github.com/liuyangming/ByteTCC)

- [ ] [alibaba/fescar](https://github.com/alibaba/fescar)

- [x] [codingapi/tx-lcn](https://github.com/codingapi/tx-lcn)

    * [分布式事务解决方案框架（LCN）](https://www.jianshu.com/p/73beee3c70e9)

- [ ] [changmingxie/tcc-transaction](https://github.com/changmingxie/tcc-transaction)

### 分布式环境下，对数据库执行更新操作，如何保证安全
* 乐观锁和悲观锁
* [spring data jpa mysql 乐观锁 与 AtomicInteger](https://blog.csdn.net/silyvin/article/details/75078694)
* [浅析项目中的并发](https://www.cnkirito.moe/concurrent-in-project/)
* [浅析项目中的并发](https://blog.csdn.net/qq315737546/article/details/76850173)
* [浅谈库存扣减和锁](https://blog.csdn.net/qq315737546/article/details/76850173)
#### 事物的隔离级别
#### 事物的传播机制

### 下订单逻辑
[高并发下的订单与库存的处理](https://blog.csdn.net/linzhiqiang0316/article/details/83279978)
### 接口文档管理
> 基于swagger

### spring boot data jpa
#### 如何替换默认的数据源？
#### 如何配置多数据源？
#### hibernate框架属性配置？
* [Hibernate5中实体映射命名策略](https://blog.csdn.net/J080624/article/details/84790421)


### spring boot学习笔记
#### spring boot自动装配原理？
* [SpringBoot自动装配原理分析](https://blog.csdn.net/Dongguabai/article/details/80865599)
* [Spring Boot自动配置（Auto-Configuration），@EnableAutoConfiguration，Spring Beans和依赖注入](https://blog.csdn.net/zyhlwzy/article/details/78744201)
