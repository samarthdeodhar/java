package datastructures;

import java.util.ArrayList;

public class stackUsingArrayList<E> extends ArrayList<E> {

	public static final long serialID=1L;
		
	public E pop(){
		E e = get(size()-1);
		remove(size()-1);
		return e;
	}
	
	public void push(E e){
		add(e);
	}
}

