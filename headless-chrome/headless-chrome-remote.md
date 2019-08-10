# <center>java远程调用headless chrome
headless chrome除了可以运行在本地机器,还可以运行在远程机器,本地编写客户端调用。

## 基本原理
## 搭建服务端环境
服务端选用阿里云CentOS7机器,配置是1核2G，也可以使用windows机器,windows机器搭建和linux基本一致,直接进入相关链接下载对应的版本即可。
- 安装chrome

```shell
wget http://dl.google.com/linux/chrome/rpm/stable/x86_64//google-chrome-stable-76.0.3809.100-1.x86_64.rpm
yum localinstall google-chrome-stable-76.0.3809.100-1.x86_64.rpm
```
- 安装chromedriver

```shell
wget https://chromedriver.storage.googleapis.com/76.0.3809.25/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
```

- 下载selenium-server-standalone

```shell
wget http://selenium-release.storage.googleapis.com/2.42/selenium-server-standalone-2.42.1.jar
```

- 启动selenium-server-standalone

``
启动selenium-server-standalone需要使用jdk,首先确保你的机器上可以使用java命令(建议使用jdk8),然后使用下列命令启动
``

```shell
java -Dwebdriver.chrome.driver=/usr/local/chromedriver -jar selenium-server-standalone-2.42.1.jar -port 4445
```

``
其中-Dwebdriver.chrome.driver=/usr/local/chromedriver是指定chromedriver所在路径,必须保证和刚才下载的chromedriver所在路径保持一致。
-port 4445是启动端口,默认的启动端口是4444,因为在liunx环境下部分运营商会禁止一些端口的使用,其中就包含4444,所以这里需要指定一个自定义的端口。为了能够在后台启动所以使用下面的命令启动
``

```shell
nohup java -Dwebdriver.chrome.driver=/usr/local/chromedriver -jar selenium-server-standalone-2.42.1.jar -port 4445 >> selenium-server-standalone.log 2>&1 &
```

``
输入启动命令后查看selenium-server-standalone.log文件,看到以下输出则是启动成功。#启动比较慢,耐心等待即可
``

![selenium-server-standalone-start](https://raw.githubusercontent.com/zdg39/Z-Spider/master/headless-chrome/selenium-server-standalone-start.png)

``
在浏览器地址栏输入http://yourip:4445/wd/hub即可看到以下输出,到这里服务端环境已经搭建成功。
``

![selenium-hub](https://raw.githubusercontent.com/zdg39/Z-Spider/master/headless-chrome/selenium-hub.png)
