package models;

public class Vacancy {
	private int id;
	private String position;
	private int depId;
	private String schedule;
	public Vacancy(int id, String position, int depId, String schedule, float salary, int quantity) {
		super();
		this.id = id;
		this.position = position;
		this.depId = depId;
		this.schedule = schedule;
		Salary = salary;
		this.quantity = quantity;
	}
	public float Salary;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
