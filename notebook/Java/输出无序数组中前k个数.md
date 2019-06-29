### 面试题：从无序数组中找出第k大的数

### 1. 基于冒泡排序和简单选择排序，时间复杂度o(n*k)

在冒泡排序和简单选择排序中，最外层的循环每遍历一次，都可以把第i大（或第i小）的数排到数组的最前面，所以我们用这种方法，最外面经过k次遍历之后，就可以找到第k大的数。

```

/**
 * @Description:
 * Created by shanzhihong on 2019/06/29-9:51.
 * @version 1.0
 */

    public void swap(int[] nums, int i,int j){
        int b = nums[i];
        nums[i] = nums[j];
        nums[j] = b;
    }
    public int findKthLargest(int[] nums, int k){
        if(nums.length <= 0||k>num.length){
            return -1;
        }

        for (int i=0;i<k-1;i++){
            for (int j=0;j<nums.length-1-i;j++){
                if (nums[j]>nums[j+1]){
                    swap(nums,j+1,j);
                }
            }
        }
        for (int i:nums){
            System.out.print(" "+i+" ");
        }
        return nums[nums.length-k];
    }
    public static void main(String[] args){
        //2  2  3  4  5  6  7  8  10  10  100  1111
        int[] arr = new int[]{5,6,3,2,7,8,4,1111,10,100};
        FindKthLargestByBubble f = new FindKthLargestByBubble();
        System.out.println(f.findKthLargest(arr,10));
    }
}
```

### 2. 借助最小堆结构，适合海量数据的O(nlogn)方法

```
import java.util.PriorittyQueue
class Solution{
    public int findKthLargest(int[] num, int k){
        PriorityQueue<Integer> pg = new PriorityQueue<>();
        for(int ele:nums){
            pg.ad(ele);
            if(pg.size() > K){ //保存堆的大小为k
                pg.poll(); //如果比k大，则把k+1个元素中的最小值poll出来
                           //并让剩下的元素以最小堆的形式重新排序
            }
        }
        return pg.peek();  //输出的最小值就是数组中的第k大的数
    }
}
```

### 3. 基于快速排序的方法，时间复杂度为O(n)

```
//这里的举例是获取第k个数，如果想获取第k大的数
//即 查询第k大的数就是查询数组中的第arr.length-k+1个数 
/**
public class FindQianK {

/**
 * @Description:
 * Created by shanzhihong on 2019/06/28-21:20.
 * @version 1.0
 */

    /**
     * 交换函数
     * @param arr
     * @param a
     * @param b
     */
    public void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int sort(int[] arr, int low, int high, int k){
        if (low <= high){  //这里要注意，如果左边或右边只剩一个数字是需要跟k进行对比的，而在快排中没必要比较
            //否则就快排查询
            int m = partitioin(arr, low, high);
            if (m == k){
                //说明m就是k大的数
                return arr[m];
            }else {
                if (k < m){
                    //说明第k大的数在左边，查找左边的
                    return sort(arr,low,m-1, k);
                }else {
                    return sort(arr,m+1, high, k);
                }
            }
        }
        return -1;
    }
    public int partitioin(int[] arr, int low, int high){
        int point = arr[low];
        while (low < high){
            while (low < high){
                if (arr[high] < point){
                    swap(arr, low, high);
                    break;
                }else {
                    high--;
                }
            }
            while (low < high){
                if (arr[low] > point){
                    swap(arr, low, high);
                    break;
                }else {
                    low++;
                }
            }
        }
        return low;
    }
    /**
     * 查询无序数组中的第k大的数
     * @param arr
     * @return
     */
    public int getTheKdata(int[] arr, int k){
        if (arr.length<=0||k>arr.length){
            return -1;
        } else {
            return sort(arr,0, arr.length-1, k-1);
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{6,4,7,3,8,9,5};//3,4,5,6,7,8,9
        int k = sc.nextInt();
        FindQianK binarySearchThe_k_big = new FindQianK();
        int a = binarySearchThe_k_big.getTheKdata(arr,k);
        System.out.println(a);

    }

}
```


