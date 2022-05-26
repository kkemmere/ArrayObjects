import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		// Creating ArrayList of objects
		ArrayList<Student> StudentArray = new ArrayList<Student>();
		StudentArray.add(new Student("Alice", "F", 23, 80.5f));
		StudentArray.add(new Student("Brian", "M", 22, 95.5f));
		StudentArray.add(new Student("Carol", "F", 21, 79.8f));
		StudentArray.add(new Student("Bruce", "M", 20, 81.0f));
		
		//Test print
		//	for(Student str: StudentArray){
		//			System.out.println(str);
		//  }
		
		// Writing Primitives to StudentRecords.txt
		FileOutputStream filePrim = new FileOutputStream("StudentRecords.txt");
		DataOutputStream dataPrim = new DataOutputStream(filePrim);
		
		for (Student str: StudentArray) {
			
			dataPrim.writeUTF(str.getStudentName()); // write obj(Student) name
			dataPrim.writeChars(str.getStudentGender()); // write obj(Student) gender
			dataPrim.writeInt(str.getStudentAge()); // write obj(Student) age
			dataPrim.writeFloat(str.getStudentGrade()); // write obj(Student) grade
			
		}
		filePrim.close();
		dataPrim.close();
		
		// Reading Primitives from StudentRecords.txt
		FileInputStream inPrim = new FileInputStream("StudentRecords.txt");
		DataInputStream datainPrim = new DataInputStream(inPrim);
		
		while(datainPrim.available() != 0)
		{
			System.out.println("Primitives: Student " +datainPrim.readUTF() + ", a " + datainPrim.readChar() + " and of age " + datainPrim.readInt() + ", received a grade of " + datainPrim.readFloat() + " in this class.");
		}
		
		inPrim.close();
		datainPrim.close();
		
		
		// Writing Objects to StudentRecords2.txt
		FileOutputStream fileObj = new FileOutputStream("StudentRecords2.txt");
		ObjectOutputStream dataObj = new ObjectOutputStream(fileObj);
		
		for (Student str: StudentArray) {
			
			dataObj.writeObject(str);
		}
		dataObj.writeObject(null); // Write null object at the end of text file so we know where the end is
		fileObj.close();
		dataObj.close();
		
		// Reading Objects from StudentRecords2.txt
		FileInputStream inObj = new FileInputStream("StudentRecords2.txt");
		ObjectInputStream datainObj = new ObjectInputStream(inObj);
		
		Student temp;
		
		while((temp = (Student) datainObj.readObject()) != null) {
			
			String tempName = temp.getStudentName();
			String tempGender = temp.getStudentGender();
			int tempAge = temp.getStudentAge();
			float tempGrade = temp.getStudentGrade();
			System.out.println("Object: Student " +tempName + ", a " + tempGender + " and of age " + tempAge + ", received a grade of " + tempGrade + " in this class.");
		
		}
		
		inObj.close();
		datainObj.close();
	}
	

}
