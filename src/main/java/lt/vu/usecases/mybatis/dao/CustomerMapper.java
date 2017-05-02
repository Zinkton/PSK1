package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Customer;
import org.mybatis.cdi.Mapper;

@Mapper
public interface CustomerMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(Customer record);
    Customer selectByPrimaryKey(Integer id);
    List<Customer> selectAll();
    int updateByPrimaryKey(Customer record);
}