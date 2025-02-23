import java.util.Arrays;

public class TimSort_이민선 {
    static final int RUN = 32;

    // 삽입 정렬 (작은 배열에서 사용)
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // 병합 과정 (Merge)
    public static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1, len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        // 배열 분할
        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        // 병합
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // 남은 원소 추가
        while (i < len1) {
            arr[k++] = leftArr[i++];
        }
        while (j < len2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Tim Sort 메인 함수
    public static void timSort(int[] arr, int n) {
        // 작은 부분 배열에 삽입 정렬 적용
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        }

        // 병합 과정 (Merge)
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    // 실행 테스트
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, -3, 0, 17, 4, 6, 11};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        timSort(arr, arr.length);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
