package com.tiy.ssa.weektwo.examplefive;

public class SocialSecurityNumber {

    private final String data;
    
    public SocialSecurityNumber(String data){
        this.data = data;
    }
    
    public String last4Digits(){
        return this.data.substring(5, data.length());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
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
        SocialSecurityNumber other = (SocialSecurityNumber) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return this.data;
    }
}
