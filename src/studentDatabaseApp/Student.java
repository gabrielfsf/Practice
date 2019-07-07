package studentDatabaseApp;

import java.util.Scanner;

public class Student {
	
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentId;
	private int tuitionBalance = 0;
	private String coursesEnrolled = "";
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	
	// Constructor prompt user to enter student name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student grade: ");
		this.gradeYear = in.nextInt();
		
		setStudentId();
		in.close();
//		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);
	}
	
	// Generate id
	private void setStudentId() {
		// Grade Year + id
		id++;
		this.studentId = gradeYear + "" + id;
	}
	
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits 0
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			in.close();
			if (!course.equals("Q")) {
				coursesEnrolled += "\n " + course;
				tuitionBalance += costOfCourse;
			} else {
				break;
			}
		} while (true);
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your current balamce is: " + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment amount: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		in.close();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	// Show Info
	@Override
	public String toString() {
		return "\nName: " + firstName + " " + lastName + 
				"\nGrade Level: " + gradeYear + 
				"\nStudent ID: " + studentId +
				"\nCourses Enrolled: " + coursesEnrolled +
				"\nBalance: $" + tuitionBalance;
	}
	
}
