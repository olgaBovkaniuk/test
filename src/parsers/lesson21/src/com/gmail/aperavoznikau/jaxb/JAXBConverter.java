package parsers.lesson21.src.com.gmail.aperavoznikau.jaxb;

import parsers.lesson21.src.com.gmail.aperavoznikau.jaxb.Customer;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBConverter {


    public void marshall() {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("test");
        customer.setAge(29);
        try {
            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unmarshall() {
        try {
            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }

    }
}
