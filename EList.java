import java.util.*;
public class EList {
    public ENode root;
    public int cntr = 0;
    public int sum = 0;

    public EList(){
        root = null;
    }
    public ENode insert(String e){
        char cur = e.charAt(cntr);
        cntr++;
        ENode n = new ENode(cur,0);
        if(root == null){
            root = n;
        }
        if(cur == '-'|| cur == '+'||cur == '*'||cur == '%'||cur == 'h'){
            n.left = insert(e);
            n.right = insert(e);
            if(cur == '-'){
                n.intdata = n.left.intdata - n.right.intdata;
            }
            else if(cur == '+'){
                n.intdata = n.left.intdata + n.right.intdata;
            }
            else if (cur == '*'){
                n.intdata = n.left.intdata * n.right.intdata;
            }
            else if(cur == '%'){
                n.intdata = n.left.intdata % n.right.intdata;
            }
            else if(cur == 'h'){
                n.intdata = (int)Math.sqrt(((n.left.intdata)*(n.left.intdata)+(n.right.intdata)*(n.right.intdata)));
            }
            
        }
        else if(cur == 'n'||cur == 'f'){
            n.left = insert(e);
            n.right = null;
            if(cur == 'n'){
                //right side null left side operator situation
                n.intdata = (n.left.intdata) * -1;
            }
            else if(cur == 'f'){
                //1-12 positive int
                n.intdata = factorial(n.left.intdata);
            }
        }
        else{
            n.intdata = (int)cur - (int)'0';
            n.left = null;
            n.right = null;
        }
        return n;
    }
    public void algoshow(ENode node){
        if(node == null){
            return;
        }
        algoshow(node.left);
        System.out.print(node.chardata);
        algoshow(node.right);
    }
    public void show(){
        algoshow(root);
        System.out.print("=" + root.intdata);
    }
    public int factorial(int num){
        
        if(num == 1){
            return 1;
        }
        else{
            return num * factorial(num-1);
        }
        
    }
    
}
