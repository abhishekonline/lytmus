package symantec;

import java.io.File;

public class DirectoryTraversal {
	public static void displayIt(File node) {

		System.out.println(node.getAbsoluteFile());

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				displayIt(new File(node, filename));
			}
		}

	}

	public static void main(String args[]) {
		displayIt(new File("d://"));
	}
}
