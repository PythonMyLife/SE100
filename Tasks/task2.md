# Restful service of wordladder 资源占用分析

## 工具

* Postman：用于发送http请求
* Apachebench：用于web服务器压力测试
* Jmeter: 监控CPU、memory等的消耗情况

## 操作及结果

1. 用postman向 http://localhost:8080/login 发送 post请求用户名和密码，获得JSESSIONID。
2. 用apachebench将不同并发量的请求发送到 http://localhost:8080/greeting?str1=data&&str2=code ，命令如下：
`ab.exe -c 100 -n 1000 -H "Cookie: JSESSIONID=4E9A66D3E4C97F526DBCC3BF063742E9" http://localhost:8080/greeting?str1=data&&str2=code`
3. 在jmeter中添加jp@gc-PerfMon Metrics Collector,在Metric to collect中添加CPU和memory,准备进行测试
4. 运行ServerAgent,点击Jmeter的start开始收集数据。
4. 结果分析

* 对于CPU：分别取cuncurrent为0,10,20,50,100,随着cuncurrent的不断增大，CPU不断被消耗。
* 对于内存：cuncurrent一定时，随着请求数量的增长，内存使用量也会增长，每到一个阶段垃圾收集器会自动收集已用内存，并发数变化时没有明显的内存变化。
