import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ChangeArray<Integer> arr = new ChangeArray<>(1,2,3,4,5,6,7);
        int n1=3;
        int n2=4;

        arr.changeArray(n1,n2);

        ArrayList <Fruit>A1 = new ArrayList();
        A1.add(new Orange());
        A1.add(new Orange());
        Box box1 = new Box(A1);
    }


}
