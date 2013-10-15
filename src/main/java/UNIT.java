public enum UNIT {
    M(1.0),CM(0.01),MM(0.001);
    private double ratio;

    private UNIT(double ratio) {
        this.ratio = ratio;
    }

}
