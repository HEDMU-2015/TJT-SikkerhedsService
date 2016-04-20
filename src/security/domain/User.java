package security.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
	
	private long id;
	private String encryptedPassword;
	private String username;
	
	public static String encrypt(String txt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] mdbytes = md.digest(txt.getBytes());
		return Base64.getEncoder().encodeToString(mdbytes);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	public void setAndEncryptPassword(String password) throws NoSuchAlgorithmException {
		this.encryptedPassword = encrypt(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", encryptedPassword=" + encryptedPassword + ", username=" + username + "]";
	}


}
