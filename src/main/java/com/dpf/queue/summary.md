# Java中的队列
Java中有顶级队列接口`Queue`。其下层实现树如图：
![image-20210418171945966](https://p3-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/aa03e5e1aaaf418f81b8803f5a0d75f5~tplv-k3u1fbpfcp-zoom-1.image)

我们在使用时通常使用`ArrayDeque`或者`LinkedList`。
常用方法：
- 入队：`add`、`offer`-->`addLast`
- 出队：`poll`、`remove`-->`pollFirst`
- 查看队头元素：`peek`、`element`