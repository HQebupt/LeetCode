#include <iostream>
#include <algorithm>
#include "MaxHeap.h"
#include "father.h"
#include "Solution.h"
#include <string>
using namespace std;

void insertSort(int* data, int length)
{
	if(data == NULL || length <= 0)
	{
		throw exception("Invalid Input!!");
	}

	for(int i = 1; i < length; ++i)
	{
		for(int j = i; j > 0; j--)
		{
			if(data[j] < data[j - 1])
				swap(data[j], data[j - 1]);
			else
				break;
		} 
	}
}

void bubbleSort(int* data, int length)
{
	if(data == NULL || length <= 0)
		throw exception("Invalid Input!");

	for(int i = 0; i < length - 1; ++i)
	{
		for(int j = length - 1; j > i; --j)
		{
			if(data[j] < data[j - 1])
				swap(data[j], data[j - 1]);
		}
	}
}

void selectSort(int* data, int length)
{
	if(data == NULL || length <= 0)
		throw exception("Invalid Input!");

	for(int i = 0; i < length - 1; ++i)
	{
		int smallest = i;
		for(int j = i + 1; j < length; ++j)
		{
			if(data[j] < data[smallest])
				smallest = j;
		}
		swap(data[smallest], data[i]);
	}
}

int partition(int* data, int length, int start, int end)
{
	if(data == NULL || length <= 0 || start < 0 || end >= length)
		throw exception("Invalid Input!!");

	int pos = start + rand() % (end - start + 1);

	swap(data[pos], data[end]);

	int small = start - 1;

	for(int i = start; i < end; i++)
	{
		if(data[i] < data[end])
		{
			small++;
			if(small != i)
				swap(data[i], data[small]);
		}
	}

	small++;
	swap(data[small], data[end]);

	return small;
}

void quickSort(int* data, int length, int start, int end)
{
	if(start >= end)
		return;
	int index = partition(data, length, start, end);
	quickSort(data, length, start, index - 1);
	quickSort(data, length, index + 1, end);
}

void merge(int* data, int* tempArray, int left, int right, int middle)
{
	int index1 = left;
	int index2 = middle + 1;

	int i = left;

	for(; (index1 <= middle) && (index2 <= right); ++i)
	{
		if(data[index1] < data[index2])
			tempArray[i] = data[index1++];
		else
			tempArray[i] = data[index2++];
	}

	while(index1 <= middle)
		tempArray[i++] = data[index1++];
	
	while(index2 <= right)
		tempArray[i++] = data[index2++];

	for(int i = left; i <= right; ++i)
		data[i] = tempArray[i];
}


void mergeSort(int* data, int* tempArray, int left, int right)
{
	if(left < right)
	{
		int middle = (left + right) / 2;
		mergeSort(data, tempArray, left, middle);
		mergeSort(data, tempArray, middle + 1, right);
		merge(data, tempArray, left, right, middle);
	}
}

void heapSort(int array[],int n)  
{  
    MaxHeap max_heap = MaxHeap(array,n);  
  
    for(int i = 0; i < n - 1; i++)  
        max_heap.removeMax();  
} 

int bubbleSort(int* data, int n, int k)
{
	for(int i = 0; i < k; i++)
	{
		for(int j = n - 1; j > i; --j)
		{
			if(data[j] > data[j - 1])
				swap(data[j], data[j - 1]);
		}
	}

	return data[k - 1];
}

int main()
{
	int data[] = {1,4,2,8,3,10,5,12};

	cout<<bubbleSort(data, 8, 3)<<endl;

	system("pause");
}