/*
 * 给定两个数组，判断经过a数组的一些入栈出栈操作，可以变成b数组
 */
public class StackFromOneToOne {

	public static boolean isStackFromOneToOne(final int a[],final int b[]){
		
		if(a.length != b.length){
			return false;
		}
		
		int len = a.length;
		
		int atop = 0;
		int apop = 0;
		int btop = 0;
		
		while(atop < len && btop < len){
			if(a[atop] != b[btop]){
				++atop;
			} else {
				int temptop = atop;
				while(temptop >= apop){
					if(a[temptop--] != b[btop++]){
						return false;
					}
				}
				apop = ++atop;
			}
		}
		
		return apop == len;
	}

	public static void main(String[] args) {
		
		int a[] = {1,3,5,7,9};
		int b[] = {9,7,5,3,1};
		
		System.out.println(isStackFromOneToOne(a,b));

	}

}
