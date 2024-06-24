
class Node {
    constructor(valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class LinkedList {
    constructor() {
        this.cabeca = null;
    }

    adicionarElemento(valor) {
        const novoNo = new Node(valor);
        novoNo.proximo = this.cabeca;
        this.cabeca = novoNo;
    }

    exibirLista() {
        let atual = this.cabeca;
        while (atual) {
            console.log(atual.valor);
            atual = atual.proximo;
        }
    }
}

// Exemplo de uso:
const lista = new LinkedList();
lista.adicionarElemento(10);
lista.adicionarElemento(20);
lista.adicionarElemento(30);
lista.exibirLista();
