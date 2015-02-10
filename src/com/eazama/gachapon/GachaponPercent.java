package gachapon;

import java.util.*;

public class GachaponPercent<T> implements IGachapon<T> {

    private float totalPercent = 0;
    private Map<IGachaCapsule, Float> pool = new HashMap<>();
    private Class<T> cls;
    
    public GachaponPercent(Class<T> cls){
        this.cls = cls;
    }
    
    @Override
    public IGachaCapsule<T> getItem() {
        if(totalPercent != 1){
            throw new java.lang.IllegalStateException("Total Percentages do not equal 100%");
        }
        
        float randFloat = new Random().nextFloat();
        //System.out.println("randInt: " + randInt);
        IGachaCapsule retVal = null;
        for(Map.Entry<IGachaCapsule, Float> kvp : pool.entrySet()){
            if(randFloat < kvp.getValue()){
                retVal = kvp.getKey();
                break;
            }
            randFloat -= kvp.getValue();
        }
        return retVal.getItem();
    }

    @Override
    public void addItem(IGachaCapsule<T> item, float value) {
        if(!cls.isInstance(item.open())){
            throw new IllegalArgumentException("invalid type");           
        }
        if(value < 0){
            throw new IllegalArgumentException("value must be greater than 0");
        }
        Float oldVal = pool.get(item);

        totalPercent += (oldVal == null ? value : value - oldVal);
        pool.put(item, value);
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
