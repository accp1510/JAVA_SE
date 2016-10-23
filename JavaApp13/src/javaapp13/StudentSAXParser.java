package javaapp13;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentSAXParser extends DefaultHandler {

    public List list = new ArrayList();
    public String groupName;
    public Student student;
    public String seeElement;

    //метод вызывается при начале считывания XML
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало парсинга");
    }

    //метод вызывается при завершении считывания XML
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец считывания");
    }

    //метод вызывается при прочтении открывающего тега
    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        System.out.println("uri " + uri + " localName " + localName + " qName " + qName);
        if (attributes.getLength() > 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("att name " + attributes.getLocalName(i)
                        + " value " + attributes.getValue(i));
            }
        }

        seeElement = qName;
        if (qName.equals("group")) {
            groupName = attributes.getValue("name");
        }
        if (qName.equals("student")) {
            student = new Student();
            String str = attributes.getValue("id");
            int id = 0;
            if (str != null)
                id = Integer.parseInt(str);
            student.setId(id);
            student.setGroupName(groupName);
        }
    }

    //метод вызывается при прочтении данных
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (!str.trim().equals(""))
            System.out.println(str);
        if (seeElement.equals("firstname"))
            student.setFirstName(str);
        if (seeElement.equals("lastname"))
            student.setLastName(str);
    }

    //метод вызывается при прочтении закрывающего тега
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("</" + qName + ">");
        if (qName.equals("student")) {
            list.add(student);
            student = null;
        }
        seeElement = "";
    }
}
