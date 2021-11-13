import java.util.HashMap;

public class TNode {

    private HashMap<Character, TNode> children;
    private Boolean endOfWord;

    public TNode() {
        children = new HashMap<>();
        endOfWord = false;
    }

    public HashMap<Character, TNode> getChildren() {
        return children;
    }

    public void setEndOfWord(Boolean cond) {
        endOfWord = cond;
    }

    public Boolean getEndOfWord() {
        return endOfWord;
    }

    @Override
    public String toString() {
        return children.values().toString();
    }

}
