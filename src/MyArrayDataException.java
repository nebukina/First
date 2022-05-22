public class MyArrayDataException extends RuntimeException{
    private int i;
    private int j;
    public MyArrayDataException(String message,int i, int j) {
        super(message+i+j);
        this.i=i;
        this.j=j;
    }
}
