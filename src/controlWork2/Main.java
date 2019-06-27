package controlWork2;

import controlWork2.task1.SingletonService;
import controlWork2.task2.Player;
import controlWork2.task2.TestSingletonService;
import controlWork2.task4.domParser.DomParser;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();

//        app.test1();

//        app.test2();

//        app.test3();

        app.test4();

    }

    private void test1() {
        SingletonService singletonService = SingletonService.getInstance();
        String stringForArray = "In any programming language arrays are used that are convenient for working with a large number of the same type of data";
        singletonService.runCreateFileThreads( stringForArray, 4);
    }

    private void test2() {
        TestSingletonService testSingletonService = TestSingletonService.getInstance();
        List<String> stringFileNameList = testSingletonService.runPlayerGeneratorTask(2, 10, 20, 40);
        List<Player> playerList = testSingletonService.runPlayerReaderTask(2, stringFileNameList);
        for (Player player : playerList) {
            System.out.println(player.getName());
        }
    }

    private void test3() {
        try (
                InputStream xml = new FileInputStream("src/controlWork2/task3/PurchaseOrder.xml");
                InputStream xsd = new FileInputStream("src/controlWork2/task3/PurchaseOrder.xsd")
        ) {
            System.out.println("Validation xml against XSD:" + validateAgainstXSD(xml, xsd));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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

    private void test4() {
        DomParser domParser = new DomParser();
        System.out.println(domParser.parse());
    }
}
