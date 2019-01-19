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

[liuyangming/ByteTCC](https://github.com/liuyangming/ByteTCC)

[alibaba/fescar](https://github.com/alibaba/fescar)

- [x] [codingapi/tx-lcn](https://github.com/codingapi/tx-lcn)

    > [分布式事务解决方案框架（LCN）](https://www.jianshu.com/p/73beee3c70e9)

[changmingxie/tcc-transaction](https://github.com/changmingxie/tcc-transaction)