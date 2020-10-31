package d12_查找;

/**
 * 长串是否包含子串
 */
public class KMP {

    protected static int[] getNext(char[] p) {
        // 已知next[j] = k,利用递归的思想求出next[j+1]的值
        // 如果已知next[j] = k,如何求出next[j+1]呢?具体算法如下:
        // 1. 如果p[j] = p[k], 则next[j+1] = next[k] + 1;
        // 2. 如果p[j] != p[k], 则令k=next[k],如果此时p[j]==p[k],则next[j+1]=k+1,
        // 如果不相等,则继续递归前缀索引,令 k=next[k],继续判断,直至k=-1(即k=next[0])或者p[j]=p[k]为止
        int len = p.length, j = 0, k = -1;
        int[] next = new int[len];
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int lenSrc = src.length;
        int lenPtn = ptn.length;
        int[] next = getNext(ptn);
        while (i < lenSrc && j < lenPtn) {
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == lenPtn)
            return i - j;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("bbc abcdab abcdabcdabde", "abcdabd"));
    }
}

