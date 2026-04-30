package datastr;

public class MyBST<Ttype> {
	private MyNode<Ttype> rootNode = null;
	private int howManyElements = 0;
	
	//beazargumenta konstruktors bus no object klases
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	public boolean isEmpty() {
		return (howManyElements == 0);
	}
	
	public boolean isFull() {
		try {
			new MyNode<Character>('A');
			return false;
		}
		catch(OutOfMemoryError error) {
			return true;
		}
	}
	
	
	
	
	
}
