import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Sdcxv on 2015/9/29.
 */
public class QiHuQ2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int a, b;
            Set<Integer> frinedsSet = new HashSet<Integer>();//便于去重
            frinedsSet.add(1);//初始化老乡集
            a = cin.nextInt();//表示N个人，但是基本无用
            b = cin.nextInt();//表示输入为接下来N组数据
            if (a == 0 && b == 0) break;//结束标记
            if (b == 0) //0组关系
                continue;//直接取下一组
            else if (a == 0 || a == 1) {//现在只有一个人或没有人
                for (int i = 0; i < b; i++) {//消耗接下来的b组数据
                    a = cin.nextInt();
                    a = cin.nextInt();
                }
                continue;//取下一组
            }
            for (int i = 0; i < b; i++) {
                int j = cin.nextInt();//数一
                int k = cin.nextInt();//数二
                if (frinedsSet.contains(j) || frinedsSet.contains(k)) {//将二者加入结果集
                    frinedsSet.add(j);
                    frinedsSet.add(k);
                }
            }
            if (frinedsSet.size() == 1)
                System.out.println(0);
            else
                System.out.println(frinedsSet.size());
        }
    }
}
