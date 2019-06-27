package parsers.lesson21.src.com.gmail.aperavoznikau.sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class UserHandlerPractice extends DefaultHandler {

    private boolean bMarks = false;
    private Integer maxElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("marks")) {
            bMarks = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("marks")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (bMarks) {
            String value = new String(ch, start, length);
            System.out.println("Marks: " + value);
            if (maxElement != null) {
                maxElement = Math.max(maxElement, Integer.valueOf(value));
            } else {
                maxElement = Integer.valueOf(value);
            }

            bMarks = false;
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Max elemen:" + maxElement);
    }
}