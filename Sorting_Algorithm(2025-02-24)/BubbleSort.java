import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, -3, 17, -10, 84, 0, -19, 6, 22, 9};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        // 버블 정렬 메서드 실행
        bubbleSort(arr);

        // 출력 결과
        System.out.println("정렬 후: " + Arrays.toString(arr));
    }  // end main

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean flag = false;  // 처음 배열이 오름차순(or 내림차순)일 때 한 번에 출력되도록 설정한 변수
        for (int i = 0; i < n - 1; i++) {
            flag = false;  // 각 루프를 돌 때마다 초기화
            for (int j = 0; j < n - i- 1; j++) {
                // 현재 원소가 다음 원소보다 크다면
                if (arr[j] > arr[j + 1]) {
                    // swap 실행
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;  // 정렬 실행했으므로 flag는 true
                }
            }
            if (!flag) break;  // swap하지 않았다면 반복문 탈출, 불필요한 탐색 실행 X
        }
    }  // end bubbleSort
}  // end class
