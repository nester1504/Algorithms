public class Main {

    public static void main(String[] args) {
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        // Вставка элементов в дерево
        tree.insert(5, "five");
        tree.insert(3, "three");
        tree.insert(8, "eight");
        tree.insert(1, "one");
        tree.insert(4, "four");

        // Вывод дерева
        System.out.println("Красно-черное дерево:");
        tree.printTree();

    }


}