public class Main {
    public static void main(String[] args) {

        Trie trie = new Trie();

        System.out.println("INSERT");
        trie.insert("air");
        trie.insert("aio");
        trie.insert("airk");
        System.out.println();

        System.out.println("SEARCH");
        trie.searchData("xyz"); //false
        System.out.println();
        trie.searchData("abc"); //false
        System.out.println();
        trie.searchData("air"); //true
        System.out.println();
        trie.searchData("ai"); //false because 'a' and 'i' are in trie but they are not a word
        System.out.println();

        System.out.println("DELETE");
        trie.deleteData("aio");



    }


}
