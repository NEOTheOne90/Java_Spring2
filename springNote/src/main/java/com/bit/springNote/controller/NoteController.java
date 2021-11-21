package com.bit.springNote.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.springNote.command.NoteCommand;
import com.bit.springNote.command.NoteListCommand;
import com.bit.springNote.command.NoteWriteCommand;

@Controller
public class NoteController {

	NoteCommand command;
	
	@RequestMapping(value = "noteForm")
	public String noteForm() {return "noteForm";}
	
	//noteWrite
	@RequestMapping(value = "noteWrite", 
			method = RequestMethod.POST)
	public String noteWrite(HttpServletRequest req, Model model) {
		model.addAttribute("request", req);
		command = new NoteWriteCommand();
		command.execute(model);//동적바인딩
		return "redirect:noteList";//noteList 액션 호출
	}
	
	//noteList
	@RequestMapping(value = "noteList")
	public String noteList(Model model) {
		command = new NoteListCommand();
		command.execute(model);
		return "noteList";//views/noteList.jsp 호출
	}
	
	//noteDelete
}









