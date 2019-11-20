import java.util.Random;

public class main {


    public static void main(String[] args) {
        final int amountOfItems = 10;
        final int minWeight = 5;
        final int maxWeight = 20;
        Item[] items = new Item[amountOfItems];
        int[] weight = new int[amountOfItems];
        Random r = new Random();
        for (int i = 0; i < amountOfItems; i++) {
            items[i] = new Item("Nr: " + i);
            weight[i] = r.nextInt((maxWeight - minWeight) + 1) + minWeight;
        }
        System.out.println("Items:");
        System.out.println(MyRandom.arrayToString(items));
        System.out.println("Weights:");
        System.out.println(MyRandom.arrayToString(weight));
        System.out.println(MyRandom.weightedRandom(items, weight));
        System.out.println(MyRandom.weightedRandom(items, weight));
        System.out.println(MyRandom.weightedRandom(items, weight));
        System.out.println(MyRandom.weightedRandom(items, weight));
        System.out.println(MyRandom.weightedRandom(items, weight));
    }


}
