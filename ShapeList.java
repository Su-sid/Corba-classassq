import java.rmi.*;
import java.util.Vector;


public interface Shape extends Remote {
    int getVersion() throws RemoteException;
    GraphicalObject getAllState() throws RemoteException;
}

public interface ShapeList extends Remote, ShapeListOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
    Shape newShape(GraphicalObject g) throws RemoteException;
    Vector allShapes() throws RemoteException;
    int getVersion() throws RemoteException;
} // interface ShapeList
