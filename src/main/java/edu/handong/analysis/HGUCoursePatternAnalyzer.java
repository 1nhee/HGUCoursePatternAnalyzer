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
		
		//you need to create instances of students which is student class array
		students = new Student[numOfStudents];
		int j = 0;
		
		//you need to count it till the end of lines
		for(int i = 0; i < 12; i++) {
			//make a string instance to create the 'check_student' instance
        	String getNamesWithTrim = new String(lines[i].split(",")[1]);
        	//make a instance to check it is already in students
        	Student check_student = new Student(getNamesWithTrim.trim());
        	//if there is no same thing in the students
        	if(!(studentExist(students, check_student))) {
        		//insert check_student in students
        		students[j] = check_student;
        		//and update the count
        		j++;
        		//but count shouldn't be over numOfStudents
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
		
		//you can't count it over numOfStudents
		for(int i = 0; i < numOfStudents; i++) {
			//if students[i] is empty(null), return false to fill it
			if(students[i] == null) {
				return false;
			//if student's name already exist, return true to skip this student's name
			}else if(students[i].getName().equals(student.getName())) {
				return true;
			}
		}
		//if student's name is not in students yet, return false to insert this student's name
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		//you need to create instances of courses which is course class array
		courses = new Course[numOfCourses]; 
		int j = 0;
		
		//you need to count it till the end of lines
        for(int i = 0; i < 12; i++) {
        	//make a string instance to create the 'check_course' instance
        	 String getNamesWithTrim = new String(lines[i].split(",")[2]);
        	 Course check_course = new Course(getNamesWithTrim.trim());
        	//if there is no same thing in the courses
        	 if(!(courseExist(courses, check_course))) {
        		//insert check_course in courses
        		 courses[j] = check_course;
        		//and update the count
        		 j++;
        		//but the count shouldn't be over numOfCourses
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
		
		//you can't count it over numOfStudents
		for(int i = 0; i < numOfCourses; i++){
			//if courses[i] is empty(null), return false to fill it
			if(courses[i] == null) {
				return false;
			//if course's name already exist, return true to skip this course name
			}else if(courses[i].getCourseName().equals(course.getCourseName())) {
				return true;
			}
		}
		//if course's name is not in courses yet, return false to insert this course's name
		return false;
	}

}
