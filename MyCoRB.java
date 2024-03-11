import java.util.ArrayList;
import java.util.List;

interface IHandlerB{
    boolean handle();
}

class HandlerC implements IHandlerB{
    boolean result = true;
    @Override
    public boolean handle() {
        System.out.println("执行HandlerA");
        return result;
    }
}

class HandlerD implements IHandlerB{
    boolean result = false;
    @Override
    public boolean handle() {
        System.out.println("执行HandlerB");
        return result;
    }
}

public class MyCoRB {
    List<IHandlerB> handlerList = new ArrayList<>();

    public void addHandler(List<IHandlerB> handlers){
        handlerList.addAll(handlers);
    }

    public boolean handle(){
        boolean resultFlag = true;
        for (IHandlerB handler : handlerList) {
            if(!handler.handle()){
                resultFlag = false;
                break;
            }
        }
        return resultFlag;
    }

    public static void main(String[] args) {
        MyCoRB myCoR = new MyCoRB();
        List<IHandlerB> handlers = new ArrayList<>();
        handlers.add(new HandlerC());
        handlers.add(new HandlerD());
        myCoR.addHandler(handlers);
        boolean result = myCoR.handle();
        if(!result){
            System.out.println("责任链中处理器不满足条件");
    }}

}
