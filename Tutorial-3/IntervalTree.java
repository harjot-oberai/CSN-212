public class IntervalTree{
	IntervalNode root;

	public void insert(IntervalNode node){
		node.setMax(node.getHigh());
		if(root==null){
			root=node;
			root.setLeftChild(null);
			root.setRightChild(null);
			return;
		}
		IntervalNode current=root;
		while(true){
			current.setMax(maxi(current.getMax(), node.getMax()));
			if(node.getLow() <= current.getLow()){
				if(current.getLeftChild() !=null){ 
					current=current.getLeftChild();
				}
				else{
					current.setLeftChild(node);
					break;
				}
			}
			else{
				if(current.getRightChild()!=null){ 
					current=current.getRightChild();
				}
				else{
					current.setRightChild(node);
					break;
				}
			}
		}
	}


	boolean check(IntervalNode node1, IntervalNode node2){
		if(node1.getLow()==node2.getLow() && node1.getHigh()==node2.getHigh()){
			return true;
		}
		return false;
	}

	void change(IntervalNode node1, IntervalNode node2){
		node1.setLow(node2.getLow());
		node1.setHigh(node2.getHigh());
	}

	int maxi(int a, int b){
		return (a>b)?a:b;
	}

	void remove(IntervalNode current, IntervalNode parent, boolean isRoot){
		int child=0;
		boolean left=false, right=false;
		if(current.getLow() <= parent.getLow()){
		 	left=true;
		}
		else {
			right=true;
		}

		if(current.getLeftChild() !=null ) child++;
		if(current.getRightChild() !=null) child++;
		
		if(child==0){
			if(isRoot){
				parent=null;
				return;
			}
			if(left) parent.setLeftChild(null);
			else parent.setRightChild(null);
		}
		else if(child==1){
			if(isRoot){
				if(current.getLeftChild()!=null) root=root.getLeftChild();
				else root=root.getRightChild();
				return;
			}
			if(left){
				if(current.getRightChild()!=null) parent.setLeftChild(current.getRightChild());
				else parent.setLeftChild(current.getLeftChild());
			}
			else{
				if(current.getRightChild() !=null) parent.setRightChild(current.getRightChild());
				else parent.setRightChild(current.getLeftChild());
			}
		}
		else{
			IntervalNode temp=current;
			temp=temp.getLeftChild();
			if(temp.getRightChild()!=null){
				while(temp.getRightChild()!=null){
					parent=temp;
					temp=temp.getRightChild();
				}
				change(current, temp);
				parent.setRightChild(null);
			}
			else{
				change(current, temp);
				remove(temp, current, false);
			}
		}
	}

	void deleteInterval(IntervalNode tempNode){
		IntervalNode current=root;
		IntervalNode parent=root;
		//eleminate the case when we have to delete the root node itself
		//take care of that later
		while(true){
			if(current==null){
				System.out.println("Interval not found! \n");
				break;
			}
			if(tempNode.getLow() < current.getLow()){
				parent=current; current=current.getLeftChild();
			}
			else if(tempNode.getLow() > current.getLow()){
				parent=current; current=current.getRightChild();
			}
			else{
				remove(current, parent, false);
				break;
			}
		}
	}

	void show(IntervalNode current){
		if(current==null) return;
		show(current.getLeftChild());
		System.out.println(current.getLow() + " ");
		show(current.getRightChild());
	}

	IntervalNode search(IntervalNode tempNode){
		IntervalNode current=root;
		while(true){
			if(current==null){
				System.out.println("No overlap found\n");
				return null;
			}
			if((tempNode.getLow() <= current.getHigh()) && (tempNode.getHigh() >= current.getLow())){
				System.out.println("An overlapping node found.\n");
				return current;
			}
			if(current.getLeftChild() !=null){
				if(current.getLeftChild().getMax() >= tempNode.getLow()) current=current.getLeftChild();
			}
			else if(current.getRightChild()!=null){
				if(current.getRightChild().getMax() >= tempNode.getLow()) current=current.getRightChild();
			}
			else{
				System.out.println("No overlap found\n");
				return null;
			}

		}
	}


}