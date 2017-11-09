#include <iostream>

int main() {
    using namespace std;
    char c;
    
    bool pancake[1000];
    int s,n,k;
    
    cin >> s;
    for (int t=1;t<=s;t++){
        n = 0;
        cin >> c;
        while (c == '-' || c == '+'){
            pancake[n] = (c=='+');
            n++;
            cin.get(c);
        }
        cin >> k;
        
        int numFlip = 0;
        int i =0;
        while (i<= n-k){
            if (!pancake[i]){
                //flip
                numFlip ++;
                for (int j=0;j<k;j++){
                    pancake[i+j] = !pancake[i+j];
                }
            }
            i++;
        }
        
        int j = n-k+1;
        while (j<n && pancake[j]){
        	j ++;
        }
        if (j < n){
        	cout << "Case #" << t << ": IMPOSSIBLE" << endl;
        }
        else{
        	cout << "Case #" << t << ": " << numFlip << endl;
        }
        
    }
    
    return 0;
    
}
