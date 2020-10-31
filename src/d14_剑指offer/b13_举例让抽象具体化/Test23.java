package d14_剑指offer.b13_举例让抽象具体化;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Test23 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    public static boolean isBST(int[] sequence, int start, int root) {
        if (start >= root) return true;
        int i;
        int key = sequence[root];
        for (i = start; i < root; i++)
            if (sequence[i] > key) break;
        for (int j = i + 1; j < root; j++)
            if (sequence[j] < key) return false;
        return isBST(sequence, i, root - 1) && isBST(sequence, start, i - 1);
    }
}
