#include <iostream>

using namespace std;

struct Node {
    int value;
    Node* left;
    Node* right;

    Node(int val) : value(val), left(nullptr), right(nullptr) {}
};

class BST {
private:
    Node* root;

    Node* insert(Node* node, int value) {
        if (node == nullptr) return new Node(value);
        if (value < node->value) node->left = insert(node->left, value);
        else node->right = insert(node->right, value);
        return node;
    }

    void postorder(Node* node) {
        if (node == nullptr) return;
        postorder(node->left);
        postorder(node->right);
        cout << node->value << '\n';
    }

public:
    BST() : root(nullptr) {}

    void insert(int value) {
        root = insert(root, value);
    }

    void postorder() {
        postorder(root);
    }
};

BST init() { 
    BST tree;
    int value;

    while (cin >> value) {
        tree.insert(value);
    }

    return tree;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    BST tree = init(); 
    tree.postorder();  

    return 0;
}
