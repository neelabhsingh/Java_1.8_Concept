package callback.demo1;
interface  CallBack{
    void methodToCallBack();
}
class CallBackImpl implements CallBack{
    @Override
    public void methodToCallBack() {
        System.out.println("I've been called back.");
    }
}
public class Caller {
    public void register(CallBack callBack){
        callBack.methodToCallBack();
    }
    public static void main(String[] args) {
        Caller caller = new Caller();
        CallBack callBack = new CallBackImpl();
        caller.register(callBack);
    }
}
