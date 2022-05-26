import java.io.Serializable;

public class Student implements Serializable {

		private String StudName;
		private String StudGender;
		private int StudAge;
		private float StudGrade;
		
		// Object
		public Student(String sname, String sgender, int sage, float sgrade)
		{
			this.StudName = sname;
			this.StudGender = sgender;
			this.StudAge = sage;
			this.StudGrade = sgrade;
		}
		
		// Get&Set
		public void setStudentName(String sname) {
			this.StudName = sname;
		}
		
		public String getStudentName()
		{
			return this.StudName;
		}
		
		public void setStudentGender(String sgender)
		{
			this.StudGender = sgender;
		}
		
		public String getStudentGender() {
			return this.StudGender;
		}
		
		public void setStudentAge(int sage) {
			this.StudAge = sage;
		}
		
		public int getStudentAge() {
			return this.StudAge;
		}
		
		public void setStudentGrade(float sgrade) {
			this.StudGrade = sgrade;
		}
		
		public float getStudentGrade() {
			return this.StudGrade;
		}
}
