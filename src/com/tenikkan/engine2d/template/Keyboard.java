package com.tenikkan.engine2d.template;

import java.awt.event.KeyEvent;

public interface Keyboard extends InputEventQueue
{
    public static final int KEY_UP             = KeyEvent.VK_UP;
    public static final int KEY_DOWN           = KeyEvent.VK_DOWN;
    public static final int KEY_LEFT           = KeyEvent.VK_LEFT;
    public static final int KEY_RIGHT          = KeyEvent.VK_RIGHT;
    
    public boolean isKeyDown(int keycode);
}