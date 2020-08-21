package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextFiltring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> abusiveText = new ArrayList<>(Arrays.asList("dog", "idiot", "shit", "dumb"));

		String input = sc.nextLine();

		String output = textFiltring(abusiveText, input);

		System.out.println(output);
	}

	public static String textFiltring(ArrayList<String> abusiveText, String input) {
		String[] inputList = input.split("\\s+|,\\s*|\\.\\s*");

		for (int i = 0; i < inputList.length; i++) {
			if (abusiveText.contains(inputList[i].toLowerCase())) {
				String hash = "";
				for (int j = 0; j < inputList[i].length(); j++)
					hash += '#';

				inputList[i] = hash;
			}
		}

		String res = String.join(" ", inputList);

		return res;
	}

}
