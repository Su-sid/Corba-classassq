public interface ShapeListOperations 
{
  Shape newShape (GraphicalObject g) throws ShapeListPackage.FullException;
  Shape[] allShapes ();
  int getVersion ();
} // interface ShapeListOperations
