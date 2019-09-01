package graph;

import java.util.*;

public class TopSort {
    class DirectedGraphNode{
        int label;
        List<DirectedGraphNode> neighbor;
        public DirectedGraphNode(int label){
            this.label = label;
            neighbor = new ArrayList<>();
        }
    }

    public List<DirectedGraphNode> topSort(List<DirectedGraphNode> graph){
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph){
            for (DirectedGraphNode neighbor : node.neighbor){
                if (map.containsKey(neighbor)){
                    map.put(neighbor,map.get(neighbor)+1);
                }else {
                    map.put(neighbor,1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        List<DirectedGraphNode> res = new ArrayList<>();

        for (DirectedGraphNode node : graph){
            if (!map.containsKey(node)){
                queue.offer(node);
                res.add(node);
            }
        }

        while (!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbor){
                map.put(n,map.get(n)-1);
                if (map.get(n) == 0){
                    queue.offer(n);
                    res.add(n);
                }
            }
        }

        return res;
    }
}
