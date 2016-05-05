package jsonpiola;

import model.Nodo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonPiola 
{
    public static void main(String[] args) 
    {
        String rutaArchivo = "San_Francisco_world.json";
        Nodo nodoPadre = (Nodo)dameJsonDelArchivo(rutaArchivo);
        
        
        
       /* for(model.Nodo nodo: nodoPadre.getChildren())
        {
            System.out.println(nodo);
           //Gson gson = new Gson();
           //gson.toJson(nodo);
            /*JsonObject jsonObject = gson.fromJson( nodo, JsonObject.class);
            jsonObject.get(fieldName); 
        }*/
        
        System.out.println("----------------" + dameNodosConLocation(nodoPadre).size());
        for(Nodo nodo : dameNodosConLocation(nodoPadre))
        {
            System.out.println(nodo);
        }
        
    }
    public static Object dameJsonDelArchivo(String rutaArchivo)
    {
        Object objSalida  = null;
        try
        {
            File file = new File(rutaArchivo);
        
            if(file.exists())
            {
                System.out.println("Existe " + rutaArchivo);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaArchivo));
                
                StringBuffer salida = new StringBuffer("");
                String linea;
                while( (linea = bufferedReader.readLine()) != null)
                {
                    salida.append(linea +  System.getProperty("line.separator"));
                }
                
                Gson gson = new Gson();
                
                Nodo data = gson.fromJson(salida.toString(), Nodo.class);
                objSalida = data;
                
                System.out.println("padre:\n" +  data);
                
                /*for(Nodo nodoActual : data.getChildren())
                {
                    //System.out.println(nodoActual);
                }*/
                
            }
            else
            {
                System.out.println("No existe " + rutaArchivo);
            }

        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
        return objSalida;
    }
    
    public static List<Nodo> dameNodosConLocation(Nodo nodoPadre)
    {
        List<Nodo> nodosConLocation = new ArrayList<Nodo>();
        
        System.out.println("e:" + nodoPadre.getChildren().size());
        for (model.Nodo nodo: nodoPadre.getChildren())
        {
            for(Nodo n2 : nodo.cualesDeMisSubNodosTienenLocation())
            {
                nodosConLocation.add(n2);
            }
        }
        
        return nodosConLocation;
    }
}
