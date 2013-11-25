import java.util.Stack;

/*
 * 给定两个数组，判断经过a数组的一些入栈出栈操作，可以变成b数组
 */
public class StackFromOneToOne {

    public static boolean isStackFromOneToOne(final int a[],final int b[]){

        if(a.length != b.length){
            return false;
        }

        Stack stack = new Stack();

        int len = a.length;
        int aIndex = 0;
        int bIndex =0 ;

        while(true){
            
            while(aIndex < len && (stack.isEmpty() || (Integer)stack.peek() != b[bIndex])){
                stack.push(a[aIndex++]);
            }

            while(!stack.isEmpty() && (Integer)stack.pop() == b[bIndex]){
                bIndex++;
            }
            
            if(aIndex >= len){
                return bIndex>= len;
            }
        }

    }

    public static void main(String[] args) {

        int a[] = {1,3,5,7,9};
        int b[] = {9,7,5,3,1};

        System.out.println(isStackFromOneToOne(a,b));

    }

}
