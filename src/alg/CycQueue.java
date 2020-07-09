package alg;

/**
 * @author tb
 * @date 7/22/19-3:19 PM
 *
 * @date 7/2/30-4:38 PM
 * each array element of arr stores interval length between two requests of an identical object
 * rear is latest, head is far
 */
public class CycQueue {//
    private String[] arr;//previous Request sequence
    private int front;//头指针，若队列不为空，指向队头元素
    private int rear; //尾指针，若队列不为空，指向队列尾元素的下一个位置
    private int maxSize;//power of 2 to support & (maxSize -1)

    public CycQueue(int maxSize) {//e.g. 1 2 3 4 5 6 7
        this.maxSize = maxSize +1;
        arr = new String[this.maxSize];//循环队列
        front = rear = 0;
    }
//resize depends on whether learn++nse supports omitted feature
//        public CycQueue(CycQueue old){
//            int oldSize = old.maxSize;
//            maxSize = oldSize << 1;
//            arr = Arrays.copyOf(old.arr, maxSize);
//        }

    //入队前判满
    public void enQueue(String e) {
        //队列头指针在队尾指针的下一位位置上  说明满了 override it!
        if (((rear+1)&(maxSize-1)) == front) {
            front = (front + 1) & (maxSize-1);;
        }
        arr[rear] = e;
        rear = (rear + 1) & (maxSize-1);
    }

    public CycQueue destroyQueue() {
        rear = front = 0;
        arr = null;
        return this;
    }

    //rear store nothing, so lastWhat should >= 1
    public String getLastElement(int lastWhat) {
        assert lastWhat >=0 ;
        return arr[(rear - lastWhat + maxSize) &(maxSize-1)];
    }

    public Integer queueLength() {
        return (rear - front + maxSize) & (maxSize-1); //求环形队列的元素个数
    }
}