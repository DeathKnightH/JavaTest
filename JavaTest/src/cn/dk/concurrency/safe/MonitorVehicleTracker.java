package cn.dk.concurrency.safe;

import cn.dk.concurrency.unsafe.MutablePoint;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ThreadSafe
public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;
    
    public MonitorVehicleTracker(Map<String, MutablePoint> locations){
        this.locations = deepCopy(locations);
    }
    
    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations){
        Map<String,MutablePoint> copys = new HashMap<>();
        for (String key:copys.keySet()) {
            copys.put(key, new MutablePoint(copys.get(key)));
        }

        return copys;
    }
}
