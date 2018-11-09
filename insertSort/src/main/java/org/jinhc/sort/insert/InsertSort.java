package org.jinhc.sort.insert;

/**
 * @author jinhongcai
 * @create 2018-11-09 13:13
 * @desc 插入排序
 **/
public class InsertSort <T extends Comparable<T>> {

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 选择排序
     * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。
     * 再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
     * <p>
     * 选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，
     * 这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
     *
     * @param nums
     */
    public void selectionSort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }


    /**
     * 冒泡排序
     * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * 在一轮循环中，如果没有发生交换，就说明数组已经是有序的，此时可以直接退出。
     *
     * @param nums
     */
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        //  需要排的趟数
        for (int i = N - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;
            //  需要比较的元素个数
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }


    /**
     * 插入排序
     * 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
     *
     * 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，插入排序每次只能交换相邻元素，令逆序数量减少 1
     * 因此插入排序需要交换的次数为逆序数量。
     * 插入排序的复杂度取决于数组的初始顺序，如果数组已经部分有序了，逆序较少，那么插入排序会很快。
     * 平均情况下插入排序需要 ~N2/4 比较以及 ~N2/4 次交换；
     * 最坏的情况下需要 ~N2/2 比较以及 ~N2/2 次交换，最坏的情况是数组是倒序的；
     * 最好的情况下需要 N-1 次比较和 0 次交换，最好的情况就是数组已经有序了。
     * 以下演示了在一轮循环中，将元素 2 插入到左侧已经排序的数组中。
     * @param nums
     */
    public void insertSort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }


    /**
     * 希尔排序
     * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
     * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
     * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
     * 希尔排序的运行时间达不到平方级别，使用递增序列 1, 4, 13, 40, ... 的希尔排序所需要的比较次数不会超过 N 的若干倍乘于递增序列的长度
     * @param nums
     */
    public void shellSort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        TestSort testSort1 = new TestSort();
        TestSort testSort2 = new TestSort();
        TestSort testSort3 = new TestSort();
        TestSort testSort4 = new TestSort();
        TestSort testSort5 = new TestSort();
        testSort1.setId(3);
        testSort2.setId(5);
        testSort3.setId(4);
        testSort4.setId(2);
        testSort5.setId(1);
        InsertSort sortUtil = new InsertSort();
        TestSort[] testSorts = new TestSort[5];
        testSorts[0] = testSort1;
        testSorts[1] = testSort2;
        testSorts[2] = testSort3;
        testSorts[3] = testSort4;
        testSorts[4] = testSort5;
        System.out.println("排序前集合!");
        for (TestSort testSort : testSorts) {
            System.out.println(testSort);
        }
        sortUtil.shellSort(testSorts);
        System.out.println("排序前集合!");
        for (TestSort testSort : testSorts) {
            System.out.println(testSort);
        }

    }
}
class TestSort implements Comparable<TestSort>{

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(TestSort testSort) {
        return this.getId() != testSort.getId() ? ((this.getId() > testSort.getId()) ? 1 : -1) : 0;
    }

    @Override
    public String toString() {
        return "TestSort{" +
                "id=" + id +
                '}';
    }
}
