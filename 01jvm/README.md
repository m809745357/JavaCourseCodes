jps/jinfo 查看Java进程相关信息。

jstat 查看Java进程堆内存使用情况。

jmap 查询堆内存的快照相关信息。

jstack 查看当前JVM内部所有的线程运行情况和线程的堆栈包括锁。

jscmd 是个整合工具。

标记清除算法(Mark and Sweep)

-XX:+MaxTenuringThreshold=15
老年代默认都是存活对象，移动方式：
1.标记所有通过GC roots 可达的对象；
2.删除所有不可达对象；
3.整理老年代空间的内容，方法是将多有的内存对象复制，从老年代空间开始的地方以此存放。

持久代/元数据区
-XX:MaxMetaspaceSize=256m