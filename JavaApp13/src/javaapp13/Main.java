package javaapp13;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        StudentSAXParser studentSAXParser = new StudentSAXParser();

        parser.parse(new File("test.xml"), studentSAXParser);

        List list = studentSAXParser.list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        long start = System.nanoTime();
        CurrencyParser currencyParser = new CurrencyParser();
        parser.parse(new File("test2.xml"), currencyParser);
        List currencies = currencyParser.list;
        long end = System.nanoTime();

        System.out.println("t = " + (end - start));


        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory1.newDocumentBuilder();


        start = System.nanoTime();
        Document document = builder.parse(new File("test2.xml"));
        CurDOMParser curDOMParser = new CurDOMParser();
        curDOMParser.parse(document.getDocumentElement());
        end = System.nanoTime();
        System.out.println("t = " + (end - start));

//        it = currencies.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

    }
}
