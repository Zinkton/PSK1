package lt.vu.usecases.mybatis.dao;

import lt.vu.usecases.mybatis.model.Student;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(Student record);
    Student selectByPrimaryKey(Integer id);
    List<Student> selectAll();
    int updateByPrimaryKey(Student record);
}