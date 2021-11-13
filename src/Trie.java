public class Trie {

    private TNode root;

    public Trie() {
        root = new TNode();
    }

    public TNode insert(String data) {

        TNode current = root;

        for(int i = 0; i < data.length(); i++) {
            TNode node = current.getChildren().get(data.charAt(i));

            if(node == null) {
                node = new TNode();
                current.getChildren().put(data.charAt(i), node);
                System.out.println(current.getChildren());
            }

            current = node;
        }

        current.setEndOfWord(true);
        System.out.println("Successfully inserted " + data + "\n");

        return root;
    }

    public Boolean searchData(String data) {
        System.out.println("Searching for " + data + "...");

        TNode current = root;

        for(int i = 0; i < data.length(); i++) {

            TNode node = current.getChildren().get(data.charAt(i));

            if(node == null) {
                System.out.println("Not in trie");
                return false;
            }

            System.out.println(data.charAt(i) + " found");

            if(node.getEndOfWord()) {
                System.out.println("Data found");
                return true;
            }

            current = node;

        }

        System.out.println("Not in trie");
        return false;
    }

    public void deleteData(String data) {
        if(searchData(data)) {
            //Recursive function, so we will start searching from root to last children and vice
            //0 is the replacement from for, so we will manually give the index of node
            delete(root, data, 0);
        }
    }

    private void delete(TNode parent, String data, int index) {

        TNode current = parent;

        if

    }

}
