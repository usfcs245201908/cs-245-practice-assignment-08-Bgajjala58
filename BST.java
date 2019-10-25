public class BST<T extends Comparable<T>>{

public Node insert(T tocheck, Node node){
	if(node==null){
		return new Node(tocheck);
	}	

	if(node.getData().compareTo(tocheck) < 0){
		node.setRight(insert(tocheck, node.right));
	}
		node.setLeft(insert(tocheck, node.left));

			return node;
}


public boolean find(T tocheck){
	return find(tocheck,root);
}


public Node delete(Node root, T tocheck) { 
	if (root == null){
		return root;
	}

	if (tocheck.compareTo(root.getData()) < 0){
		root.setLeft(delete(root.left, tocheck));
	} 
	if (tocheck.compareTo(root.getData()) > 0){
		root.setRight(delete(root.right,tocheck));
	} 

	if (root.left == null){
		return root.right;
	} 

	if (root.right == null){
		return root.left;
	}

	root.tocheck = min(root.right); 
	root.right = delete(root.right, root.getData()); 
	 
	return root; 
} 


public boolean find(T tocheck, Node node){
	if(node==null){
		return false;
	}
	if(node.getData().compareTo(tocheck) == 0){
		return true;
	}
	if(node.getData().compareTo(tocheck) < 0){

		return find(tocheck, node.right);
	}

	return find(tocheck, node.left);

}

public void insert(T tocheck){
	root = insert(tocheck,root);
}	





public void print(Node node){

	if(node==null){
		return;
	}
	print(node.left);
	System.out.println(node.getData());
	print(node.right);
}


public void print(){
	print(root);
}




public void delete(T tocheck){

	root = delete(root, tocheck); 
} 




public T min(Node root) { 
	T value = root.getData(); 
	while (root.left != null) { 

		value = root.left.getData(); 
		root = root.left; 
	} 
	return value; 
} 



class Node {
	Node right;
	Node left;
	T tocheck;
	Node(T tocheck){

		this.tocheck = tocheck;


	}



	void setRight(Node right) {

		this.right = right;

	}
	void setLeft(Node left) {

		this.left = left;
	}

	T getData(){
		return this.tocheck;
	}
}
Node root;


}