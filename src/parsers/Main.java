package parsers;

import parsers.JAXBConverter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Main {

    public static void main(String[] args) {
        try (
                InputStream xml = new FileInputStream("catalog.xml");
                InputStream xsd = new FileInputStream("catalog.xsd")
        ) {
            System.out.println("Validation xml against XSD:" + validateAgainstXSD(xml, xsd));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        JAXBConverter jaxbConverter = new JAXBConverter();
        jaxbConverter.unmarshall();
    }

    private static boolean validateAgainstXSD(InputStream xml, InputStream xsd) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
