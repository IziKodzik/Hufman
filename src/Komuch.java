import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public
	class Komuch
		implements Comparable<Komuch>{

	int frequency;
	String text;
	String code = "";

	public Komuch(int frequency, String text) {
		this.frequency = frequency;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Komuch{" +
				"frequency=" + frequency +
				", text='" + text + '\'' +
				", code='" + code + '\'' +
				'}';
	}

	public static Komuch[] createKomuches(String path) throws IOException {

		Komuch[] komuches;
		BufferedReader reader = new BufferedReader(new FileReader(path));

		{

			String line = reader.readLine();
			int n = Integer.parseInt(line);
			komuches = new Komuch[n];

			int op = 0;
			for (line = reader.readLine(); line != null; line = reader.readLine()) {

				String[] split = line.split(" ");
				System.out.println(Arrays.toString(split));
				komuches[op] = new Komuch(Integer.parseInt(split[1]),split[0]);
				++op;
			}
		}

		return komuches;

	}


	@Override
	public int compareTo(Komuch o) {
		int result = frequency - o.frequency;
		if(result != 0)
			return result;
		else
			return text.charAt(0) - o.text.charAt(0);

	}

	public Komuch mergeKomuchs(Komuch somsiad){

		return new Komuch(this.frequency + somsiad.frequency, this.text + somsiad.text);

	}
}
