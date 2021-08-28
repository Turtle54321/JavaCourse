public class Hello {

    public static void main(String[] args) {
        int sum = 0;
        int result;

        for (int i = 1; i < 4; i++) {
            sum = sum + i;
            if (i == 2) {
                sum = sum * 5;
            }
        }
        result = sum - sum / 3;
        System.out.println(result);
    }
}
