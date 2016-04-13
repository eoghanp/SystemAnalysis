package Report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FailHeader extends ReportDecorator{

	public FailHeader(ReportComponent myReport) {
		super(myReport);
	}

	@Override
	public void prtReport() {
		try(FileWriter fw = new FileWriter("printable_Delivery_Report.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("Delivery not completed");
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		super.callReport();
	}

}
