1. Singleton Mode: 
    Singleton's purpose is to control object creation, limiting the number of obejcts to one only. 
    public class ClassicSingleton{
        private static ClassicSingleton instance = null;
        private ClassicStingleton{
            //private constructor to prevent instantiation
        }
        public static ClassicSingleton getInstance(){
            if(instance == null) {
                instance = new ClassicSingleton();
            }
            return instance;
        }
    }
    There is another easy way to implement singleton, using enum
    public enum EasySingleton{
        instance;
    }
    You can use EasySingleton.instance to use it.
    
2. Simple Factory Mode: 
    Before industrial revolution, when you need a BMW, you need to new one by yourself. After industrial revolution, 
    there are factories, so when you want a BMW, you let factory new it and return it to you. 
    
3. Factory Method mode: 
    It's more advanced. That every method is a factory. There are BMW 323, 325, 328. You can't make all of them in 
    one factory, so you have many BWM factories, the 323 factory, 325 factory and 328 factory. 
    Each news a BWM and return to you. But you need an abstract class "BMW Factory"

4. Template Pattern
public abstract class Game {
   abstract void initialize();
   abstract void startPlay();
   abstract void endPlay();

   public final void play(){    //the final here is necessary for the template not to be overriden,
      initialize();
      startPlay();
      endPlay();
   }
}

5. Command mode: 
    (command is an object) this example written by myself
    public abstract class Shape{}
    public class Circle extends Shape(){
      public void move(){}
      public void moveback(){}
    }
    public abstract class Command(){
      public void execute();
    }
    public class Move implements Command{
      private Shape s;
      public Move(Shape shape){
        this.s = shape;
      }
      public void move(){
        s.move();
      }
      public void unmove(){
        s.unmove();
      }
    }
    public class Canvas{
      Circle c = new Circle();
      Command m = new Move(c);
      m.execute();
      m.unexecute();
    }

6. Proxy Mode: 
   Provides a proxy to control the access to the object
   1.经纪人和明星在一些行为上有共同点，所以定义一个共有接口：
   public interface IStar {
    void attendTheShow();
    void loveWife();
   }
   
   public class Star implements IStar {
    private String mName;

    public Star(String name) {
        mName = name;
    }

    @Override
    public void attendTheShow() {
        System.out.print( this.mName + " 参加演出 \n");
    }

    @Override
    public void loveWife() {
        System.out.print(this.mName + " 照顾了妻子");
    }
   }
  
   经纪人要代表明星，就需要和明星有同样的行为，同时持有明星的引用：
   public class Agent implements IStar {
    //经纪人可以代表一个明星做一些决定
    IStar mIStar;
    boolean mIsHappy;

    public Agent(IStar IStar) {
        mIStar = IStar;
    }

    //代理可以在一定情况下拦截、修改被代理对象的行为，这里设置一个 “心情”的状态值
    public Agent(IStar IStar, boolean isHappy) {
        mIStar = IStar;
        mIsHappy = isHappy;
    }

    @Override
    public void attendTheShow() {
        mIStar.attendTheShow();
    }

    @Override
    public void loveWife() {
        if (mIsHappy) {
            mIStar.loveWife();
        } else {
            //当经纪人心情不好时，就会干坏事
            System.out.print("经纪人 照顾妻子");
        }
    }
   }
   
   public class Environment {
        public static void main(String[] args) {
          Star baoqiang = new Star("王宝强");
          Agent songJJ = new Agent(baoqiang, false);
          songJJ.attendTheShow();
          songJJ.loveWife();
        }
    }
    运行结果: 王宝强 参加演出
              经纪人 照顾妻子

7. Strategy Mode：
    假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。一个最简单的情况就是把所有货品的单价乘上数量，
    但是实际情况肯定比这要复杂。比如，本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；
    对初级会员没有折扣。
    
    public interface MemberStrategy {
         public double calcPrice(double booksPrice);
    }
    public class PrimaryMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            System.out.println("对于初级会员的没有折扣");
            return booksPrice;
        }
    }
    public class IntermediateMemberStrategy implements MemberStrategy {
         @Override
         public double calcPrice(double booksPrice) {
            System.out.println("对于中级会员的折扣为10%");
            return booksPrice * 0.9;
         }
    }
    public class AdvancedMemberStrategy implements MemberStrategy {
        @Override
        public double calcPrice(double booksPrice) {
            System.out.println("对于高级会员的折扣为20%");
            return booksPrice * 0.8;
        }
    }
    public class Price {
         private MemberStrategy strategy;
         public Price(MemberStrategy strategy){
            this.strategy = strategy;
         }
         public double quote(double booksPrice){
           return this.strategy.calcPrice(booksPrice);
         }
    }
    public class Client {
        public static void main(String[] args) {
             MemberStrategy strategy = new AdvancedMemberStrategy();
             Price price = new Price(strategy);
             double quote = price.quote(300);
             System.out.println("图书的最终价格为：" + quote);
        }
    }
