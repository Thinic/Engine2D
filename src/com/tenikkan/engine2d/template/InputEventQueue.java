package com.tenikkan.engine2d.template;

public interface InputEventQueue
{
    public void clearEventQueue();
    public boolean nextEvent();
    
    public int getEventCode();
    public boolean getEventState();
}
