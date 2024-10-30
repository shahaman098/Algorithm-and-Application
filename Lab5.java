import java.util.ArrayList;
import java.util.Random;

public class Lab5 {

    // Method to create an ArrayList of random integers
    public static ArrayList<Integer> RandomArray(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array.add(random.nextInt(256)); // Random integers between 0 and 255
        }
        return array;
    }

    // Method to display the contents of an ArrayList
    public static void ShowArray(ArrayList<Integer> array) {
        System.out.println(array);
    }

    // Method to measure the average runtime of a sorting method
    public static long measureSortTime(int arraySize, int repetitions, String sortType) {
        long totalTime = 0;

        for (int i = 0; i < repetitions; i++) {
            ArrayList<Integer> array = RandomArray(arraySize);

            long startTime = System.nanoTime();
            switch (sortType) {
                case "SortA":
                    ThreeSorts.SortA(new ArrayList<>(array));
                    break;
                case "SortB":
                    ThreeSorts.SortB(new ArrayList<>(array));
                    break;
                case "SortC":
                    ThreeSorts.SortC(new ArrayList<>(array));
                    break;
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / repetitions; // Return average time
    }

    public static void main(String[] args) {
        // Exercise 1: Testing RandomArray and ShowArray methods
        ArrayList<Integer> randomList = RandomArray(10); // Generate a random list of 10 elements
        System.out.println("Random List:");
        ShowArray(randomList); // Display the generated list

        // Step 2: Verify sorting methods from ThreeSorts on a small random array
        System.out.println("\nTesting Sorting Methods with a Random Array:");

        ArrayList<Integer> sortedA = ThreeSorts.SortA(new ArrayList<>(randomList));
        System.out.println("Sorted with SortA:");
        ShowArray(sortedA);

        ArrayList<Integer> sortedB = ThreeSorts.SortB(new ArrayList<>(randomList));
        System.out.println("Sorted with SortB:");
        ShowArray(sortedB);

        ArrayList<Integer> sortedC = ThreeSorts.SortC(new ArrayList<>(randomList));
        System.out.println("Sorted with SortC:");
        ShowArray(sortedC);

        // Exercise 2: Experimental Analysis
        int[] arraySizes = {1000, 5000, 10000, 15000, 20000, 25000}; // Different array sizes
        int repetitions = 10; // Number of times to run each sort for averaging

        System.out.println("\nPerformance Analysis:");
        for (int size : arraySizes) {
            System.out.println("Array Size: " + size);

            long averageTimeA = measureSortTime(size, repetitions, "SortA");
            System.out.println("Average Time for SortA: " + averageTimeA + " ns");

            long averageTimeB = measureSortTime(size, repetitions, "SortB");
            System.out.println("Average Time for SortB: " + averageTimeB + " ns");

            long averageTimeC = measureSortTime(size, repetitions, "SortC");
            System.out.println("Average Time for SortC: " + averageTimeC + " ns");

            System.out.println(); // Blank line for readability
        }
    }
}
