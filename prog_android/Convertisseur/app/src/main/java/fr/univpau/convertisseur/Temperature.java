package fr.univpau.convertisseur;

public class Temperature {

    TemperatureUnits srcUnit;
    TemperatureUnits destUnit;
    double srcValue;

    public Temperature(int srcUnit, int destUnit, double srcValue) {
        this.srcUnit = getUnit(srcUnit);
        this.destUnit = getUnit(destUnit);
        this.srcValue = srcValue;
    }

    public double convert() {
        if (srcUnit == destUnit)
            return srcValue;
        else {
            if (srcUnit == TemperatureUnits.CELSIUS) {
                return destUnit == TemperatureUnits.FAHRENHEIT ?
                        srcValue * 9 / 5 + 32 :
                        srcValue + 273.15;
            }
            if (srcUnit == TemperatureUnits.FAHRENHEIT) {
                return destUnit == TemperatureUnits.CELSIUS ?
                        (srcValue - 32) * 5 / 9 :
                        (srcValue - 32) * 5 / 9 + 273.15;
            }
            if (srcUnit == TemperatureUnits.KELVIN) {
                return destUnit == TemperatureUnits.CELSIUS ?
                        srcValue - 273.15 :
                        (srcValue - 273.15) * 9 / 5 + 32;
            }
        }
        return 0;
    }
    public TemperatureUnits getUnit(int unitPosition) {
        return TemperatureUnits.values()[unitPosition];
    }
}
