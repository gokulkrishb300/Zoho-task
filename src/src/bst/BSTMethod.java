package bst;

import java.util.ArrayList;
import java.util.List;

class  Node {
	int data;
	Node left;
	Node right;
	Node(int value)
	{
		this.data=value;
	}
}


public class BSTMethod {
	
	public Node insertNode(Node node , int value) {
		if(node == null) {
			return new Node(value);
		}
		if(value < node.data) {
			node.left = insertNode(node.left,value);
		} else {
			node.right = insertNode(node.right,value);
		}
		return node;
	}
	
	List<Integer> list = new ArrayList<>();
	
	private Node sortedToBST(int[] arr,int start ,int end) {
		
		if(start>end) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(arr[mid]);
		
		node.left = sortedToBST(arr,start,mid-1);
		node.right = sortedToBST(arr,mid+1,end);
		return node;
	}
	
	private void preOrder(Node node) {
		if(node==null) {
			return;
		}
		list.add(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	 public int[] sortedArrayToBST(int[] nums) {
		 
		 int length = nums.length;
		 Node node = null;
		 node = sortedToBST(nums,0,length-1);
		 preOrder(node);
		 
		 int temp[] = new int[list.size()];
		 for(int i = 0 ; i < list.size() ;i++) {
			 temp[i] = list.get(i);
		 }
		 return temp;
	 }
	 
	 public int minValue(Node node) {
		 if(node == null) {
			 return -1;
		 }
		 if(node.left==null) {
			 return node.data;
		 }
			 return minValue(node.left);
		 
	 }
	 
}
