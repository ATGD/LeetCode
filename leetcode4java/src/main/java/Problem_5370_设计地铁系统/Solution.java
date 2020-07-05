package Problem_5370_设计地铁系统;

import java.util.ArrayList;
import java.util.List;

class UndergroundSystem {

    List<StationCost> records = new ArrayList<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        StationCost stationCost = new StationCost();
        stationCost.id = id;
        stationCost.startTime = t;
        stationCost.stationName = stationName;
        records.add(stationCost);
    }

    public void checkOut(int id, String stationName, int t) {
        for (int i = 0; i < records.size(); i++) {
            StationCost stationCost = records.get(i);
            if (stationCost.id == id && stationCost.startTime < t && stationCost.endTime == null) {
                stationCost.endTime = t;
                stationCost.endStation = stationName;
                break;
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < records.size(); i++) {
            StationCost stationCost = records.get(i);
            if (startStation.equals(stationCost.stationName) && endStation.equals(stationCost.endStation)) {
                sum += stationCost.endTime - stationCost.startTime;
                count++;
            }
        }
        return ((double) sum) / count;
    }

    class StationCost {
        int id;
        String stationName;
        String endStation;
        Integer startTime;
        Integer endTime;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */