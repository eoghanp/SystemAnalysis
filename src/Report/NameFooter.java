package Report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NameFooter extends ReportDecorator{

	public NameFooter(ReportComponent myReport) {
		// TODO Auto-generated constructor stub
		super(myReport);
	}

	@Override
	public void prtReport() {
		// TODO Auto-generated method stub
		super.callReport();
		try(FileWriter fw = new FileWriter("printable_Delivery_Report.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("Company Name");
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
	}

}
