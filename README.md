# mytomcat
模拟实现tomcat功能，先实现最简单的功能，模拟Servlet的几个接口service,doGet,doPost,
模拟tomcat的disptach(实际调用servlet的service)。
模拟tomcat的配置文件，这里使用简化的操作，没有使用xml配置文件，而是使用map替代配置文件。
后续会逐步更新换成NIO，AIO方式实现

## 步骤
```text
1.启动ServerSocket，封装在MyTomcat中
2.accept得到Socket client
3.调用disptach(new MyRequest(client.getInputStream), new MyResponse(client.getOutputStream))
4.disptch内部根据request的url查询得到对应的servlet包名
5.调用Class.forName(servletName)得到实际的servlet类
6.用反射，netInstance或构造函数创建对象 servletObj
7.servletObj调用service分发请求和应答
8.service内部根据url中的请求方法判断调用doGet或doPost

```