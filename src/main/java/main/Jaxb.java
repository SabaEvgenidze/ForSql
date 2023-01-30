package main;

import jaxb.AuditoryJAXB;
import jaxb.CourseJAXB;
import jaxb.MentorJAXB;
import jaxb.StudentJAXB;
import org.apache.log4j.Logger;

public class Jaxb {
    private static final Logger LOGGER = Logger.getLogger(Jaxb.class);

    public static void main(String[] argv) {

        /////JAXB/////Java Architecture for XML Binding

        MentorJAXB mentorJAXB = new MentorJAXB();
        StudentJAXB studentJAXB = new StudentJAXB();
        CourseJAXB courseJAXB = new CourseJAXB();
        AuditoryJAXB auditoryJAXB = new AuditoryJAXB();

//        mentorJAXB.marshall();
//        System.out.println("----------------------------");
        mentorJAXB.unmarshall();
        System.out.println("----------------------------");

//        studentJAXB.marshall();
//        System.out.println("----------------------------");
        studentJAXB.unmarshall();
        System.out.println("----------------------------");


//        courseJAXB.marshall();
//        System.out.println("----------------------------");
        courseJAXB.unmarshall();
        System.out.println("----------------------------");

//        auditoryJAXB.marshall();
//        System.out.println("----------------------------");
        auditoryJAXB.unmarshall();
        System.out.println("----------------------------");

    }
}
