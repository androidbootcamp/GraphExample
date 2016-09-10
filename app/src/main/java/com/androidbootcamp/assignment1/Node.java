package com.androidbootcamp.assignment1;


import java.util.List;

public class Node {
    private String label;
    private List<Node> neighbours;

    public Node(String label, List<Node> neighbours) {
        this.label = label;
        this.neighbours = neighbours;
    }

    public boolean canReach(Node destinationNode) {
        if (this.equals(destinationNode)) {
            return true;
        }
        else if (neighbours != null) {
            for (Node neighbour : neighbours) {
                if (neighbour.canReach(destinationNode))
                    return true;
            }
        }
        return false;
    }
}
