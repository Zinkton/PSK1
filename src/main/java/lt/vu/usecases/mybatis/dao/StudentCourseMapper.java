package lt.vu.usecases.mybatis.dao;

import lt.vu.usecases.mybatis.model.StudentCourse;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseMapper {
    int deleteByPrimaryKey(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);
    int insert(StudentCourse record);
    List<StudentCourse> selectAll();
}