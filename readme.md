references:
https://www.bilibili.com/read/cv3360446
https://kaiwu.lagou.com/course/courseInfo.htm?courseId=3#/detail/pc?id=29
https://time.geekbang.org/column/article/81186

减小规模必须放在递归调用之前

第一次插入导致window过期，所以判断过期放在插入之后

自己处理输入输出的话一定用BufferReader或者StringBuffer存起来一起输出，system.in  out会通过一部分，但超时
初始化数组不能写长度，奇怪呀
```java
        String[] ss = {"a",""};
        String[] ss = new String[] {"a",""};

        //动态初始化数据  
        String books[] = new String[2];  
        books[0] = "Thinking in Java";  
        books[1] = "Effective Java";  
```

除了循环变量，不要写无意义的ijk，教训呀！混了都不知道

不要写又长有长得相似，差一个s的变量