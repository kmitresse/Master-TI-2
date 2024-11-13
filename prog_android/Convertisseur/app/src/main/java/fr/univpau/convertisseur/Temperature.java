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
                if (destUnit == TemperatureUnits.FAHRENHEIT)
                    return srcValue * 9 / 5 + 32;
                if (destUnit == TemperatureUnits.KELVIN)
                    return srcValue + 273.15;
            }
            if (srcUnit == TemperatureUnits.FAHRENHEIT) {
                if (destUnit == TemperatureUnits.CELSIUS)
                    return (srcValue - 32) * 5 / 9;
                if (destUnit == TemperatureUnits.KELVIN)
                    return (srcValue - 32) * 5 / 9 + 273.15;
            }
            if (srcUnit == TemperatureUnits.KELVIN) {
                if (destUnit == TemperatureUnits.CELSIUS)
                    return srcValue - 273.15;
                if (destUnit == TemperatureUnits.FAHRENHEIT)
                    return (srcValue - 273.15) * 9 / 5 + 32;
            }
        }
        return 0;
    }
    public TemperatureUnits getUnit(int unitPosition) {
        return TemperatureUnits.values()[unitPosition];
    }
}
