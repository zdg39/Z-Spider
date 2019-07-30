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
- 正则
  - 贪婪模式和非贪婪模式
- xpath
- jsoup
- 构建js解析器
  - rhino+envjs
  - htmlunit+jsp
- cookie管理
  - 分布式爬虫cookie管理
  - 多域名cookie管理
- [滑块验证码](#滑块验证码)
  - [拼图类滑块验证码](#拼图类滑块验证码)
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
  - [virtualXposed(免xposed)](#virtualXposed)
- selenium
  - webdriver
  - chrome headless
  - phantomjs(版本已不再更新,一般不考虑使用)
- appium

***

### 滑块验证码
#### 拼图类滑块验证码
- [移动图片和另一张图片拼完整得到x轴坐标差(java版)](https://github.com/zdg39/Z-Spider/tree/master/slide-image)
- [移动图片和另一张图片拼完整得到x轴坐标差(python版)](https://github.com/zdg39/Z-Spider/tree/master/opencv-python)

### 反编译
#### jadx-gui
- [jadx-gui的高级技巧](https://www.jianshu.com/p/e5b021df2170)

### 中间人
#### littleproxy
- [官方文档](https://github.com/adamfisk/LittleProxy)

#### mitmproxy
- [官方文档](https://github.com/mitmproxy/mitmproxy)
- [使用mitmproxy+python做拦截代理](https://blog.wolfogre.com/posts/usage-of-mitmproxy)
- [使用mitmproxy突破网站对selenium的屏蔽](http://www.site-digger.com/html/articles/20180821/653.html)

#### servlet反向代理
  - [使用教程](https://github.com/mitre/HTTP-Proxy-Servlet)

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

## Author

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
