import java.io.*;
import java.util.*;

public class Solution {
    public static class QueueFromTwoStack<T>{
        private Stack<T> inbox;
        private Stack<T> outbox;
        
        QueueFromTwoStack(){
            inbox = new Stack<>();
            outbox = new Stack<>();
        }
        
        public void enqueue(T element){
            inbox.push(element);
        }
        
        public T dequeue(){
            if(outbox.isEmpty())while(!inbox.isEmpty())outbox.push(inbox.pop());
            if (outbox.isEmpty()) return null;
            return outbox.pop();
        }
        
        public void print(){
            if(outbox.isEmpty())while(!inbox.isEmpty())outbox.push(inbox.pop());
            System.out.println(outbox.peek());
        }
    }
    
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int queryNumber = sc.nextInt();
            int queryType=0, element=0;
            QueueFromTwoStack<Integer> queue=new QueueFromTwoStack<Integer>();
            while(queryNumber>0){
                queryType = sc.nextInt();
                if(queryType==1)element = sc.nextInt();
                switch(queryType){
                    case 1:
                        queue.enqueue(element);
                        break;
                    case 2: 
                        queue.dequeue();
                        break;
                    case 3:
                        queue.print();
                        break;
                    default:
                        System.out.println("WARNING: unrecognized query");
                }
                //System.out.println(queue.elements);
                queryNumber--;
            }
    }
}