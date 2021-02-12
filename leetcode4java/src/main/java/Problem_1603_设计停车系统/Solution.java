package Problem_1603_设计停车系统;

class ParkingSystem {

    int[] array = new int[]{0, 0, 0};

    public ParkingSystem(int big, int medium, int small) {
        array[0] = big;
        array[1] = medium;
        array[2] = small;
    }

    public boolean addCar(int carType) {
        if (array[carType - 1] > 0) {
            array[carType - 1]--;
            return true;
        } else return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */