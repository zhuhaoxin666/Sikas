package com.zhx.sikasoftware.mapper.onetomany;

import com.zhx.sikasoftware.onetomany.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    void insert(Teacher teacher);
    void update(Teacher teacher);
    void delete(Teacher teacher);
    List<Teacher> select(Teacher teacher);
}
