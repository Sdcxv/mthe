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
            Set<Integer> frinedsSet = new HashSet<Integer>();//����ȥ��
            frinedsSet.add(1);//��ʼ�����缯
            a = cin.nextInt();//��ʾN���ˣ����ǻ�������
            b = cin.nextInt();//��ʾ����Ϊ������N������
            if (a == 0 && b == 0) break;//�������
            if (b == 0) //0���ϵ
                continue;//ֱ��ȡ��һ��
            else if (a == 0 || a == 1) {//����ֻ��һ���˻�û����
                for (int i = 0; i < b; i++) {//���Ľ�������b������
                    a = cin.nextInt();
                    a = cin.nextInt();
                }
                continue;//ȡ��һ��
            }
            for (int i = 0; i < b; i++) {
                int j = cin.nextInt();//��һ
                int k = cin.nextInt();//����
                if (frinedsSet.contains(j) || frinedsSet.contains(k)) {//�����߼�������
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
