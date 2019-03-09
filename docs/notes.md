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

### 分布式事务解决方案s

- [ ] [liuyangming/ByteTCC](https://github.com/liuyangming/ByteTCC)
- [x] [alibaba/fescar](https://github.com/alibaba/fescar)
    * [详细解读 Github 上发布仅一个月就获得4k+ star 的分布式事务解决方案](https://mp.weixin.qq.com/s?__biz=MzIxMzEzMjM5NQ==&mid=2651031492&idx=1&sn=0928f5f0c5c136f6f968d33595c8cecd&chksm=8c4c52c0bb3bdbd6d1c450337d31e6e2dd41fab615585f899a37136e70b336bd8c461aef5a2f&mpshare=1&scene=1&srcid=#rd)
- [ ] [codingapi/tx-lcn](https://github.com/codingapi/tx-lcn)

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

### 项目问题总结
* @`Transactional`方法添加`synchronize`关键字，仍然线程不安全
### 如何排查一个远程过程调用没有响应？