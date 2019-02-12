public class pointSlope extends linearEquations {
    private float xOne;
    private float yOne;
    private float xTwo;
    private float yTwo;
    private float slopeNum;
    private float slopeDen;
    private int slopeNumInt;
    private int slopeDenInt;
    private int dividedSlope;
    private boolean isFactor;
    //must make public to sense in the top class:
    public boolean isFake;

    public pointSlope(float xOne, float yOne, float xTwo, float yTwo) {
        this.xOne = xOne;
        this.yOne = yOne;
        this.xTwo = xTwo;
        this.yTwo = yTwo;
        setEquation();
    }
    public void setEquation() {
        slopeNum = yTwo - yOne;
        slopeDen = xTwo - xOne;
        if (yOne == yTwo && xOne == xTwo) {
            isFake = true;
        }
        else{
            isFake = false;
        }
        if (slopeNum % slopeDen == 0) {
            slopeNumInt = (int)slopeNum;
            slopeDenInt = (int)slopeDen;
            dividedSlope = slopeNumInt / slopeDenInt;
            isFactor = true;
        }
        else{
            if (slopeDen < 0) {
                slopeDen = Math.abs(slopeDen);
                slopeNum = slopeNum - slopeNum * 2;
            }
            isFactor = false;
        }
    }
    public String getEquation() {
        if (isFactor) {
            if (xOne > 0) {
                if (yOne > 0) {
                    if (yOne == yTwo && xOne == xTwo) {
                        return "That is an impossible line!";
                    }
                    else if (yOne == yTwo && xOne != xTwo) {
                        return "y = " + yOne;
                    }
                    else if (xOne == xTwo && yOne != yTwo) {
                        return "x = " + xOne;
                    }
                    else {
                        return "y - " + yOne + " = " + dividedSlope + "(x - " + xOne + ")";
                    }
                }
                else{
                    return "y + " + Math.abs(yOne) + " = " + dividedSlope + "(x - " + xOne + ")";
                }
            }
            else{
                if (yOne > 0) {
                    return "y - " + yOne + " = " + dividedSlope + "(x + " + Math.abs(xOne) + ")";
                }
                else{
                    if (yOne == yTwo && xOne == xTwo) {
                        return "That is an impossible line!";
                    }
                    else if (yOne == yTwo && xOne != xTwo) {
                        return "y = " + yOne;
                    }
                    else if (xOne == xTwo && yOne != yTwo) {
                        return "x = " + xOne;
                    }
                    else {
                        return "y + " + Math.abs(yOne) + " = " + dividedSlope + "(x + " + Math.abs(xOne) + ")";
                    }
                }
            }
        }
        else{
            if (xOne > 0) {
                if (yOne > 0) {
                    if (yOne == yTwo && xOne == xTwo) {
                        return "That is an impossible line!";
                    }
                    else if (yOne == yTwo && xOne != xTwo) {
                        return "y = " + yOne;
                    }
                    else if (xOne == xTwo && yOne != yTwo) {
                        return "x = " + xOne;
                    }
                    else {
                        return "y - " + yOne + " = " + slopeNum + "/" + slopeDen + "(x - " + xOne + ")";
                    }
                }
                else{
                    return "y + " + Math.abs(yOne) + " = " + slopeNum + "/" + slopeDen + "(x - " + xOne + ")";
                }
            }
            else{
                if (yOne > 0) {
                    return "y - " + yOne + " = " + slopeNum + "/" + slopeDen + "(x + " + Math.abs(xOne) + ")";
                }
                else{
                    if (yOne == yTwo && xOne == xTwo) {
                        return "That is an impossible line!";
                    }
                    else if (yOne == yTwo && xOne != xTwo) {
                        return "y = " + yOne;
                    }
                    else if (xOne == xTwo && yOne != yTwo) {
                        return "x = " + xOne;
                    }
                    else{
                        return "y + " + Math.abs(yOne) + " = " + slopeNum + "/" + slopeDen + "(x + " + Math.abs(xOne) + ")";
                    }
                }
            }
        }

    }
}
