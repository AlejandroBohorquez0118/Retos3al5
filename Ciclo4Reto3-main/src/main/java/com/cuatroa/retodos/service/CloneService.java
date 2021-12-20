package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Clone;
import com.cuatroa.retodos.repository.CloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author desaextremo
 */
@Service
public class CloneService {

    @Autowired
    private CloneRepository repository;

    public List<Clone> getAll() {
        return repository.getAll();
    }

    public Optional<Clone> getClone(Integer id) {
        return repository.getClone(id);
    }

    public Clone create(Clone clone) {
        if (clone.getId()== null) {
            return clone;
        } else {
            return repository.create(clone);
        }
    }

    public Clone update(Clone clone) {

        if (clone.getId()!= null) {
            Optional<Clone> cloneDb = repository.getClone(clone.getId());
            if (!cloneDb.isEmpty()) {
                if (clone.getBrand() != null) {
                    cloneDb.get().setBrand(clone.getBrand());
                }

                if (clone.getProcesor() != null) {
                    cloneDb.get().setProcesor(clone.getProcesor());
                }

                if (clone.getOs() != null) {
                    cloneDb.get().setOs(clone.getOs());
                }

                if (clone.getDescription() != null) {
                    cloneDb.get().setDescription(clone.getDescription());
                }
                if (clone.getPrice() != 0.0) {
                    cloneDb.get().setPrice(clone.getPrice());
                }
                if (clone.getQuantity() != 0) {
                    cloneDb.get().setQuantity(clone.getQuantity());
                }
                if (clone.getPhotography() != null) {
                    cloneDb.get().setPhotography(clone.getPhotography());
                }
                cloneDb.get().setAvailability(clone.isAvailability());
                repository.update(cloneDb.get());
                return cloneDb.get();
            } else {
                return clone;
            }
        } else {
            return clone;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClone(id).map(accesory -> {
            repository.delete(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Clone> productByPrice(double price) {
        return repository.productByPrice(price);
    }
    
    public List<Clone> productByDescription(String description){
    
        return repository.productByDescription(description);
    
    }
}
