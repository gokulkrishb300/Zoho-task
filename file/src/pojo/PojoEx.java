package pojo;

public class PojoEx {

	private String studentName;
	private int studentId;
	
	public PojoEx(String studentName, int studentId) {
		
		this.studentName = studentName;
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "PojoEx [studentName=" + studentName + ", studentId=" + studentId + "]";
	}
	
}
