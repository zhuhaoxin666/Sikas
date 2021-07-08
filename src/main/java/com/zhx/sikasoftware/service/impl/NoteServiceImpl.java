package com.zhx.sikasoftware.service.impl;

import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dao.NoteDao;
import com.zhx.sikasoftware.dto.NoteDo;
import com.zhx.sikasoftware.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteDao noteDao;

    @Override
    public boolean insert(Note note) {
        boolean insert = noteDao.insert(note);
        return insert;
    }

    @Override
    public boolean update(Note note) {
        boolean update = noteDao.update(note);
        return update;
    }

    @Override
    public boolean delete(Note note) {
        boolean delete = noteDao.delete(note);
        return delete;
    }

    @Override
    public Note selectOne(Note note) {
        Note note1 = noteDao.selectOne(note);
        return note1;
    }

    @Override
    public List<Note> select() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Note> select = noteDao.select();
        for (int i = 0; i < select.size(); i++) {
            LocalDateTime addDate = select.get(i).getAddDate();
            String format = dateTimeFormatter.format(addDate);
            log.debug("时间戳----->>>>{}", format);


        }
        return select;
    }

    @Override
    public List<Note> query(NoteDo noteDo) {
        List<Note> query = noteDao.query(noteDo);
        return query;
    }
}
