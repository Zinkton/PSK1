package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.OrdersDishes;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

@Mapper
public interface OrdersDishesMapper {

    int deleteByPrimaryKey(@Param("dishId") Integer dishId, @Param("orderId") Integer orderId);
    int insert(OrdersDishes record);
    List<OrdersDishes> selectAll();
}