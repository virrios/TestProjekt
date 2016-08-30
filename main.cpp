#include <iostream>

using namespace std;
int funkt(int p);
int main()
{
    int fyra=4;
    int *ptr =&fyra;

    cout <<  "Hello world: " <<fyra <<" "<<ptr<< endl;
    *ptr=funkt(fyra);

    cout <<  "Hello world: " <<fyra <<" "<<ptr<< endl;

    return 0;
}


int funkt(int p){

    int s= p*p;
    return s;
}
