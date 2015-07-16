package Experiment;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ListPlaying {
	public static void main(String args[]){
		List<List<String>> a= new ArrayList<List<String>>();
		ArrayList<String> bom= new ArrayList<String>();
		bom.add("abhishek");
				a.add(new ArrayList<String>());
				a.add(bom);
				
		File f= new File("lolwa");
		
		
		try {
			FileOutputStream fo = new FileOutputStream(f);
			ObjectOutputStream oos= new ObjectOutputStream(fo);
			oos.writeObject(a);
			System.out.println("written");
			FileInputStream fi= new FileInputStream("lolwa");
			ObjectInputStream oi= new ObjectInputStream(fi);
			List<List<String>> ab=null;
			ab=(List<List<String>>) oi.readObject();
			System.out.println(ab);
			oi.close();
			fi.close();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
