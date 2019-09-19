# -*- encoding: utf-8 -*-

'''
@Author  :   Jeanye

@File    :   StraightInsertionSort.py

@Time    :   2019-9-18

'''

#直接插入排序
'''
体育老师说：大家先站好，等下按照我的吩咐排成从矮到高的顺序
	从第二个同学开始，向前走，找到比你矮的童鞋，站到他的后面
	后面的同学往后移动
	移动完后，第三个同学重复上面的操作
这就是插入排序的思想

假如已经排好了，那么这种方法只需要第二个同学像前面看一下就可以了，
也就是经过n-1次比较就可以告诉老师我们排好队了（有序的情况下，插入排序效率高）
'''
def insertSort(l):
	#辅助空间
	temp = l[0]
	for i in range(1, len(l)):
		if l[i] < l[i - 1]:
			#i位置的数字需要插入到比他小的位置上
			#先将其存储起来
			temp = l[i]
			insertLocal = 0
			#开始将比他大的向后移
			for j in range(i - 1, -1, -1):
				if temp < l[j]:
					#后移
					insertLocal = j
					l[j + 1] = l[j]
				else:
					break
			#这个不能放在上面else中，因为如果不需要移动的话会把前面的覆盖的
			l[insertLocal] = temp

#测试一下
# l = (1,3,5,2,6,9,1,6)
# l = [1,3,5,2,6,9,1,6]
# insertSort(l)
# print(l)
l = [] 
import random

for i in range(20):
	l.append(random.randint(0,10))
print('排序前',l)
insertSort(l)
print('排序后',l)
'''
时间复杂度分析
1.遍历需要扫描n-1次
2.最好的情况不需要移动
3.最坏的情况需要每次都从原先位置移动到头位置，移动次数为1+2+...+(n-1)
4.时间复杂度就为n^2/2

空间复杂度
只需要一个辅助空间
'''
