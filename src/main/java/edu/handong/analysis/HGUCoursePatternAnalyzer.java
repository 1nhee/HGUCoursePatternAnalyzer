package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		int i = 0;
		
		students = new Student[numOfStudents];
		
        for(String getNamesFromString: lines){
        	 String getNamesWithTrim = new String(getNamesFromString.split(",")[1]);
        	 Student check_student = new Student(getNamesWithTrim.trim());
        	 if(!(studentExist(students, check_student))) {
        		 students[i] = check_student;
        		 i++;
        	 }else{
        		 continue;
        	 }
        }
		
		return null;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		for(Student student_exist: students){
			if(student_exist == null) {
				return false;
			}else{
				String student_exist_name = new String(student_exist.getName());
				String student_name = new String(student.getName());
	       	 	if(student_name.equals(student_exist_name)) {
	       		 return true;
	       	 	}
			}
		}
		
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		int i = 0;
		
		courses = new Course[numOfCourses]; 
		
        for(String getNamesFromString: lines){
        	 String getNamesWithTrim = new String(getNamesFromString.split(",")[2]);
        	 Course check_course = new Course(getNamesWithTrim.trim());
        	 if(!(courseExist(courses, check_course))) {
        		 courses[i] = check_course;
        		 i++;
        	 }else{
        		 continue;
        	 }
        }
		
		return null;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		for(Course course_exist: courses){
			if(course_exist == null) {
				return false;
			}else{
				String course_exist_name = new String(course_exist.getCourseName());
				String course_name = new String(course.getCourseName());
		       	 if(course_name.equals(course_exist_name)) {
		       		 return true;
		       	 }
			}
		}

		return false;
	}

}
