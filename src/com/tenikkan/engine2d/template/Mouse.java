package com.tenikkan.engine2d.template;

import java.awt.event.MouseEvent;

public interface Mouse extends InputEventQueue
{
    public static final int BUTTON_1 = MouseEvent.BUTTON1;
    public static final int BUTTON_2 = MouseEvent.BUTTON2;
    public static final int BUTTON_3 = MouseEvent.BUTTON3;
    
    public boolean isButtonDown(int buttoncode);
    
    public int getX();
    public int getY();
    
    public int getGlobalX();
    public int getGlobalY();
}
