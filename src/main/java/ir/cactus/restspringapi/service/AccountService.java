package ir.cactus.restspringapi.service;

import ir.cactus.restspringapi.exception.RecordeNotFoundException;
import ir.cactus.restspringapi.exception.ResourceNotFoundException;
import ir.cactus.restspringapi.model.BankAccountEntity;
import ir.cactus.restspringapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public List<BankAccountEntity>getAllAccount(){
        List<BankAccountEntity> accountEntities=repository.findAll();
        if (accountEntities.size()>0){
            return accountEntities;
        }
        else{
            return new ArrayList<BankAccountEntity>();
        }
    }

    public List<BankAccountEntity>getAccountsById(Long id){
        List<BankAccountEntity> accounts=repository.findAllById(Collections.singleton(id));
        if(accounts.size()>0){
            return accounts;
        }else {
            return new ArrayList<>();
        }
    }
    public List<BankAccountEntity> getBankAccountByAccountNumber(String Account_Number) throws ResourceNotFoundException {
        List<BankAccountEntity>bankAccountEntity=repository.getBankAccountEntitiesByAccountNumber(Account_Number);
        if (bankAccountEntity.size()>0){
            return bankAccountEntity;
        }
        else{
            throw new ResourceNotFoundException("this acount not found");
        }
    }
}
