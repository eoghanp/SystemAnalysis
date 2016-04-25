package Report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFooter extends ReportDecorator{

	public DateFooter(ReportComponent myReport) {
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
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				out.println(dateFormat.format(cal.getTime()));
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
	}

}
