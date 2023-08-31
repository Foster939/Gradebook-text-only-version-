package com.company;

import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Section {
    private ArrayList<Student> students;
    private String sectionName;

    public Section(String sectionName) {
        this.sectionName = sectionName;
        students = new ArrayList<>();
    }

    public String getSectionName() {
        return sectionName;
    }
    //create a new student if the username does not exist and add to the studentList
    //returns false if username exists, returns true otherwise
    public Boolean addStudent(String firstName, String lastName, String username, long phoneNumber){
        //check if username exists
        int studentIndex = getStudentIndexByUsername(username);
        //if exists return false
        if(studentIndex != -1){
            return false;
        }
        //otherwise create student and add and return true
        students.add(new Student(firstName, lastName, username, phoneNumber));
        return true;
    }
    //mark the student specified by username tardy (increase tardy count)
    //if student is not found, return false, otherwise true
    public boolean markTardy(String username){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return false;
        }
        //mark student as tardy
        curStudent.markTardy();
        return true;
    }
    public boolean markAbsent(String username){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return false;
        }
        //mark student as tardy
        curStudent.markAbsent();
        return true;
    }
    public int getTardyCount(String username){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return -1;
        }
        return curStudent.getTardyCount();
    }
    public int getAbsentCount(String username){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return -1;
        }
        return curStudent.getAbsentCount();
    }
    public boolean addAssignment(String username, String assignmentName, int pointsPossible){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return false;
        }
        int pointsEarned = 0;
        if(!curStudent.addAssignment(pointsPossible, pointsEarned, assignmentName)){
            return false;
        }
        return true;
    }
    public boolean addAssignmentToSection(String assignmentName, int pointsPossible){
        int pointsEarned = 0;
        int i = 0;
        while(i < students.size()){
            if(!students.get(i).addAssignment(pointsPossible, pointsEarned, assignmentName)){
                return false;
            }
            i++;
        }
        return true;
    }
    public int getAssignmentScoreAvg(String assignmentName){
        int i = 0;
        int tempScore = 0;
        while(i < students.size()){
            tempScore = students.get(i).getScore(assignmentName) + tempScore;
            if (tempScore <= -1){
                return -1;
            }
            i++;
        }
        return (tempScore*10) / students.size();
    }
    public double getOverallScore(String username){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return -1;
        }
        return curStudent.getOverallScore() * 100;
    }
    public double getOverallScoreAvg(){
        int i = 0;
        double tempOverall = 0;
        while(i < students.size()){
            tempOverall = students.get(i).getOverallScore() + tempOverall;
            i++;
            }

        return (int) (tempOverall*100) / students.size();
    }
    public boolean setScore(String username, String assignmentName, int pointsEarned) {
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        return curStudent != null && curStudent.setScore(assignmentName, pointsEarned);
    }
    public double getAssignmentScorePercent(String username, String assignmentName){
        //get the student specified by username
        Student curStudent = getCurrentStudent(username);
        //if no student return false
        if(curStudent == null){
            return -1;
        }
        if (curStudent.getPointsPossible(assignmentName) == -1){
            return -1;
        }
        return curStudent.getScore(assignmentName)/curStudent.getPointsPossible(assignmentName) * 100;
    }
    //returns -1 if no student was found with the given username
    //otherwise returns the index of the student with the matching username
    private int getStudentIndexByUsername(String username){
        int index = 0;
        while(index < students.size()){
            if(username.equalsIgnoreCase(students.get(index).getUsername())){
                return index;
            }
            index++;
        }
        return -1;
    }
    private Student getCurrentStudent(String username){
        int index = getStudentIndexByUsername(username);
        if(index == -1){
            return null;
        }
        return students.get(index);
    }
}
