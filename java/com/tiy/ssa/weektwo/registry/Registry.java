package com.tiy.ssa.weektwo.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tiy.ssa.weektwo.examplefive.SocialSecurityNumber;

public class Registry {

    Map<SocialSecurityNumber, Person> registryMap = new HashMap<>();

    public boolean add(Person person) {
        registryMap.put(person.getSsn(), person);

        if (registryMap.containsKey(person.getSsn()))
            return true;

        return false;

        // look up parents' ssns, retrieve them through map, and add them to
        // each
        // parent's child list
    }

    public int size() {
        return registryMap.size();
    }

    public Person progenitor(SocialSecurityNumber ssn) {

       
        List<Person> progenitors = progenitorList(ssn);
        progenitors.sort((Person p1, Person p2) -> p2.age() - p1.age());
        return progenitors.get(0);
    }

     List<Person> progenitorList(SocialSecurityNumber ssn) {

        Person person = registryMap.get(ssn); 
         
        List<Person> progenitors = new ArrayList<>();
        List<Person> ancestors = new ArrayList<>(ancestors(ssn));
        
        if (person.getParents().isEmpty()) {
            progenitors.add(person);
            return progenitors;
        }
        
        for (Person p : ancestors)
            if (p.getParents().isEmpty())
                progenitors.add(p);

        return progenitors;
    }

    public List<Person> ancestors(SocialSecurityNumber ssn) {
 
        Person person = get(ssn);
        
        if (person == null)
            return new ArrayList<>(0);

        List<Person> newParentList = new ArrayList<>(person.getParents());

        for (Person p : person.getParents()) {
            newParentList.addAll(ancestors(p.getSsn()));
        }
        
        return newParentList;
        
    }

    public List<Person> descendants(SocialSecurityNumber ssn) {

        Person person = get(ssn);
        if (person == null)
            return new ArrayList<>(0);

        else if (!person.getChildren().isEmpty()) {
            List<Person> newChildList = new ArrayList<>(get(ssn).getChildren());
            
            for (Person p : person.getChildren()) {
                
                newChildList.addAll(descendants(p.getSsn()));

            }

            return newChildList;
        }

        return get(ssn).getChildren();

    }

     public Person oldestLivingRelative(SocialSecurityNumber ssn){
         List<Person> livingFamily = new ArrayList<>(entireFamily(ssn));
         
         Iterator<Person> itr = livingFamily.iterator();
         
         while(itr.hasNext()){
             if (!itr.next().isAlive()) itr.remove();
         }
     
 
         livingFamily.sort((Person p1, Person p2) -> p2.age() - p1.age());
         
         return livingFamily.get(0);
         
     }
     public boolean areRelated(SocialSecurityNumber ssn1, SocialSecurityNumber
     ssn2){
         
         List<Person> progList1 = progenitorList(ssn1);
         List<Person> progList2 = progenitorList(ssn2);
         
         for(Person progenitor : progList1){
             if (progList2.contains(progenitor)) return true;
         }
         
         return false;
     }
     
    Collection<Person> entireFamily(SocialSecurityNumber ssn){
        List<Person> progenList = progenitorList(ssn);
        Set<Person> familySet = new HashSet<>();
        
        for(Person progenitor: progenList)
            familySet.addAll(descendants(progenitor.getSsn()));
        
       return new ArrayList<>(familySet);
    }
    
    public Person get(SocialSecurityNumber ssn) {
        return registryMap.get(ssn);
    }

    
     public Relationship related(SocialSecurityNumber ssn1, SocialSecurityNumber ssn2){
         
         Person person1 = registryMap.get(ssn1);
         Person person2 = registryMap.get(ssn2);
         
         if (isParent(person1, person2)) return Relationship.PARENT;
         
         for (Person person: person1.getParents()){
             if(isParent(person, person2)) return Relationship.GRANDPARENT;
         }
         
         if (isParent(person2, person1)) return Relationship.CHILD;
         
         for (Person person: person2.getParents()){
             if(isParent(person, person1)) return Relationship.GRANDCHILD;
         }     
         
         if (sharesParents(person1, person2)) return Relationship.SIBLING;
         
         for (Person person: person1.getParents()){
             if (sharesParents(person, person2)) return Relationship.AUNCLE;        
         }
         
         for (Person p1: person1.getParents()){
             for (Person p2: person2.getParents()){
                 if (sharesParents(p1, p2)) return Relationship.COUSIN;
             }
         }
         
         for (Person person: person2.getParents()){
             if (sharesParents(person, person1)) return Relationship.NIBLING;
         }
         
         return Relationship.NONE;
     }
    
    boolean isParent(Person person1, Person person2){
        return (person1.getParents().contains(person2));
    }
    
    boolean sharesParents(Person person1, Person person2){
        
        if(person1.getParents().isEmpty() || person2.getParents().isEmpty()) return false;
        
        return(person1.getParents().equals(person2.getParents()));
    }
    
  
    public static enum Relationship {
        PARENT, CHILD, SIBLING, GRANDPARENT, GRANDCHILD, COUSIN, NIBLING, AUNCLE, NONE;
    }

    @Override
    public String toString() {
        return registryMap.toString();
    }
}
