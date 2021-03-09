package Tree;

import java.util.List;

/**
 * @Author: zhouhanming
 * @Date:2021/3/9 9:34 下午
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
