package com.tiy.ssa.week5.CustomerDB;

public class Customer implements DomainObject{

    final String firstName;
    final String lastName;
    final int id;
    
    public Customer(){
        
      this(0, "", "");
    }
    
    public Customer(int id){
        this(id, "", "");
    }
    
    public Customer(String firstName, String lastName) {
        this(0, firstName, lastName);      
    }
    
    public Customer(int id, String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public Customer setFirstName(String firstName) {
        return new Customer(this.id, firstName, this.lastName);
    }

    public Customer setLastName(String lastName) {
        return new Customer(this.id, this.firstName, lastName);
    }

    public Customer setId(int id) {
        return new Customer(id, this.firstName, this.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
        Customer other = (Customer) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
    }

 
    
    
}
