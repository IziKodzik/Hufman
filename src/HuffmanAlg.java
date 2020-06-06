public
	class HuffmanAlg {

	static public BinaryTree execute(Komuch[] komuches){

		Queue q = prepareKomuchs(komuches);
		System.out.println(q);

		System.out.println("============================");

		while(q.length > 1){

			BinaryTree treeF = q.removeFirst();
//			System.out.println(q + " first delete\n\n\n");
			BinaryTree treeS = q.removeFirst();
//			System.out.println(q + " second delete\n\n\n");

			Komuch merged = treeF.root.komuch.mergeKomuchs(treeS.root.komuch);

			System.out.println(treeF.root.komuch.text + " First " + treeF.root.komuch.frequency);
			System.out.println(treeS.root.komuch.text + " Second " + treeS.root.komuch.frequency);
			System.out.println(merged.text + " merged " + merged.frequency);
			System.out.println("\n\n");

			BinaryTree treeN = new BinaryTree(new Node(merged));
			treeN.root.leftSon = treeF.root;
			treeF.root.addAsLeft(treeN.root);
			treeN.root.rightSon = treeS.root;
			treeS.root.addAsRight(treeN.root);
			q.put(treeN);
			System.out.println(q);
			System.out.println("================================================\n\n");

		}

		return q.first.tree;
	}

	private static Queue prepareKomuchs(Komuch[] komuches) {
		Queue q = new Queue();

		for ( Komuch k : komuches
			 ) {

			BinaryTree t = new BinaryTree(new Node(k));
			q.put(t);
		}
		return q;
	}

}
