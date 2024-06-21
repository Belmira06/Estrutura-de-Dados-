import java.util.ArrayList;

<!-- Inclua o Polyfill -->
<script src="https://www.javapoly.com/javapoly.js"></script>
public class Vertice<Tipo> {
    private Tipo dado;
    private ArrayList<Aresta<Tipo>> arestasEntrada;
    private ArrayList<Aresta<Tipo>> arestasSaida;
    
    public Vertice(Tipo valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Tipo>>();
        this.arestasSaida = new ArrayList<Aresta<Tipo>>();
    }

    public Tipo getDado() {
        return dado;
    }

    public void setDado(Tipo dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<Tipo> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<Tipo> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<Tipo>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Tipo>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}

package aula25_grafos;

import java.util.ArrayList;

public class Grafo<TIPO> {
    private ArrayList<Vertice<Tipo>> vertices;
    private ArrayList<Aresta<Tipo>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<Tipo>>();
        this.arestas = new ArrayList<Aresta<Tipo>>();
    }
    
    public void adicionarVertice(Tipo dado){
        Vertice<Tipo> novoVertice = new Vertice<Tipo>(dado);
        this.vertices.add(novoVertice);
    }
    
    public void adicionarAresta(Double peso, Tipo dadoInicio, Tipo dadoFim){
        Vertice<Tipo> inicio = this.getVertice(dadoInicio);
        Vertice<Tipo> fim = this.getVertice(dadoFim);
        Aresta<Tipo> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<Tipo> getVertice(Tipo dados){
        Vertice<Tipo> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDados().equals(dados)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    public void buscarLargura(){
        ArrayList<Vertice<Tipo>> marcar = new ArrayList<Vertice<Tipo>>();
        ArrayList<Vertice<Tipo>> fila = new ArrayList<Vertice<Tipo>>();
        Vertice<Tipo> atual = this.vertices.get(0);
        marcar.add(atual);
        System.out.println(atual.getDados());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<Tipo> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<Tipo> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcar.contains(proximo)){ 
                    marcar.add(proximo);
                    System.out.println(proximo.getDados());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }
}

public class Aresta<TIPO> {
    private Double peso;
    private Vertice<Tipo> inicio;
    private Vertice<Tipo> fim;
    
    public Aresta(Double peso, Vertice<Tipo> inicio, Vertice<Tipo> fim){
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<Tipo> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<Tipo> inicio) {
        this.inicio = inicio;
    }

    public Vertice<Tipo> getFim() {
        return fim;
    }

    public void setFim(Vertice<Tipo> fim) {
        this.fim = fim;
    }
    
    

public class Vertice<TIPO> {
    private TIPO dado;
    private ArrayList<Aresta<Tipo>> arestasEntrada;
    private ArrayList<Aresta<Tipo>> arestasSaida;
    
    public Vertice(Tipo valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<Tipo>>();
        this.arestasSaida = new ArrayList<Aresta<Tipo>>();
    }

    public Tipo getDados() {
        return dado;
    }

    public void setDado(Tipo dado) {
        this.dado = dado;
    }
    
    public void adicionarArestaEntrada(Aresta<Tipo> aresta){
        this.arestasEntrada.add(aresta);
    }
    
    public void adicionarArestaSaida(Aresta<Tipo> aresta){
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<Tipo>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<Tipo>> getArestasSaida() {
        return arestasSaida;
    }
    
    
}
public class Aula_grafo {
    
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lourenço");
        grafo.adicionarVertice("Mariana");
        grafo.adicionarVertice("Celenia");
        grafo.adicionarVertice("Cláudio");
        
        grafo.adicionarAresta(2.0, "João", "António");
        grafo.adicionarAresta(3.0, "Pedro", "Costa");
        grafo.adicionarAresta(1.0, "Manuela", "Sabino");
        grafo.adicionarAresta(1.0, "José", "Fernandes");
        grafo.adicionarAresta(3.0, "Virginia", "Baptista");
        grafo.adicionarAresta(2.0, "Cláudio", "Mendoça");
        
        
        grafo.buscaEmLargura();
    }
    
}
}
<!-- Escreva seu código Java -->
<script type="grafo/java">
  package com.demo;
  import com.javapoly.dom.Window;
  public class Greeter {
    public static void sayHello(String name) {
      Window.alert("Hello " + name + ", from Java!");
    }
  }
</script>

<!-- Chame seu código Java a partir do JavaScript -->
<script type="grafo.java/javascript">
  com.demo.Greeter.sayHello("world");
</script>

