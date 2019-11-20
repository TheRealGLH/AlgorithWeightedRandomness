public class MyRandom {

    public static Object weightedRandom(Object[] items, int[] weight) {
        if (items.length != weight.length) {
            throw new IllegalArgumentException("Items length " + items.length + " and weight length " + weight.length + " did not match");
        }

        //Som van alle weights
        int totalWeight = 0;
        for (int i = 0; i < items.length; i++) {
            totalWeight += weight[i];
        }

        //Now choose a random item
        int randomIndex = -1;//De gekozen index
        double random = Math.random() * totalWeight;//Onze random waarde in een double tussen de 0 en de 1, vermenigvuldigd met de som

        //Nu loopen we door alle items
        for (int i = 0; i < items.length; ++i) {
            //Nu trekken we het gewicht van dit item van onze random waarde af
            random -= weight[i];

            //als we al onder de 0 zitten, dan nemen we het huidige gewicht en item als ons ding.

            //Omdat de totale waarde waar we het van af moeten trekken random is, is de kans dus groter dat er een item met een grote weight gekozen wordt
            if (random <= 0) {
                randomIndex = i;
                break;
            }
        }
        System.out.println("The weight was "+weight[randomIndex]+" with index: "+randomIndex);
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
