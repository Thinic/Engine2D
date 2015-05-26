package com.tenikkan.engine2d.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComponentManager
{
    private HashMap<Class<? extends Component>, ComponentList<? extends Component>> map;
    
    public ComponentManager() 
    {
        map = new HashMap<Class<? extends Component>, ComponentList<? extends Component>>();
    }
    
    public <T extends Component> void registerComponentType(Class<T> type) 
    {
        map.put(type, new ComponentList<T>());
    }
    
    public List<Class<? extends Component>> getComponentTypes() 
    {
        List<Class<? extends Component>> types = new ArrayList<Class<? extends Component>>(map.keySet());
        
        return types;
    }
    
    @SuppressWarnings("unchecked")
    public <T extends Component> ComponentList<T> getComponentList(Class<T> type) 
    { 
        return (ComponentList<T>)map.get(type); 
    }
    
    public List<Class<? extends Component>> getComponentTypesForEntity(long entityUID) 
    {
        List<Class<? extends Component>> cList = new ArrayList<Class<? extends Component>>();
        
        List<Class<? extends Component>> types = getComponentTypes();
        
        for(Class<? extends Component> type : types) 
        {
            if(getComponentOf(entityUID, type) != null) cList.add(type);
        }
        
        return cList;
    }
    
    public <T extends Component> T getComponentOf(long entityUID, Class<T> type) 
    { 
        ComponentList<T> cl = getComponentList(type);
        
        if(cl == null) return null; 
        
        return cl.getComponent(entityUID);
    }
    
    @SuppressWarnings("unchecked")
    public <T extends Component> void addComponentOf(long entityUID, T component) 
    {
        ComponentList<T> cl = (ComponentList<T>)getComponentList(component.getClass());
        
        if(cl == null) 
        {
            registerComponentType(component.getClass());
            cl = (ComponentList<T>)getComponentList(component.getClass());
        }
        
        cl.addComponent(entityUID, component);
    }
    
    public <T extends Component> void removeComponentOf(long entityUID, Class<T> type) 
    {
        ComponentList<T> cl = getComponentList(type);
        
        if(cl == null) return;
        
        cl.removeComponent(entityUID);
    }
}
