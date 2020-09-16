package structures;

public class NodeAVL<T> {
	private T data;
	private int height; 
	private int size; 
	private NodeAVL<T> left, rigth;

	public NodeAVL(T data, int height, int size) {
		this.data = data;
		this.size = size;
		this.height = height;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public NodeAVL<T> getLeft() {
		return left;
	}

	public void setLeft(NodeAVL<T> left) {
		this.left = left;
	}

	public NodeAVL<T> getRigth() {
		return rigth;
	}

	public void setRigth(NodeAVL<T> rigth) {
		this.rigth = rigth;
	}

}
