package com.cuatroa.retodos.repository.crud;

import com.cuatroa.retodos.model.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author desarrolloextremo
 */
public interface OrderCrudRepository extends CrudRepository<Order, Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    public List<Order> findByRegisterDayAndSalesMan_id(Date fecha,Integer id);
    
    public List<Order> findBySalesMan_Id(Integer id);
    
    public List<Order> findByStatusAndSalesMan_id(String status,Integer id);

}