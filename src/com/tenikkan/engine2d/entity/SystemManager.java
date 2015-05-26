package com.tenikkan.engine2d.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemManager
{
    private List<EntitySystem> systems;
    private List<Entity> entities;
    
    public SystemManager() 
    {
        systems = new ArrayList<EntitySystem>();
        entities = new ArrayList<Entity>();
    }
    
    public void addEntity(Entity e) 
    {
        entities.add(e);
        for(EntitySystem sys : systems) 
            sys.addEntity(e);
    }
    
    public void updateEntity(Entity e) 
    {
        for(EntitySystem sys : systems) 
            sys.updateEntity(e); 
    }
    
    public Entity getEntity(long uid) 
    {
        for(Entity e : entities) 
            if(e.getUID() == uid) return e;
        return null;
    }
    
    public void removeEntity(long uid) 
    {
        for(Entity e : entities) 
            if(e.getUID() == uid) 
            {
                entities.remove(e);
                for(EntitySystem sys : systems) 
                    sys.removeEntity(e); 
                return;
            }
    }
    
    public int addSystem(EntitySystem sys) 
    {
        sys.addEntities(entities);
        
        int index = systems.size();
        
        systems.add(sys);
        
        return index;
    }
    
    public EntitySystem getSystem(int index) 
    {
        return systems.get(index);
    }
}
