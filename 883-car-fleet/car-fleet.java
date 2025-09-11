
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Pair cars: [position, timeToTarget]
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort cars by starting position descending (closer to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double curTime = 0.0;

        // Traverse from front-most to back-most
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (time > curTime) { 
                // new fleet formed
                fleets++;
                curTime = time; 
            }
            // else: merges into fleet ahead
        }

        return fleets;
    }
}
