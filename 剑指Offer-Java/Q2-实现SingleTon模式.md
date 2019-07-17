### Java中的单例模式

1. 饿汉式（静态常量）
   
   ```
   public class SingleTon{
       private final static SingleTon INSTANCE = new SingleTon();
       private SingleTon(){}
       public static SingleTon getInstance(){
           return INSTANCE;
       }
   }
   ```

2. 饿汉式（静态代码块）
   
   ```
   public class SingleTon{
       private final static SingleTon INSTANCE;
       static {
           INSTANCE = new SingleTon();
       }
       private SingleTon(){}
       public static SingleTon getInstance(){
           return INSTANCE;
       }
   }
   ```

3. 懒汉式（线程不安全）
   
   ```
   public class SingleTon{
       private final static SingleTon INSTANCE;
       private SingleTon(){}
       public static SingleTon getInstance(){
           if (INSTANCE == null){
               INSTANCE = new SingleTon();
           }
           return INSTANCE;
       }
   }
   ```

4. 懒汉式（线程安全，同步方法）
   
   ```
   public class SingleTon{
       private static SingleTon INSTANCE;
       private SingleTon(){}
       public static synchronized SingleTon getInstance(){
           if (INSTANCE == null){
               INSTANCE = new SingleTon();
           }
           return INSTANCE;
       }
   }
   ```

5. 懒汉式（）
   
   ```
   public class SingleTon{
       private static SingleTon INSTANCE;
       private SingleTon(){}
       public static SingleTon getInstance(){
           if (INSTANCE == null){
               synchronized (SingleTon.class){
                   INSTANCE = new SingleTon();
               }
           }
           return INSTANCE;
       }
   }
   ```

6. 双重检查
   
   ```
   public class SingleTon{
       private volatile static SingleTon INSTANCE;
       private SingleTon(){}
       public static SingleTon getInstance(){
           if (INSTANCE == null){
               synchronized(SingleTon.class){
                   if (INSTANCE == null){
                       INSTANCE = new SingleTon();
                   }
               }
           }
           return INSTANCE;
       }
   }
   ```

7. 静态内部类
   
   ```
   public class SingleTon{
       private SingleTon(){}
       public static SingleTon getInstance(){
           return SingleTonInstance.INSTANCE;
       }
       public static class SingleTonInstance{
           private final static SingleTon INSTANCE = new SingleTon();
       }
   }
   ```

8. 枚举
   
   ```
   public enum EnumSingleton {
       INSTANCE;
   
       public void doSomething() {
           //do sth ...
       }
   }
   
   //例如
   public enum SingleTon{
       INSTAMCE;
       private SingleTon(){
           System.out.println("init");
       }
       private void print(){
           System.out.println("FFFFFFFF");
       }
       public static void main(String[] args){
           SingleTon singleTon = SingleTon.INSTAMCE;
           singleTon.print();
           SingleTon singleTon1 = SingleTon.INSTAMCE;
           singleTon1.print();
           SingleTon singleTon2 = SingleTon.INSTAMCE;
           singleTon2.print();
           //只会输出一次”init“
       }
   }
   ```

一个讲的稍微有点详细的博客，各种实现方式之间的差别和优缺点分析：[https://www.cnblogs.com/chinaifae/articles/10320692.html](https://www.cnblogs.com/chinaifae/articles/10320692.html)
