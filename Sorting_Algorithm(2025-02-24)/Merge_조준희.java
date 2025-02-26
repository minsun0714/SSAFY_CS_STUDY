import java.util.Arrays;

public class Merge_조준희 {
    /*
    머지 솔트
    1. 분할
    2. 정렬(정렬되어있다고 가정)
    3. 병합
     */
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, -3, 0, 17, 4, 6, 11};
        System.out.println("Before Sorting: " + Arrays.toString(arr));
//      전체 범위에서 시작
        mergeSort(arr, 0, arr.length-1);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
//  재귀적으로 배열 분할, 정렬된 두 배열 정렬된 하나의 배열로 병합하는 메서드
    private static void mergeSort(int[] arr, int left, int right) {
//      배열을 분할할 수 없을 때(left==right)까지 재귀적으로 분할
        if(left<right){
//          !!팁!! 이분탐색/분할정복 할 때 overflow 방지하는 방법
            int mid = left+(right-left)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
//          분할된 배열 병합하기.
//          (배열은 정렬되었다고 가정. 
//            -> 왜? 병합 시작할 때는 요소 1개짜리 배열을 병합하기 때문에 정렬된 상태가 보장됨.)
//          left~mid 배열 + mid+1~right 배열 병합한다.
            merge(arr, left, mid, right);
        }

    }
//  정렬된 두 배열을 병합하는 메서드(두 배열은 항상 연속한 인덱스 선상에 있음. left~mid, mid+1~right)
    private static void merge(int[] arr, int left, int mid, int right) {

//      좌측, 우측 배열의 길이 구하기
        int leftL = mid-left+1;
        int rightL = right-mid;

//      병합 위해 좌 우 배열 생성하기
        int[] leftArr = new int[leftL];
        int[] rightArr = new int[rightL];

//      좌 우 배열에 실제 배열 요소값 반영하기
        for(int i = 0; i<leftL; i++){
            leftArr[i] = arr[left+i];
        }
        for(int j = 0; j<rightL; j++){
            rightArr[j] = arr[mid+1+j];
        }

//      좌/우 배열 탐색 시작할 인덱스 0으로 초기화
        int i = 0, j = 0;
//      실제 배열에서 병합할 배열 시작하는 인덱스 
        int k = left;

//      i 혹은 j가 끝 인덱스에 도달할 때까지
        while(i<leftL && j<rightL){
//          좌측 배열과 우측 배열 비교
//          더 작은 요소 실제 배열에 반영, 반영된 배열의 탐색 인덱스 ++
//          !!중요!! 등호 유무에 따라 stable 여부 달라짐-등호 없다면 같은 크기 요소의 순서가 달라지며 unsatble됨
            if(leftArr[i]<=rightArr[j]){
                arr[k++] = leftArr[i++];
            }
            else{
                arr[k++] = rightArr[j++];
            }
        }
//      둘 중 한 배열이 탐색 완료 되었을 때
//      남은 배열의 요소들 반영하기
//      남은 배열은 반드시 이미 반영된 요소보다 크기가 큼. 순차적으로 반영하면 됨
        while(i<leftL ){
            arr[k++] = leftArr[i++];
        }
        while(j<rightL ){
            arr[k++] = rightArr[j++];
        }

    }
}
