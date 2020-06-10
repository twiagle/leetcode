单链表反转需要三个指针
先断开cur.next,说明需要一个next保存下一位置，将cur.next指向前边节点，说明需要一个pre保存前一位置
不需要哨兵
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while(head != null){
            //先保全后路
            next = head.next;//必须保证head不空，才可能有next，所以不能放最后一句，上次修改next可能已经是空了
            //primary logic
            head.next = pre;
            pre = head;
            head = next;        
        }
    return pre;
    }
}
```


单链表插入和删除头节点时如果没有哨兵
```java
//第一次插入
if (head == null) {
  head = new_node;
}
//删除最后一个节点，恰好最后一个又是是头结点
if (head->next == null) {
   head = null;
}
```
如果有哨兵dummy，实现从指定节点插入
```java
new_node->next = p->next;
p->next = new_node;
```

dummy在局部反转链表有作用，需要接头，但有可能头存在于被反转部分，需要根据含不含头分两种逻辑，
dummy统一逻辑，一定不含头
部分反转链表就给他四个保存点，接头接尾！！save1，save4