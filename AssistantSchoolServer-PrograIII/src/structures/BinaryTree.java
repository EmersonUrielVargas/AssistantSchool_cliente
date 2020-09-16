package structures;

import java.util.Comparator;

public class BinaryTree<T> {

	private NodeTree<T> root;
	private Comparator<T> comparator;

	public BinaryTree(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
	}

	public void insert(T data) {
		NodeTree<T> newNode = new NodeTree<T>(data);
		if (isEmpty()) {
			root = newNode;
		} else {
			NodeTree<T> actual = root;
			NodeTree<T> previous = root;
			while (actual != null) {
				if ((comparator.compare(data, actual.getData())) == -1) {
					previous = actual;
					actual = actual.getLeft();
				} else {
					previous = actual;
					actual = actual.getRigth();
				}
			}

			if ((comparator.compare(data, previous.getData())) == -1) {
				previous.setLeft(newNode);
			} else {
				previous.setRight(newNode);
			}
		}
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public boolean exist(T data) {
		boolean result = false;
		boolean isTrue = true;
		if (!isEmpty()) {
			NodeTree<T> auxiliar = root;
			while (auxiliar != null && isTrue) {
				if (auxiliar.getData() == data) {
					isTrue = false;
				} else if (comparator.compare(auxiliar.getData(), data) < 0) {
					auxiliar = auxiliar.getRigth();
				} else {
					auxiliar = auxiliar.getLeft();
				}
			}
		}
		if (isTrue == false) {
			result = true;
		}
		return result;
	}

	public NodeTree<T> ask(T data, NodeTree<T> node) {
		if (root == null) {
			return null;
		}
		if (comparator.compare(data, node.getData()) == 0) {
			return node;
		} else if ((comparator.compare(data, node.getData()) == -1)) {
			return ask(data, node.getLeft());
		} else {
			return ask(data, node.getRigth());
		}
	}

	public void remove(T data) {
		root = removeData(root, data);
	}

	protected NodeTree<T> removeData(NodeTree<T> node, T data) {
		if (node != null) {
			if (comparator.compare(node.getData(), data) == -1) {
				NodeTree<T> rigth = removeData(node.getRigth(), data);
				node.setRight(rigth);
			} else if (comparator.compare(node.getData(), data) == 1) {
				NodeTree<T> left = removeData(node.getLeft(), data);
				node.setLeft(left);
			} else {
				NodeTree<T> equal = node;
				if (equal.getLeft() == null)
					node = equal.getRigth();
				else if (equal.getRigth() == null)
					node = equal.getLeft();
				else
					equal = replace(equal);
				equal = null;
			}

		}
		return node;
	}

	public NodeTree<T> replace(NodeTree<T> equal) {
		NodeTree<T> auxiliar = equal;
		NodeTree<T> maximun = equal.getLeft();

		while (maximun.getRigth() != null) {
			auxiliar = maximun;
			maximun = maximun.getRigth();
		}
		equal.setData(maximun.getData());

		if (comparator.compare(auxiliar.getData(), maximun.getData()) == 0) {
			auxiliar.setLeft(maximun.getLeft());
		} else {
			auxiliar.setRight(maximun.getLeft());
		}
		return maximun;
	}

	public NodeTree<T> getRoot() {
		return root;
	}
}
