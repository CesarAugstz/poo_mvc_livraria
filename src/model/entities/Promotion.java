package model.entities;

public class Promotion {

	private String name;
	private Integer days;
	private String description;

	public Promotion(String name, Integer days, String description) {
		this.name = name;
		this.days = days;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "; Days: " + getDays() + "; Description: " + getDescription();
	}

}
