package com.tiy.ssa.week5.CustomerDB;

public class Customer implements DomainObject{

    final String firstName;
    final String lastName;
    final int id;
    final boolean loaded;
    
    public Customer(){
        
      this(0, "", "", false);
    }
    
    public Customer(int id){
        this(id, "", "", false);
    }
    
    public Customer(String firstName, String lastName) {
        this(0, firstName, lastName, false);      
    }
    
    public Customer(int id, String firstName, String lastName){
        this(id, firstName, lastName, false);
    }
    
    public Customer(int id, String firstName, String lastName, Boolean loaded){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.loaded = loaded;
    }
    

    public int getId() {
        return id;
    }

    public Customer setLoaded()
    {
        return new Customer(this.id, this.firstName, this.lastName, true);
    }
    
    public Customer setFirstName(String firstName) {
        return new Customer(this.id, firstName, this.lastName, this.loaded);
    }

    public Customer setLastName(String lastName) {
        return new Customer(this.id, this.firstName, lastName, this.loaded);
    }

    public Customer setId(int id) {
        return new Customer(id, this.firstName, this.lastName, this.loaded);
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
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", loaded=" + loaded
                + "]";
    }

    @Override
    public boolean deeplyEquals(Object obj) {
        if(this.equals(obj)){
            if(!this.firstName.equals(((Customer)obj).firstName))
                return false;
            if(this.lastName.equals(((Customer)obj).lastName))
                return false;
            
            return true;
        }
        return false;
    }

    @Override
    public boolean isLoaded() {
        // TODO Auto-generated method stub
        return loaded;
    }

 
    
    
}
