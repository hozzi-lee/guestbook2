package com.javaex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@WebServlet("/gbc")
public class GuestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글 깨짐 현상 해결
		request.setCharacterEncoding("UTF-8");

		// datebaseDao 인스턴스
		GuestbookDao gbDao = new GuestbookDao();

		// 파라미터 page값 읽기
		String page = request.getParameter("page");

		if ("addList".equals(page)) {
			// list DB데이터 어트리뷰트
			request.setAttribute("gList", gbDao.getList());

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/addList.jsp");
			rd.forward(request, response);

		} else if ("add".equals(page)) {
			// 파라미터 input값 읽기
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String ct = request.getParameter("ct");

			gbDao.insert(new GuestbookVo(name, pw, ct));

			response.sendRedirect("/guestbook2/gbc?page=addList");

		} else if ("dForm".equals(page)) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/dForm.jsp");
			rd.forward(request, response);

		} else if ("delete".equals(page)) {
			// 파라미터값 읽기
			int no = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("pw");

			gbDao.delete(new GuestbookVo(no, pw));

			response.sendRedirect("/guestbook2/gbc?page=addList");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
