package 类初始化.bank;

class InitialParent {
    public void parent(){
        System.out.println("parent");
    }
}

class Child extends InitialParent{
    @Override
    public void parent(){
        System.out.println("child!");
    }

    public void OnlyChild() {
        System.out.println("self child");
    }

    public static void main(String[] args) {
        Child child = new Child();
        /*什么时候,子类的输出会连着父类一起输出.?*/
        child.parent();
    }
}
