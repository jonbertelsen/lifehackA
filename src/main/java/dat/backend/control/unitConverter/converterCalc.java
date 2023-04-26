package dat.backend.control.unitConverter;

public class converterCalc {
    /**
     * Calculates the input and returns as output as the selected unit type.
     * @param input
     * @param inputUnit
     * @param outputUnit
     * @return
     */
    public double calcuate(double input, String inputUnit, String outputUnit){
        double meters = 0.0;
        /**
         * Converts number of chosen unit to meters
         */
        switch (inputUnit){
            case "mm":
                meters = input*0.001;
                break;
            case "cm":
                meters = input*0.01;
                break;
            case "inches":
                meters = input*0.0254;
                break;
            case "yards":
                meters = input*0.9144;
                break;
            case "meter":
                meters = input*1;
                break;
            case "km":
                meters = input*1000;
                break;
            case "miles":
                meters = input*1609.344;
                break;
        }
        double result=0.0;
        /**
         * Converts meter amount to chosen output unit
         */
        switch (outputUnit){
            case "mm":
                result = meters/0.001;
                break;
            case "cm":
                result = meters/0.01;
                break;
            case "inches":
                result = meters/0.0254;
                break;
            case "yards":
                result = meters/0.9144;
                break;
            case "meter":
                result = meters;
                break;
            case "km":
                result = meters/1000;
                break;
            case "miles":
                result = meters/1609.344;
                break;
        }
        /**
         * Returns the calculated input as output with the selected unit type.
         */
        return result;
    }
}
