/* codeJam Qualification Round 2017 B
Problem

Tatiana likes to keep things tidy. Her toys are sorted from smallest to largest, her pencils are sorted from shortest to longest and her computers from oldest to newest. One day, when practicing her counting skills, she noticed that some integers, when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. Some examples of this are 8, 123, 555, and 224488. She decided to call these numbers tidy. Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy number she counted?

Input

The first line of the input gives the number of test cases, T. T lines follow. Each line describes a test case with a single integer N, the last number counted by Tatiana.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last tidy number counted by Tatiana.

Limits

1 ≤ T ≤ 100.
Small dataset

1 ≤ N ≤ 1000.
Large dataset

1 ≤ N ≤ 1018.
*/

#include <iostream>

int main(){
	using namespace std;

	int cases;
	cin >> cases;
	char c;
	
	cin.get(c);
	for (int t=1; t<=cases; t++){
		int number[20];
		int n = 0;
		cin.get(c);
		while (c!= '\n'){
			number[n] = c - '0';
			n++;
			cin.get(c);
		}
		int flag = n;
		for (int i=n-1; i>0;i--){
			if (number[i] < number[i-1]){
				number[i-1] --;
				flag = i;
			}
		}

		//output
		cout << "Case #" << t << ": ";
		if (number[0] != 0){ cout << number[0];}
		for (int i=1; i<flag; i++){
			cout<< number[i];
		}
		for (int i=flag; i<n; i++){
				cout << '9';
		}
		cout << endl;
	}
	return 0;
}