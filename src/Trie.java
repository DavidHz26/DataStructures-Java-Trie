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

        current.setIsEndOfWord(true);
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

            current = node;
        }

        if(current.getIsEndOfWord()) {
            System.out.println(data + " found");
        } else {
            System.out.println(data + " does not exist as a word, but in prefix of another word");
        }

        return current.getIsEndOfWord();

    }

    public void deleteData(String data) {
        if(searchData(data)) {
            //Recursive function, so we will start searching from root to last children and vice
            //0 is the replacement from for, so we will manually give the index of node
            delete(root, data, 0);
        }
    }

    private boolean delete(TNode parent, String data, int index) {

        TNode current = parent.getChildren().get(data.charAt(index));

        //if current hashmap contains more than one element
        if(current.getChildren().size() > 1) {
            //Then we go to that node and start repeating the process
            delete(current, data, index + 1);
            return false;
        }

        //If we are already are at index of the last char of data
        if(index == data.length() - 1) {
            //We check if in this node are more than one element on his hashmap
            if(current.getChildren().size() > 1) {
                //If there is more than one, then this word is a substring of other word
                //So to delete this word we only change the boolean "endOfWord" to false
                current.setIsEndOfWord(false);
                //And lastly we return false because we are just changing a variable
                //We are not permitted to delete the string
                return false;
            }

            //If this is the only element on his hashmap then we delete the node because
            //there is no other word that is using this element
            else {
                current.getChildren().remove(data.charAt(index));
                //And return true because we can delete a node
                return true;
            }
        }

        //If we reached the index of the string we are trying to delete and it's
        // marked as end of word
        if(current.getIsEndOfWord()) {
            //Then we check the next node of current to see if this node is part
            //of some other word, and if it's possible to delete the node, it will be deleted
            delete(current, data, index + 1);

            //If we return from delete then the word wasn't deleted, so we return false
            //because someone else is using this node
            return false;
        }

        //If we can delete a node from current
        if(delete(current, data, index + 1)){
            //then we remove the element from his parent as well so the node gets
            //completely destroyed
            parent.getChildren().remove(data.charAt(index));
            //and since we were able to remove a node from his parent we return true
            return true;
        }
        //If we can't delete a node from current
        else {
            //then someone else is using this node, so we can't delete the node
            //from parent, so we return false
            return false;
        }
    }
}
