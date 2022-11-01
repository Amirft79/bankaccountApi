package ir.cactus.restspringapi.web;

import ir.cactus.restspringapi.dto.CustomersEntityDto;
import ir.cactus.restspringapi.exception.RecordeNotFoundException;
import ir.cactus.restspringapi.mapper.CustomerMapper;
import ir.cactus.restspringapi.model.CustomersEntity;
import ir.cactus.restspringapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class Controller {
    @Autowired
    CustomerService service;
    @Autowired
    CustomerMapper mapper;
    @GetMapping
    public ResponseEntity<List<CustomersEntity>>getAllCustomers() {
        List<CustomersEntity> customersEntities=service.getAllCustomer();
        return new ResponseEntity<>(customersEntities,new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomersEntity>getCustomersById(@PathVariable("id")Long id) throws RecordeNotFoundException {
      CustomersEntity entity=service.getCustomerBYId(id);
      if (entity.getCustomerName()==null){
          throw new RecordeNotFoundException("not found item");
      }
      else {
          return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
      }
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomersEntityDto> findAll() {
        return mapper.modelsToDtos(service.findAll());
    }
}
