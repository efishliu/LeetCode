package common;
/*
    用数组来实现循环队列的方式
    1、利用size记录队列中元素的个数，当head=tail时，size=0为空，size=n时为满。
    2、空置一个空间，当head=tail时为空，(tail+1)%n == head%n为满
 */
public class CircularQueue {
    //1、利用size记录队列中元素的个数
    public class Queue1{
        int size = 0;
        int N = 0;
        int head,tail;
        int[] arr;
        Queue1(){}
        Queue1(int N){
            this.size = 0;
            this.N = N;
            arr = new int[this.N];
            head = tail = 0;
        }
        public int offer(int val){
            if(size == N){//队列满，添加失败
                return -1;
            }else{//添加成功
                arr[tail++] = val;
                size++;
                return val;
            }
        }
        public int poll(){
            if(size == 0){
                //队列空，无元素
                return -1;
            }else{
                int val = arr[head++];
                size--;
                return val;
            }
        }
    }
    //不利于size,牺牲一个位置来判断队空或队满
    public class Queue2{
        int N = 0;
        int head,tail;
        int[] arr;
        Queue2(){}
        Queue2(int N){
            this.N = N;
            arr = new int[this.N];
            head = tail = 0;
        }
        public int offer(int val){
            if((tail + 1) % N == head % N){//队列满，添加失败
                return -1;
            }else{//添加成功
                arr[tail++] = val;
                return val;
            }
        }
        public int poll(){
            if(head == tail){//队列空，无元素
                return -1;
            }else{
                int val = arr[head++];
                return val;
            }
        }
    }
}

