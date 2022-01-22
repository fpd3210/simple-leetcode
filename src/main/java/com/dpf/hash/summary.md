
# 哈希

## 哈希表
- 哈希表在使用层面上可以理解为一种集合结构
- 如果只有key， 没有伴随数据value， 可以使用HashSet结构(C++中叫UnOrderedSet)
- 如果既有key， 又有伴随数据value， 可以使用HashMap结构(C++中叫UnOrderedMap)
- 有无伴随数据， 是HashMap和HashSet唯一的区别， 底层的实际结构是一回事
- 使用哈希表增(put)、 删(remove)、 改(put)和查(get)的操作， 可以认为时间复杂度为
O(1)， 但是常数时间比较大
- 放入哈希表的东西， 如果是基础类型， 内部按值传递， 内存占用就是这个东西的大小
- 放入哈希表的东西， 如果不是基础类型， 内部按引用传递， 内存占用是这个东西内存地
址的大小
## 有序表

- 有序表在使用层面上可以理解为一种集合结构
- 如果只有key， 没有伴随数据value， 可以使用TreeSet结构(C++中叫OrderedSet)
- 如果既有key， 又有伴随数据value， 可以使用TreeMap结构(C++中叫OrderedMap)
- 有无伴随数据， 是TreeSet和TreeMap唯一的区别， 底层的实际结构是一回事
- 有序表和哈希表的区别是， 有序表把key按照顺序组织起来， 而哈希表完全不组织
- 红黑树、 AVL树、 size-balance-tree和跳表等都属于有序表结构， 只是底层具体实现
不同
- 放入有序表的东西， 如果是基础类型， 内部按值传递， 内存占用就是这个东西的大小
- 放入有序表的东西， 如果不是基础类型， 必须提供比较器， 内部按引用传递， 内存占
用是这个东西内存地址的大小
