package model;

import java.util.List;
import org.json.JSONArray;

public class Nodo 
{
    /*public String name;
    public String path;
    public JSONObject labels;
    public JSONArray places2go;
    public JSONArray images;
    public JSONArray contents;
    public Boolean isValid;*/

    
    private String name;
    private String path;
    private Alias alias;
    private List<Nodo> children;
    private List<String> contents;
    private List<String> location;
    
    public Nodo(String name, String path, Alias alias, List<Nodo> children,List<String> contents, List<String> location)
    {
        this.name = name;
        this.path = path;
        this.alias = alias;
        this.children = children;
        this.contents = contents;
        this.location = location;
    }
    
    //<editor-fold desc="GYS:">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public Alias getAlias() {
        return alias;
    }

    public void setAlias(Alias alias) {
        this.alias = alias;
    }

    
    public List<Nodo> getChildren() {
        return children;
    }

    public void setChildren(List<Nodo> children) {
        this.children = children;
    } 

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }
    //</editor-fold>
    
    @Override
    public String toString()
    {
        String tabulacion = "   ";
        String salida = "Nodo\n";
        
        salida+= "{\n";
            salida +=  tabulacion + "name = " + name +",\n";
            salida +=  tabulacion + "path = " + path +",\n";
            if(contents != null)
            {
                salida +=  tabulacion + "contents = " + contents.size() +",\n";              
            }
            else
            {
                salida +=  tabulacion + "contents = " + null +",\n";
            }
            if(children != null)
            {
                salida +=  tabulacion + "children = " + children.size() + "\n";
                for(int i = 0 ; i < children.size(); i++)
                {
                    salida +=  tabulacion + " -> " + children.get(i).getName() + children.get(i).getContents() + " | " + tieneLocation(children.get(i)) +  "\n";
                }
            }
            if(tieneLocation(this))
            {
                salida += tabulacion + "location:"+ getLocation()+ ",\n";

            }
            if(alias != null)
            {
                salida += tabulacion + "alias:" + alias + "\n";
            }
            
        salida+= "}";
               
        return salida;
    }
    
    /*METODOS IMPORTANTES:*/
    public List<Nodo> cualesDeMisSubNodosTienenLocation()
    {
        List<Nodo> hijosConlocation = new java.util.ArrayList<Nodo>();
        for(int i = 0 ; i < children.size(); i++)
        {
            if(tieneLocation(children.get(i)))
            {
                hijosConlocation.add(children.get(i));
            }
        }
        return hijosConlocation;
    }
    public boolean tieneLocation(Nodo nodo)
    {
        boolean tiene = false;
        if(nodo.getContents() != null)
        {
            for(String str : nodo.getContents())
            {
                if(str.trim().equalsIgnoreCase("location"))
                {
                    tiene = true;
                }
            }
        }
        return tiene;
    }
    public String dameLocation()
    {
        String salida = "";
        if(tieneLocation(this))
        {
            salida += getLocation();
        }
        return salida;
    }
}
