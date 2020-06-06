public
	class Node
		implements Comparable<Node>{


	Komuch komuch;
	Node leftSon;
	Node rightSon;

	@Override
	public String toString() {
		return "Node{" +
				"komuch=" + komuch +
				", leftSon=" + leftSon +
				", rightSon=" + rightSon +
				'}';
	}

	public Node(Komuch k){
		komuch = k;
	}

	public void addSon(Node node){

		if(leftSon == null)
			leftSon = node;
		else if(rightSon == null)
			rightSon = node;

		System.out.println("I am full");
		leftSon.addSon(node);

	}

	public void addAsLeft(Node parent){

		this.komuch.code = addToBeginning(this.komuch.code,"0");

		parent.leftSon = this;
		if(this.leftSon != null)
			this.leftSon.leftSon.addAsLeft(this);

	}

	public void addAsRight(Node parent){

		this.komuch.code = addToBeginning(this.komuch.code,"1");

		parent.rightSon = this;
		if(rightSon != null)
			rightSon.rightSon.addAsRight(this);

	}

	@Override
	public int compareTo(Node o) {
		return komuch.compareTo(o.komuch);
	}

	private static String addToBeginning(String code,String smal){

		return smal + code;


	}

}
