#include "MaxHeap.h"
#include <algorithm>
using namespace std;

MaxHeap::MaxHeap(int* hp, int n)
{
	this->heap = hp;
	this->size = n;
	buildHeap();
}

void MaxHeap::buildHeap()
{
	for(int i = size/2 - 1; i >= 0; --i)
		shiftDown(i);
}

void MaxHeap::removeMax()
{
	swap(heap[0], heap[size - 1]);
	size--;
	shiftDown(0);
}

void MaxHeap::shiftDown(int index)
{
	int max_child = getLeftChild(index);
	while(max_child < size)
	{
		if(max_child < size - 1 && heap[getRightChild(index)] > heap[max_child])
			max_child = getRightChild(index);
		if(heap[index] > heap[max_child])
			break;
		swap(heap[max_child], heap[index]);
		index = max_child;
		max_child = getLeftChild(max_child);
	}
}


