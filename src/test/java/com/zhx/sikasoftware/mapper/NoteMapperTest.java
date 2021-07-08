package com.zhx.sikasoftware.mapper;

import com.baomidou.mybatisplus.annotation.TableId;
import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dao.NoteDao;
import com.zhx.sikasoftware.dto.NoteDo;
import com.zhx.sikasoftware.mapper.note.NoteMapper;
import com.zhx.sikasoftware.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class NoteMapperTest {

    @Autowired
    NoteMapper noteMapper;

    @Test
    void test01(){
        Note note = new Note();
        note.setAuthor("王老五");
        note.setTitle("煤老板");
        note.setEmail("王老五@outlook.com");
        note.setContent("最爱挖煤炭");
        noteMapper.insert(note);
    }

    @Test
    void test02(){
        List<Note> select = noteMapper.select();
        for (Note note : select) {
            log.debug("{}",note.toString());
        }

    }

    @Test
    void test03(){
        Note note= new Note();
        note.setMId(1);
        note.setTitle("吃饭睡觉打豆豆");
        note.setEmail("   123   @");
        note.setContent("我我我我我我我我我");
        noteMapper.update(note);
    }

    @Test
    void test04(){
        Note note = new Note();
        note.setMId(4);
        noteMapper.delete(note);
    }

    @Test
    void test05(){
        Note note = new Note();
        note.setMId(1);
        Note note1 = noteMapper.selectOne(note);
        log.debug("NOTE---->>>>{}",note1.toString());
    }

    @Autowired
    NoteService noteService;

    @Autowired
    NoteDao noteDao;
    @Test
    void test06(){
        Note note = new Note();
        note.setMId(1);
        Note note1 = noteService.selectOne(note);
        log.debug("--->>>{}",note1.toString());
    }

    @Test
    void test07(){
        NoteDo noteDo = new NoteDo();
        noteDo.setContent("好日子");
        List<Note> query = noteService.query(noteDo);
        for (Note note :query) {
            log.debug("NoteDO--->{}",note.toString());
        }

    }
}
