#include "../src/include/Market.h"
#include <iostream>
#include <sstream>

// Construtor da classe Market
Market::Market(int cashierQtd) {}

/** Método para iniciar o mercado, recebe como parâmetro a quantidade de caixas
 * extraída com iss no método main uma referência ao objeto da classe Market ins-
 * tanciado no início do método main, que é instanciado com valor 0, ou seja,
 * quantiade de caixas igual a 0. Aqui, a referência ao objeto instanciado em
 * main receberá como parâmetro cashierQtd, que será a nova quantidade de caixas
 * no mercado.
 * Após isto, o loop for irá criar espaços e armazenar nullptrs até a quantidade
 * de caixas informada. (Para mais informações sobre o vetor cashier armazenando
 * nullptrs, declaração do vetor em Market.h). **/
void Market::init(int cashierQtd, Market& market)
{
    market = Market(cashierQtd); 

    for (int i = 0; i < cashierQtd; i++) {
        cashier.push_back(nullptr);
    }

}

/** Destrutor da classe Market, necessário para desalocar a memória alocada dinâ-
 * micamente no vetor cashier. (Para mais informações sobre a alocação dinâmica no
 * vetor cashier, ver implementação do método call no mesmo arquivo.). **/
Market::~Market()
{
    for (int i = 0; i < cashier.size(); i++) {
        if (cashier.at(i) != nullptr) {
            delete cashier.at(i);
            cashier.at(i) = nullptr;
        }
    }
}

// Método para construir um novo objeto pessoa no vetor de fila de espera.
void Market::arrive(std::string name)
{
    queue.emplace_back(name); 
}

/** Método para chamar um cliente da fila de espera para um caixa fazio. Primei-
 * ro verifica se a fila de espera está vazia, se sim, informa o erro: não há clien-
 * tes na fila. Se não, verifica se o caixa especificado pelo parâmetro number
 * está vazio. Se sim, chama o construtor da classe Person com a palavra chave
 * 'new' antes do construtor, para instanciar um novo objeto de forma dinâmica.
 * É necessária a instanciação dinâmica pois cashier foi definido para armazenar
 * ponteiros, não objetos diretos. Assim, é preciso criar explicitamente o objeto
 * no heap para que ele persista além do escopo local da função.
 * O parâmetro que o construtor recebe é o método getName() do primeiro objeto arma-
 * zenado no vetor da fila de espera. A função '.front()' é usada aqui, ao invés de
 * '.begin()', pois '.front()' retorna uma referência direta ao primeiro elemento
 * do vetor queue, permitindo acessar diretamente este elemento. No caso de '.begin',
 * seria retornado um iterador apontando para o primeiro elemento do vetor, não uma
 * referência direta a ele. Nesta condição, a cópia gerada com '.begin()' não poderia
 * ser atribuída a um elemento do vetor cashier, uma vez que este armazena ponteiros
 * para objetos, não objetos diretos; nem seria possível acessar diretamente o mé-
 * todo getName() do objeto localizado no primeiro espaço do vetor.
 * Finalmente, é usada a função '.erase()' no primeiro elemento do vetor queue para
 * remover o cliente da fila de espera. **/
void Market::call(int number)
{
    if (!queue.empty() && number < cashier.size()) {

        if (cashier.at(number) == nullptr) {

            cashier.at(number) = new Person(queue.front().getName());
            queue.erase(queue.begin());
        } else {
            std::cout << "fail: caixa ocupado.\n";
        }
    } else {
        std::cout << "fail: sem clientes.\n";
    }
}

/** O método a seguir é utilizado para remover o objeto da classe Person do vetor
 * cashier, simulando o fim do atendido do cliente no caixa. Primeiro é verificado
 * se o parâmetro number está dentro da quantidade de caixas existentes, se não,
 * informa o erro: caixa inexistente. O próximo if verifica se o caixa no número
 * definido não está vazio. Se estiver vazio, informa o erro: caixa vazio, no caso,
 * contrário, substitui o elemento armazenado no caixa escolhido por um nullptr,
 * tornando o caixa vazio novamente. **/
void Market::finish(int number)
{
    if (number >= cashier.size()) {
        std::cout << "fail: caixa inexistente.\n";
    } else if (cashier.at(number) != nullptr) {
        delete cashier.at(number);
        cashier.at(number) = nullptr;
    } else {
        std::cout << "fail: caixa vazio.\n";
    }
}

/** Este método usa a função ostringstream para concatenar uma stream em uma
 * única string e retorná-la ao final do método. Para mostrar os clientes em
 * ambos o vetores (caixas e fila de espera), é criado um ponteiro que aponta
 * para o objeto em cada espaço de cada vetor permitindo acessar o método
 * getName() da classe Person. **/
const std::string Market::toString()
{
    std::ostringstream oss;
    oss << "Caixa: [ ";
     
    for (int i = 0; i < cashier.size(); i++) {
        if (cashier.at(i) == nullptr) {
            oss << "----- ";
        } else {
            oss << cashier.at(i)->getName() << " ";
        }

    }
    oss << "]\nEspera: [ ";
    if (queue.size() == 0) {
        oss << "]\n";
        return oss.str();
    } else {

        for (int i = 0; i < queue.size(); i++) {
            oss << queue.at(i).getName() << " ";
        }
    }
    oss << "]\n";

    return oss.str();
} 
