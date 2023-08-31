package com.company;

/**

 */
public class Assignment {
    private int pointsPossible;
    private int pointsEarned;
    private String assignmentName;

    public Assignment(int pointsPossible, int pointsEarned, String assignmentName) {
        this.pointsPossible = pointsPossible;
        this.pointsEarned = pointsEarned;
        this.assignmentName = assignmentName;
    }
    public String getAssignmentName() {
        return assignmentName;
    }
    public void setScore(int pointsEarned){
        this.pointsEarned = pointsEarned;
    }
    public int getScore(){
        return pointsEarned;
    }
    public int getPointsPossible(){
        return pointsPossible;
    }
}
