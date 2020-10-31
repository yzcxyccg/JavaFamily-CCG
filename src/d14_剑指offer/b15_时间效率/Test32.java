package d14_剑指offer.b15_时间效率;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Test32 {
    /**
     * 冒泡排序
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber1(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int num2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (num1 > num2) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str += numbers[i];
        }
        return str;
    }

    /**
     * 快排
     *
     * @param numbers
     * @return
     */
    public String PrintMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        quickSort(numbers, 0, numbers.length - 1);
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            str += numbers[i];
        }
        return str;
    }

    public int[] quickSort(int[] numbers, int start, int ends) {
        if (start < 0 || ends > numbers.length || start > ends) return null;
        int minIndex = partain(numbers, start, ends);
        if (minIndex > start) quickSort(numbers, start, minIndex - 1);
        if (minIndex < ends) quickSort(numbers, minIndex + 1, ends);
        return numbers;
    }

    public int partain(int[] numbers, int start, int ends) {
        int minIndex = start - 1;
        for (int i = start; i <= ends; i++) {
            long num1 = Long.valueOf(numbers[i] + "" + numbers[ends]);
            long num2 = Long.valueOf(numbers[ends] + "" + numbers[i]);
            if (num1 <= num2) {
                minIndex++;
                if (minIndex < i) {
                    int temp = numbers[i];
                    numbers[i] = numbers[minIndex];
                    numbers[minIndex] = temp;
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Test32 test32 = new Test32();
        int[] array = {3, 323, 32123};
        System.out.println(test32.PrintMinNumber2(array));
    }
}
