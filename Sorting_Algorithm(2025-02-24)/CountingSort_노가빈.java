import java.util.Arrays;

public class CountingSort_노가빈 {

    public static void main(String[] args) {

        // 1. 일반 카운팅정렬 - 양수만 가능
//        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
//        System.out.println("정렬 전: " + Arrays.toString(arr));
//        countingSort(arr);

        // 2. 음수가능버전 카운팅정렬
        int[] arr = {5, -3, 17, -10, 84, 0, -19, 6, 22, 9};
        System.out.println("정렬 전: " + Arrays.toString(arr));
        countingSort_negative(arr);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    private static void countingSort_negative(int[] arr) {

        //기저조건 하나 있으면 더 좋겠지~ 빈배열처리
        if(arr == null || arr.lengh == 0) return;


        // 1. 최댓값 찾아 , 최솟값도 찾아
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
        }

        // 2. 최댓값 크기 + 최솟값 크기만큼 count arr 만들자
        int range = max - min;
        int[] count = new int[range + 1];

        // 3. 이제 count하자
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] -min]++;
        }

        // 4. 셌으니까 이제 그 값을 하나하나 카운트를 빼면서 기존 arr에 넣어주자
        int resultIndex = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0){
                arr[resultIndex++] = i + min;
            }
        }
    }

    private static void countingSort(int[] arr) {

        // 1. 최댓값 찾아
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }

        // 2. 최댓값 크기만큼 count arr 만들자
        int[] count = new int[max + 1];

        // 3. 이제 count하자
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // 4. 셌으니까 이제 그 값을 하나하나 카운트를 빼면서 기존 arr에 넣어주자
        int resultIndex = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0){
                arr[resultIndex++] = i;
            }
        }
    }
}
