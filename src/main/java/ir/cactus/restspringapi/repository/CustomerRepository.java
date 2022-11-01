package ir.cactus.restspringapi.repository;

import ir.cactus.restspringapi.model.CustomersEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends JpaRepository<CustomersEntity,Long> {





}
