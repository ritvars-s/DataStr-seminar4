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
	
	public void add(Ttype elem) throws Exception{
		if(isFull()) {
			throw new Exception("Koks ir pilns un nevar vairs pievienot jaunus elementus");
		}
		//koks ir tuk'ss, tad ieliekam primo ka root
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(elem);
			rootNode = newNode;
		}
		else {
			addHelper(rootNode, elem);
		}
		howManyElements++;
		
	}
	
	private void addHelper(MyNode<Ttype> root, Ttype elem) {
		if(root != null) {
			
			if (((Comparable)elem).compareTo(root.getElement()) > 0) {
				addHelper(root.getRightChNode(), elem);
			}
			else {
				addHelper(root.getLeftChNode(), elem);
			}
			//TODO pabeigt
		}
	}
	
	
	
}
