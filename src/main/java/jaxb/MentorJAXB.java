package jaxb;

import models.Mentor;
import org.apache.log4j.Logger;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class MentorJAXB {
    private static final Logger LOGGER = Logger.getLogger(MentorJAXB.class);

    File file = new File("C:\\Java\\ForSql\\src\\main\\resources\\xml\\MarshallMentor.xml");

    public MentorJAXB(){}

    public void marshall() {
        try {
            Mentor mentor = new Mentor(1L, 2L, "George", "Jackson", "male", 22);
            JAXBContext jaxbContext = JAXBContext.newInstance(Mentor.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(mentor, System.out);
            marshaller.marshal(mentor, file);
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }

    public void unmarshall() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Mentor.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Mentor mentor = (Mentor) unmarshaller.unmarshal(file);
            LOGGER.info("info about mentor");
            LOGGER.info("MentorId: "+ mentor.getIdMentor());
            LOGGER.info("Name: " + mentor.getName());
            LOGGER.info("Surname: " + mentor.getSurname());
            LOGGER.info("Age: " + mentor.getAge());
            LOGGER.info("Gender: " + mentor.getGender());
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }
}
