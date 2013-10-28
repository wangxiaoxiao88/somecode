
public class BinarySearchTest {

    //最简单的二分查找
    public static int binarySearch(int[] nums, int key, int begin, int end) {

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] == key) return middle;
            else if (nums[middle] < key) begin = middle + 1;
            else end = middle - 1;
        }

        return -1;
    }

    //找到第一个等于key的
    public static int searchFirstEqual(int[] nums, int key, int begin, int end) {

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] >= key) end = middle - 1;
            else begin = middle + 1;
        }

        if (nums[begin] == key) {
            return begin;
        }

        return -1;
    }

    //找到最后一个等于key的
    public static int searchLastEqual(int[] nums, int key, int begin, int end) {

        int index = -1;

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] <= key) begin = middle + 1;
            else end = middle - 1;
        }

        if (end > 0 && nums[end] == key) {
            return end;
        }

        return index;
    }

    //查找第一个等于或者大于Key的元素
    public static int searchFirstEqualOrLarger(int[] nums, int key, int begin, int end) {

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] >= key) end = middle - 1;
            else begin = middle + 1;
        }

        return begin;
    }

    //查找第一个大于key的元素
    public static int searchFirstLarger(int[] nums, int key, int begin, int end) {

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] <= key) begin = middle + 1;
            else end = middle - 1;
        }

        return begin;
    }

    //查找最后一个等于或者小于key的元素
    public static int searchLastEqualOrSmaller(int[] nums, int key, int begin, int end) {

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] <= key) begin = middle + 1;
            else end = middle - 1;
        }

        return end;
    }

    //查找最后一个小于key的元素
    public static int searchLastSmaller(int[] nums, int key, int begin, int end) {

        while (end - begin >= 0) {
            int middle = (begin + end) / 2;
            if (nums[middle] >= key) end = middle - 1;
            else begin = middle + 1;
        }

        return end;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 5, 9, 10, 20, 25, 29, 30, 40, 100 };
        int[] cnums = { 1, 2, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 7 };

        int key = 5;
        System.out.println("binarySearch index = " + binarySearch(nums,key,0,nums.length-1));
        System.out.println("searchFirstEqual index = " + searchFirstEqual(cnums,key,0,cnums.length-1));
        System.out.println("searchLastEqual index = " + searchLastEqual(cnums,key,5,cnums.length-1));
        System.out.println("searchFirstEqualOrLarger index = " + searchFirstEqualOrLarger(cnums,key,0,cnums.length-1));
        System.out.println("searchFirstLarger index = " + searchFirstLarger(cnums,key,0,cnums.length-1));
        System.out.println("searchLastEqualOrSmaller index = " + searchLastEqualOrSmaller(cnums,key,0,cnums.length-1));
        System.out.println("searchLastSmaller index = " + searchLastSmaller(cnums,key,0,cnums.length-1));
    }

}
