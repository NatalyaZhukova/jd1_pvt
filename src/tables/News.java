package tables;

import java.io.Serializable;

public class News implements Serializable {

	/**
	 * 
	 */
	
	private int id;
	private int category;
	private String title;
	private String annotation;
	private String author;
	private String release_date;
	private String full_text;

	public News () {
	
	}

   
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getAuthor() {
        return author;
    }

   
    public void setAuthor(String author) {
        this.author = author;
    }

    
    public String getRelease_date() {
        return release_date;
    }

   
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annotation == null) ? 0 : annotation.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + category;
		result = prime * result
				+ ((full_text == null) ? 0 : full_text.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (!(obj instanceof News)) {
			return false;
		}
		News other = (News) obj;
		if (annotation == null) {
			if (other.annotation != null) {
				return false;
			}
		} else if (!annotation.equals(other.annotation)) {
			return false;
		}
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (category != other.category) {
			return false;
		}
		if (full_text == null) {
			if (other.full_text != null) {
				return false;
			}
		} else if (!full_text.equals(other.full_text)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (release_date == null) {
			if (other.release_date != null) {
				return false;
			}
		} else if (!release_date.equals(other.release_date)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
    
    

}