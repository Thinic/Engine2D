package com.tenikkan.engine2d.entity;

public class EntityComponentSystem
{
    private UIDGenerator uidGen;
    private ComponentManager comp;
    
    public EntityComponentSystem() 
    {
        comp = new ComponentManager();
        uidGen = new UIDGenerator();
    }
    
    public ComponentManager getComponentManager() { return comp; }
    
    public long generateUID() { return uidGen.nextUID(); }
}
