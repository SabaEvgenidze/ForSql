package jaxb;

import models.Auditory;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AuditoryJAXB {
    private static final Logger LOGGER = Logger.getLogger(AuditoryJAXB.class);
    File file = new File("C:\\Java\\ForSql\\src\\main\\resources\\xml\\MarshallAuditory.xml");

    public void marshall() {
        Auditory auditory = new Auditory(1L, 1L, 100);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Auditory.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(auditory, System.out);
            marshaller.marshal(auditory, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void unmarshall() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Auditory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Auditory auditory = (Auditory) unmarshaller.unmarshal(file);
            LOGGER.info("information about Auditory");
            LOGGER.info("AuditoryId: " + auditory.getIdAuditory());
            LOGGER.info("UniversityId: " + auditory.getIdUniversity());
            LOGGER.info("Capacity: " + auditory.getCapacity());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
