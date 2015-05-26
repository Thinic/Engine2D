package com.tenikkan.engine2d.graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.tenikkan.engine2d.template.Keyboard;

public class EventListenerKeyboard implements Keyboard, KeyListener
{
    private boolean[] keys;
    private int curIndex;
    private List<KeyStatus> queue;
    
    public EventListenerKeyboard(int keyListSize) 
    {
        keys = new boolean[keyListSize];
        curIndex = 0;
        queue = new ArrayList<KeyStatus>();
    }
    
    @Override
    public void clearEventQueue()
    {
        queue.clear();
        curIndex = -1;
    }

    @Override
    public boolean nextEvent()
    {
        curIndex++;
        return curIndex < queue.size();
    }

    @Override
    public int getEventCode()
    {
        if(curIndex >= queue.size()) return -1;
        
        return queue.get(curIndex).code;
    }

    @Override
    public boolean getEventState()
    {
        if(curIndex >= queue.size()) return false;
        
        return queue.get(curIndex).down;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        queue.add(new KeyStatus(code, true));
        
        if(code >= 0 && code < keys.length) 
            keys[code] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        queue.add(new KeyStatus(code, false));
        
        if(code >= 0 && code < keys.length) 
            keys[code] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public boolean isKeyDown(int code)
    {
        if(code >= 0 && code < keys.length) 
            return keys[code];
        
        return false;
    }
    
    private class KeyStatus
    {
        public int code;
        public boolean down;
        
        public KeyStatus(int code, boolean down) 
        {
            this.code = code;
            this.down = down;
        }
    }
}
