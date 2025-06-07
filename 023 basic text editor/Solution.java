import java.io.*;
import java.util.*;

public class Solution {
    public static class TextEditor{
        
        List<Integer> deleted;
        List<String> text;
        String fullText;
        TextEditor(){
            deleted = new ArrayList<>();
            text = new ArrayList<>();
            fullText="";
        }
        void append(String w){
            deleted.add(w.length());//i want to keep the 2 list with the same length
            text.add(w);
            fullText+=w;
        }
        void delete(int k){
            deleted.add(-k);
            text.add(fullText.substring(fullText.length()-k, fullText.length()));//i want to keep the 2 list with the same length
            fullText=fullText.substring(0, fullText.length()-k);
        }
        void print(int k){
            System.out.println(fullText.charAt(k-1));
        }
        void undo(){
            if(deleted.get(deleted.size()-1)>=0){//last is append
                fullText=fullText.substring(0, fullText.length()-deleted.get(deleted.size()-1));
                deleted.remove(deleted.size()-1);
                text.remove(text.size()-1);
            }else{//last was delete
                fullText+=text.get(deleted.size()-1);;
                deleted.remove(deleted.size()-1);
                text.remove(text.size()-1);
            }

        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int opsNum=s.nextInt();
        TextEditor ed=new TextEditor();
        while(opsNum>0){
            int op=s.nextInt();
            switch(op){
                case 1:
                    ed.append(s.next());
                    break;
                case 2:
                    ed.delete(s.nextInt());
                    break;
                case 3:
                    ed.print(s.nextInt());
                    break;
                case 4:
                    ed.undo();
                    break;
                default:
                    System.out.println("unsupported operation");
            }
            opsNum--;
        }
    }
}