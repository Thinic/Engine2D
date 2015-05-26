package com.tenikkan.engine2d.entity;

import java.util.HashMap;
import java.util.Map;

public class EntityManager
{
    private UIDGenerator uidGen;
    private ComponentManager cm;
    private SystemManager sm;
    private Map<Long, Entity> entities;
    
    public EntityManager() 
    {
        uidGen = new UIDGenerator();
        cm = new ComponentManager();
        sm = new SystemManager();
        entities = new HashMap<Long, Entity>();
    }
    
    public Entity createEntity() 
    {
        long uid = uidGen.nextUID();
        Entity e = new Entity(uid, this);
        entities.put(uid, e);
        sm.addEntity(e);
        return e; 
    }
    
    public Entity getEntity(long uid) 
    {
        return entities.get(uid);
    }
    
    public boolean removeEntity(long uid) 
    {
        sm.removeEntity(uid); 
        return entities.remove(uid) == null;
    }
    
    public <T extends Component> void registerComponentType(Class<T> type) 
    {
        cm.registerComponentType(type);
    }
    
    public int registerSystem(EntitySystem sys) 
    {
        return sm.addSystem(sys); 
    }
    
    public ComponentManager getComponentManager() { return cm; }
    public SystemManager getSystemManager() { return sm; }
    
    public void updateSystem(int system) 
    {
        EntitySystem sys = sm.getSystem(system);
        if(sys != null) 
        {
            sys.update();
        }
    }
}
