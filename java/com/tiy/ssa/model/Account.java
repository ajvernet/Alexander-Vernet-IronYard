package com.tiy.ssa.model;

import java.math.BigDecimal;

public class Account implements DomainObject{
    enum type { CH, SA};  
    
    final int id;
    final Customer customer;
    final type accountType;
    final BigDecimal balance;
    final boolean loaded;
    
    public Account(){
        
        this.id = 0;
        this.customer = new Customer();
        this.accountType = Account.type.CH;
        this.balance = new BigDecimal(0.0);
        this.loaded = false;
        
    }
    
    public Account(Customer customer, String accountType, BigDecimal balance)
    {
        this(0, customer, accountType, balance, false);
    }
    
    public Account(Customer customer, String accountType, BigDecimal balance, boolean loaded)
    {
        this(0, customer, accountType, balance, loaded);
        
    }
    
    public Account(int id, Customer customer, String accountType, BigDecimal balance, boolean loaded) {
        super();
        this.id = id;
        this.customer = customer;
        this.accountType = Account.type.valueOf(accountType);
        this.balance = balance;
        this.loaded = loaded;
    }

    public int getId() {
        return id;
    }

    public Account setId(int id) {
        return new Account(id, this.customer, this.accountType.toString(), this.balance, this.loaded);
    }
    
    public Account setCustomer(Customer customer)
    {
        return new Account(this.id, customer, this.accountType.toString(), this.balance, this.loaded);
    }

    public Account setLoaded()
    {
        return new Account(this.id, this.customer, this.accountType.toString(), this.balance, true);
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
            return new Account(this.id, this.customer, "CH", this.balance, this.loaded);
                    
        case "SA":
        return new Account(this.id, this.customer, "SA", this.balance, this.loaded);
        
        default: return new Account(this.id, this.customer, this.accountType.toString(), this.balance, this.loaded);
        }
              
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        return new Account(this.id, this.customer, this.accountType.toString(), balance, this.loaded);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean deeplyEquals(Object obj){
        if(this.equals(obj)){
            if(!this.customer.deeplyEquals(((Account)obj).customer))
                return false;
            if(!this.accountType.equals(((Account)obj).accountType))
                return false;
            if(this.balance != ((Account)obj).balance)
                return false;
            
            return true;
        }
        
        return false;
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
        return "Account [id=" + id + ", customer=" + customer + ", accountType=" + accountType + ", balance=" + balance
                + ", loaded=" + loaded + "]";
    }

    @Override
    public boolean isLoaded() {       
        return loaded;

    }
    

    
 
}
