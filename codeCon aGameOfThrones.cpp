//
//  main.cpp
//  exercise
//
//  Created by Clover Ye on 2017/10/12.
//  Copyright © 2017年 Clover Ye. All rights reserved.
//

/*
 War has been declared in Westeros. All houses, great and small, are vying for the iron throne.
 
 In this problem, you will be given a list containing: the name of each house, the number of sworn knights the house has, and the names of any houses sworn as bannermen. Bannermen are houses who swear their allegiance to a greater house, which we refer to as their liege lord. Beginning with the lowest houses (those without any bannermen), you will evaluate whether or not a liege lord is overthrown by one of his bannermen.
 
 A liege lord is overthrown if the number of sworn knights that the lord has is at least 3 less than the number one of his bannermen has. The overthrowing bannerman will then take the place of his liege lord in the house hierarchy while the former lord is relegated to bannerman. If multiple bannermen fit this description, the one with the most sworn knights wins, with ties broken in ascii order of house name. Proceeding in this way, you will continue on up the chain of houses until you reach the iron throne.
 
 
 Input Specifications
 
 The first line will contain a single integer, n, the number of houses in the game.
 
 This will be followed by n lines, one per house.
 
 Each line contains a space-separated list. The first token is the name of the house. The second token is the number of sworn knights the house has. The third token is an integer, b, the number of bannermen the house has. The final 'b' tokens are the names of that house's bannermen (subordinate houses).
 
 Note that house names are made up of an unbroken string of letters (possibly mixed case) with no punctuation or spaces contained.
 
 There will be no more than 50 houses provided.
 
 
 Output Specifications
 
 Ouput the levels of the resulting Westeros house hierarchy, in level order, one level per line. The house in control of the iron throne is printed first, all of its bannermen will be on the second line, and so on.
 
 Note that because we proceed bottom to top, it is possible for a house to move up multiple levels in the chain, but no house may descend more than one level.
 
 Sort each level in strict ascii order (case-sensitive), irrespective of the number of sworn knights.
 
 
 Sample Input/Output
 
 INPUT
 13
 Umber 4 0
 Frey 5 0
 Bolton 7 0
 Targaryen 6 0
 Martell 7 0
 Tyrell 5 0
 Clegane 7 0
 Arryn 5 0
 Greyjoy 5 0
 Tully 1 3 Umber Frey Bolton
 Lannister 5 4 Targaryen Martell Tyrell Clegane
 Stark 2 3 Arryn Greyjoy Tully
 Baratheon 4 2 Stark Lannister
 OUTPUT
 Bolton
 Baratheon Lannister
 Arryn Clegane Greyjoy Martell Stark Targaryen Tyrell
 Frey Tully Umber
 EXPLANATION
 The following house hierarchy is provided:
 Baratheon
 _____/        \___
 Stark            Lannister
 ____/    __|__    \____    _______/    ___/    \___    \______
 Arryn    Greyjoy    Tully    Targaryen    Martell    Tyrell    Clegane
 _____/    __|__    \____
 Umber    Frey    Bolton
 In the first round, House Bolton swaps with House Tully since it has 6 more sworn knights and the most amongst its siblings. In round 2, House Bolton swaps with House Stark because it has 5 more sworn knights and, again, the most amongst its siblings. On the other side, no house has enough knights to swap with House Lannister. Finally, in the last round, House Bolton swaps with house Baratheon to claim the iron throne.
 */

#include <iostream>
#include <sstream>
    
    using namespace std;
    
    struct house {
        string name;
        int sworn;
        int numBannermen;
        int bannermen[50];
        int overthrownMan = -1;
    };
    house houses [51];
    
    void sort(int x, int y){
        int len = y - x;
        string temp;
        for (int i=0; i< len; i++) {
            for (int j=x; j < y-i-1; j++) {
                if (houses[j+1].name > houses[j].name) {
                    temp = houses[j].name;
                    houses[j].name = houses[j+1].name;
                    houses[j+1].name = temp;
                }
            }
        }
    }
    
    int main(int argc, const char * argv[]) {
        
        //input
        int n;
        cin >> n;
        
        for (int i=0; i< n; i++)
        {
            cin >> houses[i].name;
            cin >> houses[i].sworn;
            cin >> houses[i].numBannermen;
            int maxSworn = houses[i].sworn + 3;
            bool overthrown = false;
            int overthrownMan = 50;
            for (int j=0; j<houses[i].numBannermen; j++)
            {
                string name;
                cin >> name;
                int k =0;
                while (k < i && houses[k].name != name) { k++;}
                if (k < i)
                {
                    houses[i].bannermen[j] = k;
                    if (houses[k].sworn > maxSworn)
                    {
                        overthrown = true;
                        overthrownMan = k;
                        maxSworn = houses[k].sworn;
                    }
                    else if (houses[k].sworn == maxSworn)
                    {
                        if ((!overthrown) || houses[overthrownMan].name > houses[k].name){
                            overthrown = true;
                            overthrownMan = k;
                        }
                    }
                }
            }
            if (overthrown){
                houses[i].overthrownMan = overthrownMan;
                int temp = houses[overthrownMan].sworn;
                houses[overthrownMan].sworn = houses[i].sworn;
                houses[i].sworn = temp;
            }
            
        }
        
        int i = 0;
        while (i < n){
            if (houses[i].overthrownMan != -1){
                string tempName = houses[i].name;
                houses[i].name = houses[houses[i].overthrownMan].name;
                houses[houses[i].overthrownMan].name = tempName;
            }
            i++;
        }
        
        int oldmin = n;
        int min = n-1;
        while (min < oldmin){
            int newmin = min;
            sort(min, oldmin);
            int k = oldmin -1;
            while (k >= min){
                cout << houses[k].name << " ";
                for (int t=0;t <houses[k].numBannermen;t++){
                    if (houses[k].bannermen[t] < newmin){
                        newmin = houses[k].bannermen[t];
                    }
                }
                k --;
            }
            cout << endl;
            oldmin = min;
            min = newmin;
        }
        
    }
