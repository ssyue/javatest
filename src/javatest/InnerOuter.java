package javatest;  
  
public class InnerOuter {
    public static void main(String[] args) {
       new InnerOuter().getJob().print();
    }
    public Job getJob(){
        final   int i=1;
        return new Job(){
            void print() {
                System.out.println("=="+i);
            }
        };
        
        }
    }
