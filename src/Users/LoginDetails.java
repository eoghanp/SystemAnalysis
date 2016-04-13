package Users;

public class LoginDetails {
	private int loginType;
	private String userName;
	private String password;
	
	public LoginDetails() {
		
	}
	
	public LoginDetails(int loginType, String userName, String password)
	{
		this.loginType = loginType;
		this.userName = userName;
		this.password = password;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
