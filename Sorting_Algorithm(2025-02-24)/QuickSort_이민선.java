import java.util.Arrays;

public class QuickSort_이민선 {
    public static void quickSort(int[] arr, int left, int right){
        if (left >= right) return;

        int medianPivot = getMedianPivot(arr, left, right);
        swap(arr, medianPivot, right);
        int pivotIdx = getPivotIdx(arr, left, right);

        quickSort(arr, left, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, right);
    }

    public static int getMedianPivot(int[] arr, int left, int right){
        int mid = (left + right) / 2;
        if (arr[mid] < arr[left]) swap(arr, mid, left);
        if (arr[mid] > arr[right]) swap(arr, mid, right);
        if (arr[left] > arr[right]) swap(arr, left, right);

        return mid;
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static int getPivotIdx(int[] arr, int left, int pivotIdx){
        int idx = left-1;
        for (int i=left;i<pivotIdx;i++){
            if (arr[i] < arr[pivotIdx]){
                idx++;
                swap(arr, idx, i);
            }
        }
        swap(arr, idx + 1, pivotIdx);
        return idx + 1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, -3, 0, 17, 4, 6, 11};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
/**
 *
 * pivot을 어떻게 잡느냐에 따라 시간복잡도와 공간복잡도 등등이 달라지나,
 * 스터디에서는 medianOfThree 방식을 채택하여 설명
 * 시간복잡도:
 * 균형 잡힌 분할일 때 - O(N log N) - getPivotIdx에서 처음에 N번 훑고 재귀 호출을 할 때마다 배열이 반씩 줄어든다.
 * 최악의 분할일 때 - O(N^2) 재귀호출을 할 때 반씩 줄어들지 않는다.
 * 공간복잡도: 주로 재귀호출 스택의 깊이에 의해 결정된다.
 * 균형 잡힌 분할일 때 - O(log N) - 재귀 호출 스택 사용량만 고려하면 O(log N)이다.
 * 최악의 분할일 때 - O(N) - 한쪽으로 치우친 경우, 재귀 호출이 N번 발생한다.
 * in-place: true
 * 안정 정렬 여부: 불안정 정렬 (pivot끼리 변경되는 과정에서 상대적인 순서가 바뀔 수 있음)
 */
