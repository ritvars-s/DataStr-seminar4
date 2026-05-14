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
	
	private void addHelper(MyNode<Ttype> nodeTemp, Ttype elem) {
		if(nodeTemp != null) {
			
			if (((Comparable)elem).compareTo(nodeTemp.getElement()) > 0) { //novietosies pa labi
				//ja laba puse neka nav
				if(nodeTemp.getRightChNode() == null) {
					MyNode<Ttype> newNode = new MyNode<Ttype>(elem);
					newNode.setParentNode(nodeTemp);
					nodeTemp.setRightChNode(newNode);
				}
				else {
					addHelper(nodeTemp.getRightChNode(), elem);
				}
			}
			
			else {//novietosies pa kreisi
				//ja kreisa puse neka nav
				if(nodeTemp.getLeftChNode() == null) {
					MyNode<Ttype> newNode = new MyNode<Ttype>(elem);
					newNode.setParentNode(nodeTemp);
					nodeTemp.setLeftChNode(newNode);
				}
				else {
					addHelper(nodeTemp.getLeftChNode(), elem);
				}	
			}
		}
	}
	
	public void print() throws Exception {
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša un to nevar izprintēt");
		}

		printHelper(rootNode);
	}

	private void printHelper(MyNode<Ttype> nodeTemp) {
		if (nodeTemp != null) {
			System.out.println("P: " + nodeTemp.getElement());
			// noskaidrojam, vai eksiste kreisais bērns
			if (nodeTemp.getLeftChNode() != null) {
				System.out.println(
						"P: " + nodeTemp.getElement() + " Left child: " + nodeTemp.getLeftChNode().getElement());
				// izpildi so pasu funkciju uz kreiso bērnu
				printHelper(nodeTemp.getLeftChNode());
			}
			// noskaidrojam, vai eksistē labais bērns
			if (nodeTemp.getRightChNode() != null) {
				System.out.println(
						"P: " + nodeTemp.getElement() + " Right child: " + nodeTemp.getRightChNode().getElement());
				printHelper(nodeTemp.getRightChNode());
			}
		}
	}
	
	public boolean search(Ttype elem) throws Exception{
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša un to nevar izprintēt");
		}
		
		return searchHelper(rootNode, elem);
	}
	
	private boolean searchHelper(MyNode<Ttype> nodeTemp, Ttype elem) {
		if(nodeTemp != null) {
			//ja sakrit tad atgriezam ka ir atrasts
			if(nodeTemp.getElement().equals(elem)) {
				return true;
			}
			//turpina meklet
			else {
				//meklesana notiks pa labo pusi
				if(((Comparable)elem).compareTo(nodeTemp.getElement()) > 0) {
					//parbauda vai eksisste labais node
					if (nodeTemp.getRightChNode() == null) {
						return false;
					}
					// ja eksiste turpia na iteraciju
					else {
						return searchHelper(nodeTemp.getRightChNode(), elem);
					}
				}
				else {
					if (nodeTemp.getLeftChNode() == null) {
						return false;
					}
					else {
						return searchHelper(nodeTemp.getLeftChNode(), elem);
					}	
				}	
			}
		}
		return false;
	}
	
	public void remove(Ttype elem) throws Exception{
		if (isEmpty()) {
			throw new Exception("Kaudze ir tukša");
		}
	}
	
	private void removeHelper(MyNode<Ttype> nodeTemp, Ttype elem) throws Exception{
		if(nodeTemp != null) {
			//ja sakrit tad atgriezam ka ir atrasts
			if(nodeTemp.getElement().equals(elem)) {
				//varianti
				//ja nav berni
				if(nodeTemp.getLeftChNode() == null && nodeTemp.getRightChNode() == null) {
					MyNode<Ttype> parentNode = nodeTemp.getParentNode();
					//ja dzesamais elem ir lielaks par savu vecaku, tad tas ir labais berns
					if(((Comparable)nodeTemp.getElement()).compareTo(parentNode.getElement()) > 0) {
						parentNode.setRightChNode(null);
					}
					//ja ne tad tad ir kreisais
					else {
						parentNode.setLeftChNode(null);
					}
				}
				//ja ir berni
				//ja ir tikai kreisais berns
				else if(nodeTemp.getLeftChNode() != null && nodeTemp.getRightChNode() == null) {
					MyNode<Ttype> parentNode = nodeTemp.getParentNode();
					MyNode<Ttype> leftChNode = nodeTemp.getRightChNode();
					//ja dzesamais elem ir lielaks par savu vecaku, tad tas ir labais berns
					if(((Comparable)nodeTemp.getElement()).compareTo(parentNode.getElement()) > 0) {
						parentNode.setRightChNode(leftChNode);
						leftChNode.setParentNode(parentNode);
					}
					//ja ne tad tad ir kreisais
					else {
						parentNode.setLeftChNode(leftChNode);
						leftChNode.setParentNode(parentNode);
					}
				}
				//ja ir tikai labais berns
				else if(nodeTemp.getLeftChNode() == null && nodeTemp.getRightChNode() != null) {
					MyNode<Ttype> parentNode = nodeTemp.getParentNode();
					MyNode<Ttype> rightChNode = nodeTemp.getRightChNode();
					//ja dzesamais elem ir lielaks par savu vecaku, tad tas ir labais berns
					if(((Comparable)nodeTemp.getElement()).compareTo(parentNode.getElement()) > 0) {
						parentNode.setRightChNode(rightChNode);
						rightChNode.setParentNode(parentNode);
					}
					//ja ne tad tad ir kreisais
					else {
						parentNode.setLeftChNode(rightChNode);
						rightChNode.setParentNode(parentNode);
					}
				}
				//ir abi berni
				else {
					//TODO uztaisit tuvaka elementa atrasanas algoritmu lai to ievietotu dzesamaja elementa
					//TODO notestet dzesanu mainservice
					
				}
				
			}
				
				
			//turpina meklet
		else {
			//meklesana notiks pa labo pusi
			if(((Comparable)elem).compareTo(nodeTemp.getElement()) > 0) {
				//parbauda vai eksisste labais node
				if (nodeTemp.getRightChNode() != null) {
					removeHelper(nodeTemp.getRightChNode(), elem);
				}
			}
				// ja eksiste turpina pa kreiso pusi
			else {
					if (nodeTemp.getLeftChNode() != null) {
						removeHelper(nodeTemp.getLeftChNode(), elem);
					}
			}
		}
		}
	}
	
	
	
}
