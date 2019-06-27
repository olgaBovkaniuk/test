package controlWork2.task4.domParser;

import controlWork2.task4.ParserInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser implements ParserInterface {
    @Override
    public String parse() {
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        try {
            File inputFile = new File("src/controlWork2/task3/PurchaseOrder.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    stringBuilder.append(" Product Name : "
                            + eElement
                            .getElementsByTagName("ProductName")
                            .item(0)
                            .getTextContent());
                    stringBuilder.append(" US Price : "
                            + eElement
                            .getElementsByTagName("USPrice")
                            .item(0)
                            .getTextContent());
                    sum += Integer.valueOf(eElement
                            .getElementsByTagName("USPrice")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

