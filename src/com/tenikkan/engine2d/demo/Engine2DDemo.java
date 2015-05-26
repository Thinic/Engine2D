package com.tenikkan.engine2d.demo;

import java.awt.Color;
import java.awt.Graphics;

import com.tenikkan.engine2d.entity.*;
import com.tenikkan.engine2d.graphics.CanvasDisplay;
import com.tenikkan.engine2d.template.Display;
import com.tenikkan.engine2d.template.Keyboard;
import com.tenikkan.engine2d.util.Timer;

public class Engine2DDemo
{
    Display display;
    
    public Engine2DDemo() throws InterruptedException 
    {
        display = new CanvasDisplay("Engine2D Demo", 800, 600, true);
        
        display.show();
        
        Timer timer = new Timer();
        Timer frameCounter = new Timer();
        
        long time = System.nanoTime();
        double skip = 1000000000 / 60d;
        
        long frameTime = System.nanoTime();
        double skipFrames = 1000000000 / 60d;
        
        init();
        
        while(!display.isRequestingClose()) 
        {
            while(time < System.nanoTime()) 
            {
                update();
                
                time += skip;
                
                timer.tick(); 
            }
            
            if(frameTime < System.nanoTime()) 
            {
                render();
                
                frameTime += skipFrames;
                
                frameCounter.tick();
            }
            
            if(timer.getDeltaTime() >= 0.25 * Timer.SECOND) 
            {
                display.setTitle("Engine2D Demo - " + frameCounter.getTicksPerSecondText() + " fps, " + timer.getTicksPerSecondText() + " ticks");
                timer.reset();
                frameCounter.reset();
            }
        }
        
        System.exit(0);
    }
    
    EntityManager ecs;
    Entity testEntity;
    int movementIndex, renderIndex;
    
    private Entity genTestEntity() 
    {
        Entity e = ecs.createEntity();
        
        e.addComponent(new Position(3f, 1f));
        e.addComponent(new Velocity(0.2f, 0.1f));
        
        return e; 
    }
    
    public void init() 
    {
        ecs = new EntityManager();
        testEntity = genTestEntity();
        
        movementIndex = ecs.registerSystem(new MovementSystem());
        renderIndex = ecs.registerSystem(new RenderSystem(display));
    }
    
    public void update() 
    {
        Keyboard keys = display.getKeyboard();
        while(keys.nextEvent());
        keys.clearEventQueue();
        
        System.out.println(testEntity);
        
        ecs.updateSystem(movementIndex);
    }
    
    public void render() 
    {
        Graphics g = display.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, display.getDrawWidth(), display.getDrawHeight());
        
        ecs.updateSystem(renderIndex);
        
        display.swapBuffers();
    }
    
    public static void main(String args[]) 
    {
        try
        {
            new Engine2DDemo();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
