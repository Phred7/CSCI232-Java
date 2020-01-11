package projectII;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import labVIII.Queue;


public class BSUMSUNode<Key extends Comparable<Key>, Value> {
	
	private MSUClassNode root;
	
	private class MSUClassNode {
    	
    	private String title;
    	private String classID;
    	private int numSeats;
    	private int numSections;
    	//private String[] keys = new String[3];
    	private Key key;
    	private Value val;
    	private boolean lecture;
    	
    	private MSUClassNode left, right;
    	private int size;
    	
    	public MSUClassNode (Key key, Value value, int size){
    		this.key = key;
    		this.val = value;
    		this.size = size;
    		
    		String val = value.toString();
    		String[] vals = new String[4];
    		Scanner valScan = new Scanner(val);
    		valScan.useDelimiter("_");
    		int i = 0;
    		while(valScan.hasNext()) {
    			vals[i] = valScan.next();
    			i++;
    		}
    		
    		this.classID = vals[0];
    		this.title = vals[1];
    		this.numSections = Integer.valueOf(vals[2]);
    		this.numSeats = Integer.valueOf(vals[3]);
    	}
    	
    	public Key getKey() {
    		return this.key;
    	}
    	
    	public Value getValue() {
			return this.val;
    	}
    	
    	public Value updateValue() {
    		String vals = (this.classID + "_" + this.title + "_" + String.valueOf(this.numSections) + "_" + String.valueOf(this.numSeats));
    		this.val = (Value) vals;
    		return this.val;
    	}
    	
    	public Value addSection(int newSeats) {
    		this.numSections++;
    		this.numSeats += newSeats;
    		return updateValue();
    	}
    }
	
	public BSUMSUNode() {
		
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return size(root);
	}
	
	public int size(MSUClassNode x) {
		if(x == null) {
			return 0;
		}else {
			return x.size;	
		}		
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(MSUClassNode x, Key key) {
		if(key == null) {
			throw new IllegalArgumentException("calls get() with a null key");
		}
		if(x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if		 (cmp < 0) {
			return get(x.left, key);
		}else if (cmp > 0) {
			return get(x.right, key);
		}else {
			return x.val;
		}
	}
	
	public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
	
	public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert check();
    }

	/**
	 * Modified put(Node, Key, Value) method for this Binary Search Tree. 
	 * Utilizes the MSUClassNode as tree elements. 
	 * Modifications to this put:
	 * 		When keys match the value of the key already in the tree is incrimented by 1 for its number of sections and the avalible seats is incrimented by the value sent in
	 * 
	 * 
	 * @param x node already in this tree
	 * @param key key of the node that is going to be added
	 * @param val value associated with the above key
	 * @return a parent (regular, grand and so on until the root) of the inserted key recursively returned until the root is reached and upfated
	 */
    private MSUClassNode put(MSUClassNode x, Key key, Value val) {
        if (x == null) {
        	return new MSUClassNode(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) {
        	x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
        	x.right = put(x.right, key, val);
        } else {
        	String value = val.toString();
    		String[] vals = new String[4];
			Scanner valScan = new Scanner(value);
    		valScan.useDelimiter("_");
    		int i = 0;
    		while(valScan.hasNext()) {
    			vals[i] = valScan.next();
    			i++;
    		}
        	x.addSection(Integer.valueOf(vals[3]));
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private MSUClassNode deleteMin(MSUClassNode x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert check();
    }

    private MSUClassNode deleteMax(MSUClassNode x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public void delete(Key key) {
    	if(key == null) {
    		throw new IllegalArgumentException("calls delete() with null key");
    	}
    	root = delete(root, key);
    	assert check();
    }
    
    private MSUClassNode delete(MSUClassNode x, Key key) {
    	if(x == null) {
    		return null;
    	}
    	
    	int cmp = key.compareTo(x.key);
    	if		(cmp < 0) {
    		x.left = delete(x.left, key);
    	}else if(cmp > 0) {
    		x.right = delete(x.right, key);
    	}else {
    		if(x.right == null) {
    			return x.left;
    		}
    		if(x.left == null) {
    			return x.right;
    		}
    		MSUClassNode t = x;
    		x = min(t.right);
    		x.right = deleteMin(t.right);
    		x.left = t.left;
    	}
    	x.size = size(x.left) + size(x.right)+ 1;
    	return x;
    }
    
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private MSUClassNode min(MSUClassNode x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 

    private MSUClassNode max(MSUClassNode x) {
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        MSUClassNode x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private MSUClassNode floor(MSUClassNode x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        MSUClassNode t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 

    public Key floor2(Key key) {
        return floor2(root, key, null);
    }

    private Key floor2(MSUClassNode x, Key key, Key best) {
        if (x == null) return best;
        int cmp = key.compareTo(x.key);
        if      (cmp  < 0) return floor2(x.left, key, best);
        else if (cmp  > 0) return floor2(x.right, key, x.key);
        else               return x.key;
    }
    
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        MSUClassNode x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private MSUClassNode ceiling(MSUClassNode x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
        	MSUClassNode t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 
    
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        MSUClassNode x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private MSUClassNode select(MSUClassNode x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    private int rank(Key key, MSUClassNode x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 
    
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(MSUClassNode x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }

    public int height() {
        return height(root);
    }
    private int height(MSUClassNode x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<MSUClassNode> queue = new Queue<MSUClassNode>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
        	MSUClassNode x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

  /*************************************************************************
    *  Check integrity of BST data structure.
    ***************************************************************************/
    private boolean check() {
        if (!isBST())            System.out.println("Not in symmetric order");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
        if (!isRankConsistent()) System.out.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(MSUClassNode x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(MSUClassNode x) {
        if (x == null) return true;
        if (x.size != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }
    
    /**
     *  This method prints this tree using the logic behind Depth First Traversal of trees
     *  *NOTE: This method is an implementation of the InOrder variation DepthFirstTraversal*
     *   
     *  Recursive method that calls an overloaded variation of itself to print the contents of this tree
     *  Since it is a recursive method it utilized the call stack as a data structure to order the prints of the key value pairs in the tree
     *  
     *  Logic:
     *  The root can be found in the middle of the tree. All left children will be above the root in the prints and all right children will be below
     *  So, by that same principal the left most element ie, the left most child of every node in the tree will be the first node to be printed
     *  Every node that has a child or children will have every left child above itself and every right child below it    *  
     * 
     */
    public void DepthFirstTraversal() {
    	System.out.println("DepthFirstTraversal: In Order\n");
    	System.out.printf("ID\t\tTitle\t\t\t\t\tSects\tSeats\tWhen\n");
    	//left first onto stack so...
    	if(root.left != null) {
    		DepthFirstTraversal(root.left);
    	}
    	
    	System.out.printf("%s\t%-35s\t%d\t%d\t%-45s\n",root.classID, root.title, root.numSections, root.numSeats, root.key);
    	
    	if(root.right != null) {
    		DepthFirstTraversal(root.right);
    	}
    	
    }
    
    /**
     * See above method
     * 
     * @param node A node of type MSUClassNode, an element, that can be found in this tree
     */
    private void DepthFirstTraversal(MSUClassNode node) {
    	if(node.left != null) {
    		DepthFirstTraversal(node.left);
    		
    	}
    	
    	System.out.printf("%s\t%-35s\t%d\t%d\t%-45s\n",node.classID, node.title, node.numSections, node.numSeats, node.key);
    	
    	if(node.right != null) {
    		DepthFirstTraversal(node.right);
    		
    	}
    }
    
    
    /**
     * This method prints this tree utilizing the logic behind BreadthFirstTraversal of trees
     * 
     * This method utilized a queue as a data structure to arrange the printed nodes in a logical manner
     * 
     * Logic:
     * Starting at the root each element is enqueued into the queue when parent of that node is dequeued. Left children of the parent are queued before right children
     * When a node is dequeued its key and values are printed
     * Once there are no more keys in the queue this print statement has completed
     * 
     * BredthFirstTraversal 
     * 
     */
    public void BreadthFirstTraversal() {
    	System.out.println("BreadthFirstTraversal\n");
    	System.out.printf("ID\t\tTitle\t\t\t\t\tSects\tSeats\tWhen\n");
    	Queue<MSUClassNode> queue = new Queue<MSUClassNode>();
    	queue.enqueue(this.root);
    	while(!queue.isEmpty()) {
    		MSUClassNode node = queue.dequeue();
    		System.out.printf("%s\t%-35s\t%d\t%d\t%-45s\n",node.classID, node.title, node.numSections, node.numSeats, node.key);
    		if(node.left != null) {
    			queue.enqueue(node.left);
    		}
        	
    		if(node.right != null) {
    			queue.enqueue(node.right);
    		}
        	
    	}
    }
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException { 
        BSUMSUNode<String, String> st = 
                new BSUMSUNode<String, String>();
        
        File file = new File(args[0]);
        
        BufferedReader reader;
        
        try {
        	reader = new BufferedReader(new FileReader(file));
        
            String line = reader.readLine();
            String[] lineElems;
            int i = 0;
            
            /**
             * For each line in the file check to see if its null and if not execute the following:
             * 
             * Split the line into a String array
             * Check to see if the class in this line is a Lecture. If not skip this line and move on
             * 		If it is a lecture put the key value pair associated with it into this tree
             * 			Then check to make sure everything in the tree is properly ordered and to see if this tree is a valid tree
             * Finally print the tree out when there are no more lines to be parsed within the input file
             */
        	while(line != null) {
        		lineElems = line.split(",");
        		
        		if((lineElems[13].charAt(0) == 'L' && lineElems[13].charAt(1) == 'a') || (lineElems[14].charAt(0) == 'L' && lineElems[14].charAt(1) == 'a')) {
        			//System.out.println("Lab omitted");
        		}else if((lineElems[13].charAt(0) == 'R' && lineElems[13].charAt(1) == 'e') || (lineElems[14].charAt(0) == 'R' && lineElems[14].charAt(1) == 'e')) {
        			//System.out.println("Recitation omitted");
        		}else {
        			
        			String key = (lineElems[15] + "_" + lineElems[16]);
            		String value = (lineElems[1] + "_" + lineElems[2] + "_1_" + lineElems[4]);

            		if ((st.size() > 1) && (st.floor(key) != st.floor2(key)))
                        throw new RuntimeException("floor() function inconsistent");

            		st.put(key, value);

        		}
        		line = reader.readLine();
        		i++;
        	}
        	reader.close();
        } catch(IOException e) {
        	e.printStackTrace();
        }
        
        st.BreadthFirstTraversal();
        System.out.println("\n");
        st.DepthFirstTraversal();
	}

}
