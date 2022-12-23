package org.example.collections;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Products {
    private static void display(LinkedHashMap<String, String> lhm) {
        Set set = lhm.entrySet();

        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry entry = (Map.Entry)i.next();
            System.out.print(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> products = Files.readAllLines(Paths.get(CollectionsUsage.class.getResource("/products-input.txt").toURI()));

        LinkedHashMap<String, String> codToProductMap = new LinkedHashMap<>();

        for (String product : products) {
            String[] productElements = product.split("\\|");

            codToProductMap.put(productElements[0], productElements[1]);
        }

        display(codToProductMap);
        System.out.println("");

        List<String> listKeys = new ArrayList<>(codToProductMap.keySet());
        String lastAddedKey = null;
        if(listKeys.size() > 0 ) {
            lastAddedKey = listKeys.get( listKeys.size() - 1 );
        }

        codToProductMap.put(lastAddedKey, "Pepsi-Cola");
        display(codToProductMap);

        try {
            FileWriter myWriter = new FileWriter("./src/main/resources/products-output.txt");

            Set set = codToProductMap.entrySet();

            Iterator i = set.iterator();

            while(i.hasNext()) {
                Map.Entry entry = (Map.Entry)i.next();
                myWriter.write(entry.getKey() + ": " + entry.getValue());
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
