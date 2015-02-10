package gachapon;

public interface IGachapon<T> extends IGachaCapsule<T> {
    public void addItem(IGachaCapsule<T> item, float value);
    public void removeItem(IGachaCapsule<T> item);
}