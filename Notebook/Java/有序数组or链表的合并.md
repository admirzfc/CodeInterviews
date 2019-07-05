### 有序数组合并

```
import java.util.ArrayList;
import java.util.List;

public class Solution{

/**
 * @ClassName: SortedArrMerge
 * @Description: 两个有序数组合并为一个有序数组
 * @Version 1.0
 * Created by Fanchao.Zhao on 2019/07/05-9:35.
 */
    public static void main(String[] args){

        int[] arrA = new int[]{1,2,3,4,5,6,7};
        int[] arrB = new int[]{2,5,7,8,9,10};
        List c = new ArrayList();
        int[] arrC = merge(arrA, arrB);
        for (int i:arrC){
            System.out.print(" "+i+" ");
        }
    }
    public static int[] merge(int[] arrA, int[] arrB){
        int[] arrC = new int[arrA.length + arrB.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arrA.length && j < arrB.length){
            //选择A,B中的一个插入到C
            if (arrA[i] <= arrB[j]){
                arrC[k] = arrA[i++];
            }else {
                arrC[k] = arrB[j++];
            }
            k++;
        }
        if (i < arrA.length){
            //A数组没复制完
            for (;i<arrA.length;i++){
                arrC[k++] = arrA[i];
            }
        }
        if (j < arrB.length){
            for(;j<arrB.length;j++){
                arrC[k++] = arrB[j];
            }
        }
        return arrC;
    }

}
```

有序链表合并

```
public class Solution{


/**
 * @ClassName: SortedNodeMerge
 * @Description:
 * @Version 1.0
 * Created by Fanchao.Zhao on 2019/07/05-10:20.
 */
 

    public static Node merge(Node a,Node b){
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node head = null;
        if (a.getData() <= b.getData()){
            head = a;
            head.setNode(merge(a.getNode(),b));
        }else {
            head = b;
            head.setNode(merge(a,b.getNode()));
        }
        return head;
    }

    public static void main(String[] args){

        Node node1 = new Node(10,null);
        Node node2 = new Node(8,node1);
        Node node3 = new Node(4,node2);
        Node node4 = new Node(2,node3);
        Node node5 = new Node(1,node4);
        

        Node node7 = new Node(9,null);
        Node node8 = new Node(5,node7);
        Node node9 = new Node(3,node8);
        

        Node head1 = new Node(0,node5);
        Node head2 = new Node(1,node9);

        Node head= merge(head1, head2);
        Node node = head;
        while (node.getNode() != null){
            System.out.print(" " + node.getData() + " ");
            node = node.getNode();
        }
        System.out.println(" " + node.getData() + " ");

    }

}
```


