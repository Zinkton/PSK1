package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Dish;
import org.mybatis.cdi.Mapper;

@Mapper
public interface DishMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(Dish record);
    Dish selectByPrimaryKey(Integer id);
    List<Dish> selectAll();
    int updateByPrimaryKey(Dish record);
}