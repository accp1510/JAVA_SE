package javaapp12;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOMParser {

    private Document document;
    private Element rootElement;

    public void createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.newDocument();
        rootElement = document.createElement("cars");
        document.appendChild(rootElement);
    }

    public void createDocument(String fileName)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File(fileName));
        rootElement = document.getDocumentElement();
    }

    public void printDocument() {
        System.out.println(rootElement.getNodeName());
        NodeList list = rootElement.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            String s = n.getNodeName();
            if (!s.equals("#text")) {
                System.out.println("\t" + s);
                NodeList carsChild = n.getChildNodes();
                for (int j = 0; j < carsChild.getLength(); j++) {
                    Node c = carsChild.item(j);
                    s = c.getNodeName();
                    if (!s.equals("#text")) {
                        if (!c.getNodeName().equals("cats")) {
                            s += " " + c.getTextContent();
                            System.out.println("\t\t" + s);
                        } else {
                            System.out.println("\t\t" + s);

                            NodeList catsChild = c.getChildNodes();
                            for (int k = 0; k < catsChild.getLength(); k++) {
                                Node catNode = catsChild.item(k);
                                if (!catNode.getNodeName().equals("#text")) {
                                    s = catNode.getNodeName() + " " + catNode.getTextContent();
                                    NamedNodeMap map = catNode.getAttributes();
                                    for (int l = 0; l < map.getLength(); l++) {
                                        Node att = map.item(l);
                                        if (!att.getNodeName().equals("#text")) {
                                            s += " " + att.getTextContent();
                                        }
                                    }
                                    System.out.println("\t\t\t" + s);
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public void addCar(Car car) {
        //создание узла (тега)
        Element node = document.createElement("car");

        Element makeNode = document.createElement("make");
        Element modelNode = document.createElement("model");
        Element catsNode = document.createElement("cats");

        //добавление в узел makeNode данные
        makeNode.setTextContent(car.getMake());
        modelNode.setTextContent(car.getModel());

        //вложение в тег <car> тег <make>
        node.appendChild(makeNode);
        //вложение в тег <car> тег <model>
        node.appendChild(modelNode);
        //вложение в тег <car> тег <model>
        node.appendChild(catsNode);

        //вложение в тег <cars> тег <car>
        rootElement.appendChild(node);

    }

    public void addCat(Cat cat, String make) {
        //поиск тега
        NodeList list = rootElement.getElementsByTagName("car");
        Node findCats = null;
        for (int i = 0; i < list.getLength(); i++) {
            Node car = list.item(i);
            NodeList carChild = car.getChildNodes();

            boolean findCar = false;

            for (int j = 0; j < carChild.getLength(); j++) {
                Node n = carChild.item(j);
                if (n.getNodeName().equals("cats")) {
                    findCats = n;
                }
                if (n.getNodeName().equals("make")
                        && n.getTextContent().equals(make)) {
                    findCar = true;

                }
            }
            if (findCar && findCats != null) {
                break;
            } else {
                findCats = null;
                findCar = false;
            }
        }
        if (findCats != null) {
            Element catNode = document.createElement("cat");
            catNode.setTextContent(cat.getName());
            if (cat.isDrive()) {
                catNode.setAttribute("place", "Водитель");
            }
            findCats.appendChild(catNode);
        }

    }

    public void saveDocument(String fileName) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();

        Source s = new DOMSource(document);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(s, result);

    }
}
