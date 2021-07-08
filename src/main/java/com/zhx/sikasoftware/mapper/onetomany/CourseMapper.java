package com.zhx.sikasoftware.mapper.onetomany;


import com.zhx.sikasoftware.onetomany.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    void insert(Course course);
    List<Course> select(Course course);
    void update(Course course);
    void delete(Course course);
}
