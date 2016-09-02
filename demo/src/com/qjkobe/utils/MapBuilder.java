package com.qjkobe.utils;

import com.qjkobe.entity.Node;

import java.util.Set;

public class MapBuilder {
    public Node build(Set<Node> open, Set<Node> close){
        Node nodeA=new Node("上海");
        Node nodeB=new Node("浙江");
        Node nodeC=new Node("江苏");
        Node nodeD=new Node("河南");
        Node nodeE=new Node("安徽");
        Node nodeF=new Node("福建");
        Node nodeG=new Node("江西");
        Node nodeH=new Node("湖南");
        nodeA.getChild().put(nodeB, 176);
        nodeA.getChild().put(nodeC, 183);
        nodeB.getChild().put(nodeA, 176);
        nodeB.getChild().put(nodeF, 185);
        nodeB.getChild().put(nodeG, 242);
        nodeB.getChild().put(nodeE, 231);
        nodeC.getChild().put(nodeA, 183);
        nodeC.getChild().put(nodeE, 113);
        nodeD.getChild().put(nodeE, 156);
        nodeE.getChild().put(nodeB, 231);
        nodeE.getChild().put(nodeC, 113);
        nodeE.getChild().put(nodeD, 156);
        nodeE.getChild().put(nodeG, 270);
        nodeF.getChild().put(nodeB, 185);
        nodeF.getChild().put(nodeG, 123);
        nodeG.getChild().put(nodeB, 242);
        nodeG.getChild().put(nodeF, 123);
        nodeG.getChild().put(nodeE, 270);
        nodeG.getChild().put(nodeH, 168);
        nodeH.getChild().put(nodeG, 168);
        open.add(nodeB);  
        open.add(nodeC);  
        open.add(nodeD);  
        open.add(nodeE);  
        open.add(nodeF);  
        open.add(nodeG);  
        open.add(nodeH);  
        close.add(nodeA);  
        return nodeA;  
    }  
}  