package com.bit.springNote.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bit.springNote.dao.NoteDao;
import com.bit.springNote.dto.NoteDto;

public class NoteDeleteCommand implements NoteCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("request");
		int id = Integer.parseInt(req.getParameter("writer"));
		NoteDao dao = new NoteDao();
		dao.delete(id);
	}
}









