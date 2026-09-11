import java.util.HashMap;

class UndergroundSystem {

    // Stores check-in information for each customer
    private HashMap<Integer, CheckIn> checkIns;

    // Stores total travel time and number of trips for each route
    private HashMap<String, Route> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        String routeName = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        if (!routes.containsKey(routeName)) {
            routes.put(routeName, new Route());
        }

        Route route = routes.get(routeName);
        route.totalTime += travelTime;
        route.totalTrips++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation + "->" + endStation;

        Route route = routes.get(routeName);

        return (double) route.totalTime / route.totalTrips;
    }

    // Class to store customer check-in information
    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Class to store route information
    static class Route {
        int totalTime;
        int totalTrips;

        Route() {
            totalTime = 0;
            totalTrips = 0;
        }
    }
}


OUTPUT:


Accepted
Runtime: 20 ms
Case 1
Case 2
Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
