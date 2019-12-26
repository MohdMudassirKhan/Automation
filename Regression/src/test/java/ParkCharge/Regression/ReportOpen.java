package ParkCharge.Regression;

import org.testng.annotations.Test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ReportOpen extends TestBase {

  @Test
  public void Report() throws IOException { 
	  File htmlFile = new File(path+"\\target\\surefire-reports\\html\\index.html");		
	  Desktop.getDesktop().open(htmlFile);
 
  }
}
