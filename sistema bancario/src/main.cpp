#include <iostream>
#include <sstream>
#include <string>
#include <vector>

class Conta
{
    private:
        int numero;
        std::string titular;
        double saldo;
        static int totalContas;

    public:
        Conta(std::string titular) : titular(titular)
        {
            this->titular = titular;
            this->numero = totalContas;
            this->saldo = 0;
            totalContas++;
        }

        int getNumero() const { return numero; }
        void setNumero(int numero) { this->numero = numero; }
        
        std::string getTitular() const { return titular; }
        void setTitular(std::string titular) { this->titular = titular; }

        double getSaldo() const { return saldo; }
        void setSaldo(double saldo) { this->saldo = saldo; }

        static void init(std::istringstream& iss, std::vector<Conta>& contas)
        {
            std::string titular;
            iss >> titular;
            contas.emplace_back(titular);
        }

        static void show(std::istringstream& iss, std::vector<Conta>& contas)
        {

            int numConta;
            iss >> numConta;
            Conta *ptr;
            
            for (int i = 0; i < contas.size(); i++) {

                ptr = &contas.at(i);
                if (ptr->getNumero() == numConta) {
                    std::cout << ptr->toString() << '\n';
                    break;
                }
            }
        }

        static void deposit(std::istringstream& iss, std::vector<Conta>& contas)
        {
            int numConta;
            iss >> numConta;
            Conta *ptr;

            for (int i = 0; i < contas.size(); i++) {

                ptr = &contas.at(i);
                if (ptr->getNumero() == numConta) {
                    double saldoDeposito;
                    iss >> saldoDeposito;
                    ptr->setSaldo(saldoDeposito + ptr->getSaldo());
                    break;
                }
            }
        }

        static void transfer(std::istringstream& iss, std::vector<Conta>& contas)
        {
            int numConta, numConta2;
            double saldoTransferir;
            iss >> numConta;
            Conta *ptr;
            Conta *ptr2;
            for (int i = 0; i < contas.size(); i++) {

                ptr = &contas.at(i);
                if (ptr->getNumero() == numConta) {
                    iss >> numConta2;
                    for (int i = 0; i < contas.size(); i++) {
                        ptr2 = &contas.at(i);
                        if (ptr2->getNumero() == numConta2) {
                            iss >> saldoTransferir; 
                            ptr->setSaldo(ptr->getSaldo() - saldoTransferir);
                            ptr2->setSaldo(ptr2->getSaldo() + saldoTransferir);
                            break;
                        }
                    }
                }
            }

        }

        static void withdraw(std::istringstream& iss, std::vector<Conta>& contas)
        {
            
            int numConta;
            iss >> numConta;
            Conta *ptr;

            for (int i = 0; i < contas.size(); i++) {

                ptr = &contas.at(i);
                if (ptr->getNumero() == numConta) {
                    double saldoSaque;
                    iss >> saldoSaque;
                    int diferença = ptr->getSaldo();
                    ptr->setSaldo(ptr->getSaldo() - saldoSaque);
                    if (ptr->getSaldo() < 0) {
                        ptr->setSaldo(0);
                        std::cerr << "Conta ficou zerada após o saque " << diferença << " reais\n";
                    }
                    break;
                }
            }
        }

        std::string toString() const
        {
            return "Numero da conta: " + std::to_string(getNumero()) + ", Titular: " + getTitular()
                + ", Saldo: " + std::to_string(getSaldo());
        }

};

int Conta::totalContas = 0;

int main()
{
    std::string buffer; 
    std::vector<Conta> contas;

    while (1) {
        std::getline(std::cin,  buffer);
        std::istringstream iss (buffer);

        std::cout << "$" << buffer << '\n';

        std::string command;
        iss >> command;

        if (command == "end") {
            break; 
        }
        else if (command == "init") {
            Conta::init(iss, contas);
        }
        else if (command == "show") {
            Conta::show(iss, contas);
        }
        else if (command == "deposita") {
            Conta::deposit(iss, contas);
        }
        else if (command == "transfere") {
            Conta::transfer(iss, contas);
        }
        else if (command == "saca") {
            Conta::withdraw(iss, contas);
        } else {
            std::cerr << "fail: comando inválido." << '\n';
        }
    }

    return 0;
}
