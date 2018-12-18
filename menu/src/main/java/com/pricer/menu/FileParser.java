package com.pricer.menu;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manages parsing files into Java objects.
 */
public class FileParser {

    /**
     * This method converts xml file into Java objects.
     *
     * @param filepath Path of the xml file.
     * @return A menu object that represents the xml data.
     */
    public static Menu xmlParser(String filepath) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the xml file and return an instance of Document.
            Document document = builder.parse(new File(filepath));
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            Menu menu = new Menu();
            BreakfastMenu breakfastMenu = new BreakfastMenu();
            List<Food> foodList = new ArrayList<Food>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    Food food = new Food();

                    // Get the value of all sub-elements.
                    String name = elem.getElementsByTagName("name")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    String price = elem.getElementsByTagName("price")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    String description = elem.getElementsByTagName("description")
                            .item(0).getChildNodes().item(0).getNodeValue();
                    short calories = Short.parseShort(elem.getElementsByTagName("calories")
                            .item(0).getChildNodes().item(0).getNodeValue());


                    food.setName(name);
                    food.setPrice(price);
                    food.setDescription(description);
                    food.setCalories(calories);
                    foodList.add(food);
                }
            }

            breakfastMenu.setFood(foodList);
            menu.setBreakfastMenu(breakfastMenu);

            return menu;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * This method converts json file into Java objects.
     *
     * @param filepath Path of the json file.
     * @return A menu object that represents the json data.
     */
    public static Menu jsonParser(String filepath) {

        try {
            Reader reader = new FileReader(filepath);
            Gson gson = new Gson();
            Menu menu = gson.fromJson(reader, Menu.class);
            return menu;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
