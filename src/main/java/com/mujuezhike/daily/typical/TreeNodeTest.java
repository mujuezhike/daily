package com.mujuezhike.daily.typical;

public class TreeNodeTest {

	public static void main(String[] args) {
		
		Node n1 = new Node();
		n1.setId(1);
		n1.setName("node1");
		
		Node n2 = new Node();
		n2.setId(2);
		n2.setName("node2");
		n2.setLeftNode(n1);
		
		Node n3 = new Node();
		n3.setId(3);
		n3.setName("node3");
		
		Node n4 = new Node();
		n4.setId(3);
		n4.setName("node3");
		n4.setLeftNode(n2);
		n4.setRightNode(n3);
		
		System.out.println(n1.getLeftNode());
		System.out.println(n2.getLeftNode());
		System.out.println(n3.getLeftNode());
		System.out.println(n4.getLeftNode());
		
	}

}
