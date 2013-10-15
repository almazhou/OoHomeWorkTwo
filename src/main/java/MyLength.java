import java.util.HashMap;

public class MyLength {

    private String unit;
    private UNIT unit2;
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

    public MyLength(double value, UNIT unit) {
        this.value = value;
        this.unit2 = unit;
    }

    public MyLength add(MyLength addedLength) {
        return new MyLength(convertUnitToM(this) + convertUnitToM(addedLength), "m");
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

    public int compareTo(MyLength otherLength) {
        return (int) (convertUnitToM(this) - convertUnitToM(otherLength));
    }

    public MyLength subtract(MyLength otherLength) {
        return new MyLength(convertUnitToM(this) - convertUnitToM(otherLength),"m");
    }

    public double multiply(MyLength otherLength) {
        return convertUnitToM(this) * convertUnitToM(otherLength);
    }

    public double divide(MyLength otherLength) {
        if(otherLength.getValue()!=0){
        return convertUnitToM(this)/convertUnitToM(otherLength);
        }else {
            throw new RuntimeException("divided length is 0");
        }
    }

    public double convertToCm() {
        return convertUnitToM(this)*100;
    }

    public double convertToMm() {
        return convertUnitToM(this)*1000;
    }

    public double convertToM() {
        return convertUnitToM(this)*1;
    }
}
