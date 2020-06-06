public
	class Queue {

	Element first,
			last;
	int length;


	public void put(BinaryTree binaryTree) {
//		System.out.println("put in");
		Element ne = new Element();
		ne.tree = binaryTree;
//
//		if(binaryTree.root.komuch.text.equals("WLITVPCAKBQUH"))
//			System.out.println("XD");

		if(first == null){
			first = ne;
			last = ne;

		}else{

			Element iterator = null;
			for(iterator = first; iterator != null ; iterator = iterator.next){

//				System.out.println(iterator + " iter");
				if(binaryTree.compareTo(iterator.tree) < 0){

					ne.next = iterator;
					ne.previous = iterator.previous;
					if(iterator.previous != null) {
						iterator.previous.next = ne;
						iterator.previous = ne;
					}
					if(first == iterator)
						first = ne;
					break;
				}

			}
			if(iterator == null){

				ne.previous = last;
				last.next = ne;
				last = ne;

			}

		}
//
//		System.out.println(ne.previous + " prev");
//		System.out.println(ne + " ne");
//		System.out.println(ne.next + " next");
//		System.out.println(first + " first");
//		System.out.println(last + " last");
		++length;

//		System.out.println("put out");

	}

	public BinaryTree removeFirst() {

		if(length==0)
			return null;
		Element result = first;
		first.previous = null;
		first = first.next;
		--length;
		return result.tree;
	}

	static class Element{
		@Override
		public String toString() {
			return "Element{" +
					"tree=" + tree.root.komuch.text +

					'}';
		}


		BinaryTree tree;
		Element next;
		Element previous;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for(Element iterator = first; iterator != null ; iterator = iterator.next)
			sb.append(iterator.tree.root.komuch).append(", ");

		return "Queue{" +
				"list=" + sb.toString() +
				"; length=" + length +
				'}';
	}

}


