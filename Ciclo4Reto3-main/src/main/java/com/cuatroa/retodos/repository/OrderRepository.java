package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Order;
import com.cuatroa.retodos.repository.crud.OrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author desarrolloextremo
 */
@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

    public List<Order> findByZone(String zona) {
        return orderCrudRepository.findByZone(zona);
    }

    public List<Order> ordersSalesManByState(String state, Integer id) {

        return orderCrudRepository.findByStatusAndSalesMan_id(state, id);
    }
    
    public List<Order> orderByDate(Date fecha, Integer id){
    
        return orderCrudRepository.findByRegisterDayAndSalesMan_id(fecha,id);
        
    }
    
    public List<Order> findBySalesManId(Integer id){
    
    
        return orderCrudRepository.findBySalesMan_Id(id);
    
    }
}
