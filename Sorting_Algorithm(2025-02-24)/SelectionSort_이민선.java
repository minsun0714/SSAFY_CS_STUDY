import java.util.Arrays;

public class SelectionSort_이민선 {
    public static void selectionSort(int[] arr, int length){
        for (int i=0;i<length;i++){
            int minIdx = i;
            for (int j=i+1;j<length;j++){
                if (arr[j] <arr[minIdx]){
                    minIdx = j;
                }
            }
            swap(arr, minIdx, i);
        }
    }

    public static void swap(int[] arr, int minIdx, int i){
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, -3, 0, 17, 4, 6, 11};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        selectionSort(arr, arr.length);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
/**
 * 시간복잡도 O(N^2)
 * 공간복잡도 O(1)
 * in-place 여부 : true
 * stable sort :전통적으로는 불안정정렬로 분류하나,
 * arr[j] <= arr[minIdx] 대신에 arr[j] < arr[minIdx]를 쓰면 안정정렬처럼 동작한다.
 */
