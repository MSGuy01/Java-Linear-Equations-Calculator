public class converter extends linearEquations {
    //finish up the checking if a equation is just y = 0, etc.
    public String converterChoice;
    public String result;
    private double nextSlopeNum;
    private double nextSlopeDen;
    private boolean isFactor;
    private double resultYIntercept;
    private double resultSlopeNum;
    private double resultSlopeDen;
    private double resultXOne;

    public converter(String converterChoice) {
        this.converterChoice = converterChoice;
        //use this info in the getEquation string
    }
    public void sips(float slopeNum, float slopeDen, float yIntercept) {
        if (slopeDen == 1) {
            isFactor = true;
        }
        else{
            isFactor = false;
        }
        if (yIntercept > 0) {
            if (isFactor) {
                result = "y - " + yIntercept + " = " + slopeNum + "(x)";
            }
            else {
                result = "y - " + yIntercept + " = " + slopeNum + "/" + slopeDen + "(x)";
            }
        }
        else{
            if (isFactor) {
                result = "y + " + Math.abs(yIntercept) + " = " + slopeNum + "(x)";
            }
            else{
                result = "y + " + Math.abs(yIntercept) + " = " + slopeNum + "/" + slopeDen + "(x)";
            }
        }
    }
    public void sis(float slopeNum, float slopeDen, float yIntercept) {
        if (slopeDen == 1) {
            isFactor = true;
        }
        else{
            isFactor = false;
        }
        if (isFactor) {
            if (Math.abs(slopeNum) == slopeNum) {
                slopeNum = slopeNum - slopeNum * 2;
            }
            else{
                slopeNum = Math.abs(slopeNum);
            }
            result = slopeNum + "x + y = " + yIntercept;
        }
        else{
            if (Math.abs(slopeNum) == slopeNum) {
                slopeNum = slopeNum - slopeNum * 2;
            }
            else{
                slopeNum = Math.abs(slopeNum);
            }
            result = slopeNum + "/" + slopeDen + "x + y = " + yIntercept;

        }
    }
    public void pssi(double xOne, double yOne, double slopeNum, double slopeDen) {
        if (slopeDen == 1) {
            isFactor = true;
        }
        else{
            isFactor = false;
        }
        if (! isFactor) {
            //y - y1 = m(x - x1) -> y = mx + b
            nextSlopeNum = slopeNum / 100;
            nextSlopeDen = slopeDen / 100;
            //divide above more

            while (xOne > 0) {
                yOne = yOne - nextSlopeNum;
                xOne = xOne - nextSlopeDen;
            }
            if (xOne == 0) {
                result = "y = " + slopeNum + "/" + slopeDen + "x + " + yOne;

            } else {
                result = "y = " + slopeNum + "/" + slopeDen + "x + (about)" + yOne;
            }
        }
        else{
            while (xOne != 0){
                yOne = yOne - slopeNum;
                xOne = xOne - 1;
            }
            result = "y = " + slopeNum + "x + " + yOne;
        }

        resultXOne = xOne;
        resultYIntercept = yOne;
        resultSlopeDen = slopeNum;
        resultSlopeNum = slopeDen;
    }
    public void pss(double xOne, double yOne, double slopeNum, double slopeDen) {
        if (slopeDen == 1) {
            isFactor = true;
        }
        else{
            isFactor = false;
        }
        pssi(xOne, yOne, slopeNum, slopeDen);
        //finish up code using the result variables
        if (Math.abs(resultSlopeNum) == resultSlopeNum) {
            slopeNum = resultSlopeNum - resultSlopeNum * 2;
        }
        else{
            slopeNum = Math.abs(resultSlopeNum);
        }
        if (isFactor) {
            if (slopeNum == 1){
                result = "x + y = " + resultYIntercept;
            }
            else {
                result = slopeNum + "x + y = " + resultYIntercept;
            }
        }
        else{
            if (slopeNum == 1 && slopeDen == 1) {
                result = "x + y = " + resultYIntercept;
            }
            else {
                result = slopeNum + "/" + slopeDen + "x + y = " + resultYIntercept;
            }
        }
    }
    public void ssi(float aX, float bY, float C) {
        //AX + BY = C -> y = mx + b
        String aXFraction;
        String sign;
        String CFraction;
        if (C > 0) {
            sign = "+";
        }
        else{
            sign = "-";
            C = Math.abs(C);
        }
        result = bY + "y = " + aX + "x + " + C;
        if (aX % bY == 0) {
            aX = aX / bY;
            aXFraction = "hi";
        }
        else{
            aXFraction = aX + "/" + bY;
        }
        if (C % bY == 0) {
            C = C / bY;
            CFraction = "hi";
        }
        else{
            CFraction = C + "/" + bY;
        }
        if (CFraction.equals("hi")) {
            if (aXFraction.equals("hi")) {
                result = "y = " + aX + "x " + sign + " " + C;
            }
            else{
                result = "y = " + aXFraction + "x " + sign + " " + C;
            }
        }
        else{
            if(aXFraction.equals("hi")) {
                result = "y = " + aX + "x " + sign + " " + CFraction;
            }
            else{
                result = "y = " + aXFraction + "x " + sign + " " + CFraction;
            }
        }

    }
    public void sps(float aX, float bY, float C) {
        //result = "y - " + C + " = " + [find slope, aX / bY] + "(x)";
        String aXFraction;
        if (aX > 0) {
            aX = aX - aX * 2;
        }
        else{
            aX = Math.abs(aX);
        }
        if (aX % bY == 0) {
            aX = aX / bY;
            aXFraction = "hi";
        }
        else{
            aXFraction = aX + "/" + bY;
        }
        if (C > 0) {
            if (aXFraction.equals("hi")) {
                result = "y - " + C + " = " + aX + "(x)";
            }
            else{
                result = "y - " + C + " = " + aXFraction + "(x)";
            }
        }
        else{
            if (aXFraction.equals("hi")) {
                result = "y + " + Math.abs(C) + " = " + aX + "(x)";
            }
            else {
                result = "y + " + Math.abs(C) + " = " + aXFraction + "(x)";
            }
        }
    }

}
