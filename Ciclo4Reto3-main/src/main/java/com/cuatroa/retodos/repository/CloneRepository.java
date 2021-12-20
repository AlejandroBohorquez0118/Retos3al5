package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.CloneCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class CloneRepository {
    @Autowired
    private CloneCrudRepository repository;

    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone> getClone(Integer id) {
        return repository.findById(id);
    }
    
    public Clone create(Clone clone) {
        return repository.save(clone);
    }

    public void update(Clone clone) {
        repository.save(clone);
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
    public List<Clone> productByPrice(double precio) {
	return repository.findByPriceLessThanEqual(precio);
}
    
    public List<Clone> productByDescription (String description){
     
       return repository.findByDescriptionContainingIgnoreCase(description);
        
    }
}
