package model;

import com.google.gson.annotations.SerializedName;

public class Alias 
{
    private String fr;
    @SerializedName("zh-Hans")
    private String zhHans;
    private String pt;
    private String es;
    private String en;
    private String de;
    private String it;

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getZh() {
        return zhHans;
    }

    public void setZh(String zh) {
        this.zhHans = zh;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    @Override
    public String toString() 
    {
        String tabulacion = "   ";
        String salida = "Alias\n";
        salida += tabulacion +"{\n";
        salida += tabulacion + tabulacion + "fr=" + fr +"\n";
        salida += tabulacion + tabulacion + "zhHans=" + zhHans +"\n";
        salida += tabulacion + tabulacion + "pt=" + pt +"\n";
        salida += tabulacion + tabulacion + "es=" + es +"\n";
        salida += tabulacion + tabulacion + "en=" + en +"\n";
        salida += tabulacion + tabulacion + "de=" + de +"\n";
        salida += tabulacion + tabulacion + "it=" + it +"\n";
        salida += tabulacion +"}";
        
        return salida; //"Alias\n" + tabulacion +"{\n" + tabulacion+tabulacion +"fr=" + fr + tabulacion +",\n zh=" + zhHans + tabulacion + ",\n pt=" + pt + tabulacion +",\n es=" + es + tabulacion +",\n en=" + en + tabulacion +",\n de=" + de + tabulacion +",\n it=" + it +"\n}";
    }
 
    
    
}
