package com.tiy.ssa.model;

public interface DomainObject {

    boolean deeplyEquals(Object obj);
    boolean isLoaded();
}
