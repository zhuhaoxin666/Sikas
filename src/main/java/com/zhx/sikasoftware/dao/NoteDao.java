package com.zhx.sikasoftware.dao;

import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dto.NoteDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao {
    boolean insert(Note note);
    boolean update(Note note);
    boolean delete(Note note);
    List<Note> select();
    Note selectOne(Note note);
    List<Note> query(NoteDo noteDo);
}
