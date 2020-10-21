<h1 align="center">Welcome to Z-Spider 👋</h1>
<p align="center">
  <img src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
  <img src="https://img.shields.io/badge/java-1.8-blue.svg" />
  <img src="https://img.shields.io/badge/python-3.7-blue.svg"/>
  <a href="https://github.com/zdg39/Z-Spider">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" target="_blank" />
  </a>
  <a href="https://github.com/zdg39/Z-Spider/blob/master/LICENSE">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" target="_blank" />
  </a>
</p>

> Z-Spider:一些爬虫开发的技巧和案例

### 🏠 [Homepage](https://github.com/zdg39/Z-Spider)

## 目录
- [抓包工具](#抓包工具)
  - [Fiddler](#Fiddler)
  - [Charles](#Charles)
  - [mitmproxy](#mitmproxy)
  - [Wireshark](#Wireshark)
- [正则](#正则)
  - [基础知识](#基础知识)
  - [元字符和简写字符集](#元字符和简写字符集)
  - 贪婪模式,懒惰模式和独占模式
- [xpath](#xpath)
  - [基础知识](#基础知识)
- [jsoup](#jsoup)
  - [基础知识](#基础知识)
- 构建js解析器
  - rhino+envjs
  - htmlunit+jsp
- cookie管理
  - 分布式爬虫cookie管理
  - 多域名cookie管理
- [滑块验证码](#滑块验证码)
  - [拼图类滑块验证码](#拼图类滑块验证码)
  - [拖动类滑块验证码](#拖动类滑块验证码)
- [图形验证码](#图形验证码)
  - [数字英文类图形验证码](#数字英文类图形验证码)
- [反编译](#反编译)
  - [jadx-gui](#jadx-gui)
- [中间人(mitm)](#中间人)
  - [littleproxy](#littleproxy)
  - [mitmproxy](#mitmproxy)
  - [servlet反向代理](#servlet反向代理)
- [xposed](#xposed)
  - [xposed插件](#xposed插件)
  - [xposed脱壳](#xposed脱壳)
  - [hook](#hook)
  - [virtualXposed(免root xposed)](#virtualXposed)
- [selenium](#selenium)
  - [headlessChrome](#headlessChrome)
  - phantomjs(版本已不再更新,一般不考虑使用)
- [appium](#appium)
  - [appium环境搭建](#appium环境搭建)
- ActiveX控件(一般是银行的数据会采用ActiveX控件反爬,不建议分析了解即可)

---
## 正文

### 抓包工具
#### Fiddler
- [官方文档](https://www.telerik.com/fiddler)

#### Charles
- [官方文档](https://www.charlesproxy.com)

#### mitmproxy
- [官方文档](https://github.com/mitmproxy/mitmproxy)

#### Wireshark
- [官方文档](https://www.wireshark.org)
- [Wireshark 捕捉本地数据 --WinPcap切换NPcap](https://www.cnblogs.com/hongdada/p/7474917.html)
- [如何用 wireshark 抓包 TLS 封包](https://segmentfault.com/a/1190000018746027)

---

### 正则
#### 基础知识
- [正则学习](https://github.com/ziishaned/learn-regex/blob/master/translations/README-cn.md)

#### 元字符和简写字符集
- [元字符](https://github.com/zdg39/Z-Spider/tree/master/regex/meta-character.md)
- [简写字符集](https://github.com/zdg39/Z-Spider/tree/master/regex/simple-character.md)

---

### xpath
#### 基础知识
- [xpath语法](https://devhints.io/xpath)
- [xpath语法验证](http://www.whitebeam.org/library/guide/TechNotes/xpathtestbed.rhtm)

---

### jsoup
#### 基础知识
- [jsoup语法](https://jsoup.org/cookbook)
- [jsoup语法验证](https://try.jsoup.org)

---

### 滑块验证码
#### 拼图类滑块验证码
- [移动图片和另一张图片拼完整得到x轴坐标差(java版)](https://github.com/zdg39/Z-Spider/tree/master/slide-image)
- [移动图片和另一张图片拼完整得到x轴坐标差(python版)](https://github.com/zdg39/Z-Spider/tree/master/opencv-python)

#### 拖动类滑块验证码
- [拖动滑块至最右侧类滑块验证码](https://github.com/zdg39/Z-Spider/blob/master/slider-verification-code/slider-verification-code1.md)

### 图形验证码
#### 数字英文类图形验证码
- [无干扰线无扭曲无交叠数字英文类图形验证码](https://github.com/zdg39/Z-Spider/tree/master/tess4j-ocr-examples)

---

### 反编译
#### jadx-gui
- [jadx-gui的高级技巧](https://www.jianshu.com/p/e5b021df2170)

---

### 中间人
#### littleproxy
- [官方文档](https://github.com/adamfisk/LittleProxy)

#### mitmproxy
- [官方文档](https://github.com/mitmproxy/mitmproxy)
- [使用mitmproxy+python做拦截代理](https://blog.wolfogre.com/posts/usage-of-mitmproxy)
- [使用mitmproxy突破网站对selenium的屏蔽](http://www.site-digger.com/html/articles/20180821/653.html)

#### servlet反向代理
  - [使用教程](https://github.com/mitre/HTTP-Proxy-Servlet)

---

### xposed
#### xposed插件
- [Xposed+JustTrustMe关闭SSL证书验证](https://www.jianshu.com/p/310d930dd62f)

#### xposed脱壳
- [使用Xposed+FDex2插件脱壳](http://www.site-digger.com/html/articles/20190622/732.html)

#### hook
- [XPosed入门与登陆劫持演示](https://www.csdn.net/article/2015-08-14/2825462)

#### virtualXposed
- [官方文档](https://vxposed.com)
- [使用VirtualXposed进行hook](https://mp.weixin.qq.com/s?__biz=MzI1NDg4MTIxMw==&mid=2247484059&idx=1&sn=08722492fcaca840d980b20921217d1c&key=4e389947016351e1e0db9e4c748d4deb1b165b7ba8575728f8540ec8b86c839a13a3bece438383827c017d8e908b56f00dd5ae22ac718ac33436d0ffa42a6ca8dfc753c56945a92789d2c883f11c4f49&ascene=1&uin=MjE4NDE2MzgzNw%3D%3D&devicetype=Windows+10&version=62060739&lang=zh_CN&pass_ticket=f78tVFFElmpnLb7e%2F62L9mBW74v5Nfk9gRZSx%2F0gSXqm5m33zI4TBCJ2csHcyBCO)

---

### selenium
#### headlessChrome
- [java使用headless chrome](https://github.com/zdg39/Z-Spider/blob/master/headless-chrome/headless-chrome-base-java.md)
- [java远程调用headless chrome](https://github.com/zdg39/Z-Spider/blob/master/headless-chrome/headless-chrome-remote.md)

---

### appium
#### appium环境搭建
- [java使用appium](http://www.testclass.net/appium/appium-base-java)
- [appium相关教程](http://www.testclass.net/appium)

---

### Author

👤**zdg &lt;zhudg39@gmail.com&gt;**

* Github: [@zdg39](https://github.com/zdg39)

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/zdg39/Z-Spider/issues).

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2019 [zdg](https://github.com/zdg39).<br />
This project is [MIT](https://github.com/zdg39/Z-Spider/blob/master/LICENSE) licensed.

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
