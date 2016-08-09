package com.tiy.ssa.weektwo.assignmenttwo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NameUserTest {
    
    List<User> userList = new ArrayList<>();
   
    @Before
    public void setList(){
        userList.add(new User("Joe", "Bob", 32));
        userList.add(new User("Dave", "Thompson", 3));
        userList.add(new User("Billy", "Bob", 16));
        userList.add(new User("Sally", "Joe", 13));
        userList.add(new User("Lisa", "Jones", 25));
        userList.add(new User("Angie", "Athaway", 5));
        userList.add(new User("Angie", "Athaway", 5));
    }
    
    @After
    public void clearList(){
        userList.clear();
    }
    
    @Test
    public void testChildrenMakesList(){
        assertTrue((children(userList)).size() >= 0);
    }
    
    @Test
    public void testChildrenListNoRepeats(){
        
        Collection<Name> childNames = children(userList);
        
        for(Name n: childNames){
            for(Name c: childNames){
                if(n != c) assertFalse(n.equals(c));
            }
        }
    }
    
    @Test
    public void testAvgAdultAge(){
        assertEquals(24.3, adultAverageAge(userList), .1);
    }
    
    static Collection<Name> children(Collection<? extends User> users) {

        Set<Name> childNameSet = new HashSet<>();

        for (User g : users) {

            if (g.getAge() < 16) {

                childNameSet.add(new Name(g.getFirstName(), g.getLastName()));
            }
        }

        return new ArrayList<>(childNameSet);

    }

    static float adultAverageAge(Collection<? extends User> users) {

        float age = 0, numUsers = 0;

        for (User u : users) {
            if(u.getAge() > 15){
            age += u.getAge();  
            ++numUsers;
            }
        }

        return (age > 0) ? (age / numUsers) : 0f;

    }

}
