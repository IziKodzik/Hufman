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
}
