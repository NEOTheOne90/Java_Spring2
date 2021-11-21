package com.bit.springNote2.dao;

import java.util.ArrayList;

import com.bit.springNote2.dto.NoteDto;

public interface IDao {
	public void write(String writer, String content);
	public ArrayList<NoteDto> list();
	public void delete(int id);
}
