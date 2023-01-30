package jaxb;

import models.Course;
import org.apache.log4j.Logger;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class CourseJAXB {
    private static final Logger LOGGER = Logger.getLogger(CourseJAXB.class);

    File file = new File("C:\\Java\\ForSql\\src\\main\\resources\\xml\\MarshallCourse.xml");

    public void marshall() {
        Course course = new Course(1L, "Math", 2);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(course, System.out);
            marshaller.marshal(course, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unmarshall() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Course course = (Course) unmarshaller.unmarshal(file);
            LOGGER.info("Information about Course");
            LOGGER.info("CourseId: " + course.getIdCourse());
            LOGGER.info("Name: " + course.getName());
            LOGGER.info("Course: " + course.getCourse());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
