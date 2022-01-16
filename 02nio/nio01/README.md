（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。

Java 版本 11

系统环境 Window 10

1、使用G1 GC策略。
```
java -jar -XX:+UseG1GC -XX:+PrintGCDetails -Xloggc:gc.g1.log -Xmx512m -Xms512m .\gateway-server-0.0.1-SNAPSHOT.jar
```

![g1gc.png](images1gc.png)

总结：都是 Yang GC 没有出现 Full GC 且 GC 的次数较少，平均 GC 时间为10ms左右，最后的几次 GC 用时比较快。

2、使用CMS GC 策略
```
java -jar -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xloggc:gc.g1.log -Xmx512m -Xms512m .\gateway-server-0.0.1-SNAPSHOT.jar
```

![cms.png](imagesms.png)

总结：都是YangGC 没有出现Full GC , GC 次数较多，每次GC 暂停时长较短，平均时长为 1ms。

2、使用Parallel GC策略
```
java -jar -XX:+UseParallelGC -XX:+PrintGCDetails -Xloggc:gc.g1.log -Xmx512m -Xms512m .\gateway-server-0.0.1-SNAPSHOT.jar
```

![parallel.png](imagesarallel.png)

总结：都是YangGC 没有出现Full GC , GC 次数较多，每次GC 暂停时长较短，平均时长为 1ms。

2、使用Serial GC策略
```
java -jar -XX:+UseG1GC -XX:+PrintGCDetails -Xloggc:gc.g1.log -Xmx512m -Xms512m .\gateway-server-0.0.1-SNAPSHOT.jar
```

![serial.png](imageserial.png)

总结：都是YangGC 没有出现Full GC , GC 次数较多，每次GC 暂停时长较短，平均时长为 1ms。
