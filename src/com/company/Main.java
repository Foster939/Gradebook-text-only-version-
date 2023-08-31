package com.company;

import java.util.Scanner;

public class Main {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
	    //set up optionsArray
        String[] options = new String [14];
        options[0] = "change section";
        options[1] = "add section";
        options[2] = "add student";
        options[3] = "add assignment to student";
        options[4] = "add assignment to section";
        options[5] = "set score";
        options[6] = "mark tardy";
        options[7] = "mark absent";
        options[8] = "get overall score";
        options[9] = "get overall score avg";
        options[10] = "get assignment score";
        options[11] = "get assignment score avg";
        options[12] = "get tardy count";
        options[13] = "get absent count";


        //main loop to get input:
        while(true){
            //print options
            System.out.println("Type one of the following commands:");
            for(int i=0; i<options.length;i++){
                System.out.println(options[i]);
            }
            String input = console.nextLine();
            //find out which option the selected
            int optionSelectIndex;
            for(optionSelectIndex=0; optionSelectIndex<options.length;optionSelectIndex++){
                if (options[optionSelectIndex].equalsIgnoreCase(input)){
                    break;
                }
            }

            boolean retBool =false;
            double retDouble =-1;
            if(optionSelectIndex == 0){
                System.out.println("Enter a section name");
                String sectionName= console.nextLine();
                retBool=gradebook.changeSection(sectionName);
            }
            else if(optionSelectIndex == 1){
                System.out.println("Enter a section name");
                String sectionName= console.nextLine();
                retBool=gradebook.addSection(sectionName);
            }
            else if(optionSelectIndex == 2){
                System.out.println("Enter student first name:");
                String firstName= console.nextLine();
                System.out.println("Enter student last name:");
                String lastName= console.nextLine();
                System.out.println("Enter student username:");
                String userName= console.nextLine();
                long phoneNumber= getPhoneNumber();
                retBool=gradebook.addStudent(firstName,lastName,userName,phoneNumber);
            }
            else if(optionSelectIndex == 3){
                System.out.println("Enter student username:");
                String userName= console.nextLine();
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                int ptsPossible = getUInt();
                retBool=gradebook.addAssignmentToStudent(userName,assignmentName,ptsPossible);
            }
            else if(optionSelectIndex == 4){
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                int ptsPossible = getUInt();
                retBool=gradebook.addAssignmentToSection(assignmentName,ptsPossible);
            }
            else if(optionSelectIndex == 5){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                int ptsEarned = getUInt();
                retBool=gradebook.setScore(userName,assignmentName,ptsEarned);
            }
            else if(optionSelectIndex == 6){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retBool=gradebook.markTardy(userName);
            }
            else if(optionSelectIndex == 7){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retBool=gradebook.markAbsent(userName);
            }
            else if(optionSelectIndex == 8){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retDouble=gradebook.getOverallScore(userName);
            }
            else if(optionSelectIndex == 9){
                retDouble=gradebook.getOverallScoreAvg();
            }
            else if(optionSelectIndex == 10){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                retDouble=gradebook.getAssignmentScorePercent(userName,assignmentName);
            }
            else if(optionSelectIndex == 11){
                System.out.println("Enter assignment name:");
                String assignmentName = console.nextLine();
                retDouble=gradebook.getAssignmentScoreAvg(assignmentName);
            }
            else if(optionSelectIndex == 12){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retDouble=gradebook.getTardyCount(userName);
            }
            else if(optionSelectIndex == 13){
                System.out.println("Enter student username:");
                String userName = console.nextLine();
                retDouble=gradebook.getAbsentCount(userName);
            }
            else{
                System.out.println("not a valid option");
                continue;
            }
            if(retBool){
                System.out.println("action completed successfully");
            }
            else if (retDouble != -1){
                System.out.println("Result from command: " + retDouble);
            }
            else{
                System.out.println("There was an error with the command, operation not completed");
            }
        }

    }
    static long getPhoneNumber(){
        while(true){
            try{
                System.out.println("enter a phone number including area code as a 10 digit number");
                long phoneNumber = Long.parseLong(console.nextLine());
                if(phoneNumber<1000000000L || phoneNumber>9999999999L){
                    System.out.println("not a valid phone number enter a number including area code without space or - etc");
                    continue;
                }
                return phoneNumber;
            }catch(NumberFormatException ex){
                System.out.println("not an integer");
            }
        }
    }
    static int getUInt(){
        while(true){
            try{
                System.out.println("Enter amount of points");
                int number = Integer.parseInt(console.nextLine());
                if(number<0){
                    System.out.println("not a positive integer");
                    continue;
                }
                return number;
            }catch(NumberFormatException ex){
                System.out.println("not an integer");
            }
        }
    }
}
