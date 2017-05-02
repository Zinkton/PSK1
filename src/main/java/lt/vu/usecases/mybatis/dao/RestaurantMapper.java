package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Restaurant;
import org.mybatis.cdi.Mapper;

@Mapper
public interface RestaurantMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(Restaurant record);
    Restaurant selectByPrimaryKey(Integer id);
    List<Restaurant> selectAll();
    int updateByPrimaryKey(Restaurant record);
}