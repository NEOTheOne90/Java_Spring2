package com.bit.springNote2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.springNote2.dao.IDao;

@Controller
public class NoteController {

	 // servlet-context.xml 선언된 객체를 주입 받아서 사용
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "noteForm")
	public String noteForm() {
		return "noteForm";
	}

	// noteWrite
	@RequestMapping(value = "noteWrite", method = RequestMethod.POST)
	public String noteWrite(@RequestParam("writer") String writer, 
			@RequestParam("content") String content) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.write(writer, content);
		return "redirect:noteList";// noteList 액션 호출
	}

	// noteList
	@RequestMapping(value = "noteList")
	public String noteList(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.list());
		return "noteList";// views/noteList.jsp 호출
	}

	// noteDelete
	@RequestMapping(value = "noteDelete")
	public String noteDelete(@RequestParam("id") int id) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.delete(id);
		return "redirect:noteList";
	}

}
