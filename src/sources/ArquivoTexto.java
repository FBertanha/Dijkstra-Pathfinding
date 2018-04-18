package sources;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import javax.annotation.processing.FilerException;

/**
 * Created by berta on 4/4/2018.
 */
public class ArquivoTexto {
    private static final int INDICE_ORIGEM = 0;
    private static final int INDICE_DESTINO = 1;
    private static final int INDICE_PESO = 2;
    private static final String SEPARADOR = " ";
    private final String caminhoDoArquivo;

    public ArquivoTexto(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    private List<String> ler() throws Exception {
        // Lê arquivo texto e retorna em forma de string
        List<String> linhas = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoDoArquivo));
            String linha = reader.readLine();
            //String linhaQuebrada[];
            while (linha != null) {
                //linhaQuebrada = linha.split(SEPARADOR);
                linhas.add(linha);
                linha = reader.readLine();
            }

            //System.out.println(linhas);
            reader.close();

        } catch (java.io.IOException e) {
            throw new Exception("Erro ao ler arquivo texto!");
        }
        return linhas;
    }


    public Grafo getGrafo() throws Exception{
        List<String> linhas = ler();
        Grafo grafo = new Grafo();


        for (String linha :
                linhas) {

            Aresta aresta = getAresta(linha);
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();

            //traz nos existentes
            if (grafo.containsVertice(origem)) {
                origem = grafo.getVertice(origem);
            }
            if (grafo.containsVertice(destino)) {
                destino = grafo.getVertice(destino);
            }
            origem.addVizinho(destino);
            destino.addVizinho(origem);

            //adicionar na lista
            grafo.addVertice(origem);
            grafo.addVertice(destino);

            grafo.getArestas().add(aresta);

        }
        return  grafo;
    }

    public static Aresta getAresta(String linha) {
        String[] linhaQuebrada = linha.split(SEPARADOR);
        Vertice origem = new Vertice(linhaQuebrada[INDICE_ORIGEM]);
        Vertice destino = new Vertice(linhaQuebrada[INDICE_DESTINO]);
        Aresta aresta = null;

        try {
            aresta = new Aresta(origem, destino, Double.parseDouble(linhaQuebrada[INDICE_PESO]));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        return aresta;
    }

    public void fechar() {

    }
}
