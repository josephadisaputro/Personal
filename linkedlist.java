package fun;
public class linkedlist {
	
	private static node head = null;
	private static node tail = null;
	
	public static void appendFirst(int value){
		node newNode = new node();
		newNode.setNext(null);
		newNode.setValue(value);
		head = newNode;
		tail = newNode;
		
	}
	public static void append(int value){
			node newNode = new node();
			newNode.setNext(head);
			newNode.setValue(value);
			head = newNode;
		
	}
	
	public static void appendLast(int value){
		if(tail != null){
			node newNode = new node();
			newNode.setValue(value);
			newNode.setNext(null);
			tail.setNext(newNode);
			tail = newNode;
		}else{
			System.out.println("no linkedlist");
		}
	}
	
	public static void appendMiddle(int value, int valueB){
		if(head != null){
			node newNode = new node();
			newNode.setValue(value);
			newNode.setNext(null);
			node p = head;
			for(int i = 0; p != null; p = p.getNext()){
				if(p.getValue() == valueB){
					newNode.setNext(p.getNext());
					p.setNext(newNode);
				}
			}
		}
	}
	
	public static void traverse(){
		for(int i = 0; head != null; head = head.getNext()){
			System.out.println("value is " + head.getValue());
		}
	}
	
	public static void deleteFirst(){
		if(head != null){
			head = head.getNext();
		}
	}
	
	public static void deleteLast(){
		if(tail != null){
			node p = head;
			for(int i = 0; p != null; p = p.getNext()){
				if(p.getNext() == tail){
					p.setNext(null);
				}
			}
		}
	}
	
	/*public static void delete(int value){
		if(head != null){
			node p = head;
			for(int i = 0; p != null; p = p.getNext()){
				if((p.getNext()).getValue() == value){
					p.setNext((p.getNext()).getNext());
				}
			}
			
		}
	}*/
	
	public static void main(String[] args){
		appendFirst(14);
		append(13);
		append(12);
		append(11);
		append(10);
		appendLast(100);
		appendMiddle(999, 12);
		deleteFirst();
		deleteLast();
		//delete(12);
		traverse();
	}
}
	