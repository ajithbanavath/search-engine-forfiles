class AVLNode{    
     AVLNode left, right;
     String we;
     int woi;
     int height;
 
     /* Constructor */
     public AVLNode() {
         left = null;
         right = null;
         we = null;
         woi = 0;        
         height = 0;
     }
     /* Constructor */
     public AVLNode(String n) {
         left = null;
         right = null;
         we = n;
         woi = 0;
         height = 0;
     }     
 }
 
 /* Class AVLTree */
 class AVL{
      AVLNode root;     
 
     /* Constructor */
     public AVL(){
         root = null;
     }

     /* Function to check if tree is empty */
     public boolean isEmpty(){
         return root == null;
     }

     /* Make the tree logically empty */
     public void makeEmpty(){
         root = null;
     }

     /* Function to insert data */
     public void insert(String n, int i){
         root = insert(n, root, i);
     }

     /* Function to get height of node */
     private int height(AVLNode t ){
         return t == null ? -1 : t.height;
     }

     /* Function to max of left/right node */
     private int max(int lhs, int rhs){
         return lhs > rhs ? lhs : rhs;
     }

     /* Function to insert data recursively */
     private AVLNode insert(String n, AVLNode t, int i){
         if (t == null){
            t = new AVLNode(n);
            t.woi = i;
        }

         else if (i < t.woi){
             t.left = insert( n, t.left,i );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( i < t.left.woi )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( i > t.woi ){
             t.right = insert( n, t.right,i );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( i > t.right.woi)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */     
     private AVLNode rotateWithLeftChild(AVLNode k2){
         AVLNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private AVLNode rotateWithRightChild(AVLNode k1){
         AVLNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private AVLNode doubleWithLeftChild(AVLNode k3){
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private AVLNode doubleWithRightChild(AVLNode k1){
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }    

     /* Functions to count number of nodes */
     public int countNodes(){
         return countNodes(root);
     }

     private int countNodes(AVLNode r){
         if (r == null)
             return 0;
         else{
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }

     /* Functions to search for an element */
     public boolean search(int n){
         return search(root, n);
     }

     private boolean search(AVLNode r, int n){
         boolean found = false;
         while ((r != null) && !found){
             int rval = r.woi;
             if (n < rval)
                 r = r.left;
             else if (n > rval)
                 r = r.right;
             else{
                 found = true;
                 break;
             }
             found = search(r, n);
         }
         return found;
     }

     public AVLNode returnNode(int n){
        return returnNode(root,n);
     }

     private AVLNode returnNode(AVLNode r, int n){
        AVLNode h = null;
        boolean found = false;
        while((r != null) && !found){
            int rval = r.woi;
            if(n < rval)
                r = r.left;
            else if(n > rval)
                r = r.right;
            else{
                found = true;
                h = r;
                break;
            }
            h = returnNode(r,n);
        }
        return h;
     }
}     