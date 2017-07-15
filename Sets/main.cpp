#include <iostream>
#include<bits/stdc++.h>
using namespace std ;
vector<set<string> > sets ;
set <string> universe ;
set<string> tmp;
int  n , m;
set<string>:: iterator it ;
int main() {
    ios::sync_with_stdio(false);
    cout << "Enter the number of total elements : " << endl;
    cin >> n ;
    cout << "Enter the elements : " << endl;
    string s ;
    for(int i = 0 ; i < n ; i++){
        cin >> s ;
        universe.insert(s);
    }
    cout << "Enter Number of sets : " << endl;
    cin >> n ;
    sets.resize(n);
    for(int i = 0 ; i < n ; i++){
        cout << "Enter the number of elements of set #" << i+1 << endl;
        cin >> m ;
        cout << "Enter the elements of set #" << i+1 << endl;
        for(int j = 0 ; j < m ; j++){
            cin >> s ;
            sets[i].insert(s);
        }
    }
    int set1 , set2 ;
    while(true){
        cout << "Enter 1 to union or 2 to intersect or 3 to complement or any thing else to exit " << endl;
        cin >> m ;
        if(m == 1 ){
            cout << "Enter the sets to union " << endl;
            cin >> set1 >> set2 ;
            tmp = sets[set1-1];
            for(it = sets[set2-1].begin() ; it != sets[set2-1].end() ; it++){
                tmp.insert(*it);
            }
        }else if(m== 2){
            cout << "Enter the sets to intersect " << endl;
            cin >> set1 >> set2 ;
            for(it = sets[set2-1].begin() ; it != sets[set2-1].end() ; it++){
                if(sets[set1-1].count(*it)){
                    tmp.insert(*it);
                }
            }
        }else if(m==3){
            cout << "Enter the set to complement " << endl;
            cin >> set1 ;
            for(it = universe.begin() ; it != universe.end() ; it++){
                if(!sets[set1-1].count(*it)){
                    tmp.insert(*it);
                }
            }

        }else{
            break;
        }
        cout << "Computing ..... \n" ;
        if (tmp.size() == 0 ){
            cout << "Empty set" << endl;
        }else{
            for(it = tmp.begin() ; it != tmp.end() ; it++){
                cout << *it << " " ;
            }
            cout << endl;
        }

        tmp.clear();
    }
    return 0;
}