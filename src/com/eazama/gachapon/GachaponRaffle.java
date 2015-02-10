package gachapon;

import java.util.*;

public class GachaponRaffle<T> implements IGachapon<T>{
    private float totalTickets = 0;
    private Map<IGachaCapsule<T>, Float> pool = new HashMap<>();
    
    public GachaponRaffle(){
    }

    @Override
    public IGachaCapsule<T> getItem() {
        float randFloat = new Random().nextFloat()*totalTickets;
        //System.out.println("randInt: " + randInt);
        IGachaCapsule<T> retVal = null;
        for(Map.Entry<IGachaCapsule<T>, Float> kvp : pool.entrySet()){
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
        if(value < 0){
            throw new IllegalArgumentException("value must be greater than 0");
        }
        
        Float oldVal = pool.get(item);
        totalTickets += (oldVal == null ? value : value - oldVal);
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
