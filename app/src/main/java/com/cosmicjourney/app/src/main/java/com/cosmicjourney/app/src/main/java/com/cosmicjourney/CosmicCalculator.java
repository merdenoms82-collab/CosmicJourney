package com.cosmicjourney;

public class CosmicCalculator {
    
    // Speeds in miles per hour
    private static final double EARTH_ROTATION_SPEED = 1037.0;      // mph
    private static final double EARTH_ORBIT_SPEED = 67000.0;        // mph  
    private static final double SOLAR_SYSTEM_SPEED = 514000.0;      // mph
    private static final double GALACTIC_TRAVEL_SPEED = 1300000.0;  // mph
    
    public static double calculateTotalDistance(long secondsAlive) {
        double total = 0;
        
        // Convert mph to miles per second, then multiply by seconds alive
        total += (EARTH_ROTATION_SPEED / 3600.0) * secondsAlive;
        total += (EARTH_ORBIT_SPEED / 3600.0) * secondsAlive;
        total += (SOLAR_SYSTEM_SPEED / 3600.0) * secondsAlive;
        total += (GALACTIC_TRAVEL_SPEED / 3600.0) * secondsAlive;
        
        return total;
    }
    
    public static double[] calculateBreakdown(long secondsAlive) {
        double[] breakdown = new double[4];
        
        breakdown[0] = (EARTH_ROTATION_SPEED / 3600.0) * secondsAlive;
        breakdown[1] = (EARTH_ORBIT_SPEED / 3600.0) * secondsAlive;
        breakdown[2] = (SOLAR_SYSTEM_SPEED / 3600.0) * secondsAlive;
        breakdown[3] = (GALACTIC_TRAVEL_SPEED / 3600.0) * secondsAlive;
        
        return breakdown;
    }
}
