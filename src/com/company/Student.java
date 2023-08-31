package com.company;

import java.util.ArrayList;


public class Student {
    private String firstName;
    private String lastName;
    private String username;
    private long phoneNumber;
    private ArrayList<Assignment> assignments;
    private int daysAbsent;
    private int daysTardy;

    public Student(String firstName, String lastName, String username, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
        assignments = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }
    public void markTardy(){
        daysTardy++;
    }
    public void markAbsent(){
        daysAbsent++;
    }
    public int getTardyCount(){
        return daysTardy;
    }
    public int getAbsentCount(){
        return daysAbsent;
    }
    public boolean addAssignment(int pointsPossible, int pointsEarned, String assignmentName){
        int index = 0;
        while(index < assignments.size()){
            if(assignmentName.equalsIgnoreCase(assignments.get(index).getAssignmentName())){
                return false;
            }
            index++;
        }
        assignments.add(new Assignment(pointsPossible, pointsEarned, assignmentName));
        return true;
    }
    public boolean setScore(String assignmentName, int pointsEarned){
        //get the assignment specified by name
        Assignment curAssignment = getCurrentAssignment(assignmentName);
        //if no student return false
        if(curAssignment == null){
            return false;
        }
        int i = getAssignmentIndexByAssignmentName(assignmentName);
        assignments.get(i).setScore(pointsEarned);
        return true;
    }
    public int getScore(String assignmentName){
        //get the assignment specified by name
        Assignment curAssignment = getCurrentAssignment(assignmentName);
        //if no assignment return false
        if(curAssignment == null){
            return -1;
        }
        int i = getAssignmentIndexByAssignmentName(assignmentName);
        return assignments.get(i).getScore();
    }
    public double getOverallScore(){
        int index = 0;
        double tempAssignment = 0;
        double tempPointsPossible = 0;
        while(index < assignments.size()){
            tempAssignment = assignments.get(index).getScore() + tempAssignment;
            tempPointsPossible = assignments.get(index).getPointsPossible() + tempPointsPossible;
            index++;
        }
        if (tempPointsPossible == 0){
            return -1;
        }
        return tempAssignment / tempPointsPossible;
    }

    public int getPointsPossible(String assignmentName){
        //get the assignment specified by name
        Assignment curAssignment = getCurrentAssignment(assignmentName);
        //if no assignment return false
        if(curAssignment == null){
            return -1;
        }
        int i = getAssignmentIndexByAssignmentName(assignmentName);
        return assignments.get(i).getPointsPossible();
    }
    private int getAssignmentIndexByAssignmentName(String assignmentName){
        int index = 0;
        while(index < assignments.size()){
            if(assignmentName.equalsIgnoreCase(assignments.get(index).getAssignmentName())){
                return index;
            }
            index++;
        }
        return -1;
    }
    private Assignment getCurrentAssignment(String assignmentName){
        int index = getAssignmentIndexByAssignmentName(assignmentName);
        if(index == -1){
            return null;
        }
        return assignments.get(index);
    }
}
