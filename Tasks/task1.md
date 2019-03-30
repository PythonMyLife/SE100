# 对上海交通大学主页的分析和比较

## 运用F12对上海交通大学新版主页进行分析

### 学习使用Chrome的F12开发者工具

![新版主页elements](https://img-blog.csdnimg.cn/20190330215038789.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjY4NjMz,size_16,color_FFFFFF,t_70)  
点击F12进入Chrome的开发者工具界面，查看Elements，查看前面界面的html的Dom结构。

#### Elements

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

#### Network

![Network总览](https://img-blog.csdnimg.cn/20190330230323847.png)

1、