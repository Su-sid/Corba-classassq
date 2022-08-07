import org.omg.CosNaming.*;
import org.omg.CORBA.*;


class ShapeServant extends ShapePOA {
    int myVersion;
    GraphicalObject obj1;
    
    public ShapeServant(GraphicalObject g, int version){
 		obj1 = g;
        myVersion = version;
    }
    
     
	public int getVersion(){
	    return myVersion;
	}
	
   
   public GraphicalObject getAllState() {
        return obj1;
   }
   
    
}

