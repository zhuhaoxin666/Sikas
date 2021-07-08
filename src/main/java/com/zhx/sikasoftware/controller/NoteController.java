package com.zhx.sikasoftware.controller;

import com.zhx.sikasoftware.bean.Note;
import com.zhx.sikasoftware.dto.NoteDo;
import com.zhx.sikasoftware.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping("/tomain")
    public ModelAndView toMain(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        List<Note> select = noteService.select();
        modelAndView.addObject("selectAll",select);
        for (Note note : select) {
            log.debug("------{}-------",note.toString());

        }
        return modelAndView;
    }

    @RequestMapping("/toNew")
    public String toNew(){
        return "new";
    }

    @RequestMapping("/insert")
    public String insertNote(Note note){
        log.debug("{}",note.toString());
        noteService.insert(note);
        return "redirect:/tomain";
    }

    @RequestMapping("/todelete")
    public String deleteNote(@Param("id") Integer id){
        log.debug("DELETE----->>>>{}",id);
        Note note = new Note();
        note.setMId(id);
        noteService.delete(note);
        return "redirect:/tomain";
    }

    @RequestMapping("/toupdate")
    public ModelAndView toUpdateNote(@Param("id") Integer id){
        log.debug("UPDATE----->>>>{}",id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("mid",id);
        Note note = new Note();
        note.setMId(id);
        Note note1 = noteService.selectOne(note);
        log.debug("NOTE------->>>>>>{}",note1);
        modelAndView.addObject("note",note1);
        return modelAndView;
    }

    @RequestMapping("/updateNote")
    public String updateNote(Note note,ModelAndView modelAndView){
        noteService.update(note);
        return "redirect:/tomain";
    }

    @RequestMapping("/toquery")
    public ModelAndView query(NoteDo noteDo){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myquery");
        modelAndView.addObject("noto",noteDo);
        List<Note> query = noteService.query(noteDo);
        for (Note note :query) {
            log.debug("QUERY------>>>>{}",note.toString());
        }

        modelAndView.addObject("queryall",query);
        return modelAndView;
    }

}
