package structures;

import java.util.Comparator;

import comparators.ComparatorByString;
import models.PartialNote;

public class AVLTree<T> {

	private NodeAVL<T> root;
	private Comparator<T> comparator;

	public AVLTree(Comparator<T> comparator) {
		this.root = null;
		this.comparator = comparator;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return root.getSize();
	}

	private int size(NodeAVL<T> node) {
		if (node == null)
			return 0;
		return node.getSize();
	}

	public int height() {
		return height(root);
	}

	private int height(NodeAVL<T> node) {
		if (node == null)
			return -1;
		return node.getHeight();
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	public NodeAVL<T> ask(T data, NodeAVL<T> node) {
		if (node == null) {
			return null;
		}
		if (comparator.compare(data, node.getData()) == 0) {
			return node;
		} else if (comparator.compare(data, node.getData()) == -1) {
			return ask(data, node.getLeft());
		} else {
			return ask(data, node.getRigth());
		}
	}

	public boolean exist(T data, NodeAVL<T> node) {

		if (node == null) {
			return false;
		}

		if (comparator.compare(data, node.getData()) == 0) {
			return true;
		} else if (comparator.compare(data, node.getData()) == -1) {
			return exist(data, node.getLeft());
		} else {
			return exist(data, node.getRigth());
		}
	}

	private NodeAVL<T> insert(NodeAVL<T> node, T data) {
		if (node == null)
			return new NodeAVL<T>(data, 0, 1);

		if (comparator.compare(data, node.getData()) == -1) {
			node.setLeft(insert(node.getLeft(), data));
		} else if (comparator.compare(data, node.getData()) == 1) {
			node.setRigth(insert(node.getRigth(), data));
		} else {
			node.setData(data);
			return node;
		}
		node.setSize(1 + size(node.getLeft()) + size(node.getRigth()));
		node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRigth())));
		return balance(node);
	}

	private NodeAVL<T> balance(NodeAVL<T> node) {
		if (balanceFactor(node) > 1) {
			if (balanceFactor(node.getRigth()) < 0) {
				node.setRigth(rotateRight(node.getRigth()));
			}
			node = rotateLeft(node);
		} else if (balanceFactor(node) < -1) {
			if (balanceFactor(node.getLeft()) > 0) {
				node.setLeft(rotateLeft(node.getLeft()));
			}
			node = rotateRight(node);
		}
		return node;
	}

	private int balanceFactor(NodeAVL<T> node) {
		return height(node.getRigth()) - height(node.getLeft());
	}

	private NodeAVL<T> rotateRight(NodeAVL<T> node) {
		NodeAVL<T> auxiliar = node.getLeft();
		node.setLeft(auxiliar.getRigth());
		auxiliar.setRigth(node);
		auxiliar.setSize(node.getSize());
		node.setSize(1 + size(node.getLeft()) + size(node.getRigth()));
		node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRigth())));
		auxiliar.setHeight(1 + Math.max(height(auxiliar.getLeft()), height(auxiliar.getRigth())));
		return auxiliar;
	}

	private NodeAVL<T> rotateLeft(NodeAVL<T> node) {
		NodeAVL<T> auxiliar = node.getRigth();
		node.setRigth(auxiliar.getLeft());
		auxiliar.setLeft(node);
		auxiliar.setSize(node.getSize());
		node.setSize(1 + size(node.getLeft()) + size(node.getRigth()));
		node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRigth())));
		auxiliar.setHeight(1 + Math.max(height(auxiliar.getLeft()), height(auxiliar.getRigth())));
		return auxiliar;
	}

	public void delete(T data) {
		if (this.exist(data, root) == true) {
			root = delete(root, data);
		}
	}

	private NodeAVL<T> delete(NodeAVL<T> node, T data) {
		if (comparator.compare(data, node.getData()) == -1) {
			node.setLeft(delete(node.getLeft(), data));
		} else if (comparator.compare(data, node.getData()) == 1) {
			node.setRigth(delete(node.getRigth(), data));
		} else {
			if (node.getLeft() == null) {
				return node.getRigth();
			} else if (node.getRigth() == null) {
				return node.getLeft();
			} else {
				NodeAVL<T> y = node;
				node = minimun(y.getRigth());
				node.setRigth(deleteMinimun(y.getRigth()));
				node.setLeft(y.getLeft());
			}
		}
		node.setSize(1 + size(node.getLeft()) + size(node.getRigth()));
		node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRigth())));
		return balance(node);
	}

	private NodeAVL<T> deleteMinimun(NodeAVL<T> node) {
		if (node.getLeft() == null)
			return node.getRigth();
		node.setLeft(deleteMinimun(node.getLeft()));
		node.setSize(1 + size(node.getLeft()) + size(node.getRigth()));
		node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRigth())));
		return balance(node);
	}

	private NodeAVL<T> minimun(NodeAVL<T> node) {
		if (node.getLeft() == null)
			return node;
		return minimun(node.getLeft());
	}

	public T askMinimun(NodeAVL<T> node) {
		NodeAVL<T> auxiliar = node;
		T result = auxiliar.getData();
		if (node == null) {
			return null;
		}
		while (auxiliar.getLeft() != null) {
			auxiliar = auxiliar.getLeft();
			result = auxiliar.getData();
		}
		return result;

	}

	public T askMaximum(NodeAVL<T> node) {
		NodeAVL<T> auxiliar = node;
		T result = auxiliar.getData();
		if (node == null) {
			return null;
		}
		while (auxiliar.getRigth() != null) {
			auxiliar = auxiliar.getRigth();
			result = auxiliar.getData();
		}
		return result;

	}

	public NodeAVL<T> getRoot() {
		return root;
	}

	private void show(NodeAVL<T> auxiliar) {
		if (auxiliar != null) {
			show(auxiliar.getLeft());
			System.out.println(auxiliar.getData());
			show(auxiliar.getRigth());
		}
	}

	public static void main(String[] args) {
		AVLTree<String> strings = new AVLTree<>(new ComparatorByString());
		strings.insert("Hola");
		strings.show(strings.getRoot());
	}

}
