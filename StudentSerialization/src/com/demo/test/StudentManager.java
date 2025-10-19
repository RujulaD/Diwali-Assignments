package com.demo.test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.demo.model.LowAttendanceException;
import com.demo.model.Student;

		
		public class StudentManager {

		    private static final String DATA_FILE = "students.dat";

		    public static void main(String[] args) {
		       
		        List<Student> created = new ArrayList<>();
		        Object[][] sample = {
		        		{1, "Aarav", "Computer Science", 92.5, 91.0},
		        		{2, "Bhavna", "Mechanical", 88.0, 78.0},
		        		{3, "Chirag", "Civil", 59.0, 55.0},        
		        		{4, "Deepak", "Electrical", 75.0, 82.0},
		        		{5, "Esha", "Computer Science", 60.0, 66.0},
		        		{6, "Farhan", "Mechanical", 45.0, 40.0},   
		        		{7, "Gauri", "Civil", 80.0, 90.0},
		        		{8, "Harsh", "Electrical", 95.0, 95.0},
		        		{9, "Isha", "Computer Science", 70.0, 72.0},
		        		{10, "Jay", "Mechanical", 85.0, 88.0},
		        		{11, "Kiran", "Civil", 65.0, 63.0},
		        		{12, "Lakshmi", "Electrical", 78.0, 69.0}

		        };

		        for (Object[] rec : sample) {
		            int roll = (int) rec[0];
		            String name = (String) rec[1];
		            String course = (String) rec[2];
		            double attendance = (double) rec[3];
		            double score = (double) rec[4];

		            try {
		                Student s = new Student(roll, name, course, attendance, score);
		                created.add(s);
		                System.out.println("Created: " + s);
		            } catch (LowAttendanceException lae) {
		                
		                System.err.println("Cannot create student (roll " + roll + "): " + lae.getMessage());
		            }
		            if (created.size() == 10) break;
		        }

		        System.out.println("\nTotal valid students created: " + created.size());

		       
		        serializeStudents(created, DATA_FILE);

		       
		        Set<Student> sortedDescByAttendance = readAndSortStudents(DATA_FILE);

		        System.out.println("\nStudents in decreasing order of attendance:");
		        for (Student s : sortedDescByAttendance) {
		            System.out.println(s);
		        }
		    }

		    
		    private static void serializeStudents(List<Student> students, String filename) {
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
		            oos.writeObject(students);
		            System.out.println("\nSerialized " + students.size() + " students to file: " + filename);
		        } catch (IOException e) {
		            System.err.println("Failed to serialize students: " + e.getMessage());
		            e.printStackTrace();
		        }
		    }

		    
		    private static Set<Student> readAndSortStudents(String filename) {
		        List<Student> studentsFromFile = new ArrayList<>();
		        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
		            Object obj = ois.readObject();
		            if (obj instanceof List) {
		                studentsFromFile = (List<Student>) obj;
		                System.out.println("\nDeserialized " + studentsFromFile.size() + " students from file: " + filename);
		            } else {
		                System.err.println("Unexpected data in file: not a List.");
		            }
		        } catch (IOException | ClassNotFoundException e) {
		            System.err.println("Failed to read students from file: " + e.getMessage());
		            e.printStackTrace();
		        }

		        Comparator<Student> comp = (a, b) -> {
		            int cmp = Double.compare(b.getAttendancePercentage(), a.getAttendancePercentage()); // descending
		            if (cmp != 0) return cmp;
		            return Integer.compare(a.getRollno(), b.getRollno());
		        };

		        Set<Student> sortedSet = new TreeSet<>(comp);
		        sortedSet.addAll(studentsFromFile);
		        return sortedSet;
		    }
		

	}


