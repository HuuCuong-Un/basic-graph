/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;


import Element.Vertex;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 * 
 */

//Using for detect cycle in kruskal
public class CycleDetectionUndr<T> {

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(null, vertex)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Vertex<T> caller, Vertex<T> current) {
        current.setVisited(true);
        for (Vertex<T> neighbor : current.getNeighbors()) {
            if (neighbor.isVisited() && !neighbor.equals(caller) || !neighbor.isVisited() && hasCycle(current, neighbor)) {
                return true;
            }
            /*
                Equivalent Code:
                ----------------
                if (neighbor.isVisited()) {
                    if (current.equals(neighbor) || !neighbor.equals(caller)) {
                        return true;
                    }
                } else if (hasCycle(current, neighbor)) {
                    return true;
                }
            */
        }
        return false;
    }


}