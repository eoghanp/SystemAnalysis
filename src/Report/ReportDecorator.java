package Report;

public abstract class ReportDecorator extends ReportComponent{
	private ReportComponent myReport;
	
	public ReportDecorator(ReportComponent myReport){
		this.myReport = myReport;
	}
	
	public void callReport(){
		if(myReport != null)
			myReport.prtReport();
	}
}
