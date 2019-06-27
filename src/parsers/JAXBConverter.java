package parsers;

import parsers.Catalog;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBConverter {

    public void unmarshall() {
        try {
            File file = new File("catalog.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Catalog catalog = (Catalog) jaxbUnmarshaller.unmarshal(file);
            System.out.println(catalog);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
