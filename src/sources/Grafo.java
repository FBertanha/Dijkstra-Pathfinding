package sources;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by berta on 4/5/2018.
 */
public class Grafo {
    private List<Vertice> vertices; //Cidades
    private List<Aresta> arestas; //Caminhos

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public Grafo(List<Vertice> vertices, List<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public Aresta getAresta(Aresta aresta) {
        return this.arestas.get(this.arestas.indexOf(aresta));
    }

    public Aresta getAresta(Vertice origem, Vertice destino) {
        Aresta tempAresta = new Aresta(origem, destino);
        if (!arestas.contains(tempAresta)) return null;
        return this.arestas.get(arestas.indexOf(tempAresta));
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public boolean containsVertice(Vertice vertice) {
        return this.vertices.contains(vertice);
    }

    public Vertice getVertice(Vertice vertice) {
        return this.vertices.get(this.vertices.indexOf(vertice));
    }

    public Vertice getVerticeByName(String rotulo) {
        for (Vertice v :
                this.vertices) {
            if (v.getRotulo().equalsIgnoreCase(rotulo)) {
                return v;
            }
        }
        return null;
    }

    public void addVertice(Vertice vertice) {

        //Se o nó ja existir add apenas os vizinhos
        if (containsVertice(vertice)) {
            List<Vertice> novosVizinhos = vertice.getVizinhos();
            Vertice verticeExistente = getVertice(vertice);
            for (Vertice v :
                    novosVizinhos) {
                verticeExistente.addVizinho(v);
            }
        } else {
            this.vertices.add(vertice);
        }
    }

}

