package week4;
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
import java.util.PriorityQueue;

public class L295_FindMedianFromDataStream {
  public static void main(String[] args) {
      MedianFinder medianFinder = new L295_FindMedianFromDataStream().new MedianFinder();
      medianFinder.addNum(1);
      medianFinder.addNum(2);
      System.out.println(medianFinder.findMedian());
      medianFinder.addNum(3);
      System.out.println(medianFinder.findMedian());
      medianFinder.addNum(4);
      System.out.println(medianFinder.findMedian());
  }
class MedianFinder {

      private PriorityQueue<Integer> left;//大顶堆
      private PriorityQueue<Integer> right;//小顶堆

    /** initialize your data structure here. */
    public MedianFinder() {
        //构造一个大顶堆和一个小顶堆，时刻保证 0<=大顶堆.size-小顶堆.size <=1;如果size相等，则各取一个相加/2返回，否则取大顶堆的数返回
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if(left.size() < right.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / (double)2;
        }else{
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}