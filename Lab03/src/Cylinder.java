public class Cylinder {

    private double height;
    private double radius;

    public void setRadius(double newRadius){
        radius = newRadius;
    }

    public void setHeight(double newHeight){
        height = newHeight;
    }

    public double getRadius(){return radius;}

    public double getHeight(){return height;}

    public Cylinder(double cylinderRadius, double cylinderHeight){
        radius = cylinderRadius;
        height = cylinderHeight;
    }

    public Cylinder(){

    }

    public double baseArea(){
        return Math.PI*Math.pow(radius,2);
    }

    public double sideArea(){
        return 2*Math.PI*Math.pow(radius,2);
    }

    public double area(){
        return sideArea()+ 2 * baseArea();
    }

    public double volume(){
        return baseArea()*height;
    }

}
