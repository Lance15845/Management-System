# 疫情信息管理系统
## 一、课题背景
&ensp;&ensp;&ensp;&ensp;疫情当前，人员管理工作因为基数大，参数多，成为了防疫工作中的一大难题，患者患病、治愈、死亡等状态的转变，也需要及时地得到统计，这无疑给医护人员增加了巨大的工作量。  
&ensp;&ensp;&ensp;&ensp;当前统计工作没有具体的解决方案，于是想到了制作这样一个疫情信息管理系统，旨在通过信息化手段记录跟踪本地区密切接触者、受感染者、危重症病人、治愈者以及死亡者，以密切接触者为开始一直到感染者治愈或者死亡，记录其基本信息、感染源、核算记录以及发病情况等信息，在通过信息化可视化手段展示本地区疫情发展情况，统计各个人群的数量，每个人群所占比例，以此来减少医务人员的工作量。当前信息管理的不足之处在于：信息更新得不及时，传达不迅速，登记和修改不方便。我们想做的这个系统不光可以登记被隔离的人员，还可以实时地修改他们的信息，例如治愈或者死亡，都可以在第一时间作出修改并同步到系统。在信息统计方面我们也添加了一些功能，管理人员可以直观地从饼状图和折线图观察当前登记人员的治愈率和死亡率，以方便医护人员对于当前的防疫形式做出调整和准确的判断。  
&ensp;&ensp;&ensp;&ensp;如此一来各地信息就可以达到同步，以更快地了解到当前疫情的状况，减少人力物力，提高防疫的工作效率。
## 二、相关技术
### （1）前端：
&ensp;&ensp;&ensp;&ensp;本项目页面涉及到很多个页面的跳转，包括登录界面，主界面，菜单栏，人员的CRUD界面以及数据统计界面，这就导致了前端工作较为繁琐机械，于是我们想到了采用一些框架结构，来减少页面制作的工作量，以此来把有限的时间更多地花在实现预期功能上。所以我们采用了AdminLTE，这是一个主要基于Bootstrap和jQuery的完全响应管理模板里面集成的界面模板与控件非常丰富。只需进行一些简单的页面排版就可以架构起整个界面的大体框架，后面类似的界面以此类推，这样一来减少了原本工作量的同时也保障了页面的美观。但在AdminLTE 使用的过程中我们发现，此类模板虽然操作简单易于制作，但是也存在着许多的弊端，例如很多的地方的修改不够灵活，控件也局限也局限于它自身所带的库，以此有的无法进行制作的界面如登录界面我们仍然采用了传统的html-css的结构框架去进行设计，以求整体系统能达到我们预期的效果。
### （2）后端：
&ensp;&ensp;&ensp;&ensp;本项目后端基于SpringBoot、Spring MVC、Spring Security、Mybatis等技术实现。项目运行时，SpringBoot会生成Dispatcher Servlet拦截所有的请求，并将带有URL的请求转交给对应的控制器，在controller层中，进行业务逻辑的处理，其中涉及到了service层和dao数据访问层。在dao层中，通过MyBatis与数据库进行交互。交互期间，自定义的数据类型以一对一或一对多的形式进行嵌套的链表查询，从而得到对应的数据。数据返回控制器后，产生对应的Model，接着通过html文件进行格式化，形成View，最终通过视图解析器得到视图，响应到页面中。
## 三、环境需求
```
Windows10 64位
Chrome版本 102.0.5005.115（正式版本）
测试环境： 
SDK版本：SDK11
IDE环境：IntelliJ IDEA 2021.1.1
硬件：
处理器：Intel(R) Core(TM)i5-9300H
显卡：NVIDIA GeForce GTX 1660Ti
内存：16GB
硬盘空间：3G以上
```
## 四、需求分析
&ensp;&ensp;&ensp;&ensp;该疫情信息管理系统主要面向政府、社区、医院所开发设计，系统主界面为数据面板，可以直观地向用户展示当前疫情的情况。此外，系统还分为疫情信息管理系统和系统人员管理系统，疫情信息管理主要提供确诊患者管理、死亡患者管理、治愈患者管理以及密切接触管理四大功能，为用户提供详细准确精准的数据，直观地展现并分析当前疫情情况。系统人员管理系统则是针对系统管理着设计的，主要分为增加管理员信息、删除管理员信息、修改管理员信息和查找管理员信息，可设置不同权限，使管理者和普通用户权限分开，可以更好的管理此系统。
## 五、系统设计
### 1.ER图
![image](https://github.com/Lance15845/Management-System/blob/main/src/main/image.png)
### 2.时序图
![image](https://github.com/Lance15845/Management-System/blob/main/src/main/image1.png)
## 六、设计心得
&ensp;&ensp;&ensp;&ensp;本次web开发的实训让我学到了很多。首先这次作业提交采用了github平台，每个小组都会创建一个自己的仓来保存共有的进度，这极大地方便了组员各自在家的情况下小组作业的同步工作；同时github也会显示每个小组成员的贡献，让我体会到了团队协助在项目建设中的重要作用；以及此次分工还采用了甘特图这样的分工具体化方式，提高了小组组员间的合作效率，可以各司其职，更快地投入到自己的工作中去。
&ensp;&ensp;&ensp;&ensp;课题的选择也是我们前期纠结的一大问题，很多的传统系统功能已经趋于完善，很难再又更大的创新。于是我们把眼光投向了最近的社会问题，发现疫情爆发一来，很多地方的信息登记还只是停留在纸质书写和人工统计，这给了我们灵感，才想到开发一个这样的疫情信息管理系统。这让我们发现，开发系统还是要回归于生活回归社会，考虑到实际的实用意义，才能将系统功能和界面设计得更好。
&ensp;&ensp;&ensp;&ensp;在系统开发的过程中，我们遇到过许多的困难，如功能繁多时间紧迫，难以完成大量的页面设计，于是我们便寻找到了结构化模块这样的方法来提高视觉化界面制作的效率，这才在规定时间内把系统完善到了一个预期。后期数据的相互传输与数据库的链接也花费了很多的时间，才做到数据的一体化同步。因此系统开发的过程，也是一个不断学习的过程，这需要我们有不断的知识摄入，才能进一步得优化和改进手头并不完善的系统。
