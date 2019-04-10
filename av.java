public class avl{
	node root;

	public avl(){
		root = null;
	}

	public void insert(position p){
		root = insert(p,root);
	}

	public int height(avlnode t){
		if(t == null){return -1;}
		else return t.height;
	}

	public avlnode insert(position p, avlnode t){
		if(t == null){
			t = new avlnode();
			t.position = p;
		}
		else if(p.wi < t.position.wi){
			t.l_child = insert(p,t.l_child);
			t.l_child.parent = t;
			avlnode n = t;
			while(t != null){
				t.height = t.height + 1;
				if(t.parent.height == t.height + 1){
					break;
				}
				else{
					t = t.parent;
				}	
			}
			if(n.left.height - n.right.height)
		}
		else if(p.wi > t.position.wi){
			t.r_child = insert(p,t.r_child);
			t.r_child.parent = t;
			while(t != null){
				t.height = t.height + 1;
				if(t.parent.height == t.height + 1){
					break;
				}
				else{
					t = t.parent;
				}				
			}
		}
	}





}

class avlnode{
	node parent;
	avlnode l_child;
	avlnode r_child;
	Object position;
	int height;

	public avlnode(){
		l_child = null;
		r_child = null;
		height = 0;
		position = null;
	}
}