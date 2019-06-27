package controlWork2.task4;

import controlWork2.task4.domParser.DomParser;

public class ParserFactory {
    public ParserInterface getParser(ParserEnum parserEnum) {
        switch (parserEnum) {
            case DOM:
                return new DomParser();
            case SAX:
            case JAXB:
        }
        throw new RuntimeException("Not supported value of enum:" + parserEnum);
    }
}