package service;

import datastr.MyBST;
import model.Patient;

public class MainService {

	public static void main(String[] args) throws Exception {
		MyBST<Integer> bst1 = new MyBST<Integer>();
		try {
			
			bst1.add(10);
			bst1.add(15);
			bst1.add(5);
			bst1.add(6);
			bst1.add(7);
			
			bst1.print();
			System.out.println(bst1.search(10));
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		MyBST<Patient> bst2 = new MyBST<Patient>();
		try {
			System.out.println("Patient");
					
			bst2.add(new Patient("Janis", "Shags", 1));
			bst2.add(new Patient("Liga", "Bome", 3));
			bst2.add(new Patient("Baiba", "Kalnina", 2));
			bst2.add(new Patient("Juris", "Trakais", 5));
			
			bst2.print();
					
					
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
