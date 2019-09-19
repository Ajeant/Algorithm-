# -*- encoding: utf-8 -*-

'''
@Author  :   Jeanye

@File    :   StraightInsertionSort.py

@Time    :   2019-9-19

'''

#希尔排序
'''
希尔排序最重要的就是要确定增量
增量的好坏直接影响排序的时间复杂度
不过目前还没有确定增量的标准
只是由经验得出h = h * 3 + 1，h=1开始计算 
直到h > 数组长度
'''
def calculateIncrement(length):
	'''
	Args:
		length: 数组长度
	Returns:
		返回增量数组
	'''
	res = []
	h = 1
	res.append(h)
	while h < length:
		h = 3 * h + 1
		res.append(h)
	res.pop()
	reversed(res)
	return res

# print(calculateIncrement(500))

def shellSort(l):
	#计算增量
	increment = calculateIncrement(len(l))
	#进行len(increment)次希尔排序
	for i in range(0, len(increment)):
		shellInsert(l, increment[i])

def shellInsert(l, increment):

	for i in range(increment, len(l)):
		if l[i] < l[i - increment]:
			#将这个需要前插的数据保存起来
			temp = l[i]
			#找到插入的位置，将原来的数据后移
			insertLocal = 0
			for j in range(i - increment, -1, -increment):
				if temp < l[j]:
					insertLocal = j
					l[j + increment] = l[j]
				else:
					break
			l[insertLocal] = temp

import random

# random.seed(5)
numbers = []
for i in range(20):
	numbers.append(random.randint(0,10))
print(numbers)
shellSort(numbers)
print(numbers)

import numpy as np 

nn = np.random.randint(20, size=30).tolist()
print(nn)
shellSort(nn)
print(nn)

'''
这个的时间复杂度比较难计算，首先它取决于增量序列
目前通过大量的实验推出：当n足够大时，他的时间复杂度接近n(logn)^2
空间复杂度与前面一样，只需要一个辅助空间
'''