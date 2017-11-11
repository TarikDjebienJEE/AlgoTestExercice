package exercice4;

import java.util.ArrayList;
import java.util.List;

public class Tree<E> {
	
	private E root;
	private int numberOfChild;
	private int sum;
	private float average;
	private List<Tree<E>> childs;
	
	public Tree(E rootValue){
		super();
		this.root = rootValue;
		this.numberOfChild = 0;
		this.sum = 0;
		this.average = 0;
		this.childs = new ArrayList<Tree<E>>();
	}
	
	public Tree<E> addChild(E value) {
		Tree<E> child = new Tree<E>(value);
		this.childs.add(child);
		return child;
	}
	
	private boolean hasChildren() {
		return !this.childs.isEmpty();
	}
	
	private float getAverage(Tree<E> t) {
		if (t.numberOfChild != 0) {
			t.average = (float) t.sum / (float) t.numberOfChild;
		}
		return average;
	}
	
	private int getSum(Tree<E> e) {
		int result = 0;
		if(isNumber(e.root.toString())) {
			if(e.hasChildren()) {
				for(Tree<E> child : e.childs) {
					if(isNumber(child.root.toString())) {
						result += Integer.parseInt(child.root.toString()) + getSum(child);
					}
				}
			}
		}
		return result;
	}
	
	private int countChild(Tree<E> e) {
		int result = 0;
		if(isNumber(e.root.toString())) {
			if(e.hasChildren()) {
				for(Tree<E> child : e.childs) {
					if(isNumber(child.root.toString())) {
						result += 1 + countChild(child);
					}
				}
			}
		}
		return result;
	}

	private boolean isNumber(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	public String algo(Tree<E> e) {
		String result = "";
		if(isNumber(e.root.toString())) {
			if(e.hasChildren()) {
				for(Tree<E> child : e.childs) {
					if(isNumber(child.root.toString())) {
						result += algo(child);
					}
				}
			}
			e.numberOfChild = countChild(e);
			e.sum = getSum(e);
			e.average = e.getAverage(e);
			result += "Le noeud avec la valeur "+e.root.toString()+" ";
			if (e.numberOfChild > 0) {
				result += "a "+e.numberOfChild+" enfant(s), la somme est "+e.sum+" et la moyenne est "+e.average+".\n";
			} else {
				result += "n'a pas d'enfant.\n";
			}
		}
		return result;
	}
	
	/**
	 * 			
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 *  			  9
         *             /     \
         *         12          A
       	 *      /  /  \      /   \
    	 *     D  C    2    8    99
         *                 /
         *                89
		 */
		Tree<String> neuf = new Tree<String>("9");
		
		Tree<String> douze = neuf.addChild("12");
		douze.addChild("D");
		douze.addChild("C");
		douze.addChild("2");
		
		Tree<String> A = neuf.addChild("A");
		A.addChild("8").addChild("89");
		A.addChild("99");
		
		System.out.println(neuf.algo(neuf));
	}
}
