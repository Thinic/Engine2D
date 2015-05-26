package com.tenikkan.engine2d.template;

import java.awt.Graphics;
import java.awt.Graphics2D;

public interface Display
{
    public int getWidth();
    public int getHeight();
    
    public int getDrawWidth();
    public int getDrawHeight();
    
    public int getX();
    public int getY();
    
    public void centerOnScreen();
    public void setPosition(int x, int y);
    public void setX(int x);
    public void setY(int y);
    
    public void setSize(int width, int height);
    public void setWidth(int width);
    public void setHeight(int height);
    
    public void setDrawSize(int width, int height);
    public void setDrawWidth(int width);
    public void setDrawHeight(int height);
    
    public String getTitle();
    public void setTitle(String title);
    
    public boolean isVisible(); 
    public void setVisible(boolean visible);
    public void show();
    public void hide();
    
    public boolean isDisplayable();
    public void swapBuffers();
    
    public boolean isRequestingClose();
    
    public Graphics getGraphics();
    public Graphics2D getGraphics2D();
    
    public Keyboard getKeyboard();
    public Mouse getMouse();
}
