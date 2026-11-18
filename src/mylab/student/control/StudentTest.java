package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) throws InvalidGradeException {
			Student student = new Student();
			
//			김민수 / 컴퓨터공학 / 3학년
//			5학년으로 변경 
//			학년은 1~4 사이의 값이어야 합니다.

			student.setName("김민수");
			student.setMajor("컴퓨터공학");
			student.setGrade(3);
			
			System.out.print(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
			
			//5학년으로 변경
			student.setGrade(5);
	}
}
