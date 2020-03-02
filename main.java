public class main {

    public static void main(String[] args) {
        Car car = new Car(60,60,4,20,3,3);
        System.out.println(car.stop());
        System.out.println(car.pass()); // conclusion: can both stop and pass
        System.out.println(car.passMaxSpeed(70)); // conclusion: have to stop
        Car carFront = new Car(30, 60, 4, 20, 1, 1);
        System.out.println(car.twoCars(carFront, 10)); // conclusion: both cars have to stop

        System.out.println();

        Car car1 = new Car(80, 40, 2, 10, 3, 1);
        System.out.println(car1.stop());
        System.out.println(car1.pass()); // conclusion: have to pass
        System.out.println(car1.passMaxSpeed(95)); // conclusion: car will be stuck in the intersection

        System.out.println();

        Car car2 = new Car(50, 70, 4, 10, 3, 2);
        System.out.println(car2.stop());
        System.out.println(car2.pass()); // conclusion: have to stop
        System.out.println(car2.passMaxSpeed(100)); // conclusion: have to stop
        Car car3 = new Car(80, 70, 4, 10, 3, 3);
        System.out.println(car2.twoCars(car3, 70)); // conclusion: first car passes, second car stops
    }

}
