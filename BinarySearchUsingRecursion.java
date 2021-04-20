import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(9);
        integers.add(8);
        integers.add(-6);
        integers.add(5);
        integers.add(-4);
        integers.add(0);
        Collections.sort(integers);
        System.out.println(binarySearchUsingRecursion(5, 0, integers.size() - 1, integers));
    }

    public static boolean findNumber(int number, List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            if (number == integers.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean findNumberUsingBinarySearch(int number, List<Integer> integers) {
        int left = 0;
        int right = integers.size() - 1;
        do {
            int mid = (left + right) / 2;
            if (number == integers.get(mid)) {
                return true;
            } else if (number < integers.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } while (left <= right);
        return false;
    }

    //Xay dung tim kiem nhi phan su dung de quy
    public static boolean binarySearchUsingRecursion(int number, int left, int right, List<Integer> integers) {
        int mid = (left + right) / 2;
        if (left > right) {
            return false;
        }
        if (number == integers.get(mid)) {
            return true;
        }
        if (number < integers.get(mid)) {
            return binarySearchUsingRecursion(number, left, mid - 1, integers);
        } else {
            return binarySearchUsingRecursion(number, mid + 1, right, integers);
        }
    }
}