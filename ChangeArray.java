public class ChangeArray <T>{
    private T[] arr1;

    public ChangeArray(T...arr1) {
        this.arr1 = arr1;
    }

    public void changeArray(int x1,int x2){
        T c;
        c=arr1[x1];
        arr1[x1]=arr1[x2];
        arr1[x2]=c;

        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
    }

}
