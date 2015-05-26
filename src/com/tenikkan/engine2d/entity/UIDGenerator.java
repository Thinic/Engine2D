package com.tenikkan.engine2d.entity;

public class UIDGenerator
{
    private long nextID;
    
    public UIDGenerator() 
    {
        this(0);
    }
    
    public UIDGenerator(long start) 
    {
        nextID = start;
    }
    
    public long nextUID() { return nextID++; }
}
