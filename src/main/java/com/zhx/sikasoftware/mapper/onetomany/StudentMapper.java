package com.zhx.sikasoftware.mapper.onetomany;

import com.zhx.sikasoftware.onetomany.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    void insert(Student student);
    void update(Student student);
    void delete(Student student);
    List<Student> select(Student student);
}
