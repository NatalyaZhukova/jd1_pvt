package tables;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	
	private int id;
	private String name;

	public Category() {

	}

	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getName(){
		return name;
	}
	public void setName(String n){
		this.name = n;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	

}