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
		
		students = new Student[numOfStudents];
		
		for(int i = 0, j = 0; i < 12; i++) {
        	String getNamesWithTrim = new String(lines[i].split(",")[1]);
        	Student check_student = new Student(getNamesWithTrim.trim());
        	if(!(studentExist(students, check_student))) {
        		students[j] = check_student;
        		j++;
        		if (j >= numOfStudents) {
          			 break;
          		 }
        	 }
        }
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		for(int i = 0; i < numOfStudents; i++) {
			if(students[i] == null) {
				return false;
			}else if(students[i].getName().equals(student.getName())) {
				return true;
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
		
		courses = new Course[numOfCourses]; 
		
        for(int i = 0, j = 0; i < 12; i++) {
        	 String getNamesWithTrim = new String(lines[i].split(",")[2]);
        	 Course check_course = new Course(getNamesWithTrim.trim());
        	 if(!(courseExist(courses, check_course))) {
        		 courses[j] = check_course;
        		 j++;
        		 if (j >= numOfCourses) {
        			 break;
        		 }
        	 }
        }
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		for(int i = 0; i < numOfCourses; i++){
			if(courses[i] == null) {
				return false;
			}else if(courses[i].getCourseName().equals(course.getCourseName())) {
				return true;
			}
		}
		return false;
	}

}
