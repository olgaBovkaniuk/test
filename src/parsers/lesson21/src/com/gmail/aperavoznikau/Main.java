package parsers.lesson21.src.com.gmail.aperavoznikau;

import parsers.lesson21.src.com.gmail.aperavoznikau.dom.DomParserDemo;
import parsers.lesson21.src.com.gmail.aperavoznikau.jaxb.JAXBConverter;
import parsers.lesson21.src.com.gmail.aperavoznikau.sax.SaxParserDemo;
import parsers.lesson21.src.com.gmail.aperavoznikau.stax.StAXParserDemo;
import parsers.lesson21.src.com.gmail.aperavoznikau.jaxb.JAXBConverter;

public class Main {

    public static void main(String[] args) {
/*        DomParserDemo domParserDemo = new DomParserDemo();
        domParserDemo.domParser();

        SaxParserDemo saxParserDemo = new SaxParserDemo();
        saxParserDemo.saxParser();

        StAXParserDemo stAXParserDemo = new StAXParserDemo();
        stAXParserDemo.staxParser();*/

        JAXBConverter jaxbConverter = new JAXBConverter();
        //jaxbConverter.marshall();
        jaxbConverter.unmarshall();
    }
}
