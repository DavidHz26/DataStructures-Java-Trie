import java.util.HashMap;

public class TNode {

    private HashMap<Character, TNode> children;
    private Boolean isEndOfWord;

    public TNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }

    public HashMap<Character, TNode> getChildren() {
        return children;
    }

    public void setIsEndOfWord(Boolean cond) {
        isEndOfWord = cond;
    }

    public Boolean getIsEndOfWord() {
        return isEndOfWord;
    }

    @Override
    public String toString() {
        return children.values().toString();
    }

}
