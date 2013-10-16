public class MyLength {

    private UNIT unit;
    private double value;

    public MyLength(double value, UNIT unit) {
        this.value = value;
        this.unit = unit;
    }

    public MyLength add(MyLength addedLength) {
        return new MyLength(convertUnitToM(this) + convertUnitToM(addedLength), UNIT.valueOf("M"));
    }

    private double convertUnitToM(MyLength length) {
        return length.getValue() * length.getUnit().getRatio();
    }

    public double getValue() {
        return value;
    }

    public UNIT getUnit() {
        return unit;
    }

    public double compareTo(MyLength otherLength) {
        return (convertUnitToM(this) - convertUnitToM(otherLength));
    }

    public MyLength subtract(MyLength otherLength) {
        return new MyLength(convertUnitToM(this) - convertUnitToM(otherLength), UNIT.valueOf("M"));
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
