package com.demo.model;

public class LowAttendanceException extends Exception {
    public LowAttendanceException() {
        super("Attendance is below required threshold (60%).");
    }

    public LowAttendanceException(String message) {
        super(message);
    }
}
