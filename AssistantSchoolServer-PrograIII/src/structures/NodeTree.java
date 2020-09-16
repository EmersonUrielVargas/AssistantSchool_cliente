package structures;

public class NodeTree<T>{
		
		private T data;
		private NodeTree<T> rigth,left;

		public NodeTree(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public NodeTree<T> getRigth() {
			return rigth;
		}

		public void setRight(NodeTree<T> rigth) {
			this.rigth = rigth;
		}
		public NodeTree<T> getLeft() {
			return left;
		}

		public void setLeft(NodeTree<T> left) {
			this.left = left;
		}

	}