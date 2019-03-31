# 对上海交通大学主页的分析和与旧版的比较

## 学习使用Chrome的F12开发者工具对上海交通大学新版主页进行分析

![新版主页elements](https://img-blog.csdnimg.cn/20190330215038789.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjY4NjMz,size_16,color_FFFFFF,t_70)  
点击F12进入Chrome的开发者工具界面，查看Elements，查看前面界面的html的Dom结构。

### Elements

* Elements 分为两部分：  
A：HTML结构面板  
B：操作dom样式、结构、时间的显示面板  
  
1、鼠标移动到elements的HTML结构面板的元素上，html视图将对应的元素背景改为蓝色，选中元素后右侧显示面板框中还会展示该元素的样式。（还可以对style进行更改，html结构也会实时更新。）
![Element操作1](https://img-blog.csdnimg.cn/20190330221257473.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjY4NjMz,size_16,color_FFFFFF,t_70)
  
2、在Event Listeners界面可以查看元素绑定的事件。点击链接可以跳转到事件具体的位置。
![Element操作2](https://img-blog.csdnimg.cn/20190330222729623.png)
  
3、可以在左侧按快捷键Ctrl+F对元素进行查找，匹配的元素会高亮显示。  
![Elements操作3](https://img-blog.csdnimg.cn/2019033022403263.png)
  
4、选中一个元素，右击鼠标，有一个弹出窗口出现，里面有若干选项：

* Add attribut : 为该元素添加属性
* Edit attribute：修改该元素的属性
* Force element state： 为元素激活某种状态（主要用在可以几乎的元素比如a、input、button等）
* Edit as HTML：编辑该元素（你可以重写它的整个content）甚至修改它的标签名称
* Break on：为该元素添加dom操作事件监听。包含三个选项（树结构改变、属性改变、节点移除）
![element操作4](https://img-blog.csdnimg.cn/20190330225509126.png)

### Network

![Network总览](https://img-blog.csdnimg.cn/20190330230323847.png)

1、Network是一个监控当前网页所有的http请求的面版，它主体部分展示的是每个http请求，每个字段表示着该请求的不同属性和状态：

* Name：请求文件名称
* Method：方法（常见的是get post）
* Status：请求完成的状态
* Type：请求的类型
* Initiator：请求源
* Size：下载文件或者请求占的资源大小
* Time：请求或下载的时间
* Waterfall：该链接在发送过程中的时间状态轴（我们可以把鼠标移动到这些红红绿绿的时间轴上，对应的会有它的详细信息：开始下载时间，等待加载时间，自身下载耗时）

2、单击面板中的任意一条http信息，会在底部弹出一个新的面板，其中记录了该条http请求的详细参数header（表头信息、返回信息、请求基本状态）、Preview（返回的格式化转移后文本信息）、response（转移之前的原始信息）、Cookies（该请求带的cookies）、Timing（请求时间变化）

![Network操作1](https://img-blog.csdnimg.cn/20190331175126639.png)

3、在主面板的顶部，有一些按钮从左到右它们的功能分别是：是否启用继续http监控（默认高亮选中过）、清空主面板中的http信息、是否启用过滤信息选项（启用后可以对http信息进行筛选）、列出多种属性、只列出name和time属性、preserve log、Dishable cahe（禁用缓存，所有的304返回会和fromm cahe都回变成正常的请求忽视cache conctrol 设定）；

![Network操作2](https://img-blog.csdnimg.cn/20190331175739108.png)

### Sources

Sources部分主要向我们展示了本界面所加载的资源列表。还有cookie和local storage 、SESSION 等本地存储信息.

![Network操作2](https://img-blog.csdnimg.cn/20190331180056747.png)

## 与旧版网页进行比较分析

### 1、页面分析

* 整体界面

新版界面更加简洁美观。
![新版界面1](https://img-blog.csdnimg.cn/20190331182721451.png)

旧版界面功能更多，但比较丑陋。
![旧版界面1](https://img-blog.csdnimg.cn/20190331182729737.jpg)

* css框架采用  

新版界面采用了bootstrap框架。
![新版界面2](https://img-blog.csdnimg.cn/20190331183233254.png)

旧版界面未采用框架进行布局，这使得旧版网页的模块化做得不如新版网页好，整体呈现出一种比较贴图化的特征。
![旧版界面2](https://img-blog.csdnimg.cn/2019033118393196.png)

* 缩放

新版网页缩放会使得模块与模块之间发生重叠。
![新版界面3](https://img-blog.csdnimg.cn/20190331184721730.png)

旧版网页缩放则不会产生问题。
![旧版界面3](https://img-blog.csdnimg.cn/20190331185220792.png)

### 2、响应速度

* 打开主页时

新版loading:47.6ms
![新版响应1](https://img-blog.csdnimg.cn/20190331194051959.png)

旧版loading:22.9ms
![旧版响应1](https://img-blog.csdnimg.cn/20190331194208747.jpg)

新版页面的加载时间比旧版页面慢，其中script占比比较大。

* 点击用jaccount登录时

新版load：1.03s
![新版响应2](https://img-blog.csdnimg.cn/20190331195401649.png)

旧版load：945ms
![旧版响应2](https://img-blog.csdnimg.cn/20190331195410625.png)
新旧版响应速度差不多。

* jaccount登录时

新版load：1.36s
![新版响应3](https://img-blog.csdnimg.cn/20190331195837606.png)

旧版load：1.36s
![旧版响应3](https://img-blog.csdnimg.cn/20190331195937690.png)
新旧版响应速度差不多

总体来将响应速度方面差别不大。

### 优化建议

新版主页的页面布局可以进一步优化，以避免组件堆叠在一起的情况。

## 参考资料

[Chrome开发者工具不完全指南（一、基础功能篇）](https://cloud.tencent.com/developer/article/1343645)
[chrome调试-性能分析performance篇](https://www.jianshu.com/p/b6f87bac5381)