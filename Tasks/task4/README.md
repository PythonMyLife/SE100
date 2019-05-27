# Task4: A Contianer in Java

## 文件构成：

* application.java：运行主程序，模拟发送请求和接收请求。

* Consumer.java：模拟向容器发送请求

* Producer.java：模拟从容器处理请求

* Container.java：模拟容器处理发送的和待处理的请求

## 运行方式：

```java
Producer producer = new Producer(5, 50);
Consumer consumer = new Consumer(5, 10, 20);
Container container = new Container(35, 20);
container.dealRequest(consumer,producer);
container.print();
```

构造producer：参数分别为producer个数和处理请求所需要的时间
构造consumer：参数分别为consumer个数和发送请求个数以及发送时间间隔
构造container：参数分别为请求超时时间和达到个数上限改变策略，从queue方式处理请求改变为stack方式处理请求

## 运行结果

应用程序运行结果：

```text
request 0:success
request 1:success
request 2:success
request 3:success
request 4:success
request 5:success
request 6:success
request 7:success
request 8:success
request 9:success
request 10:timeout
request 11:timeout
request 12:timeout
request 13:timeout
request 14:timeout
request 15:timeout
request 16:timeout
request 17:timeout
request 18:timeout
request 19:timeout
request 20:success
request 21:success
request 22:success
request 23:success
request 24:success
request 25:timeout
request 26:timeout
request 27:timeout
request 28:timeout
request 29:timeout
request 30:success
request 31:success
request 32:success
request 33:success
request 34:success
request 35:timeout
request 36:timeout
request 37:timeout
request 38:timeout
request 39:timeout
request 40:timeout
request 41:timeout
request 42:timeout
request 43:timeout
request 44:timeout
request 45:success
request 46:success
request 47:success
request 48:success
request 49:success
```