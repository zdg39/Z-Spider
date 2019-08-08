# <center>java使用headless chrome
首先下载chromedriver,配置相关启动参数
- webdriver.chrome.driver:设置chromedriver路径,将下载好的chromedriver移动到这个目录下
- --user-data-dir:用户数据存放目录,假设需要多开headless chrome则需要新建另一个目录用来区分不同账户
- --profile-directory:配置文件存放目录,多开headless chrome也需要新建一个新的目录用来区分不同账户
- --User-Agent:修改用户来源,反爬措施会检测到headless chrome的User-Agent
- --headless:开启headless模式
- --disable-gpu:官方文档建议使用,避免出现bug
- --window-size=1920,1080:设置分辨率
- --remote-debugging-address=0.0.0.0:设置远程调试地址,默认是本地回环地址127.0.0.1
- --remote-debugging-port=9222:设置远程调试端口

> 更多配置可以参考:https://peter.sh/experiments/chromium-command-line-switches

在pom.xml文件增加selenium依赖
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>2.42.1</version>
</dependency>
```

编写以下代码
```java

String driverPath = "D:\\soft\\chromedriver.exe";
System.setProperty("webdriver.chrome.driver",driverPath);

ChromeOptions options = new ChromeOptions();
String userDataDir = "D:\\Profile\\Profile1";
File file = new File(userDataDir);
if(!file.exists()){
    file.mkdir();
}
String profileDir = "D:\\Profile\\profile1";
file = new File(profileDir);
if(!file.exists()){
    file.mkdir();
}
options.addArguments("--user-data-dir=" + userDataDir);
options.addArguments("--profile-directory=" + profileDir);
options.addArguments("--User-Agent=Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36");
options.addArguments("--headless");
options.addArguments("--disable-gpu");
options.addArguments("--window-size=1920,1080");
options.addArguments("--remote-debugging-address=0.0.0.0");
options.addArguments("--remote-debugging-port=9222");

WebDriver headlessChromeDriver = new ChromeDriver(options);
headlessChromeDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

headlessChromeDriver.get("https://www.baidu.com");
```
当你使用--remote-debugging-port=9222运行Chrome他会启动一个支持[DevTool协议](https://chromedevtools.github.io/devtools-protocol)的实例该协议用于与Chrome进行通信，并且驱动 Headless Chrome浏览器实例。它也是一个类似Sublime、VS Code 和 Node 的工具，可用于应用程序的远程调试。#协同效应
启动程序后可以使用localhost:9222访问headless chrome的运行情况
<center>![](/headless-chrome/remote-debugging-1.png)</center>

点击百度一下,你就知道则进入打开的百度窗口
<center>![](/headless-chrome/remote-debugging-2.png)</center>

>DevTool Api:https://chromedevtools.github.io/devtools-protocol
