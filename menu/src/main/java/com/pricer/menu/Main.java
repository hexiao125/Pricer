package com.pricer.menu;

import org.apache.commons.io.FilenameUtils;

/**
 * This program implements an application that parses xml or json file and
 * sorts the food in the breakfast menu according to the food name and prints
 * the data to console.
 */
public class Main {

    public static void main(String[] args) {

        if (args.length != 2)
            throw new RuntimeException("File name and sort order are required!");

        String ext = FilenameUtils.getExtension(args[0]);

        if (!ext.equals("xml") && !ext.equals("json"))
            throw new RuntimeException("File type not supported!");

        if (!args[1].equals("asc") && !args[1].equals("desc"))
            throw new RuntimeException("Invalid sort order!");

        // Parsing file according to the file type.
        Menu menu = new Menu();
        if (ext.equals("xml")) {
            menu = FileParser.xmlParser(args[0]);
        } else { // ext.equals("json")
            menu = FileParser.jsonParser(args[0]);
        }

        // Sort menu according to food name.
        menu.sort(args[1]);
        System.out.println(menu.toString());

    }
}
