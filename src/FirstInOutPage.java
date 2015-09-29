import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sdcxv on 2015/9/29.
 */
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FirstInOutPage {
    public static void main(String[] args) {
        int max_cache_size = 2;
        int[] page_requests = {1, 2, 1, 3, 1, 2};
        countCacheMiss(max_cache_size, page_requests);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int countCacheMiss(int max_cache_size, int[] page_requests) {
        // INSERT YOUR CODE HERE
        int misses = 0;
        List<Integer> bufferList = new ArrayList<>();
        for (int i = 0; i < page_requests.length; i++) {
            if (bufferList.size() < max_cache_size) {//cache isn't full
                bufferList.add(page_requests[i]);
                for (int k = 0; k < bufferList.size() - 1; k++) {
                    System.out.print(bufferList.get(k) + ",");
                }
                System.out.println(bufferList.get(bufferList.size() - 1));
                misses++;
            } else {//cache is full
                int marker = 0;
                for (int j = 0; j < bufferList.size(); j++) {
                    if (page_requests[i] == bufferList.get(j)) {//find in cache,just print
                        for (int k = 0; k < bufferList.size() - 1; k++) {
                            System.out.print(bufferList.get(k) + ",");
                        }
                        System.out.println(bufferList.get(bufferList.size() - 1));
                        marker = 1;
                    }
                }
                if (marker == 0) {
                    bufferList.remove(0);//first out
                    bufferList.add(page_requests[i]);//last in
                    misses++;//misses
                    for (int k = 0; k < bufferList.size() - 1; k++) {//print
                        System.out.print(bufferList.get(k) + ",");
                    }
                    System.out.println(bufferList.get(bufferList.size() - 1));
                }
            }
        }

        System.out.println();
        System.out.println("cache misses:" + misses);
        return 0;
    }
    // METHOD SIGNATURE ENDS
}
