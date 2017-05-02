package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Order;
import org.mybatis.cdi.Mapper;

@Mapper
public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(Order record);
    Order selectByPrimaryKey(Integer id);
    List<Order> selectAll();
    int updateByPrimaryKey(Order record);
}