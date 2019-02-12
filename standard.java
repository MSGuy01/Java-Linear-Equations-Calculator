public class standard extends linearEquations {
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
    private String yIntercept;
    private float yInterceptFloat;
    private float partOne;
    private float partTwo;
    //must make public to sense in the top class:
    public boolean isFake;
    //use code for finding slope intercept equation, then convert it to standard
    public standard(float xOne, float yOne, float xTwo, float yTwo) {
        this.xOne = xOne;
        this.yOne = yOne;
        this.xTwo = xTwo;
        this.yTwo = yTwo;
        setEquation();
    }
    public void setEquation() {
        if (yOne == yTwo && xOne == xTwo) {
            isFake = true;
        }
        else{
            isFake = false;
        }
        slopeNum = yTwo - yOne;
        slopeDen = xTwo - xOne;
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
        if (! isFactor) {
            partOne = xOne * slopeNum;
            partTwo = yOne * slopeDen;
            yIntercept = partTwo - partOne + "/" + slopeDen;
            yInterceptFloat = (partTwo - partOne) / slopeDen;

        }
        else{
            partOne = xOne * dividedSlope;
            yIntercept = yOne - partOne + ".";
            yInterceptFloat = yOne - partOne;
        }
    }
    public String getEquation() {
        if (isFake) {
            return "That is an impossible line!";
        }
        else if (! isFactor) {
            if (yOne == yTwo) {
                return "y = " + yOne;
            }
            else if (xOne == xTwo) {
                return "x = " + xOne;
            }
            else{
                return slopeNum + "/" + slopeDen + "x + y = " + yIntercept;
            }
        }
        else{
            if (yOne == yTwo) {
                return "y = " + yOne;
            }
            else if (xOne == xTwo) {
                return "x = " + xOne;
            }
            else{
                return dividedSlope + "x + y = " + yIntercept;
            }
        }
    }
}
