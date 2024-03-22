package array_string;

public class daily2671 {
    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        frequencyTracker.add(3); // 数据结构现在包含 [3]
        frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
        System.out.println(frequencyTracker.hasFrequency(2)); // 返回 true ，因为 3 出现 2 次

        FrequencyTracker frequencyTracker1 = new FrequencyTracker();
        frequencyTracker1.add(1); // 数据结构现在包含 [1]
        frequencyTracker1.deleteOne(1); // 数据结构现在为空 []
        System.out.println(frequencyTracker1.hasFrequency(1)); // 返回 false ，因为数据结构为空

        FrequencyTracker frequencyTracker2 = new FrequencyTracker();
        frequencyTracker2.hasFrequency(2); // 返回 false ，因为数据结构为空
        frequencyTracker2.add(3); // 数据结构现在包含 [3]
        System.out.println(frequencyTracker2.hasFrequency(1)); // 返回 true ，因为 3 出现 1 次
    }
}

/**
 * 频率跟踪器
 * 思路：按题意使用数组设计即可
 * 
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
class FrequencyTracker {
    /**
     * 数字的出现频率
     */
    private int[] numberCntArr;
    /**
     * 各个频率的出现次数
     */
    private int[] numberFrequencyArr;

    public FrequencyTracker() {
        numberCntArr = new int[100001];
        numberFrequencyArr = new int[100001];
    }

    public void add(int number) {
        --numberFrequencyArr[numberCntArr[number]];
        ++numberCntArr[number];
        ++numberFrequencyArr[numberCntArr[number]];
    }

    public void deleteOne(int number) {
        if (numberCntArr[number] != 0) {
            --numberFrequencyArr[numberCntArr[number]];
            --numberCntArr[number];
            ++numberFrequencyArr[numberCntArr[number]];
        }
    }

    public boolean hasFrequency(int frequency) {
        return numberFrequencyArr[frequency] > 0;
    }
}
