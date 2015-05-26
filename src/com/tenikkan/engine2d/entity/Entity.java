package com.tenikkan.engine2d.entity;

import java.util.List;

public class Entity
{
    private long uid;
    private EntityManager em;
    
    protected Entity(long uid, EntityManager em) 
    {
        this.uid = uid;
        this.em = em;
    }
    
    public long getUID() { return uid; }
    
    public void addComponent(Component c) 
    {
        em.getComponentManager().addComponentOf(uid, c);
        em.getSystemManager().updateEntity(this); 
    }
    
    public <T extends Component> void removeComponent(Class<T> type) 
    {
        em.getComponentManager().removeComponentOf(uid, type);
        em.getSystemManager().updateEntity(this); 
    }
    
    public <T extends Component> T getComponent(Class<T> type) 
    {
        return em.getComponentManager().getComponentOf(uid, type);
    }
    
    public String toString() 
    {
        String str = "entity@" + Long.toHexString(uid) + " {";
        
        List<Class<? extends Component>> cList = em.getComponentManager().getComponentTypesForEntity(uid);
        
        for(Class<? extends Component> type : cList) 
        {
            str += "\n  " + getComponent(type);
        }
        
        str += "\n}";
        
        return str;
    }
}
