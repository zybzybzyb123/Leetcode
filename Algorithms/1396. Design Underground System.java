/**
 * 简单设计题,getOrDefault之前用的常量踩坑了
 */

class UndergroundSystem {

    private class CheckInStationRecord {
        private String stationName;
        private int time;
    }

    private class StationCost {
        private int cnt;
        private int cost;
    }

    private Map<Integer, CheckInStationRecord> checkInStationRecordMap;
    private Map<String, StationCost> stationCostMap;

    public UndergroundSystem() {
        checkInStationRecordMap = new HashMap<>();
        stationCostMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        CheckInStationRecord checkInStationRecord = new CheckInStationRecord();
        checkInStationRecord.stationName = stationName;
        checkInStationRecord.time = t;
        checkInStationRecordMap.put(id, checkInStationRecord);
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInStationRecord checkInStationRecord = checkInStationRecordMap.get(id);
        String startStationName = checkInStationRecord.stationName;
        String key = startStationName + "," + stationName;
        StationCost stationCost = stationCostMap.getOrDefault(key, new StationCost());
        stationCost.cnt++;
        stationCost.cost += t - checkInStationRecord.time;
        // System.out.printf("key=%s cnt=%d cost=%d\n", key, stationCost.cnt, stationCost.cost);
        stationCostMap.put(key, stationCost);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "," + endStation;
        StationCost stationCost = stationCostMap.getOrDefault(key, new StationCost());
        if (stationCost.cnt == 0) {
            return 0;
        }
        return stationCost.cost * 1.0 / stationCost.cnt;
    }
}