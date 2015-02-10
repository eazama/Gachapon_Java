package gachapon;

import java.util.*;

public class GachaponUnweighted<T> implements IGachapon<T> {
    
    private ArrayList<IGachaCapsule<T>> pool = new ArrayList<>();
    Class<T> cls;

    public GachaponUnweighted(Class<T> cls){
        this.cls = cls;
    }
    
    @Override
    public IGachaCapsule<T> getItem() {
        int randInt = new Random().nextInt(pool.size());
        return pool.get(randInt);
    }

    @Override
    public void addItem(IGachaCapsule<T> item, float value) {
        if(!cls.isInstance(item.open())){
            throw new IllegalArgumentException("invalid type");           
        }
        if(!cls.isInstance(item.open())){
            throw new IllegalArgumentException("invalid type");           
        }
        pool.add(item);
    }

    @Override
    public void removeItem(IGachaCapsule<T> item) {
        pool.remove(item);
    }

    @Override
    public T open() {
        return getItem().open();
    }
}
