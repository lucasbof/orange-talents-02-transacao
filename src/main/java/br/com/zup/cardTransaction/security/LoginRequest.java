package br.com.zup.cardTransaction.security;

public class LoginRequest {

    private String user;
    private String password;

	public LoginRequest(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
