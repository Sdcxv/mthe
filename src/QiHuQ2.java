/**
 * Created by Sdcxv on 2015/9/29.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QiHuQ2 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a = 0, b = 0;
        List<String> stringList = new ArrayList<String>();//ԭʼ����
        List<String> stringListResult = new ArrayList<String>();//�����
        while (cin.hasNextInt()) {
            a = cin.nextInt();
            while (cin.hasNextLine()) {
                b++;
                stringList.add(cin.nextLine());
                if (b > 3) break;
            }
            break;
        }
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).contains("@")) {//���С�@��ȡ���һ���Ӵ����滻ԭλ�����ݲ�����
                String[] strings = stringList.get(i).split("@");
                stringList.set(i, strings[strings.length - 1]);
                i--;
            } else if (stringList.get(i).contains("#")) {//���С�#����任Ϊchar���飬ÿ����һ�ξ��Ƴ�stringBuilder���һλ
                char[] chars = stringList.get(i).toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] != '#') {
                        stringBuilder.append(chars[j]);
                    } else {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }
                stringListResult.add(stringBuilder.toString());
            } else {//������ֱ�Ӽ�������
                stringListResult.add(stringList.get(i));
            }
        }
        for (int i = 0; i < stringListResult.size(); i++) {//������
            System.out.println(stringListResult.get(i));
        }
    }
}
