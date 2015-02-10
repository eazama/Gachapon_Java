package gachapon;

public class GachaCapsule<T> implements IGachaCapsule<T> {

    private T obj;
    
    public GachaCapsule(T obj){
        this.obj = obj;
    }
    
    @Override
    public IGachaCapsule getItem() {
        return this;
    }

    @Override
    public T open() {
        return obj;
    }    
}
