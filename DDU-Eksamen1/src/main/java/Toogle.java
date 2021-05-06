public class Toogle {
    boolean toogled = false;

    void tooglePick(){
        if(toogled==false)
            toogled = true;
        else
            toogled=false;

        System.out.println(toogled);
    }
}
