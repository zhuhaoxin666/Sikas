package com.zhx.sikasoftware.mapper.note;

import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dto.NoteDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteMapper {
    int insert(Note note);
    int update(Note note);
    List<Note> select();
    int delete(Note note);
    Note selectOne(Note note);
    List<Note> query(NoteDo noteDo);
}
