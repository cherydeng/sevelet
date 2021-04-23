package entity;
import java.util.ArrayList;
import entity.GoodsSingle;
public class ShopCar {
    private ArrayList buyList = new ArrayList();

    public void setBuyList(ArrayList buyList){
        this.buyList = buyList;
    }
    /**
     * @function 向购物车添加商品
     * @use  single为GOodsSinagle类对象
     */
    public void addItem(GoodsSingle single){
        if(single != null){
            if(buyList.size() == 0){
                GoodsSingle temp = new GoodsSingle();
                temp.setName(single.getName());
                temp.setPrice(single.getPrice());
                temp.setNum(single.getNum());
                buyList.add(temp);
            }
            else{
                int i =0;
                for(;i<buyList.size();i++){
                    GoodsSingle temp = (GoodsSingle)buyList.get(i);

                    if(temp.getName().equals(single.getName())){
                        temp.setNum(temp.getNum()+1);
                        break;
                    }
                }
                if(i >= buyList.size()){
                    GoodsSingle temp = new GoodsSingle();
                    temp.setName(single.getName());
                    temp.setPrice(single.getPrice());
                    temp.setNum(single.getNum());
                    buyList.add(temp);
                }
            }
        }
    }
    /**
     * @function 向购物车移除指定商品
     * @use  single为GOodsSinagle类对象
     */
    public void removeItem(String name){
        for(int i = 0;i<buyList.size();i++){
            GoodsSingle temp = (GoodsSingle)buyList.get(i);
            if(temp.getName().equals(name)){
                temp.setNum(temp.getNum()-1);
                break;
            }
            else if(temp.getNum() == 1){
                buyList.remove(i);
            }
        }
    }
}
