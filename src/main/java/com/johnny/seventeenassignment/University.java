package com.johnny.seventeenassignment;

public class University {
    public static void main(String[] args) {
        // These throw an exception due to blank name or -age
//        LecturerRecord joe = new LecturerRecord("", 22, new BusinessFaculty(), new SocialCareDept());
//        LecturerRecord joe = new LecturerRecord("Joe Bloggs", -3, new BusinessFaculty(), new SocialCareDept());

        LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, new BusinessFaculty(), new SocialCareDept());
        System.out.println(jane);
        System.out.println("Name is " + jane.name());
        System.out.println("Age is " + jane.age());
        System.out.println("Faculty is " + jane.faculty());
        System.out.println("Department is " + jane.dept());
        jane.whichFaculty();
        jane.whichDept();
        System.out.println(jane.hasPhd());
        System.out.println();

        LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 35, new BusinessFaculty(), new AccountingDept());
        System.out.println(anne);
        System.out.println(anne.hasPhd());
        String s = anne.hasPhd() ? "Anne has a PhD" : "Anne does not have an PhD";
        System.out.println(s);
        System.out.println(anne.hasPhd() ? "Anne has a PhD" : "Anne does not have a PhD");
        System.out.println();

        LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, new HumanitiesFaculty(), new SocialCareDept());
        System.out.println(joe);
        System.out.println(joe.hasPhd() ? "Joe has a PhD" : "Joe does not have a PhD");

    }
}
