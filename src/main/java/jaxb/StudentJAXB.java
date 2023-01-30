package jaxb;

import models.Student;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class StudentJAXB {
    private static final Logger LOGGER  =Logger.getLogger(StudentJAXB.class);
    File file = new File("C:\\Java\\ForSql\\src\\main\\resources\\xml\\MarshallStudent.xml");

    public void marshall(){
        Student student = new Student(1L, 2L, 3L, "Saba", "Evgenidze", "Male", 22);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(student, System.out);
            marshaller.marshal(student,file);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    public void unmarshall(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
            Student student = (Student) unmarshaller.unmarshal(file);
            LOGGER.info("Information abut Student: ");
            LOGGER.info("StudentId: " + student.getIdStudent());
            LOGGER.info("UniversityId: " + student.getIdUniversity());
            LOGGER.info("FacultyId: " + student.getIdFaculty());
            LOGGER.info("Name: " + student.getName());
            LOGGER.info("Surname: " + student.getSurname());
            LOGGER.info("Gender: " + student.getGender());
            LOGGER.info("Age: " + student.getAge());
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

}
