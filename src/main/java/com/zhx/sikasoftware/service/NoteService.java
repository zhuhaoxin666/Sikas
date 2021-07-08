package com.zhx.sikasoftware.service;

import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dto.NoteDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    boolean insert(Note note);
    boolean update(Note note);
    boolean delete(Note note);
    Note selectOne(Note note);
    List<Note> select();
    List<Note> query(NoteDo noteDo);
}
