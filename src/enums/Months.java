package enums;

import javax.swing.plaf.PanelUI;

public enum Months {
    APRIL("It's so cold"),
    MAY("It's so hot");

    Months(String value){
        this.value = value;
    }
    private String value;

    public String getValue(){
        return value;
    }
}
