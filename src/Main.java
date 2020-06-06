import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public
	class Main {

	public static void main(String[] args)
		throws IOException {

		Komuch[] komuches = Komuch.createKomuches("huffman.txt");
		Arrays.sort(komuches);
		BinaryTree tree = HuffmanAlg.execute(komuches);
		System.out.println(tree);
		List<Komuch> list = tree.getPrefixesAsList();
		System.out.println("===== Komuchy =====");
		System.out.println(list);

	}

}
