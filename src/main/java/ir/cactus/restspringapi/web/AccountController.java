package ir.cactus.restspringapi.web;

import ir.cactus.restspringapi.exception.RecordeNotFoundException;
import ir.cactus.restspringapi.exception.ResourceNotFoundException;
import ir.cactus.restspringapi.model.BankAccountEntity;
import ir.cactus.restspringapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Accounts")
public class AccountController {

    @Autowired
    AccountService service;
    @GetMapping
    public ResponseEntity<List<BankAccountEntity>>getAllAccounts(){

        List<BankAccountEntity>accountEntities=service.getAllAccount();
        return new ResponseEntity<>(accountEntities,new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/accountsByCustomer/{id}")
    public ResponseEntity<List<BankAccountEntity>>getBankAccountById(@PathVariable("id")Long id) throws ResourceNotFoundException {
        List<BankAccountEntity> accountEntities=service.getAccountsById(id);
        if (accountEntities.size()>0) {
            return new ResponseEntity<>(accountEntities, new HttpHeaders(), HttpStatus.OK);
        }else throw new ResourceNotFoundException("account not found");
    }

    @GetMapping("/accountByAccountNumber/{accountNumber}")
    public ResponseEntity<List<BankAccountEntity>>getBankAccountBYAccountNumber(@PathVariable("accountNumber")String AccountNumber) throws ResourceNotFoundException {
        List<BankAccountEntity> entity=service.getBankAccountByAccountNumber(AccountNumber);
        if (entity.size()>0){
            return new ResponseEntity<>(entity,new HttpHeaders(),HttpStatus.OK);
        }
        else throw new ResourceNotFoundException("accounts not found");
    }



}
