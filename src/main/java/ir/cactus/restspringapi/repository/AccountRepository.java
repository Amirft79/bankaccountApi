package ir.cactus.restspringapi.repository;

import ir.cactus.restspringapi.model.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<BankAccountEntity,Long> {


    @Query("from BankAccountEntity  where accountNumber=?1")
    public List<BankAccountEntity> getBankAccountEntitiesByAccountNumber(String accountNumber);


}
