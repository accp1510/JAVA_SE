package javaapp13;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Губин_Н on 16.05.2016.
 */
public class CurDOMParser {

    List list = new ArrayList();

    public void parse(Element rootElement) {
        NodeList currencies = rootElement.getElementsByTagName("CURRENCY");
        for (int i = 0; i < currencies.getLength(); i++) {
            Node c = currencies.item(i);
            parseCurrency(c);
        }

    }

    private void parseCurrency(Node cur) {
        NamedNodeMap att = cur.getAttributes();
        String curName = null;
        for (int i = 0; i < att.getLength(); i++) {
            Node a = att.item(i);
            if (a.getNodeName().equals("CurrencyName")) {
                curName = a.getTextContent();
                break;
            }
        }
        NodeList settles = cur.getChildNodes();
        for (int i = 0; i < settles.getLength(); i++) {
            Node settle = settles.item(i);
            parseSettle(settle, curName);
        }


    }

    private void parseSettle(Node settle, String curName) {
        if (!settle.getNodeName().equals("#text")) {
            NamedNodeMap att = settle.getAttributes();
            String price = null;
            String date = null;
            for (int i = 0; i < att.getLength(); i++) {
                Node a = att.item(i);
                if (a.getNodeName().equals("SettleDate")) {
                    date = a.getTextContent();
                }
                if (a.getNodeName().equals("Price")) {
                    price = a.getTextContent();
                }
            }
            double p = 0;
            if (price != null) {
                p = Double.parseDouble(price);
            }
            Currency currency = new Currency(curName, date, p);
            list.add(currency);
        }
    }
}
