import cv2
import pysnooper
import matplotlib.pyplot as plt


@pysnooper.snoop()
def trim(img):
    # 找到所有非黑像素点
    coords = cv2.findNonZero(img)
    # 找到最小裁剪矩形范围
    x, y, w, h = cv2.boundingRect(coords)
    # 裁剪图像，舍弃拼图的突出部分（14个像素），以提高匹配正确率
    rect = img[y + 20:y + h - 20, x:x + w - 20]
    return rect


@pysnooper.snoop()
def match(target, template):
    # 读取图像
    img_rgb = cv2.imread(target)
    img_gray = cv2.cvtColor(img_rgb, cv2.COLOR_BGR2GRAY)
    template = cv2.imread(template, 0)
    new_template = trim(template)
    # 使用matchTemplate对原始灰度图像和碎片图进行匹配
    res = cv2.matchTemplate(img_gray, new_template, cv2.TM_CCOEFF_NORMED)
    min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(res)
    top_left = max_loc

    # 使用灰度图像中的坐标对原始RGB图像进行标记
    # cv2.rectangle(图片，矩形对角线坐标1，矩形对角线坐标2，颜色，粗细)
    h, w = new_template.shape
    bottom_right = (top_left[0] + w, top_left[1] + h)
    cv2.rectangle(img_rgb, top_left, bottom_right, (255, 255, 255), 2)
    plt.imshow(img_rgb)
    plt.show()
    # 返回匹配位置左上角的横坐标
    print(top_left[0])
    return top_left[0]


image = ("D://opencv/ba.png")
target = ("D://opencv/bu.png")
match(image,target)
