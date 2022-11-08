package ir.cactus.restspringapi.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "get customer by id",description = "use this get method to get customers by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok, successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomersEntity.class)))) ,
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")})
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
