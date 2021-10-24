package task1.com.anish.calabashbros;

public class SelectSorter<T extends Comparable<T>> implements Sorter<T> {

    private T[][] a;

    @Override
    public void load(T[][] a) {
        this.a = a;
    }

    private void swap(int row1, int col1, int row2, int col2) {
        T temp = a[row1][col1];
        a[row1][col1] = a[row2][col2];
        a[row2][col2] = temp;
        // 这里不是更新下标，而是下标对应的rank
        plan += "" + a[row1][col1] + "<->" + a[row2][col2] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        // 对一个二维数组进行排序，

        // boolean sorted = false;
        // while (!sorted) {
        // sorted = true;
        // for (int i = 0; i < (a.length * a[0].length) - 1; i++) {
        // int row1 = i / a.length;
        // int col1 = i % a[0].length;
        // int col2 = (col1 + 1) == a[0].length ? 0 : (col1 + 1);
        // int row2 = col2 == 0 ? (row1 + 1) : row1;
        // // try {

        // // } catch (Exception e) {
        // // Scanner sc = new Scanner(System.in);
        // // sc.nextInt();
        // // sc.close();
        // // }
        // if (a[row1][col1].compareTo(a[row2][col2]) > 0) {
        // swap(row1, col1, row2, col2);
        // sorted = false;
        // }
        // }
        // }
        for (int i = 0; i < (a.length * a[0].length) - 1; i++) {
            int row1 = i / a.length;
            int col1 = i % a[0].length;
            int row = row1;
            int col = col1;
            T min = a[row1][col1];
            for (int j = i + 1; j < (a.length * a[0].length); j++) {
                int row2 = j / a.length;
                int col2 = j % a[0].length;
                if (min.compareTo(a[row2][col2]) > 0) {
                    min = a[row2][col2];
                    row = row2;
                    col = col2;
                }
            }
            if (row != row1 || col != col1) {
                swap(row1, col1, row, col);
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}