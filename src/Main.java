public class Main {
    public static void main(String[] args) {
        String[][] arr1 = new String[][]{
                {"1", "2", "3","4"},
                {"1", "2", "3","4"},
                {"1", "2", "d","4"},
                {"1", "2", "3","4"},
        };
        addArray(arr1);
    }

        public static boolean addArray(String[][] arr1) throws MyArrayDataException{
            if (arr1.length != 4) {
                throw new MyArraySizeException("size error");
            }
            int s = 0;
            int i = 0;
            int j = 0;
            try {
                for (i = 0; i < 4; i++) {
                    for (j = 0; j < 4; j++) {
                        int x = Integer.valueOf(arr1[i][j]);
                        s = x+s;
                    }
                }
                System.out.println(s);
            } catch (NumberFormatException e) {
                throw new MyArrayDataException("error in ", i, j);
            }

            return false;
        }

}
