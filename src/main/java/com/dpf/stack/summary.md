# Java中的栈
- 在Java中没有对应的Stack接口，Stack继承自Vector，Vector加锁效率不高。
- Java中建议使用`LinkedList`或者`ArrayDeque`作为栈的使用
# LinkedList和ArrayDeque相关栈方法
标准的栈方法只有(参照LinkedList源码)
- push：入栈： 头插
- pop: 出栈：头取

> LinkedList和ArrayDeque都既可以做栈也可以做队列
- 对于添加方法除了有`First`都是添加到尾部
- 对于获取方法除了有`Last`都是从头部获取数据