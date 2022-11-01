package ir.cactus.restspringapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@Setter
@Getter
@Entity
@Table(name = "customers", schema = "bankaccount", catalog = "")
public class CustomersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private Long customerId;
    @Basic
    @Column(name = "customer_name")
    private String customerName;
    @Basic
    @Column(name = "customer_surname")
    private String customerSurname;
    @Basic
    @Column(name = "customer_address")
    private String customerAddress;
    @Basic
    @Column(name = "customer_zip_code")
    private int customerZipCode;
    @Basic
    @Column(name = "customer_national_id")
    private String customerNationalId;
    @Basic
    @Column(name = "customer_birth_date")
    private String customerBirthDate;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return customerId == that.customerId && customerZipCode == that.customerZipCode && Objects.equals(customerName, that.customerName) && Objects.equals(customerSurname, that.customerSurname) && Objects.equals(customerAddress, that.customerAddress) && Objects.equals(customerNationalId, that.customerNationalId) && Objects.equals(customerBirthDate, that.customerBirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerSurname, customerAddress, customerZipCode, customerNationalId, customerBirthDate);
    }
}
