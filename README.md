# tasks

1. task_one:
  SpingMvc+Spring(4.3.10)+Mybatis(3.2.7)+oracle 搭建框架，简单的HTML页面，查询、插入（新建用户）、登陆。
    要点：	
	0. 搭建基本框架 SSM + MySQL
	1. 单元测试（test）
	2. controller集成测试
	3. 登陆注册、查询修改
	4. Oracle数据库测试(自增序列)
	5. jsp -> HTML（Ajax数据传递）
	6. bootstrap集成页面
	7. 分页（暂时未作）
	
2. Spring(4.3.10)+Mybatis+dubbo+zookeeper 在实现 1 的前提下，RPC调用，Zookeeper（集群模式，3个节点）（dubbo-admin），实现consumer对provider得调用。（分布式调用）
    要点：
	0. zookeeper集群模式三节点
	1. dubbo-admin框架搭建
	2. 基于task_one，实现dubbo_consumer 对 dubbo_provider 的调用

3. Spring(4.3.10)+Mybatis+dubbo+zookeeper+redis(memcache)+kafka 搭建Redis集群（哨兵模式），消息订阅，数据传递，搭建Kafka集群。(高可用)
	要点：
	0. 本地搭建redis(memcache)
	1. kafka集群
	2. rpc调用数据需要加密（md5和rsa两种模式）
	3. rpc调用转httpclient调用
	4. nginx安装和配置，最后提交nginx链接，Nginx(负载均衡+反向代理)
	5. tomcat应用需要起多个（第一期交付，可以没有）
