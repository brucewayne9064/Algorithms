# Algorithms

- 布隆过滤器 (MyBloomFilter)

  布隆过滤器实际上是一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。它的优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。

## JVM

- Garbage Collection (GCTest.java)

  JDK17默认的垃圾回收器是G1

- 线程执行过程（SimpleThreadExample.java）

  1. 新建状态 (New)
  2. 就绪状态 (Runnable)
  3. 运行状态 (Running)
  4. 阻塞状态 (Blocked)
  5. 等待状态 (Waiting)
  6. 超时等待状态 (Timed Waiting)
  7. 终止状态 (Terminated)

## JAVA集合

- ArrayList

    底层实现是数组，查询快，增删慢。扩容时，新数组的大小是原数组的1.5倍。

- HashMap

    JDK8之前，HashMap是数组+链表的结构，JDK8之后，HashMap是数组+链表+红黑树的结构。
    
    HashMap的扩容机制是当HashMap的size超过了threshold时，会进行扩容。扩容时，会将原数组中的元素重新计算hash值，然后放入新数组中。
    
    HashMap的负载因子默认是0.75，当HashMap的size超过了threshold * loadFactor时，会进行扩容。

## 深度学习

- 注意力机制 (SelfAttention.py)

  这种机制可以增强神经网络输入数据中某些部分的权重，同时减弱其他部分的权重，以此将网络的关注点聚焦于数据中最重要的一小部分。数据中哪些部分比其他部分更重要取决于上下文。可以通过梯度下降法对注意力机制进行训练。

## 设计模式

- 责任链 (MyCoR, Chain of Responsibility)

  在责任链模式中，多个处理器（参照上述拦截器）依次处理同一个请求。一个请求先经过 A 处理器处理，然后再把请求传递给 B 处理器，B 处理器处理完后再传递给 C 处理器，以此类推，形成一个链条，链条上的每个处理器 各自承担各自的处理职责。

  责任链模式中多个处理器形成的处理器链在进行处理请求时，有两种处理方式：

  1. 请求会被 所有的处理器都处理一遍，不存在中途终止的情况，这里参照 MyBatis 拦截器理解。
  
  2. 二则是处理器链执行请求中，某一处理器执行时，如果不符合自制定规则的话，停止流程，并且剩下未执行处理器就不会被执行，大家参照 SpringMvc 拦截器理解。

## 数据结构

- 红黑树 (MyRBTree)

## Web

- ThreadLocal（ThreadLocalExample.java）

## JAVA

- try-catch-finally执行顺序（ExceptionTest.java）