package ir.cactus.restspringapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "bank_account", schema = "bankaccount", catalog = "")
public class BankAccountEntity {
    @Basic
    @Column(name = "account_number")
    private String accountNumber;
    @Basic
    @Column(name = "account_type")
    private String accountType;

    @Id
    @Basic
    @Column(name = "account_customer_id")
    private Long accountCustomerId;
    @Basic
    @Column(name = "account_limit")
    private int accountLimit;
    @Basic
    @Column(name = "account_open_date")
    private String accountOpenDate;
    @Basic
    @Column(name = "account_balance")
    private int accountBalance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountEntity that = (BankAccountEntity) o;
        return accountCustomerId == that.accountCustomerId && accountLimit == that.accountLimit && accountBalance == that.accountBalance && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountType, that.accountType) && Objects.equals(accountOpenDate, that.accountOpenDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType, accountCustomerId, accountLimit, accountOpenDate, accountBalance);
    }
}
