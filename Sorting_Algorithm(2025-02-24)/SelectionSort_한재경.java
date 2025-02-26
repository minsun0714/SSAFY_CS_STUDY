import java.util.Arrays;

//삽입정렬: key값 전에 key값보다 작은값들 오른쪽으로 밀고 삽입하기
public class SelectionSort_한재경 {
    public static void mySort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 현재 삽입할 값
            int j = i - 1;

            //i전에 작으면 한칸씩 밀기
            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, -3, 17, -10, 84, 0, -19, 6, 22, 9};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        mySort(arr);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }
}
