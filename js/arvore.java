<!-- Inclua o Polyfill -->
<script src="https://www.javapoly.com/javapoly.js"></script>
public class Node {
 
    private String nome;
    private Node esquerda;
    private Node direita;
     
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; } 
    public Node getEsquerda() { return esquerda; }
    public void setEsquerda(Node esquerda) { this.esquerda = esquerda; }
    public Node getDireita() { return direita; }
    public void setDireita(Node direita) { this.direita = direita; }
     
    public Node(){
        this(null, null, null);
    }
    public Node(String nome){
        this(nome, null, null);
    }
     
    public Node(String nome, Node esquerda, Node direita){
        setNome(nome);
        setEsquerda(esquerda);
        setDireita(direita);
    }
     
    @Override
    public int hashCode() {
        return getNome() == null ? 0 : getNome().hashCode();
    }
     
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Node)) { return false; }
        return ((Node)obj).hashCode() == hashCode();
    }
     
    @Override
    public String toString() {
        return getNome() == null ? "" : getNome();
    }
     
}
O objetivo da classe nó (‘Node’) é ser um nodo da árvore binária, possuindo um iden

     
    /**
     * ao invés deste enum, poderia ser usado um boolean
     */
    public enum ModoRL {
        esquerda, direita
    }
     
    private Node arvore;
 
    public Node getArvore() { return arvore; }
    public void setArvore(Node arvore) { this.arvore = arvore; }
     
    /**
     * 
     * @param raiz raiz da árvore
     */
    public ArvoreBin(String raiz){
        setArvore(new Node(raiz));
    }
     
    /**
     * adiciona um novo nó
     * @param noPai nome do nó pai
     * @param nomeNo nome do novo nó
     * @param modo posição: direita / esquerda
     */
    public void AdicionarNo(String noPai, String nomeNo, ModoRL modo){
        if (modo == ModoRL.direita) {
            AdicionarNoDireita(noPai, nomeNo);
        } else if (modo == ModoRL.esquerda) {
            AdicionarNoEsquerda(noPai, nomeNo);
        }
    }
     
    public void AdicionarNoEsquerda(String noPai, String nomeNo){
        Node no = findNode(getArvore(), noPai);
        if (no == null) { return; }
        no.setEsquerda(new Node(nomeNo));
    }
     
    public void AdicionarNoDireita(String noPai, String nomeNo){
        Node no = findNode(getArvore(), noPai);
        if (no == null) { return; }
        no.setDireita(new Node(nomeNo));
    }
     
    /**
     * A ideia não é criar uma árvore binária ordenada,
     * por isto a busca exaustiva pelos nós.
 
     * A principal ideia é permitir criar qualquer tipo
     * de árvore, com qualquer tipo de ordenação.
     * @param no
     * @param nome
     * @return
     */
    private Node findNode(Node no, String nome){
        if (no == null || nome == null || nome.isEmpty()) { return null; }
        if (no.getNome().equals(nome)) { return no; }
        Node noesquerda = findNode(no.getEsquerda(), nome);
        if (noesquerda != null) { return noesquerda; }
        return findNode(no.getDireita(), nome);
    }
     
    /**
     * limpa a árvore
     * @param raiz raiz da árvore
     */
    public void Clear(String raiz){
        nullnodes(getArvore());
        setArvore(new Node(raiz));
    }
     
    /**
     * método recursivo auxiliar para limpar a árvore
     * @param no
     */
    private void nullnodes(Node no){
        if (no == null) { return; }
        nullnodes(no.getDireita());
        nullnodes(no.getEsquerda());
        no.setEsquerda(null); no.setDireita(null);
        no = null;
    }
     
    /**
     * RED
     * @return
     */
    public String PreOrdem(){
        if (getArvore() == null) { return ""; }
        return readPreOrdem(getArvore());
    }
     
    /**
     * RED
     * @param no
     * @return
     */
    private String readPreOrdem(Node no){
        if (no == null) {return "";}
        String rt = no.toString();
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPreOrdem(no.getEsquerda());
        }
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPreOrdem(no.getDireita());
        }
        return rt;
    }
     
    /**
     * ERD
     * @return
     */
    public String InOrdem(){
        if (getArvore() == null) { return ""; }
        return readInOrdem(getArvore());
    }
     
    /**
     * ERD
     * @param no
     * @return
     */
    private String readInOrdem(Node no){
        if (no == null) {return "";}
        String rt = "";
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readInOrdem(no.getEsquerda());
        }
        rt += (rt.isEmpty() ? "" : ",") + no.toString();
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readInOrdem(no.getDireita());
        }
        return rt;
    }
     
    /**
     * EDR
     * @return
     */
    public String PosOrdem(){
        if (getArvore() == null) { return ""; }
        return readPosOrdem(getArvore());
    }
     
    /**
     * EDR
     * @param no
     * @return
     */
    private String readPosOrdem(Node no){
        if (no == null) {return "";}
        String rt = "";
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPosOrdem(no.getEsquerda());
        }
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPosOrdem(no.getDireita());
        }
        rt += (rt.isEmpty() ? "" : ",") + no.toString();
        return rt;
    }
     


public class Main {
 
    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        ArvoreBin arvore = new ArvoreBin("A");
         
        arvore.AdicionarNo("A","B", ModoRL.esquerda);
        arvore.AdicionarNo("B", "D", ModoRL.esquerda);
        arvore.AdicionarNo("A", "C", ModoRL.direita);
        arvore.AdicionarNo("C", "E", ModoRL.esquerda);
        arvore.AdicionarNo("E", "G", ModoRL.direita);
        arvore.AdicionarNo("C", "F", ModoRL.direita);
        arvore.AdicionarNo("F", "H", ModoRL.esquerda);
        arvore.AdicionarNo("F", "I", ModoRL.direita);
         
        System.out.println("PreOrdem (RED): " + arvore.PreOrdem());
        System.out.println("InOrdem (ERD): " + arvore.InOrdem());
        System.out.println("PosOrdem (EDR): " + arvore.PosOrdem());
        System.out.println("-----------------------------------------");
         
        arvore.Clear("F");
         
        arvore.AdicionarNo("F","B", ModoRL.esquerda);
        arvore.AdicionarNo("B","A", ModoRL.esquerda);
        arvore.AdicionarNo("B","D", ModoRL.direita);
        arvore.AdicionarNo("D","C", ModoRL.esquerda);
        arvore.AdicionarNo("D","E", ModoRL.direita);
        arvore.AdicionarNo("F","G", ModoRL.direita);
        arvore.AdicionarNo("G","I", ModoRL.direita);
        arvore.AdicionarNo("I","H", ModoRL.esquerda);
         
        System.out.println("PreOrdem (RED): " + arvore.PreOrdem());
        System.out.println("InOrdem (ERD): " + arvore.InOrdem());
        System.out.println("PosOrdem (EDR): " + arvore.PosOrdem());
        System.out.println("-----------------------------------------");
         
        arvore.Clear("A");
         
        arvore.AdicionarNo("A","B", ModoRL.esquerda);
        arvore.AdicionarNo("B","C", ModoRL.esquerda);
        arvore.AdicionarNo("C","E", ModoRL.esquerda);
        arvore.AdicionarNo("E","I", ModoRL.direita);
        arvore.AdicionarNo("C","F", ModoRL.direita);
        arvore.AdicionarNo("F","J", ModoRL.direita);
        arvore.AdicionarNo("B","D", ModoRL.direita);
        arvore.AdicionarNo("D","G", ModoRL.esquerda);
        arvore.AdicionarNo("D","H", ModoRL.direita);
        arvore.AdicionarNo("H","K", ModoRL.esquerda);
        arvore.AdicionarNo("H","L", ModoRL.direita);
         
        System.out.println("PreOrdem (RED): " + arvore.PreOrdem());
        System.out.println("InOrdem (ERD): " + arvore.InOrdem());
        System.out.println("PosOrdem (EDR): " + arvore.PosOrdem());
        System.out.println("-----------------------------------------");
    }
 
}
/*
 
    Saída
    -----------------------------------------
    PreOrdem (RED): A,B,D,C,E,G,F,H,I
    InOrdem (ERD): D,B,A,E,G,C,H,F,I
    PosOrdem (EDR): D,B,G,E,H,I,F,C,A
    -----------------------------------------
    PreOrdem (RED): F,B,A,D,C,E,G,I,H
    InOrdem (ERD): A,B,C,D,E,F,G,H,I
    PosOrdem (EDR): A,C,E,D,B,H,I,G,F
    -----------------------------------------
    PreOrdem (RED): A,B,C,E,I,F,J,D,G,H,K,L
    InOrdem (ERD): E,I,C,F,J,B,G,D,K,H,L,A
    PosOrdem (EDR): I,E,J,F,C,G,K,L,H,D,B,A
    -----------------------------------------
 
*/

<!-- Escreva seu código Java -->
<script type="arvore/java">
  package com.demo;
  import com.javapoly.dom.Window;
  public class Greeter {
    public static void sayHello(String name) {
      Window.alert("Hello " + name + ", from Java!");
    }
  }
</script>

<!-- Chame seu código Java a partir do JavaScript -->
<script type="arvore.java/javascript">
  com.demo.Greeter.sayHello("world");
</script>


