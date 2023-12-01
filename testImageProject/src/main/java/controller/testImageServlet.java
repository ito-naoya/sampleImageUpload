package controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/main")
@MultipartConfig
public class testImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public testImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String view = "/WEB-INF/views/formImage.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		Part part = req.getPart("pict");
		System.out.println("part is the " + part);
		
		//ファイル名を取得
		String filename = part.getSubmittedFileName();//ie対応が不要な場合

		System.out.println("fileName is the " + filename);
		//アップロードするフォルダ
		String path = "/Applications"
				+ "/Eclipse_2023-09.app"
				+ "/Contents"
				+ "/workspace"
				+ "/testImageProject"
				+ "/src"
				+ "/main"
				+ "/webapp"
				+ "/images";

		System.out.println("path is the " + path);

		//書き込み
		part.write(path + File.separator + filename);

		req.setAttribute("filename", filename);

		String view = "/WEB-INF/views/result.jsp";
		req.getRequestDispatcher(view).forward(req, res);

	}

}
