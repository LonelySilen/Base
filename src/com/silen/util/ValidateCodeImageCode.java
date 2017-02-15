package com.silen.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/*
 * 完成验证码图片的生成并将验证码的值传回去放入session中。
 * 验证码生成思路及过程
 * */

public class ValidateCodeImageCode {
	private ByteArrayInputStream image;// 定义存储验证码图片的字节数组对象 ==给Struts Action使用
	private BufferedImage bufferedImage; // 定义存储验证码图片的图片内存对象 ==给Servlet使用
	private String code;// 验证码
	private int codeNum = 5;// 验证码字符个数，默认是5个

	public void setCodeNum(int codeNum) {
		this.codeNum = codeNum;
	}

	// 验证码的取值范围
	private static final char[] randomSequence = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9' };

	// 默认生成5个字符的验证码
	private ValidateCodeImageCode() {
		init();// 完成验证码的生成
	}

	// 根据参数生成验证码的个数
	private ValidateCodeImageCode(int codeNum) {
		this.codeNum = codeNum;
		init();// 完成验证码的生成
	}

	public static ValidateCodeImageCode newInstance() {
		return new ValidateCodeImageCode();
	}

	public static ValidateCodeImageCode newInstance(int codeNum) {
		return new ValidateCodeImageCode(codeNum);
	}

	public ByteArrayInputStream getImage() {
		return this.image;
	}

	public String getCode() {
		return this.code;
	}

	private void init() {
		// 定义验证码图片的宽和高（宽度的计算方式，每个字符占13个像素，前后各留出6个像素点，如果是5个字符，则为：6+13*5+6=77，高度为什么是20，参看下面说明
		int width = 6 + 13 * this.codeNum + 6, height = 20;
		// 定义用于存储验证码图片的BufferedImage对象，指定宽、高，使用RGB颜色机制
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取BufferedImage
		this.bufferedImage = image;
		// 创建用于画图的对象Graphics，此时所有对于Graphics对象g的操作均会放入image中。 g可以理解为画笔对象
		Graphics g = image.getGraphics();
		// 生成随机数类，使用种子，保证每次生成的随机数都不相同
		Random random = new Random(new Date().getTime());
		// 设定背景色,三个参数是rgb的颜色值
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		// 设定图形的大小
		g.fillRect(0, 0, width, height);
		// 创建字体，字形，字体的大小（根据图片的高度确定）。字体也可以是中文
		Font font = new Font("Times New Roman", Font.PLAIN, height - 2);
		// new Font("微软雅黑"， Font.PLAIN, height-2);
		// 设置字体。
		g.setFont(font);
		// 随机产生若干条干扰线，也就是所谓的噪点，使图象中的认证码不易被其它程序识别出来
		// 随机设置线的颜色
		g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		// 随机生成干扰线的数目，最多10条；
		int lineNum = random.nextInt(10);
		// 循环输出干扰线
		for (int i = 0; i < lineNum; i++) {
			// 随机干扰线的起点和终点（终点是起点+12）
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			// 绘制干扰线
			g.drawLine(x, y, x + xl, y + yl);
			// 输出其他干扰字符，如*
			// g.drawString("*", x1, y1);
		}
		// 产生随机数（假定产生5个随机数），并用随机颜色绘制
		// 初始化验证码字符串
		String sRand = "";
		// 随机产生codeNum个验证码，每产生一个验证码就用随机颜色绘制出来
		for (int i = 0; i < codeNum; i++) {
			// 随机产生一个数组长度以内的数字
			// randomSequence.length 数组长度，获取其范围以内的随机数
			int index = random.nextInt(randomSequence.length);
			// 在验证码的取值范围中获取随机生成的那个验证码
			String rand = String.valueOf(randomSequence[index]);
			// 累加生成验证码字符串
			sRand += rand;
			// 设置绘制验证码的随机颜色
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			// 绘制验证码，注意，此处的y坐标是绘制字符的下方起点的坐标，所以是16，也即是上下各留2个像素点，加上字体的高度是18，所以图像高度是20
			g.drawString(rand, 13 * i + 6, 16);
		}
		// 将验证码放入code准备回传
		this.code = sRand;
		// 注销图象对象
		g.dispose();
		// 生成字节数组输出流对象
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			// 使用字节数组输出流output生成图像输出流对象imageOut，向imageOut中输入的任何图像均会放入output中
			ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
			// 由已放入验证码图像的image对象生成类型为JPEG图片的图片输出流
			ImageIO.write(image, "JPEG", imageOut);
			// 写入完毕，关闭imageOut对象
			imageOut.close();
			// 将最后生成的图像的字节数组输出流output放入字节数组输入流中
			this.image = new ByteArrayInputStream(output.toByteArray());
		} catch (Exception e) {
			System.out.println("验证码图片产生出现错误：" + e.toString());
		}

	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
}
