package com.tenikkan.engine2d.entity;

import java.util.HashMap;

public class ComponentList<T extends Component>
{
    private HashMap<Long, T> list;
    
    public ComponentList() 
    {
        list = new HashMap<Long, T>();
    }
    
    public void addComponent(long uid, T comp) 
    {
        list.put(uid, comp);
    }
    
    public void removeComponent(long uid) 
    {
        list.remove(uid);
    }
    
    public T getComponent(long uid) 
    {
        return list.get(uid);
    }
}
