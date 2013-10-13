import java.util.HashMap;

public class MyLength {

    private final String unit;
    private double value;
    HashMap<String, Double> ratioMap = new HashMap<String, Double>() {{
        put("m", 1.0);
        put("cm", 0.01);
        put("mm", 0.001);
    }};

    public MyLength(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public MyLength add(MyLength addedLength) {
        return new MyLength(convertUnitToM(this) + convertUnitToM(addedLength), unit);
    }

    private double convertUnitToM(MyLength length) {
        return length.getValue() * ratioMap.get(length.getUnit());
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}
