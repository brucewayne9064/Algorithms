import java.util.ArrayList;
import java.util.List;

interface IHandler{
    void handle();
}

class HandlerA implements IHandler{

    @Override
    public void handle() {
        System.out.println("执行HandlerA");
    }
}

class HandlerB implements IHandler{

    @Override
    public void handle() {
        System.out.println("执行HandlerB");
    }
}



public class MyCoRA {
    List<IHandler> handlerList = new ArrayList<>();

    public void addHandler(List<IHandler> handlers){
        handlerList.addAll(handlers);
    }

    public void handle(){
        handlerList.forEach(IHandler::handle);
    }

    public static void main(String[] args) {
        MyCoRA myCoR = new MyCoRA();
        List<IHandler> handlers = new ArrayList<>();
        handlers.add(new HandlerA());
        handlers.add(new HandlerB());
        myCoR.addHandler(handlers);
        myCoR.handle();
    }
}
