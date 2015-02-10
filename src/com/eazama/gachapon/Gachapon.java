package gachapon;

public class Gachapon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GachaRaffleTest();
        GachaPercentTest();
        GachaUnweightedTest();
        GachaRaffleNestedTest();
    }
    
    public static void GachaRaffleTest(){
        
        int item1 = 0;
        int item2 = 0;
        int item3 = 0;
        
        IGachapon<String> gacha = new GachaponRaffle<>();
        
        gacha.addItem(new GachaCapsule<>("item1"), 1.5f);
        gacha.addItem(new GachaCapsule<>("item2"), 4);
        gacha.addItem(new GachaCapsule<>("item3"), 3.5f);
        
        double reps = 1000;
        
        for(int i = 0; i < reps; ++i){
            switch(gacha.getItem().open()){
                case "item1":
                    item1++;
                    break;
                case "item2":
                    item2++;
                    break;
                case "item3":
                    item3++;
                    break;
            }
        }
        
        System.out.println(String.format("%f, %f, %f",item1/reps*100, item2/reps*100, item3/reps*100));
    }
    
    public static void GachaPercentTest(){
        
        int item1 = 0;
        int item2 = 0;
        int item3 = 0;
        
        IGachapon gacha = new GachaponPercent(String.class);
        
        gacha.addItem(new GachaCapsule("item1"), .1f);
        gacha.addItem(new GachaCapsule("item2"), .3f);
        gacha.addItem(new GachaCapsule("item3"), .6f);
        
        double reps = 10000;
        
        for(int i = 0; i < reps; ++i){
            switch(gacha.getItem().open().toString()){
                case "item1":
                    item1++;
                    break;
                case "item2":
                    item2++;
                    break;
                case "item3":
                    item3++;
                    break;
            }
        }
        
        System.out.println(String.format("%f, %f, %f",item1/reps*100, item2/reps*100, item3/reps*100));
    }
    
    public static void GachaUnweightedTest(){
        
        int item1 = 0;
        int item2 = 0;
        int item3 = 0;
        
        IGachapon gacha = new GachaponUnweighted(String.class);
        
        gacha.addItem(new GachaCapsule("item1"), .1f);
        gacha.addItem(new GachaCapsule("item2"), .3f);
        gacha.addItem(new GachaCapsule("item3"), .6f);
        
        double reps = 10000;
        
        for(int i = 0; i < reps; ++i){
            switch(gacha.getItem().open().toString()){
                case "item1":
                    item1++;
                    break;
                case "item2":
                    item2++;
                    break;
                case "item3":
                    item3++;
                    break;
            }
        }    
        System.out.println(String.format("%f, %f, %f",item1/reps*100, item2/reps*100, item3/reps*100));
    }
    
    public static void GachaRaffleNestedTest(){
        
        int item1 = 0;
        int item2 = 0;
        int item3 = 0;
        
        IGachapon<String> gacha = new GachaponRaffle<>();
        IGachapon<String> gacha2 = new GachaponRaffle<>();
        
        gacha2.addItem(new GachaCapsule<>("item1"), 1);
        gacha2.addItem(new GachaCapsule<>("item2"), 4);
        gacha.addItem(gacha2, 5);
        gacha.addItem(new GachaCapsule<>("item3"), 5);
        
        double reps = 1000;
        
        for(int i = 0; i < reps; ++i){
            switch(gacha.getItem().open().toString()){
                case "item1":
                    item1++;
                    break;
                case "item2":
                    item2++;
                    break;
                case "item3":
                    item3++;
                    break;
            }
        }
        
        System.out.println(String.format("%f, %f, %f",item1/reps*100, item2/reps*100, item3/reps*100));
    }
}
