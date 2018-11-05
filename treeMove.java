import java.util.List;
import java.util.ArrayList;
class Node {
		int coins;
		List<Node> children;
		Node(int val) {
			this.coins = val;
			this.children = new ArrayList<Node>();
		}
		public void addChild(Node c){
			this.children.add(c);
		}
}
class TreeMove {
	public static int treeMoveStep (Node root){
		if (root == null) return 0;
		if (root.children.size() == 0) return 0;
		int step = 0;
		int coins = root.coins;
		for (Node ch : root.children) {
			step += treeMoveStep(ch);
			if (ch.coins > 1) {
				step += ch.coins - 1;
				root.coins += ch.coins -1;
				ch.coins = 1;
			} else if (ch.coins < 1) {
				step += ((-ch.coins) + 1);
				root.coins -= ((-ch.coins) + 1);
				ch.coins = 1;
			}
		}
		return step;
	}
	
	public static void main(String[] args){
		// sample tree
		/*
			1
		      / |  \
		     0  1   0
		    /
		   3
		*/
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(0);
		n1.addChild(new Node(3));
		Node root = new Node(1);
		root.addChild(n1);
		root.addChild(n2);
		root.addChild(n3);
		//call
		int move = treeMoveStep(root);
		System.out.println(move);
	}

}
