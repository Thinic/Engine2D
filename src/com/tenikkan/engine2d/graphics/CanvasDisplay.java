package com.tenikkan.engine2d.graphics;

import java.awt.*;

import com.tenikkan.engine2d.template.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class CanvasDisplay implements Display
{
    private Frame frame;
    private Canvas canvas;
    private EventListenerKeyboard keyboard;
    private Mouse mouse;
    private boolean requestClose;
    
    public CanvasDisplay(String title, int drawWidth, int drawHeight, boolean centered) 
    {
        requestClose = false;
        
        frame = new Frame();
        frame.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent arg0)
            {
                requestClose = true;
            }
        });
        canvas = new Canvas();
        
        keyboard = new EventListenerKeyboard(256);
        canvas.addKeyListener(keyboard);
        
        frame.add(canvas);
        
        setTitle(title);
        setDrawSize(drawWidth, drawHeight);
        
        if(centered) centerOnScreen();
    }
    
    @Override
    public int getWidth() { return frame.getWidth(); }
    
    @Override
    public int getHeight() { return frame.getHeight(); }
    
    @Override
    public int getDrawWidth() { return canvas.getWidth(); }
    
    @Override
    public int getDrawHeight() { return canvas.getHeight(); }
    
    @Override
    public void centerOnScreen() { frame.setLocationRelativeTo(null); }
    
    @Override
    public void setPosition(int x, int y) { frame.setLocation(x, y); }
    
    @Override
    public void setX(int x) { frame.setLocation(x, getY()); }
    
    @Override
    public void setY(int y) { frame.setLocation(getX(), y); }
    
    @Override
    public int getX() { return frame.getX(); }
    
    @Override
    public int getY() { return frame.getY(); }
    
    @Override
    public void setSize(int width, int height) { frame.setSize(width, height); }
    
    @Override
    public void setWidth(int width) { frame.setSize(width, getHeight()); }
    
    @Override
    public void setHeight(int height) { frame.setSize(getWidth(), height); }
    
    @Override
    public void setDrawSize(int width, int height) 
    {
        canvas.setSize(width, height);
        frame.pack(); 
    }
    
    @Override
    public void setDrawWidth(int width) 
    {
        canvas.setSize(width, getDrawHeight());
        frame.pack(); 
    }
    
    @Override
    public void setDrawHeight(int height) 
    {
        canvas.setSize(getDrawWidth(), height);
        frame.pack(); 
    }
    
    @Override
    public String getTitle() { return frame.getTitle(); }
    
    @Override
    public void setTitle(String title) { frame.setTitle(title); }
    
    @Override
    public boolean isVisible() { return frame.isVisible(); }
    
    @Override
    public void setVisible(boolean show) 
    {
        if(show) 
        {
            frame.setVisible(true);
            canvas.createBufferStrategy(2);
        } else 
        {
            requestClose = false;
            frame.setVisible(false);
        }
    }
    
    @Override
    public void show() { setVisible(true); }
    
    @Override
    public void hide() { setVisible(false); }
    
    @Override
    public boolean isDisplayable() { return isVisible(); }
    
    @Override
    public void swapBuffers() 
    {
        BufferStrategy bs = canvas.getBufferStrategy();
        
        if(bs == null) 
        {
            if(isDisplayable()) canvas.createBufferStrategy(2);
            return;
        }
        
        bs.show(); 
    }
    
    @Override
    public boolean isRequestingClose() { return requestClose; }
    
    @Override
    public Graphics getGraphics() 
    {
        BufferStrategy bs = canvas.getBufferStrategy();
        
        if(bs == null) return null;
        
        return bs.getDrawGraphics();
    }
    
    @Override
    public Graphics2D getGraphics2D() { return (Graphics2D) getGraphics(); }
    
    @Override
    public Keyboard getKeyboard() { return keyboard; }
    
    @Override
    public Mouse getMouse() { return mouse; }
}
