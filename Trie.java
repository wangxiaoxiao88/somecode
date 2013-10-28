/**
 * @author wangxiaoxiao
 * @date   Oct 16, 2013
 * @desc   trie树java实现
 */
public class Trie {

    private final int NODES_COUNT = 26;

    class TrieNode{
        public int prefix;
        public int count;
        public TrieNode nodes[];

        TrieNode(){
            nodes = new TrieNode[NODES_COUNT];
        }
    }

    public TrieNode root = new TrieNode();

    private void add(String value){
        add(root,value);
    }

    private void add(TrieNode node,String value){
        if(value.length() == 0){
            node.count ++;
        } else {
            node.prefix++;
            char begin = value.charAt(0);
            int index = begin - 'a';
            if(node.nodes[index] == null){
                node.nodes[index] = new TrieNode();
            }
            add(node.nodes[index],value.substring(1));
        }
    }

    private void countPrefix(String value){
        countPrefix(root,value);
    }

    private void countPrefix(TrieNode node,String value){
        if(value.length() == 0){
            System.out.println("countPrefix = " + node.prefix);
            return;
        }

        char begin = value.charAt(0);
        countPrefix(node.nodes[begin-'a'],value.substring(1));
    }

    private void countWord(String value){
        countWord(root,value);
    }

    private void countWord(TrieNode node,String value){
        if(value.length() == 0){
            System.out.println("countWord = " + node.count);
            return;
        }

        char begin = value.charAt(0);
        countWord(node.nodes[begin-'a'],value.substring(1));
    }

    private void listAll(){
        String value = "";
        listAll(root,value);
    }

    private void listAll(TrieNode node,String value){

        boolean hasValue = false;

        for(int i = 0 ; i < NODES_COUNT; ++i){
            if(node.nodes[i] != null){
                hasValue = true;
                listAll(node.nodes[i],value + (char)('a'+i));
            }
        }

        if(!hasValue){
            System.out.println("value = "+value);
        }
    }

    public static void main(String[]args){

        Trie trie = new Trie();
        trie.add("china");
        trie.add("china");
        trie.add("china");

        trie.add("crawl");
        trie.add("crime");
        trie.add("ban");
        trie.add("china");

        trie.add("english");
        trie.add("establish");
        trie.add("eat");
        System.out.println("all count = " + trie.root.prefix);

        trie.listAll();


        trie.countPrefix("ch");
        trie.countWord("china");


    }

}
