package com.lsw.demo;

import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by liushuwei on 2017/8/22.
 */

public class PointToOffer {

    private static PointToOffer mPointToOffer = new PointToOffer();

    private PointToOffer() {
    }

    public static PointToOffer getPointToOffer() {
        return mPointToOffer;
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int [][] array) {
        int rowLen = array.length;
        int columnLen = array[0].length;
        int row = 0;
        int column = columnLen -1;
        while((row<rowLen)&&(column>=0)){
            if(array[row][column]>target){
                column--;
            }else if(array[row][column]<target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }



    /**
     * 输入一个链表，从尾到头打印链表每个节点的值
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode= constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    public TreeNode constructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if((startPre>endPre)||(startIn>endIn)){
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i = 0;i<=endPre;i++){
            if(pre[startPre] == in[i]){
                root.left=constructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=constructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return value;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        return array[0];
    }


    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int num0 = 0;
        int num1 = 1;
        if(n <= 0) return num0;
        if(n == 1) return num1;
        int result = 0;
        for(int i = 2; i <= n; i++){
            result = num0 + num1;
            num0 = num1;
            num1 = result;
        }
        return result;
    }


    /**
     * 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     *
     * 分析：
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
     * 其余所有位将不会受到影响。
     * 举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。
     * 减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
     * 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
     * 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }


    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = base;
        int n = exponent;
        if (exponent < 0) {
            exponent = -exponent;
        } else if (exponent == 0) {
            return 1;
        }
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }

        return n < 0 ? 1 / result : result;
    }


    /**
     * 打印1到最大的n位数
     * 题目：输入数字n，按顺序打印出从1到最大的n位进制数。比如输入3则打印出 1、2、3 一直到999.
     * @param n
     */

    //方法一
    public void printToMaxOfNDigits1(int n) {
        int num = 1;
        for (int j = 0; j < n; j++) {
            num *= 10;
        }
        for (int k = 1; k < num; k++) {
            Log.i("lsw---", k + "");
        }

    }

    //方法二
    public void printToMaxOfNDigits2(int n) {
        int[] array = new int[n];
        if (n <= 0)
            return;
        printArray(array, 0);
    }

    private void printArray(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if (n != array.length) {
                array[n] = i;
                printArray(array, n + 1);
            } else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }

    /**
     * 在 O（1）时间删除链表结点
     * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除
     * 该结点。
     * @param head
     * @param pToBeDeleted
     */
    public void deleteNode(SingleListNode head, SingleListNode pToBeDeleted){
        if(head == null || pToBeDeleted == null){
            return;
        }
        SingleListNode q = pToBeDeleted.next;
        //要删除的不是尾结点
        if(q != null){
            pToBeDeleted.value = q.value;
            pToBeDeleted.next = q.next;
            q = null;
        } else if(head == pToBeDeleted){//链表只有一个结点，删除头结点（也是尾节点）
            pToBeDeleted = null;
            head = null;
        }else{//链表中有多个结点，删除尾结点
            SingleListNode q1 = head;
            while(q1.next!=pToBeDeleted){
                q1 = q1.next;
            }
            q1.next = null;
            pToBeDeleted = null;
        }
    }

    class SingleListNode{
        int value;
        SingleListNode next;
        public SingleListNode(int v){value = v;}
    }


    public void order(int[] array) {
        if (array == null || array.length == 0)
            return;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !isEven(array[start])) {
                start++;
            }
            while (start < end && isEven(array[end])) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    private boolean isEven(int n) {
        return n%2 == 0;
    }

}
