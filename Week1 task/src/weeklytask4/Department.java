package weeklytask4;

public class Department {

private int departmentId;
private String departmentName;
private Integer managerId;

public int getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public Integer getManagerId() {
	return managerId;
}
public void setManagerId(Integer managerId) {
	this.managerId = managerId;
}
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
			+ managerId + "]";
}
public Department(int departmentId, String departmentName, Integer managerId) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.managerId = managerId;
}


}
