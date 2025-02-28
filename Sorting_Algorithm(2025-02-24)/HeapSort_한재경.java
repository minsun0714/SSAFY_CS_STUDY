import java.util.Arrays;

//힙 자료구조는 자식노드간 크기 보장이 안됨. 오직 부모노드>자식노드만 보장
//힙 자식 i*2+1, i*2+2. 부모 (i-1)/2
public class HeapSort_한재경 {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // heapify(): 자식노드가 더 크면 부모노드와 체인지하는 작업
        // heapify() 함수는 자식 노드가 있는 "부모 노드"들만 실행하면 됨!
        // 마지막 부모노드 인덱스는 (n-1)/2 (n번째자식의 부모), 루트인덱스는 0
        for (int i = (n-1)/2; i >= 0; i--) {  //부모노드 전체 역순!
            // 역순: 부모 노드보다 먼저 자식 노드를 정리해야해서
            heapify(arr, n, i);
            // 최대 힙:   [84, 22, 19, 10, 3, 17, 6, 5, 9]
        }

        // 힙에서 최댓값 하나씩 꺼내면서 정렬 수행
        // 힙의 0번째 값이 정렬된값!
        for (int i = n - 1; i > 0; i--) {
            // 루트(최대값)와 마지막 요소 교환
            swap(arr, 0, i);

            // 힙 크기를 줄이고 다시 힙 속성 유지
            heapify(arr, i, 0);
        }
    }

    // 힙을 유지하는 함수 (Heapify)
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 루트를 가장 큰 값으로 설정
        int left = 2 * i + 1; // 왼쪽 자식
        int right = 2 * i + 2; // 오른쪽 자식

        // 왼쪽 자식이 현재 최대값보다 크면 largest 업데이트
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 현재 최대값보다 크면 largest 업데이트
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // largest가 변경되었으면 스왑하고 재귀적으로 힙 속성 유지
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest); //이전 자식 위치(largest)에서 다시 heapify 수행
        }
    }

    // 두 요소를 교환하는 함수
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 실행 예제
    public static void main(String[] args) {
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
