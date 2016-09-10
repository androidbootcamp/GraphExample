package com.androidbootcamp.assignment1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class NodeTest {

    private Node nodeA;

    @Before
    public void setUp() throws Exception {
        nodeA = new Node("A", null);
    }

    @Test
    public void canReachSelf() throws Exception {
        assertTrue(nodeA.canReach(nodeA));
    }

    @Test
    public void canReachItsNeighbour() throws Exception {
        Node nodeB = new Node("B", null);
        nodeA = new Node("A", Collections.singletonList(nodeB));
        assertTrue(nodeA.canReach(nodeB));
    }

    @Test
    public void cannotReachDisjointNodes() throws Exception {
        Node nodeA = new Node("A", Arrays.asList(new Node("B", null)));
        Node nodeC = new Node("C", null);
        assertFalse(nodeA.canReach(nodeC));
    }

    @Test
    public void canReachMultipleNeighbours() throws Exception {
        Node nodeC = new Node("C", null);
        Node nodeB = new Node("B", null);
        nodeA = new Node("A", Arrays.asList(nodeB, nodeC));
        assertTrue(nodeA.canReach(nodeC));
    }

    @Test
    public void cannotReachAnyIfSourceIsLeafNode() throws Exception {
        Node nodeA = new Node("A", null);
        assertFalse(nodeA.canReach(new Node("B", null)));
    }

    @Test
    public void canReachIfTheyAreInSamePath() throws Exception {
        Node nodeC = new Node("C", null);
        Node nodeB = new Node("B", Collections.singletonList(nodeC));
        nodeA = new Node("A", Collections.singletonList(nodeB));
        assertTrue(nodeA.canReach(nodeC));
    }
}
