package sources;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by berta on 4/4/2018.
 */
public class Vertice {
    private String rotulo;
    private Double distancia = Double.MAX_VALUE; //dist
    private List<Vertice> vizinhos = new ArrayList<>();

    public Vertice() {
    }

    public Vertice(String rotulo) {
        this.rotulo = rotulo;
    }

    public Vertice(String rotulo, Double distancia) {
        this.rotulo = rotulo;
        this.distancia = distancia;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }


    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public List<Vertice> getVizinhos() {
        return vizinhos;
    }

    public Vertice getVizinho(Vertice vertice) {
        return this.vizinhos.get(this.vizinhos.indexOf(vertice));
    }

    public void addVizinho(Vertice vizinho) {
        if (this.vizinhos.contains(vizinho)) return;
        this.vizinhos.add(vizinho);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertice vertice = (Vertice) o;

        return rotulo != null ? rotulo.equals(vertice.rotulo) : vertice.rotulo == null;
    }

    @Override
    public int hashCode() {
        return rotulo != null ? rotulo.hashCode() : 0;
    }

//    @Override
//    public String toString() {
//        return "Vertice{" +
//                "rotulo='" + rotulo + '\'' +
//                ", distancia=" + distancia +
//                //", vizinhos=" + vizinhos +
//                '}';
//    }

    @Override
    public String toString() {
        return rotulo;
    }

}
