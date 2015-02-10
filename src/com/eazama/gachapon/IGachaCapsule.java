package gachapon;

public interface IGachaCapsule<T> {
    public IGachaCapsule<T> getItem();
    public T open();
}
