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
        List<String> stringList = new ArrayList<String>();//原始数据
        List<String> stringListResult = new ArrayList<String>();//结果集
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
            if (stringList.get(i).contains("@")) {//含有“@”取最后一个子串，替换原位置数据并继续
                String[] strings = stringList.get(i).split("@");
                stringList.set(i, strings[strings.length - 1]);
                i--;
            } else if (stringList.get(i).contains("#")) {//含有“#”责变换为char数组，每遇到一次就移除stringBuilder最后一位
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
            } else {//皆无则直接加入结果集
                stringListResult.add(stringList.get(i));
            }
        }
        for (int i = 0; i < stringListResult.size(); i++) {//输出结果
            System.out.println(stringListResult.get(i));
        }
    }
}
