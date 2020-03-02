public class Car {

    int v0, x0, t, s, a_p, a_n;

    Car(int v0, int x0, int t, int s, int a_p, int a_n) {
        this.v0 = v0;
        this.x0 = x0;
        this.t = t;
        this.s = s;
        this.a_p = a_p;
        this.a_n = a_n;
    }

    boolean stop() {
        return Math.pow(v0, 2) / (a_n * 2 * Math.pow(3.6, 2)) <= x0;
    }

    boolean pass() {
        return a_p * Math.pow(t, 2) / 2 + v0 * t / 3.6 >= s + x0;
    }

    boolean passMaxSpeed(int v1) {
        if(a_p * Math.pow(t,2) / 2 + v0 * t / 3.6 < s + x0) return false;
        else {
            boolean check = 2 * a_p * (s + x0) + Math.pow(v0, 2) / Math.pow(3.6, 2) <= Math.pow(v1, 2) / Math.pow(3.6, 2);
            if(check) return true;
            else {
                double t0 = (v1 - v0) / (3.6 * a_p);
                return a_p * Math.pow(t0, 2) / 2 + v0 * t0 / 3.6 + v1 * (t - t0) / 3.6 > x0 + s;
            }
        }
    }

    String twoCars(Car carFront, int d) {
        boolean c1s, c1p, c2s, c2p = false;
        c1s = carFront.stop();
        Car this_car_behind = new Car(this.v0, this.x0 + d, this.t, this.s, this.a_p, this.a_n);
        c2s = this_car_behind.stop();
        c1p = carFront.pass();
        if(c1p) c2p = this_car_behind.pass();

        return "Car 1 stop: " + c1s + ", Car 1 pass: " + c1p + ", Car 2 stop: " + c2s + ", Car 2 pass: " + c2p;
    }

}