package jiuzhang.graph;

import java.util.*;

public class CloneGraph {
    class UndirectedNode{
        int label;
        List<UndirectedNode> neighbor;
        public UndirectedNode(int label){
            this.label = label;
            neighbor = new ArrayList<>();
        }
    }

    public UndirectedNode cloneGraph(UndirectedNode node){
        Map<UndirectedNode,UndirectedNode> map = new HashMap<>();
        ArrayList<UndirectedNode> nodes = getNode(node);
        for (UndirectedNode n : nodes){
            map.put(n,new UndirectedNode(n.label));
        }
        for (UndirectedNode n : nodes){
            UndirectedNode newNode = map.get(n);
            for (UndirectedNode neighbor : n.neighbor){
                UndirectedNode newNeighbor = map.get(neighbor);
                newNode.neighbor.add(newNeighbor);
            }
        }

        return map.get(node);

    }

    public ArrayList<UndirectedNode> getNode(UndirectedNode node){
        HashSet<UndirectedNode> set = new HashSet<>();
        Queue<UndirectedNode> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()){
            UndirectedNode node1 = queue.poll();
            for (UndirectedNode node2 : node.neighbor){
                queue.offer(node2);
            }
            if (!set.contains(node1)){
                set.add(node1);
            }
        }

        return new ArrayList<>(set);
    }
}
