package sources;



/**
 * Created by berta on 4/4/2018.
 */
public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private Double peso;

    public Aresta() {
    }

    public Aresta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Aresta(Vertice origem, Vertice destino, Double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Aresta{" +
                "origem=" + origem +
                ", destino=" + destino +
                ", peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aresta aresta = (Aresta) o;

        if (origem != null ? !origem.equals(aresta.origem) : aresta.origem != null) return false;
        return destino != null ? destino.equals(aresta.destino) : aresta.destino == null;
    }

    @Override
    public int hashCode() {
        int result = origem != null ? origem.hashCode() : 0;
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        return result;
    }
}
