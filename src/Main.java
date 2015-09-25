public class Main {
    public static void main(String[] args) {

        // 进行十亿次测试
        int times = 1000000000;
        // 不更改选择命中计数
        int firstCount = 0;
        // 更改选择命中计数
        int secondCount = 0;
        while (times-- > 0) {
            // 第一次选择的门
            int firstSelectedIndex = -1;
            // 主持人选择的门（在未被选择的两个门中选择一个）
            int hostSelectedIndex = -1;
            // 第二次选择的门（在被主持人打开后的两门）
            int secondSelectedIndex = -1;
            // 门数组，把山羊放进门后
            boolean[] boxes = new boolean[3];
            // 取其中随机一个门设为true，即有宝马BMW
            boxes[(int) (Math.random() * 3)] = true;
            // 从三个门中随机选择一个门，作为第一次选择
            firstSelectedIndex = (int) (Math.random() * 3);
            // 记录两个第一次未被选择的门的位置
            int[] firstNotSelected = {-1, -1};
            for (int i = 0, j = 0; i < boxes.length; i++) {
                if (i != firstSelectedIndex) {
                    firstNotSelected[j] = i;
                    j++;
                }
            }
            // 从两个第一次未被选择的门里挑一个后面是山羊的门作为主持人选择的门
            for (int i = 0; i < firstNotSelected.length; i++) {
                if (!boxes[firstNotSelected[i]]) {
                    hostSelectedIndex = firstNotSelected[i];
                    break;
                }
            }
            // 记录两个主持人没选的门的地址
            int[] hostNotSelectedIndex = {-1, -1};
            for (int i = 0, j = 0; i < boxes.length; i++) {
                if (i != hostSelectedIndex) {
                    hostNotSelectedIndex[j] = i;
                    j++;
                }
            }
            // 选择第二次
            secondSelectedIndex = hostNotSelectedIndex[(int) (Math.random() * 2)];

            // 改变选择
            while (secondSelectedIndex == firstSelectedIndex) {
                secondSelectedIndex = hostNotSelectedIndex[(int) (Math.random() * 2)];
            }
            // 判断两次命中情况
            if (boxes[firstSelectedIndex])
                firstCount++;
            if (boxes[secondSelectedIndex])
                secondCount++;
        }
        // 显示命中情况
        System.out.println("共测试" + (firstCount + secondCount) + "次");
        System.out.println("第一次（未改变选择）猜中" + firstCount + "次");
        System.out.println("第二次（改变选择）  猜中" + secondCount + "次");
    }
}