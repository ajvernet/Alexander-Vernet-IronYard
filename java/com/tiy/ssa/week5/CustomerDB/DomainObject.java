package com.tiy.ssa.week5.CustomerDB;

public interface DomainObject {

    boolean deeplyEquals(Object obj);
    boolean isLoaded();
}
