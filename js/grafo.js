class Graph {
    constructor() {
        this.nodes = new Map(); // Armazena os nós e suas arestas
    }

    addNode(node) {
        this.nodes.set(node, new Set()); // Cria um novo nó com um conjunto vazio de arestas
    }

    addEdge(node1, node2) {
        this.nodes.get(node1).add(node2); // Adiciona uma aresta entre dois nós
        this.nodes.get(node2).add(node1); // Grafo não direcionado, então adicionamos nos dois sentidos
    }

    getNeighbors(node) {
        return Array.from(this.nodes.get(node)); // Retorna os vizinhos de um nó
    }
}

// Exemplo de uso
const myGraph = new Graph();
myGraph.addNode('A');
myGraph.addNode('B');
myGraph.addNode('C');
myGraph.addEdge('A', 'B');
myGraph.addEdge('B', 'C');

console.log(myGraph.getNeighbors('B')); // ['A', 'C']
