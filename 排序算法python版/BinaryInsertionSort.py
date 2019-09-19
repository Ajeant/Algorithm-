# -*- encoding: utf-8 -*-

'''
@Author  :   Jeanye

@File    :   BinaryInsertionSort.py

@Time    :   2019-9-18

'''

#二分查找比指定数字小的数的位置
#l在low和high之间必须有序
def binarySearch(l, goal, low = 0, high = 0):
	mid = low
	while low <= high:
		mid = (low + high) // 2
		if goal < l[mid]:
			high = mid - 1
		else:
			low = mid + 1
	return high + 1

#折半插入排序
def binaryInsertionSort(l = [0]):
	#辅助空间
	temp = l[0]
	for i in range(1, len(l)):
		if l[i] < l[i - 1]:
			#i位置的数字需要插入到比他小的位置上
			#先将其存储起来
			temp = l[i]
			#在前面有序的列表中找到比他小的
			mid = binarySearch(l, temp, 0, i - 1)
			#开始将比他大的向后移,必须从后向前循环，否则数据会被覆盖
			for j in range(i, mid, -1):
				l[j] = l[j - 1]
			#移动完成后将mid插入temp值
			l[mid] = temp

#测试
l = [2,1,5,5,55,4,56,5,65,11,23,2,0,20]
print(l)
binaryInsertionSort(l)
print(l)#[0, 1, 2, 2, 4, 5, 5, 5, 11, 20, 23, 55, 56, 65]
# l.sort()
# print(l)  #[0, 1, 2, 2, 4, 5, 5, 5, 11, 20, 23, 55, 56, 65]

l = [] 
import random

for i in range(20):
	l.append(random.randint(0,10))
print('排序前',l)
binaryInsertionSort(l)
print('排序后',l)

'''
时间复杂度
1.同样扫描n-1次
2.折半查找为：第i个记录时，搜索时间复杂度为logi
3.移动和直接插入一样，1+2+...+(n-1)
4.总的时间复杂度嘛，尴尬，跟前面直接插入一样，n^2/2，区别是折半比较快找到需要开始移动的位置
空间复杂度
一个辅助空间
'''