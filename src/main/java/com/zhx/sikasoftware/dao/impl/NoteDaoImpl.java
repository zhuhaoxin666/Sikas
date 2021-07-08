package com.zhx.sikasoftware.dao.impl;

import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dao.NoteDao;
import com.zhx.sikasoftware.dto.NoteDo;
import com.zhx.sikasoftware.mapper.note.NoteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class NoteDaoImpl implements NoteDao {

    @Autowired
    NoteMapper noteMapper;

    @Override
    public boolean insert(Note note) {
        int insert = noteMapper.insert(note);
        if (insert > 0)
            return true;
        return false;
    }

    @Override
    public boolean update(Note note) {
        int update = noteMapper.update(note);
        if (update > 0)
            return true;
        return false;
    }

    @Override
    public boolean delete(Note note) {
        int delete = noteMapper.delete(note);
        if (delete > 0)
            return true;
        return false;
    }

    @Override
    public List<Note> select() {
        List<Note> select = noteMapper.select();
        return select;
    }

    @Override
    public Note selectOne(Note note) {
        Note note1 = noteMapper.selectOne(note);
        return note1;
    }

    @Override
    public List<Note> query(NoteDo noteDo) {
        List<Note> query = noteMapper.query(noteDo);
        return query;
    }
}
