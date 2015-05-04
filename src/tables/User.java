package tables;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	
	public User() {
	
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String e) {
		this.email = e;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass){
		this.password = pass;
	}
	public String getFirst_name(){
		return first_name;
	}
	public void setFirst_name(String fn){
		this.first_name = fn;
	}
	public String getLast_name(){
		return last_name;
	}
	public void setLast_name(String ln){
		this.last_name=ln;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (first_name == null) {
			if (other.first_name != null) {
				return false;
			}
		} else if (!first_name.equals(other.first_name)) {
			return false;
		}
		if (last_name == null) {
			if (other.last_name != null) {
				return false;
			}
		} else if (!last_name.equals(other.last_name)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}
	

}