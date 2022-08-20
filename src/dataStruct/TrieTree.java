package dataStruct;

import java.util.HashMap;
import java.util.Map;

/*
    前缀树的数据结构
 */
public class TrieTree {

    public boolean isEnd = false;

    public Map<Character, TrieTree> subNode = new HashMap<>();

    public TrieTree getSubNode(Character c){
        return subNode.get(c);
    }

    public TrieTree addSubNode(Character c, TrieTree node){
        subNode.put(c, node);
        return node;
    }

    public boolean isWordEnd(){
        return isEnd;
    }

    public void setEnd(){
        this.isEnd = true;
    }

    public void addKeyword(TrieTree rootNode,String word){
        TrieTree root = rootNode;
        for(char c : word.toCharArray()){
            if(root.getSubNode(c) == null){
                root = root.addSubNode(c, new TrieTree());
            }else{
                root = rootNode.getSubNode(c);
            }
        }
        root.setEnd();
    }


}
