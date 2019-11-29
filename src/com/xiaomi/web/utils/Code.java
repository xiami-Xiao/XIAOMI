package com.xiaomi.web.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
@WebServlet("/code")
public class Code extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// BufferedImage
		int width = 98;
		int height = 40;
		// 生成图片
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNIPQRSTUVWXYZ0123456789";
		Random r = new Random();
		//拿到画笔
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		int x = 20;
		int y = 20;
		g2d.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g2d.setColor(Color.ORANGE);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			
			int jiaodu = r.nextInt(20) - 10;
			int index = r.nextInt(str.length());
			char c = str.charAt(index);
			g2d.drawString(c+"", x, y);
			sb.append(c);
			g2d.rotate(jiaodu*Math.PI/180,x,y);
			x += 20;
			g2d.rotate(-jiaodu*Math.PI/180,x,y);
		}
		//绘制三条干扰线
		g2d.setColor(Color.WHITE);
		int x1 , y1 , x2 ,y2;
		for (int i = 0; i < 3; i++) {
			x1 = r.nextInt(width);
			x2 = r.nextInt(width);
			y1 = r.nextInt(height);
			y2 = r.nextInt(height);
			
			g2d.drawLine(x1, y1, x2, y2);
		}
		request.getSession().setAttribute("checkCode", sb.toString());
		System.out.println(request.getSession().getAttribute("checkCode"));
		// 显示到页面上
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
