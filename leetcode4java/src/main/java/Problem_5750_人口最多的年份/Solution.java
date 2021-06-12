package Problem_5750_人口最多的年份;

import java.util.Arrays;

class Solution {
    public int maximumPopulation(int[][] logs) {
        int[][] birthOrDeaths = new int[logs.length * 2][2];
        int index = 0;

        for (int[] log : logs) {
            birthOrDeaths[index][1] = 1;
            birthOrDeaths[index++][0] = log[0];
            birthOrDeaths[index][1] = 0;
            birthOrDeaths[index++][0] = log[1];
        }
        Arrays.sort(birthOrDeaths, (t0, t1) -> t0[0] - t1[0]);

        int tempYear = -1,maxPopulation = 0,maxYear = 0,tempPeople = 0;

        for (int[] birthOrDeath : birthOrDeaths) {
            int happenYear = birthOrDeath[0];
            boolean isBirth = birthOrDeath[1] == 1;
            if (tempYear != happenYear) {
                if (tempPeople > maxPopulation) {
                    maxYear = tempYear;
                    maxPopulation = tempPeople;
                }
                tempYear = happenYear;
            }
            tempPeople+=(isBirth?1:-1);
        }
        return tempPeople > maxPopulation?tempYear:maxYear;
    }
}