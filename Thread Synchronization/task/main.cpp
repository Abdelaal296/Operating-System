#include <iostream>
using namespace std;
class Payment{
public:
    int amount;
    Payment(){}
    Payment(int m){
        amount=m;
    }
    virtual int getSerivceFees(){}
    virtual int pay(int amount){}

};

class Fawry:Payment{
public:

    Fawry(int m): Payment(m)  {
        this->amount = m  ;
    }
    int getSerivceFees(){
        return 10;
    }

    int pay(int amount){
        int res=amount+getSerivceFees();
        return res;
    }


};

class VodaFoneCash:Payment{
    VodaFoneCash(int m): Payment(m)  {
        this->amount = m  ;
    }
    int getSerivceFees(){
        return 5;
    }

    int pay(int amount){
        int res=amount+getSerivceFees();
        return res;
    }

};
class Installment{
    virtual int clacIntersst(){}
};
class NOInstallment:Installment{
    int clacIntersst(){
        return 0;
    }
};
class TwelveMonths:Installment{
    int clacIntersst(){
        return 10;
    }
};
class ElevenMonths:Installment{
    int clacIntersst(){
        return 20;
    }
};
class Billing{
public:
    int checkOut(Payment pay){
        return pay.amount;
    }
    virtual int clacDelivery(int dfees){}


};

class CreateRunner:Billing{
public:
    int clacDelivery(int dfees){
        return dfees;
    }
};
class drivethrow:Billing{
public:
    int clacDelivery(int dfees){
        cout<<"NO FEES";
        return 0;
    }
};

class Delivery{
public:
    virtual int getFees(){}
};

class Runner:Delivery{
    int getFees(){
        return 50;
    }
};
class drive:Delivery{
    int getFees(){
        return 1;
    }
};

int main() {
//    Payment p =new Fawry(5);
//    Billing b;
//    cout<<b.checkOut(p);
//    return 0;
}
