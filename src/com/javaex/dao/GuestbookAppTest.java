package com.javaex.dao;

import java.util.List;

import com.javaex.vo.GuestbookVo;

public class GuestbookAppTest {

	public static void main(String[] args) {

		GuestbookDao gbDao = new GuestbookDao();

		gbDao.delete(new GuestbookVo(10, "asd"));

		gbDao.insert(new GuestbookVo("test2", "test2", "test2"));

		showList(gbDao.getList());

	}

	public static void showList(List<GuestbookVo> l) {
		for (GuestbookVo g : l) {
			System.out.println(
					"번호: " + g.getNo() + "\n"
					+ "이름: " + g.getName() + "\n"
					+ "비밀번호: " + g.getPassword() + "\n"
					+ "내용: " + g.getContent() + "\n"
					+ "작성날짜: " + g.getDate()
					);
		}
		System.out.println();
	}
}
