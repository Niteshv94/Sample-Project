package demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeAdmin {
	
	/* TestNG will convert automatically passed parameter value sin desired data types.*/
    @Parameters({"StringParam", "intParam", "booleanParam"})
    @Test
    /*
     * A test method accepting argument of different datatypes
     */
    public void sampleTest(String stringParaValue, int intParamValue, boolean booleanParamValue)
    {
        System.out.println("String parameter: "+stringParaValue);
        System.out.println("Int parameter: "+intParamValue);
        System.out.println("Boolean parameter: "+booleanParamValue);
    }

}
