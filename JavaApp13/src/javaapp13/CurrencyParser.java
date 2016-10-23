package javaapp13;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class CurrencyParser extends DefaultHandler {

    List list = new ArrayList();
    Currency currency = null;
    String seeElement;
    String nameCurrency;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        seeElement = qName;
        if (qName.equals("CURRENCY")) {
            nameCurrency = attributes.getValue("CurrencyName");
        }
        if (qName.equals("SETTLEDATE")) {
            currency = new Currency();
            currency.setName(nameCurrency);
            String price = attributes.getValue("Price");
            String date = attributes.getValue("SettleDate");
            currency.setDate(date);
            if (price==null) {
                currency.setPrice(0);
            } else {
                currency.setPrice(Double.parseDouble(price));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        seeElement = "";
        if (qName.equals("SETTLEDATE")) {
            list.add(currency);
            currency = null;
        }
    }

}
