package ir.cactus.restspringapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * A DTO for the {@link ir.cactus.restspringapi.model.CustomersEntity} entity
 */
@Getter
@Setter
@Data
public class CustomersEntityDto implements Serializable {
    @Id
    private final Long customerId;

    private final String customerName;
    private final String customerSurname;
    private final String customerAddress;
    private final int customerZipCode;
    private final String customerNationalId;
    private final String customerBirthDate;
}