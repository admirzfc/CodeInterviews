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
   ```
