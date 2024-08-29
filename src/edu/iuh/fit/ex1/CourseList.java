package edu.iuh.fit.ex1;

import java.util.Arrays;

/**
 * Description: This class represents a list of courses
 * @author Hung, Nguyen Tan Hung
 * date: 29/8/2024
 * version 1.0
 */
public class CourseList {

    private Course[] courses;
    private static int count = 0;

    /**
     * Description: Constructor with a parameter to initialize the array of courses with a specific length n
     * @author Hung, Nguyen Tan Hung
     * @param n The length of the array
     * @throws IllegalArgumentException if n is less than or equal to 0
     * date: 29/8/2024
     * version 1.0
     */
    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n]; // create an array of n elements
    }

    /**
     * Description: Add a course to the list
     * @param course
     * @author Hung, Nguyen Tan Hung
     * @return true if the course is added successfully, false otherwise
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full
     * date: 29/8/2024
     * version 1.0
     */
    public boolean addCourse(Course course) {
        //  check if course is null
        if(course == null)
            return false;
        //  check if course already exists
        if(exists(course)) //Check if id of course duplicate
            return false;
        //  check if the array is full
        if (count == courses.length)
            return false;
        //  add course to the array
        courses[count++] = course;
        return true;
    }

    /**
     * Description: Check if the course exists in the list, based on the course ID
     * @author Hung, Nguyen Tan Hung
     * @param course The course to check
     * @return true if the course exists, false otherwisedate:
     * 29/8/2024
     * version 1.0
     */
    private boolean exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }
    /**
     * Description: Method to search for courses with the largest number of signals.
     * @author Hung, Nguyen Tan Hung
     * @return Smaxx is have the most courses.
     * date: 29/8/2024
     * version 1.0
     */
    public String findDepartmentWithMostCourses(){
        int maxx=0;
        String Smaxx =" ";
        for(Course c : getCourses()){
            if(c!= null && c.getCredit()>maxx){
                maxx=c.getCredit();
                Smaxx=c.getDepartment();
            }
        }
        return Smaxx;
    }
    /**
     * Description: Scientific search methods have the most courses
     * @author Hung, Nguyen Tan Hung
     * @return a if a[i] is the most course.
     * date: 29/8/2024
     * version 1.0
     */
    public Course[] findMaxCreditCourse(){
        int maxx=0;
        Course[] a= new Course[getCourses().length];
        for(Course c : getCourses()){
            if(c!= null && c.getCredit()>maxx){
                maxx=c.getCredit();

            }
        }
        int i=0;
        for(Course c : getCourses()){
            if(c!= null && c.getCredit()>=maxx) {
                a[i] = c;
                i++;
            }
        }
        return a;
    }
    /**
     * Description: Sort courses by course name, returning a list of courses after sorting (not sorting on the original list).
     * @author Hung, Nguyen Tan Hung
     * @return courses is a list of courses after sorting.
     * date: 29/8/2024
     * version 1.0
     */
    public Course[] sortCourses(){
        for(int i=0;i<count-1;i++) {
            char a=courses[i].getTitle().charAt(0);
            for (int j = i + 1; j < count; j++) {
                char b=courses[j].getTitle().charAt(0);
                if (a > b) {
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses;
    }
    /**
     * Description: Search for a course by course code. Returns course information if found, otherwise returns null.
     * @author Hung, Nguyen Tan Hung
     * @param a The String to check
     * @return c if find, null otherwise
     * date: 29/8/2024
     * version 1.0
     */
    public Course searchCourseById(String a){
        if(a==null) return null;
        for(Course c : getCourses()){
            if(c!=null && c.getId().equals(a)){
                return c;
            }
        }
        return null;
    }
    /**
     * Description: Delete a course from the list. If the course code does not exist, an error message will be reported.
     * @author Hung, Nguyen Tan Hung
     * @param a The course to check
     * @return true if the course exists, false otherwise
     * date: 29/8/2024
     * version 1.0
     */
    public boolean removeCourse(String a) {
        if(a==null) return false;
        int c=count;
        for(int i=0;i<count;i++) {
            if(courses[i].getId().equals(a)) {
                for (int j = i; j < count-1; j++) {
                    courses[j]=courses[j+1];
                }
                count--;
            }
        }
        if(count<c) return true;
        return false;
    }
    /**
     * Description: search for courses by course name (relative search). Returns a list of courses if found, otherwise returns null.
     * @author Hung, Nguyen Tan Hung
     * @param a The String to check
     * @return c if find, null otherwise
     * date: 29/8/2024
     * version 1.0
     */
    public Course[] searchCourse(String a){
        if(a==null) return null;
        Course[] b= new Course[count];
        int dem=0;
        for(Course c: getCourses()){
            if(c!=null && c.getTitle().equals(a)){
                b[dem]=c;
                dem++;
            }
        }
        if(dem==0) return null;
        return b;
    }
    /**
     * Description: Search for courses by department. Returns a list of courses if found, otherwise returns null.
     * @author Hung, Nguyen Tan Hung
     * @param a The String to check
     * @return c if find, null otherwise
     * date: 29/8/2024
     * version 1.0
     */
    public Course[] searchCourseByDepartment(String a){
        if(a==null) return null;
        Course[] b= new Course[count];
        int dem=0;
        for(Course c: getCourses()){
            if(c!=null && c.getDepartment().equals(a)){
                b[dem]=c;
                dem++;
            }
        }
        if(dem==0) return null;
        return b;
    }
    /**
     * Description: Get the array courses of the course
     * @author Hung, Nguyen Tan Hung
     * @return the array courses of the course
     * date: 29/8/2024
     * version 1.0
     */
    public Course[] getCourses() {
        return courses;
    }
}