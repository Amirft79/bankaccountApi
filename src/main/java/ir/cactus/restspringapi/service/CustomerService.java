package ir.cactus.restspringapi.service;

import ir.cactus.restspringapi.exception.RecordeNotFoundException;
import ir.cactus.restspringapi.model.CustomersEntity;
import ir.cactus.restspringapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository repository;

    public List<CustomersEntity> getAllCustomer(){
        List<CustomersEntity> customersEntities=repository.findAll();
        if (customersEntities.size()>0){
            return customersEntities;
        }
        else{
            return new ArrayList<CustomersEntity>();
        }

    }

    public CustomersEntity getCustomerBYId( Long customerId)throws RecordeNotFoundException {

         Optional<CustomersEntity> customersEntity=repository.findById(customerId);
        if (customersEntity.isPresent()){
            return customersEntity.get();
        }else{
            throw  new RecordeNotFoundException("not found");
        }
    }

    public List<CustomersEntity> findAll() {
        return repository.findAll();
    }



}
