import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class ShapeListServer
{
    public static void main(String args[])
    {
        try{
           
            Properties props = new Properties();
        	props.put("org.omg.CORBA.ORBInitialPort", "1500");
        	ORB orb = ORB.init(args, props);
            
           
      		POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
     		 rootpoa.the_POAManager().activate();
              
            ShapeListServant SLSRef = new ShapeListServant(rootpoa);
                    
         
      		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(SLSRef);
           	ShapeList SLRef = ShapeListHelper.narrow(ref);
   
            
            org.omg.CORBA.Object objRef = 
                orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
   
           
            NameComponent nc = new NameComponent("ShapeList", "");
            NameComponent path[] = {nc};
            ncRef.rebind(path, SLRef);
            System.out.println("ShapeList Server ready and waiting...");
          
            orb.run();
     	} catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("ShapeList Server Exiting...");
    }
}



