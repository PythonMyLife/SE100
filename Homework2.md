# Web App,Native App和Hybird App 的比较
## Native app 
    Native App是一种基于智能手机本地操作系统如iOS、Android、WP并使用原生程式编写运行的第三方应用程序，也叫本地app。
    一般使用的开发语言为Objective-C、JAVA、C++。
应用举例：

<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540723014511&di=9988e38d3bacafdf2cdd4728850a9587&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20150420%2FshishangshoujiAPPjiemian_4192766.jpg" width="40%" height="40%">

**优点**： 

   （1）可以对不同平台的用户提供完美的用户体验  
   （2）性能稳定，上手流畅，操作速度快  
   （3）可以访问本地硬件设备和资源（摄像头，通讯录）  
   （4）拥有系统级的贴心通知或提醒  
   （5）盈利模式明朗，用户存留率高  

**缺点**： 

   （1）可移植性低，不同平台需要分别开发  
   （2）需要第三方审核  
   （3）维护成本高，不同平台不同版本都需要维护
   （4）盈利需要与第三方分成  
   （5）更新-审核-上线 使得版本更新缓慢
   
## Web App
    以HTML+JS+CSS等WEB技术编程，代码运行在移动端浏览器中，通过该移动端浏览器来调用Device API（取决于HTML5未来的支持
    能力）的不需要用户安装的应用程序；

应用举例：

<img src="http://image.woshipm.com/wp-files/2014/12/819633c03aeddd9f06db8d0844ebd10a.png">

**优点**：

   （1）开发成本低，版本更新快  
   （2）维护成本低，版本更新无需用户手动更新  
   （3）能够跨平台和终端 
   
**缺点**：
 
   （1）用户体验差，操作流畅性较差  
   （2）不支持离线模式，渲染性能较弱   

## Hybird App
    Hybrid APP指的是半原生半Web的混合类App，兼具“Native App良好用户交互体验的优势”和“Web App跨平台开发的优势”。 
    需要下载安装，看上去类似Native App，但只有很少的UI Web View，访问的内容是 Web 。 

Hybrid App按网页语言与程序语言的混合，又分为四种类型：

- **多View混合型**  
   Native View和Web View独立展示，交替出现。  
   这种应用混合逻辑相对简单。即在需要的时候，将WebView当成一个独立的View（Activity）运行起来，在WebView内完成相关的展示操作。  
   这种移动应用主体通常是Native App，Web技术只是起到补充作用。开发难度和Native App基本相当。  
     
- **单View混合型**  
   即在同一个View内，同时包括Native View和Web View，互相之间是覆盖（层叠）的关系。   
   这种Hybrid App的开发成本较高，开发难度较大，但是体验较好。   
     
- **Web主体型** 
   移动应用的主体是Web View，主要以网页语言编写，穿插Native功能的Hybrid App开发类型。  
   这种类型开发的移动应用体验相对而言存在缺陷，但整体开发难度大幅降低，并且基本可以实现跨平台。  
     
- **多主体共存型** 
   这是一种新型的开发模式，即支持Web主体型的应用，又支持以Native主体的应用，也支持两者混合的开发模式。 
   比如kerkee框架，它具有跨平台、用户体验好、性能高、扩展性好、灵活性强、易维护、规范化、具有Debug环境、彻底解决跨域问题等特点。
   用户体验与Native App媲美。功能方面，开发者可随意扩展接口。

## 三者关系和比较
三者关系图：

![关系图](https://img-blog.csdn.net/20160818121839209)

它们在开发成本，用户体验等方面的对比：

![对比图](https://img-blog.csdn.net/20160818123829374)

技术特性对比：

![技术对比](http://image.woshipm.com/wp-files/2014/12/b0cf05c189c1814380709ec94ebd5a7b.png)

## 不同类型app应用情景
- 预算充足时可以开发几个native app和一个web app，预算不足时可以开发web app
- 开发时间紧迫时可以优先开发web app 可以快速面市
- 应用如果需要和手机的某些功能深度整合（比如摄像头），优先选择native app

### 参考资料
- [[1]百度百科：Native app](https://baike.baidu.com/item/Native%20App/4491953?fr=aladdin)
- [[2]CSDN:什么是Web App、Hybrid App、 Native App以及区别，当前主流移动和应用程序类型](https://blog.csdn.net/csdn100861/article/details/52239925)
- [[3]web app 、native app、hybrid app比较](http://blog.51cto.com/11959825/2173950)
- [[4]聊聊Web App、Hybrid App与Native App的设计差异](http://www.woshipm.com/pd/123646.html)
