package com.bit.springNote.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bit.springNote.dao.NoteDao;
import com.bit.springNote.dto.NoteDto;

public class NoteListCommand implements NoteCommand {

	@Override
	public void execute(Model model) {
		NoteDao dao = new NoteDao();
		ArrayList<NoteDto> dtos = dao.list();
		model.addAttribute("list", dtos);
	}
}









