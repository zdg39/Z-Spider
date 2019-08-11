# <center>破解拖动滑块至最右侧类滑块验证码
很多网站都会采用拖动滑块至最右侧这一类验证码,这时采用selenium来开启浏览器拖动滑块来破解,验证码如下:

![slider-verification-code-1](https://raw.githubusercontent.com/zdg39/Z-Spider/master/slider-verification-code/images/slider-verification-code-1.png)

``
这一类验证码只需要找到滑块所在的位置,然后得到移动到最右侧的x轴坐标差就可以;然而部分网站还会校验滑动轨迹,找到滑块的元素就开始拖动会导致失败,就是说需要模拟人类来滑动。
``
## 查找滑块位置和移动距离
首先需要查找到滑块的位置,在chrome浏览器按下F12打开开发者工具,就很容易找到滑块的位置,可以根据你的个人喜好通过xpath或者css selector定位,在这里我使用xpath定位滑块的位置。移动距离在开发者工具打开的情况下可以一边移动滑块一边查看元素的坐标变化,最后成功的style:left的值就是你要移动的距离,或者也可以直接使用量一下大致的距离大概有多少px。

```xpath
//div[@class='bgSlider']/div[1]
```

![slider-verification-code-location](https://raw.githubusercontent.com/zdg39/Z-Spider/master/slider-verification-code/images/slider-verification-code-location.png)

## 启动selenium
在这里使用headless chrome来完成破解,首先需要启动一个ChromeDriver,编写以下代码,如果想使用带有图形化界面的chrome只需修改ChromeOptions的参数即可。#具体headless chrome的使用可以参考[java使用headless chrome](https://github.com/zdg39/Z-Spider/blob/master/headless-chrome/headless-chrome-base-java.md)

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
```

``
获取到滑块的位置和要移动的距离并且已经成功启动headless chrome,则可以开始拖动滑块,在拖动时不能直接拖到最右侧,如果碰见滑动轨迹检测,必定会失败,所以对拖动滑块的代码做了以下封装,整个过程涉及到的鼠标动作有鼠标左键点击滑块不释放,然后拖动一定的距离然后释放。
``

```java
    /**
     * 拖动滑块
     * @param driver
     * @param element:滑块元素
     * @param distance:需要拖动的距离
     * @throws InterruptedException
     */
    public static void move(WebDriver driver,WebElement element,int distance) throws InterruptedException {
        int xDis = distance + 11;
        System.out.println("应平移距离:" + xDis);
        int moveX = new Random().nextInt(8) - 5;
        int moveY = 1;
        Actions actions = new Actions(driver);

        new Actions(driver).clickAndHold(element).perform();
        TimeUnit.MILLISECONDS.sleep(200);

        actions.moveToElement(element, moveX, moveY).perform();
        System.out.println(moveX + "--" + moveY);
        for (int i = 0; i < 22; i++){
            int s = 10;
            if (i % 2 == 0){
                s = -10;
            }
            actions.moveToElement(element, s, 1).perform();
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100) + 150);
        }

        System.out.println(xDis + "--" + 1);
        actions.moveByOffset(xDis, 1).perform();
        TimeUnit.MILLISECONDS.sleep(200);

        actions.release(element).perform();
    }

```

``
在可以模拟人类拖动后就可以开始拖动,使用以下代码拖动滑块
``

```java
WebElement webElement = headlessChromeDriver.findElement(new By.ByXPath("//div[@class='bgSlider']/div[1]"));
move(remoteHeadlessDriver,webElement,400);
```

``
当整个流程可以跑通后再浏览器界面键入:http://localhost:9222 点击你所加载的网站即可看到headless chrome的运行状态,可以看到滑块已经验证成功,在破解滑块成功后记得使用headlessChromeDriver.quit()关闭浏览器
``

![slider-verification-code-success](https://raw.githubusercontent.com/zdg39/Z-Spider/master/slider-verification-code/images/slider-verification-code-success.png)

## 后记
在这里使用的是调用本地的headless chrome破解滑块验证码,还可以调用远程headless chrome,具体可以参考[java远程调用headless chrome](https://github.com/zdg39/Z-Spider/blob/master/headless-chrome/headless-chrome-remote.md)。
