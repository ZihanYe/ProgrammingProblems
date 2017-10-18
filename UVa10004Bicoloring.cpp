//
//  main.cpp
//  UVa10004
//
//  Created by Clover Ye on 18/10/2017.
//  Copyright © 2017 Clover Ye. All rights reserved.
//

/*
 UVa 10004 Bicoloring
 In 1976 the “Four Color Map Theorem” was proven with the assistance of a computer. This theorem states that every map can be colored using only four colors, in such a way that no region is colored using the same color as a neighbor region.
 Here you are asked to solve a simpler similar problem. You have to decide whether a given arbitrary connected graph can be bicolored. That is, if one can assign colors (from a palette of two) to the nodes in such a way that no two adjacent nodes have the same color. To simplify the problem you can assume:
 • no node will have an edge to itself.
 • the graph is nondirected. That is, if a node a is said to be connected to a node b, then you must
 assume that b is connected to a.
 • the graph will be strongly connected. That is, there will be at least one path from any node to
 any other node.
 
 Input
 The input consists of several test cases. Each test case starts with a line containing the number n (1 < n < 200) of different nodes. The second line contains the number of edges l. After this, l lines will follow, each containing two numbers that specify an edge between the two nodes that they represent. A node in the graph will be labeled using a number a (0 ≤ a < n).
 An input with n = 0 will mark the end of the input and is not to be processed. Output
 You have to decide whether the input graph can be bicolored or not, and print it as shown below.

 Output
 You have to decide whether the input graph can be bicolored or not, and print it as shown below.
 
 
 */

#include <iostream>
using namespace std;

int n,l;
int flag;
int times[200];
bool edges[200][200] = {{false}};
bool visited[200] = {false};

bool dfs(int u){
    visited[u] = true;
    flag++;
    times[u] = flag;
    for (int i=0;i<n;i++){
        if (edges[u][i] && !visited[i]){
            if (!dfs(i))
                return false;
        }
        if (edges[u][i] && visited[i]){
            if ((times[u] - times[i])%2 == 0){
                //odd cycle
                return false;
            }
        }
    }
    flag --;
    return true;
}

int main(int argc, const char * argv[]) {
    //input

    cin >> n;
    while (n != 0){
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                edges[i][j]=false;
            }
        }
        cin >> l;
        for (int i=0; i<l;i++){
            int x,y;
            cin >> x >> y;
            edges[x][y]= true;
            edges[y][x]= true;
        }
        // if a graph contains odd cycle then it is not bicolorable
        // dfs to find all cycles
        bool ok = true;
        for (int i=0; i<n;i++){
            visited[i] = false;
        }
        for (int i=0; i<n; i++){
            if (!visited[i]){
                flag = 0;
                ok = ok && dfs(i);
                if (!ok){
                    break;
                }
            }
        }
        
        if (ok)
            cout << "BICOLORABLE."<<endl;
        else
            cout << "NOT BICOLORABLE." << endl;
        
        cin >> n;
    }
    
    
    
    return 0;
}
