import java.util.ArrayList;
import java.util.List;

public
	class BinaryTree
		implements Comparable<BinaryTree>{

	Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}



	@Override
	public String toString() {
		return "BinaryTree{" +
				"root=" + root +
				'}';
	}

	@Override
	public int compareTo(BinaryTree o) {
		return root.compareTo(o.root);
	}

	public List<Komuch> getPrefixesAsList(){


		List<Komuch> result = new ArrayList<>();

		preOrder(this.root,result);

		return result;
	}

	public void preOrder(Node node,List<Komuch> list){

		if(node == null)
			return;
		if(node.leftSon == null && node.rightSon == null)
			list.add(node.komuch);

		preOrder(node.leftSon,list);
		preOrder(node.rightSon,list);

	}
}
