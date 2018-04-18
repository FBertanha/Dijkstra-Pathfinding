package sources;


import javax.swing.*;
import java.util.*;

/**
 * Created by berta on 4/7/2018.
 */
public class Dijkstra {

    private Grafo grafo;
    private Map<Vertice, Vertice> caminho = new HashMap<>();

    public Dijkstra(Grafo grafo) {
        this.grafo = grafo;
    }

    public String executar(Vertice origem, Vertice destino) {
        String resultado;
        //Verifica se origem e destino existe

        if (grafo.getVertice(origem) == null) {
            throw new ArrayIndexOutOfBoundsException("Origem informada não existe no grafo!");
        }
        if (grafo.getVertice(destino) == null) {
            throw new ArrayIndexOutOfBoundsException("Destino informadao não existe no grafo!");
        }
        origem = grafo.getVertice(origem);
        destino = grafo.getVertice(destino);

        //'(distance'to'source'vertex'is'zero)
        origem.setDistancia(0d);

        //(set'all'other'distances'to'infinity)'
        // Vertices ja tem dist "INFINITO", atribuido na criação do objeto
        //'(S,'the'set'of'visited'vertices'is'initially'empty)'
        List<Vertice> S = new ArrayList<>(); //Lista de nós ja vizitados
        //'(Q,'the'queue'initially'contains'all'vertices)'
        List<Vertice> Q = new ArrayList<>(grafo.getVertices()); //Lista com todos os nós

        //'(while'the'queue'is'not'empty)'
        while (!Q.isEmpty()) {
            //(select'the'element'of'Q'with'the'min.'distance)'
            Vertice u = minDistance(Q);
            //Adiciona na lista S de nós visitados
            S.add(u);
            //Remove da lista Q
            Q.remove(u);
            //caminhoCompleto.append(origem.getRotulo()).append(" -> ");
            //Visita todos os nós adjacentes (vizinhos) ao vertice U
            for (Vertice v
                    : u.getVizinhos()) {
                if (v.getDistancia() > u.getDistancia() + weight(u, v)) {
                    v.setDistancia(u.getDistancia() + weight(u, v));
                    //map para fazer o caminho
                    caminho.put(v, u);
                }
            }
//            //Para o while quando U (menor distância) for o própio destino
//            if (u.equals(destino)) {
//                System.out.println("PARAR");
//                //break;
//            }

        }

        resultado = getCaminhoCompleto(origem, destino);

        return resultado;

    }

    private String getCaminhoCompleto(Vertice origem, Vertice destino) {
        List<Vertice> listaCaminho = new ArrayList<>();
        Vertice passo = destino;
        StringBuilder stringBuilder = new StringBuilder();

        listaCaminho.add(passo);
        while (caminho.get(passo) != null) {
            passo = caminho.get(passo);
            listaCaminho.add(passo);
        }
        //Inverte lista
        Collections.reverse(listaCaminho);
        stringBuilder.append("Melhor caminho encontrado de: ").append(origem.getRotulo()).append(" a ").append(destino.getRotulo()).append("\n");
        for (Vertice c : listaCaminho) {
            stringBuilder.append(" - > ").append(c.getRotulo());
        }
        stringBuilder.append("\n").append("Distância total: ").append(destino.getDistancia()).append("KM");
        return stringBuilder.toString();
    }


    private Vertice minDistance(List<Vertice> vertices) {
        Vertice verticeComMenorDistancia;
        verticeComMenorDistancia = Collections.min(vertices, Comparator.comparing(v -> v.getDistancia()));
        return verticeComMenorDistancia;
    }

    private Double weight(Vertice u, Vertice v) {
        Aresta aresta;
        Double weigth;

        aresta = grafo.getAresta(u, v);
        if (aresta == null) {
            aresta = grafo.getAresta(v, u);
        }

        if (aresta != null) {
            weigth = aresta.getPeso();
        } else {
            weigth = 0d;
        }

        return weigth;
    }
}
