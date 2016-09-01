package com.tiy.ssa.week5.model;

import java.math.BigDecimal;

import com.tiy.ssa.week5.CustomerDB.Customer;
import com.tiy.ssa.week5.CustomerDB.DomainObject;

public class Account implements DomainObject{
    enum type { CH, SA};  
    
    final int id;
    final Customer customer;
    final type accountType;
    final BigDecimal balance;
    
    public Account(){
        
        this.id = 0;
        this.customer = new Customer();
        this.accountType = Account.type.CH;
        this.balance = new BigDecimal(0.0);
        
    }
    
    public Account(Customer customer, String accountType, BigDecimal balance)
    {
        this(0, customer, accountType, balance);
        
    }
    
    public Account(int id, Customer customer, String accountType, BigDecimal balance) {
        super();
        this.id = id;
        this.customer = customer;
        this.accountType = Account.type.valueOf(accountType);
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Account setId(int id) {
        return new Account(id, this.customer, this.accountType.toString(), this.balance);
    }
    
    public Account setCustomer(Customer customer)
    {
        return new Account(this.id, customer, this.accountType.toString(), this.balance);
    }

    public int getCustomerID() {
        return customer.getId();
    }
    
    public Customer getCustomer()
    {
        return customer;
    }

    public type getAccountTypeValue()
    {
        return this.accountType;
    }
    public String getAccountTypeString() {
        
        switch(accountType){
        case CH: return "CH";
        
        case SA: return "SA";
        
        default: return "00";
        }
        
    }

    public Account setAccountType(String type) {
        
        switch(type){
        case "CH": 
            return new Account(this.id, this.customer, "CH", this.balance);
                    
        case "SV":
        return new Account(this.id, this.customer, "SV", this.balance);
        
        default: return new Account(this.id, this.customer, this.accountType.toString(), this.balance);
        }
              
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        return new Account(this.id, this.customer, this.accountType.toString(), balance);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", customerID=" + getCustomerID() + ", accountType=" + accountType + ", balance="
                + balance + "]";
    }
    

    
 
}
