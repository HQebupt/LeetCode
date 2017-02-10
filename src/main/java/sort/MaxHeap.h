#include<iostream>

class MaxHeap
{
public:
	MaxHeap(int* hp, int n);
	void shiftDown(int index);
	void removeMax();
	void buildHeap();
	int getLeftChild(int index) {return index * 2 + 1;}
	int getRightChild(int index) {return index * 2 + 2;}
private:
	int* heap;
	int size;
};