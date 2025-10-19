package com.demo.model;
import java.io.Serializable;
import java.util.Objects;


public class Student implements Serializable {
	    private static final long serialVersionUID = 1L;

	    private int rollno;
	    private String sname;
	    private String course;
	    private double attendancePercentage;
	    private double score;

	    // Default constructor
	    public Student() {
	        this.rollno = 0;
	        this.sname = "";
	        this.course = "";
	        this.attendancePercentage = 0.0;
	        this.score = 0.0;
	    }

	    // Parameterized constructor 
	    public Student(int rollno, String sname, String course, double attendancePercentage, double score)
	            throws LowAttendanceException {
	        this.rollno = rollno;
	        this.sname = sname;
	        this.course = course;
	        setAttendancePercentage(attendancePercentage); 
	        this.score = score;
	    }

	   
	    public int getRollno() { return rollno; }
	    public void setRollno(int rollno) { this.rollno = rollno; }

	    public String getSname() { return sname; }
	    public void setSname(String sname) { this.sname = sname; }

	    public String getCourse() { return course; }
	    public void setCourse(String course) { this.course = course; }

	    public double getAttendancePercentage() { return attendancePercentage; }

	    // This setter enforces the attendance minimum rule
	    public void setAttendancePercentage(double attendancePercentage) throws LowAttendanceException {
	        if (attendancePercentage < 60.0) {
	            throw new LowAttendanceException("Student " + sname + " (roll: " + rollno + ") has low attendance: "
	                    + attendancePercentage + "%");
	        }
	        this.attendancePercentage = attendancePercentage;
	    }

	    public double getScore() { return score; }
	    public void setScore(double score) { this.score = score; }

	    
	    public String calculateGrade() {
	        if (score >= 90) return "A";
	        if (score >= 75) return "B";
	        if (score >= 60) return "C";
	        return "F";
	    }

	    @Override
	    public String toString() {
	        return "Student { " +
	                "rollno=" + rollno +
	                ", name='" + sname + '\'' +
	                ", course='" + course + '\'' +
	                ", attendance=" + attendancePercentage +
	                "%, score=" + score +
	                ", grade=" + calculateGrade() +
	                " }";
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Student)) return false;
	        Student student = (Student) o;
	        return rollno == student.rollno;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(rollno);
	    }
	}


