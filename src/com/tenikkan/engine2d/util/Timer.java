package com.tenikkan.engine2d.util;

import java.text.DecimalFormat;

public class Timer
{
    public static final long SECOND = 1000000000L;
    
    private DecimalFormat fmt = new DecimalFormat("0.00");
    
    private long ticks;
    private long time;
    
    public Timer() 
    {
        ticks = 0;
        time = getTime();
    }
    
    public void tick() { ticks++; }
    
    public long getTicks() { return ticks; }
    public long getTimeMillis() { return time; }
    
    public double getTicksPerSecond() { return (double)getTicks() * SECOND / getDeltaTime(); }
    public String getTicksPerSecondText() { return fmt.format(getTicksPerSecond()); }
    
    public void resetTicks() { ticks = 0; }
    public void resetTime() { time = getTime(); }
    public void reset() 
    {
        resetTicks();
        resetTime();
    }
    
    public long getDeltaTime() { return getTime() - time; }
    
    private long getTime() { return System.nanoTime(); }
}
