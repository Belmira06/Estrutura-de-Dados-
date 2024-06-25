class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    constructor() {
        this.root = null;
    }

    insert(value) {
        const newNode = new Node(value);
        if (!this.root) {
            this.root = newNode;
        } else {
            this._insertNode(this.root, newNode);
        }
    }

    _insertNode(node, newNode) {
        if (newNode.value < node.value) {
            if (!node.left) {
                node.left = newNode;
            } else {
                this._insertNode(node.left, newNode);
            }
        } else {
            if (!node.right) {
                node.right = newNode;
            } else {
                this._insertNode(node.right, newNode);
            }
        }
    }
    remove(value) {
        this.root = this._removeNode(this.root, value);
    }

    _removeNode(node, value) {
        if (!node) {
            return null;
        }

        if (value === node.value) {
            if (!node.left && !node.right) {
                return null;
            } else if (!node.left) {
                return node.right;
            } else if (!node.right) {
                return node.left;
            } else {
                const minRight = this._findMin(node.right);
                node.value = minRight.value;
                node.right = this._removeNode(node.right, minRight.value);
            }
        } else if (value < node.value) {
            node.left = this._removeNode(node.left, value);
        } else {
            node.right = this._removeNode(node.right, value);
        }

        return node;
    }
}
    // display() {
      //   this.preOrder(this.root);
   //  }

    // preOrder(node) {
      //   if (node !== null) {
          //   console.log(node.value); // Exibe o valor do nó
            // this.preOrder(node.left); // Percorre à esquerda
            // this.preOrder(node.right); // Percorre à direita
       //  }
   //  }
    

