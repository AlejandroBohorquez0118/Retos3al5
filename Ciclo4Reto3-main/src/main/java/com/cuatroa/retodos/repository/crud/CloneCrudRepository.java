/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatroa.retodos.repository.crud;

import com.cuatroa.retodos.model.Clone;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desaextremo
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {
    public  List<Clone> findByDescriptionContainingIgnoreCase(String description);
    public List<Clone> findByPriceLessThanEqual(double precio);
}
