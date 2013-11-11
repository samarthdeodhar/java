package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		TreeStructure node=null;
		node = bst.insert(node, 10);
		TreeStructure rootNode = node;
		node = bst.insert(node,5);
		node = bst.insert(node, 8);
		node = bst.insert(node, 12);
		node = bst.insert(node, 10);
		node = bst.insert(node, 16);
		node = bst.insert(node, 26);
		
		bst.printTreeLayers(rootNode);
	}

public TreeStructure insert(TreeStructure node, int value){
	if(node==null){
		node = new TreeStructure();
		node.data=value;
		
	}else{
		if(node.data>value){
			node.left =insert(node.left,value);
			
		}else if(node.data<=value){
			node.right=insert(node.right,value);
		}
	}
	return node;
 }

public void printTreeLayers(TreeStructure root){
	
	Queue<TreeStructure> tree = new LinkedList<TreeStructure>();
	tree.add(root);
	
	while(!tree.isEmpty()){
		TreeStructure node = tree.poll();
		System.out.print(node.data +", ");
		if(node.left !=null){
			tree.add(node.left);
		}
		if(node.right !=null){
			tree.add(node.right);
		}
	}
	
	
 }

}


	
class TreeStructure{
	int data;
	TreeStructure left;
	TreeStructure right;
	
}