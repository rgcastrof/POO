// Declaração dos atributos e métodos da classe Market

#ifndef __MARKET_H__
#define __MARKET_H__

#include <sstream>
#include <string>
#include <vector>
#include "Person.h"

class Market {
    private:
        /** vetor para a quantidade de caixas em Market,
        é declarado como ponteiro pois é necessário
        para inicializar todos os caixas com valores
        nulos, a saber, nullptrs. Responsáveis por in-
        dicar se os caixas estão vazios. **/
        std::vector<Person*> cashier; 

        std::vector<Person> queue;

    public:
        Market(int cachierQtd);
        ~Market();

        void init(int cashierQtd, Market& market);

        void arrive(std::string name);

        void call(int number);
        void finish(int number);
        const std::string toString();

};

#endif
