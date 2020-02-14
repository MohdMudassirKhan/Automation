package Utils.ExtentReports;
 
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.nio.file.Paths;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
            	new File(workingDir+"\\target\\ExtentReports\\").mkdir();
                extent = new ExtentReports(workingDir + "\\target\\ExtentReports\\ExtentReportResults.html", true);
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            	new File(workingDir+"/target/ExtentReports\\").mkdir();
                extent = new ExtentReports(workingDir + "/target/ExtentReports/ExtentReportResults.html", true);
            }
        }
        return extent;
    }
}
