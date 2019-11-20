import java.io.*;

public class MyRandom {


    public static Object weightedRandom(Object[] items, int[] weight, boolean logToFile) {
        if (items.length != weight.length) {
            throw new IllegalArgumentException("Items length " + items.length + " and weight length " + weight.length + " did not match");
        }

        int total = 0;
        int n = weight.length; //the value of n for the Big O notation.

        //Som van alle weights
        int totalWeight = 0;
        for (int i = 0; i < n; i++) {
            totalWeight += weight[i];
            total++;// this loop is O(n), so for every loop we add to the total. adding a total of n
        }

        int randomIndex = -1;//De gekozen index
        //Onze random waarde in een double tussen de 0 en de 1, vermenigvuldigd met de som
        double random = Math.random() * totalWeight;
        total *= 1;//O(1)

        //Nu loopen we door alle items
        for (int i = 0; i < n; ++i) {
            total++;// this loop is O(n), so for every loop we add to the total. adding a total of n
            //Nu trekken we het gewicht van dit item van onze random waarde af
            random -= weight[i];
            total *= 1;//O(1)

            //als we al onder de 0 zitten, dan nemen we het huidige gewicht en item als ons ding.

            //Omdat de totale waarde waar we het van af moeten trekken random is, is de kans dus groter dat er een item met een grote weight gekozen wordt

            total *= 1;//O(1)
            if (random <= 0) {
                randomIndex = i;
                break;
            }
        }

        boolean isN2 = (total / n == 2);
        System.out.println("Total: "+total);
        System.out.println("n: "+n);
        System.out.println("Is O(n*2): " + isN2);
        System.out.println("The weight was " + weight[randomIndex] + " with index: " + randomIndex);

        if(logToFile) {
            PrintWriter writer = null;
            try {
                FileWriter fw = new FileWriter("log.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                writer = new PrintWriter(bw);
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.println(n+","+total+","+isN2);
            writer.close();
        }
        return items[randomIndex];
    }


    public static String arrayToString(Object[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < array.length; i++) {
            if (i != 0) sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < array.length; i++) {
            if (i != 0) sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("}");
        return sb.toString();
    }


}
