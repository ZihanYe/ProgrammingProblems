// source: https://www.careercup.com/question?id=5709428993556480
// print binary tree nodes column wise and row wise
/*
for example: given root of the following tree:
	6
      /   \
     9     4
    / \     \
   5   1     3
    \       /
output: 5 9 0 6 1 4 7 3
*/

// Utility function to store vertical order in map 'm' 
    // 'hd' is horizontal distance of current node from root. 
    // 'hd' is initially passed as 0 
    static void getVerticalOrder(Node root, int hd, 
                                TreeMap<Integer,Vector<Integer>> m) 
    { 
        // Base case 
        if(root == null) 
            return; 
          
        //get the vector list at 'hd' 
        Vector<Integer> get =  m.get(hd); 
          
        // Store current node in map 'm' 
        if(get == null) 
        { 
            get = new Vector<>(); 
            get.add(root.key); 
        } 
        else
            get.add(root.key); 
          
        m.put(hd, get); 
          
        // Store nodes in left subtree 
        getVerticalOrder(root.left, hd-1, m); 
          
        // Store nodes in right subtree 
        getVerticalOrder(root.right, hd+1, m); 
    } 
      
    // The main function to print vertical oder of a binary tree 
    // with given root 
    static void printVerticalOrder(Node root) 
    { 
        // Create a map and store vertical oder in map using 
        // function getVerticalOrder() 
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>(); 
        int hd =0; 
        getVerticalOrder(root,hd,m); 
          
        // Traverse the map and print nodes at every horigontal 
        // distance (hd) 
        for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
    }
