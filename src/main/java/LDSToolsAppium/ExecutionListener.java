package LDSToolsAppium;


import java.io.File;
import org.testng.IExecutionListener;



public class ExecutionListener implements IExecutionListener {
	//File myFile = new File("test-output/emailable-report.html");
	File myFile = new File("test-output/custom-report.html");
	
	//myFile = "test-output/emailable-report.html";
	
	@Override
	public void onExecutionStart() {
		//System.out.println("Test Started!");
	}
	
	@Override
    public void onExecutionFinish() {
		String[] args = null;
		System.out.println("Test is finished... Sending email");
		/*
		try {
			java.awt.Desktop.getDesktop().open(myFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		SendFileEmail.main(args);
	}


}