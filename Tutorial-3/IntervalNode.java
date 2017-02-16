public class IntervalNode {
	int low, high;
	int max;
	IntervalNode leftChild;
	IntervalNode rightChild;

	public int getLow(){
		return low;
	}

	public void setLow(int low){
		this.low = low;
	}

	public int getHigh(){
		return high;
	}

	public void setHigh(int high){
		this.high = high;
	}

	public int getMax(){
		return max;
	}

	public void setMax(int max){
		this.max = max;
	}

	public IntervalNode getLeftChild(){
		return leftChild;
	}

	public void setLeftChild(IntervalNode leftChild){
		this.leftChild = leftChild;
	}

	public IntervalNode getRightChild(){
		return rightChild;
	}

	public void setRightChild(IntervalNode rightChild){
		this.rightChild = rightChild;
	}

}