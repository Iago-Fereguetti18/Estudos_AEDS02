import java.util.*;

/*
 * Testes de funçoes para lista flexivel dupla
 */

class CelulaDupla {
    public int elemento;
    public CelulaDupla prox, ant;

    // construtor
    public CelulaDupla() {
        this(0);
    }

    public CelulaDupla(int x) {
        this.elemento = x;
        this.prox = this.ant = null;
    }
}

class ListaDupla {
    private CelulaDupla primeiro, ultimo;

    // construtor
    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    // funcoes Lista
    /**
     * Função para pegar tamanho atual da lista
     * @return count
     */
    public int Tamanho(){
        int count = 0;
        CelulaDupla i = primeiro.prox;//pegar valor na posição 0(celula posterior da celula primeiro)
        for(count = 0; i != null; i = i.prox, count++);//andar na lista até o final contando

        return count;
    }

    /**
     * Função para inserir no inicio
     * @param x
     */
    public void inserirInicio(int x) {
        CelulaDupla tmp = new CelulaDupla(x);//criar nova celula
        tmp.ant = primeiro;//direcionar ponteiro de anterior da nova celula para a celula primeiro
        tmp.prox = primeiro.prox;//direcionar ponteiro de proximo da nova celula para a celula pos primeiro
        primeiro.prox = tmp;//direcionar ponteiro de primeiro para nova celula
        if (primeiro == ultimo) {
            ultimo = tmp;//caso a lista esteja vazia colocar referencia ultimo na nova celula
        }
        tmp = null;//retirar referencia da celula inserida
    }

    /**
     * Funcao para inserir no fim
     * @param x
     */
    public void inserirFim(int x) {
        ultimo.prox = new CelulaDupla(x);//criar nova celula na posicao posterior a ultimo
        ultimo.prox.ant = ultimo;//direcionar ponteiro ant da nova celula para ultimo
        ultimo = ultimo.prox;//redirecionar referencia ultimo para nova celula
    }

    /**
     * Funcao para inserir em qualquer posisao da lista
     * @param x
     * @param pos
     */
    public void inserir(int x, int pos) {
        int tam = 0;
        tam = Tamanho();//pegar tamanho para testes

        if (pos < 0 || pos > tam) {//testar posisao
            System.out.println("Posicao invalida");
            // return -1;
        } else if (pos == 0) {//caso posisao seja primeiro
            inserirInicio(x);
        } else if (pos == tam) {//caso posicao seja ultimo
            inserirFim(x);
        } else {
            CelulaDupla i = primeiro;//criar celula para referencia
            for (int j = 0; j < pos; i = i.prox, j++)//andar celula para posicao anterior pedida
                ;
            CelulaDupla tmp = new CelulaDupla(x);//criar nova celula para insercao
            tmp.ant = i;//direcionar ponteiro anterior da celula a ser inserida para referencia
            tmp.prox = i.prox;//direcionar ponteiro proximo da celula a ser inserida para referencia
            tmp.ant.prox = tmp.prox.ant = tmp;//retirar ponteiros de tmp
            tmp = i = null;//retirar celulas
        }
    }

    /**
     * Funcao para remover no inicio
     * @return
     */
    public int removerInicio() {
        int removido = 0;
        if (primeiro == ultimo) {//verificar se a lista não esta vazia
            System.out.println("Lita vazia");
            return -1;
        }
        CelulaDupla tmp = primeiro;//Criar nova celula na referencia primeiro
        primeiro = primeiro.prox;//passar referencia para proxima celula
        removido = primeiro.elemento;//copiar elemento
        tmp.prox = primeiro.ant = null;//apagar ponteiros
        tmp = null;
        return removido;
    }

    public int removerFim() {
        int removido = 0;
        if (primeiro == ultimo) {//verificar se a lista nã oestar vazia
            System.out.println("Lita vazia");
            return -1;
        }
        ultimo = ultimo.ant;//passar referencia para ultimo para o valor anterior
        ultimo.prox.ant = null;//apagar ponteiro para ultimo valor da lista
        ultimo.prox = null;//apagar ponteiro do ultimo valor da lista
        return removido;
    }

    public int remover(int pos){
        int removido = 0;
        int tam = Tamanho();//pegar tamanho para testes
        if(pos < 0 || pos > tam){//testar posisao
            System.out.println("ERRO - Posisao Invalida");
            return -1;
        }else if(pos == 0){//caso posicao seja primeiro
            removerInicio();
        }else if(pos == tam){//caso posicao seja ultimo
            removerFim();
        }else{
            CelulaDupla i = primeiro;//criar celula para referencia
            for(int j = 0; j <= pos; i = i.prox, j++);
            i.ant.prox = i.prox;//apagar ponteiros
            i.prox.ant = i.ant;//apagar ponteiros
            removido = i.elemento;//copiar elemento
            i = i.prox = i.ant = null;//apagar
            i = null;
        }


        return removido;
    }

    public void mostrar() {
        CelulaDupla i = primeiro.prox;
        int x = 0;
        while (i != null) {
            System.out.println(x + ": " + i.elemento);
            i = i.prox;
            x++;
        }
    }
}

public class ListaDupla01 {

    public static void main(String[] args) {
        ListaDupla lista = new ListaDupla();
        Scanner scanner = new Scanner(System.in);
        System.out.println("0 - Parar");
        System.out.println("1 - inserir inicio");
        System.out.println("2 - inserir fim");
        System.out.println("3 - inserir inserir");
        System.out.println("4 - remover inicio");
        System.out.println("5 - remover fim");
        System.out.println("6 - remover remover");
        System.out.print("Escolha um metodo: ");
        int x = scanner.nextInt();

        while (x != 0) {
            int input = 0;
            int pos = 0;
            switch (x) {
                case 0:
                    break;
                case 1:
                    System.out.println("1 - inserir inicio");
                    System.out.print("Valor a ser inserido: ");
                    input = scanner.nextInt();
                    lista.inserirInicio(input);
                    System.out.println("-----------------");
                    System.out.println("Lista: ");
                    lista.mostrar();
                    System.out.println("-----------------");
                    break;
                case 2:
                    System.out.println("2 - inserir fim");
                    System.out.print("Valor a ser inserido: ");
                    input = scanner.nextInt();
                    lista.inserirFim(input);
                    System.out.println("-----------------");
                    System.out.println("Lista: ");
                    lista.mostrar();
                    System.out.println("-----------------");
                    break;
                case 3:
                    System.out.println("3 - inserir");
                    System.out.print("Valor a ser inserido: ");
                    input = scanner.nextInt();
                    System.out.println("Posicao: ");
                    pos = scanner.nextInt();
                    lista.inserir(input, pos);
                    System.out.println("-----------------");
                    System.out.println("Lista: ");
                    lista.mostrar();
                    System.out.println("-----------------");
                    break;
                case 4:
                    System.out.println("4 - retirar inicio");
                    lista.removerInicio();
                    System.out.println("-----------------");
                    System.out.println("Lista: ");
                    lista.mostrar();
                    System.out.println("-----------------");
                    break;
                case 5:
                    System.out.println("5 - retirar fim");
                    lista.removerFim();
                    System.out.println("-----------------");
                    System.out.println("Lista: ");
                    lista.mostrar();
                    System.out.println("-----------------");
                    break;
                case 6:
                    System.out.println("6 - retirar");
                    System.out.print("Posicao a ser retirado: ");
                    input = scanner.nextInt();
                    lista.remover(input);
                    System.out.println("-----------------");
                    System.out.println("Lista: ");
                    lista.mostrar();
                    System.out.println("-----------------");
                    break;
                default:
                    System.out.println("ERRO - VALOR_INVALIDO");
            }
            System.out.println("0 - Parar");
            System.out.println("1 - inserir inicio");
            System.out.println("2 - inserir fim");
            System.out.println("3 - inserir inserir");
            System.out.println("4 - remover inicio");
            System.out.println("5 - remover fim");
            System.out.println("6 - remover remover");
            System.out.print("Escolha um metodo: ");
            x = scanner.nextInt();
        }

        scanner.close();
    }
}