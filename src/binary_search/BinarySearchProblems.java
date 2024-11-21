package binary_search;

public class BinarySearchProblems {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 5, 10, 16, 19, 22, 55, 66, 100, 1115, 2000, 4555, 9000, 15015};

        System.out.println(ceilingEqual(testArray, 115));
        System.out.println(floorEqual(testArray, 15));
        System.out.println(infiniteArray(testArray, 15015));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(peakIndexMountainArray(new int[]{0, 3, 2, 0, 9, 5, 0}));
        System.out.println(findPivot(new int[]{2, 3, 4, 5, 6, 7, 0, 1}));
        System.out.println(findInRotatedSortedArray(new int[]{3, 4, 5, 6, 7, -1, 2}, -1));
        System.out.println(rotationCount(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    static int rotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (middle > start && arr[middle] > arr[middle + 1]) {
                return middle + 1;
            } else if (middle < end && arr[middle] < arr[middle - 1]) {
                return middle;
            } else if (arr[middle] <= arr[start]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    static int findInRotatedSortedArray(int[] arr, int target) {
        int ans = binarySearch(arr, target, findPivot(arr) + 1, arr.length - 1);
        if (ans == -1) ans = binarySearch(arr, target, 0, findPivot(arr));
        return ans;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    static int peakIndexMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        //end is the same;
        return start; // start == end;
    }

    static char nextGreatestLetter(char[] letters, char target) {
        //You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
        // There are at least two different characters in letters.
        //Return the smallest character in letters that is lexicographically greater than target.
        // If such a character does not exist, return the first character in letters.
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length];
    }

    static int infiniteArray(int[] arr, int target) {
        int start = 0;
        int end = 1;

        int ans = binarySearch(arr, target, start, end);

        while (ans == -1) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            ans = binarySearch(arr, target, newStart, end);
        }

        return ans;
    }

    static int ceilingEqual(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    static int floorEqual(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return end;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if (arr.length == 0) return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}


