package bst;
import java.util.*;
public class BSTRunner {
	
	private static void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	BSTMethod method = new BSTMethod();	
	int dial = sc.nextInt();
	
	switch(dial) {
	case 1 :
	{
		Node root = null;
		int size = sc.nextInt();
		while(size>0) {
		root = method.insertNode(root, sc.nextInt());
		size--;
		}
		preOrder(root);
	}
		break;
	case 2:
	{
		int size = sc.nextInt();
		int[] nums = new int[size];
		for(int i = 0 ; i < size ;i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(method.sortedArrayToBST(nums)));
	}
	break;
	
	case 3:
	{
		Node node =null;
		int size = sc.nextInt();
		while(size>0) {
			node = method.insertNode(node, sc.nextInt());
			size--;
		}
		
		System.out.println(method.minValue(node));
	}
	break;
	}
	sc.close();
}
}
