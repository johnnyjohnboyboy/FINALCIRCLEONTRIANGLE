package finalcircleontriangle;
import java.awt.Point;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;



  
    

public class Finalcircleontriangle extends Application{
Circle circle;  //circle
    Circle point1, point2, point3; //points/nodes
    Line line1, line2, line3; //lines to connect points
    Text angleText1, angleText2, angleText3; //angle text
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        circle = new Circle(250, 250, 200);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        
        points();
        lines();
        angles();
        
        
        Group gp = new Group(circle, line1, line2, line3, point1, point2, point3, angleText1, angleText2, angleText3);
        Scene sn = new Scene(gp, 500, 500, Color.WHITE);
        stage.setScene(sn);
        stage.setTitle("TriangleOnCircle");
        stage.show();
       
    }
    
    //initializes points/nodes and lines
    public void points(){
        double CENTERx, CENTERy;
        
        CENTERx = circle.getCenterX();
        CENTERy = circle.getCenterY();
         double radius = circle.getRadius();
         double angle = 0;
         
         double x =CENTERx+ radius * Math.cos(Math.toRadians(angle));
        double y = CENTERy + radius * Math.sin(Math.toRadians(angle));
        point1 = new Circle(x, y, 10);
        point1.setFill(Color.RED);
        point1.setStroke(Color.BLACK);
        point1.setOnMouseDragged(e -> drag(point1, e));
        
        x = circle.getCenterX() + circle.getRadius() * Math.cos(275);
        y = circle.getCenterY() + circle.getRadius() * Math.sin(275);
        
        point2 = new Circle(x, y, 10);
        point2.setFill(Color.RED);
        point2.setStroke(Color.BLACK);
        point2.setOnMouseDragged(e -> drag(point2, e));
        
        x = circle.getCenterX() + circle.getRadius() * Math.cos(185);
        y = circle.getCenterY() + circle.getRadius() * Math.sin(185);
        
        point3 = new Circle(x, y, 10);
        point3.setFill(Color.RED);
        point3.setStroke(Color.BLACK);
        point3.setOnMouseDragged(e -> drag(point3, e));
    }
   
      
    //initializes lines conneting points
    public void lines(){
        
        line1 = new Line(point1.getCenterX(), point1.getCenterY(), point2.getCenterX(), point2.getCenterY());
        line2 = new Line(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
        line3 = new Line(point3.getCenterX(), point3.getCenterY(), point1.getCenterX(), point1.getCenterY());
        
    }
    
    //initializes text angle
    public void angles(){
        double x, y; //
        double d1, d2, d3;
        double ANGLE1;
    double ANGLE2;
    double ANGLE3;
        
       double A = Point.distance(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
    double B = Point.distance(point1.getCenterX(), point1.getCenterY(), point3.getCenterX(), point3.getCenterY());
    double C = Point.distance(point2.getCenterX(), point2.getCenterY(), point1.getCenterX(), point1.getCenterY());

        x = circle.getCenterX() + (circle.getRadius() - 50) * Math.cos(45);
        y = circle.getCenterY() + (circle.getRadius() - 50) * Math.sin(45);
        
        ANGLE1 = Math.acos((A*A - B*B - C*C)/(-2 * B * C));
       
        angleText1 = new Text();
       
          
        
        
      
        
        ANGLE2 = Math.acos((B*B - A*A - C*C)/(-2 * A * C));
        
        angleText2 = new Text();
        
        
       
        
        ANGLE3 = Math.acos((C*C - B*B - A*A)/(-2 * A * B));
        
        angleText3 = new Text();
        
       
        
        
       
        
    }
    
    public void test(){
        
        line1.setStartX(point1.getCenterX());
    line1.setStartY(point1.getCenterY());
    line1.setEndX(point2.getCenterX());
    line1.setEndY(point2.getCenterY());
    line2.setStartX(point2.getCenterX());
    line2.setStartY(point2.getCenterY());
    line2.setEndX(point3.getCenterX());
    line2.setEndY(point3.getCenterY());
    line3.setStartX(point3.getCenterX());
    line3.setStartY(point3.getCenterY());
    line3.setEndX(point1.getCenterX());
    line3.setEndY(point1.getCenterY());
        
         double A = Point.distance(point2.getCenterX(), point2.getCenterY(), point3.getCenterX(), point3.getCenterY());
    double B = Point.distance(point1.getCenterX(), point1.getCenterY(), point3.getCenterX(), point3.getCenterY());
    double C = Point.distance(point2.getCenterX(), point2.getCenterY(), point1.getCenterX(), point1.getCenterY());
    
    double ANGLE1 = Math.acos((A*A - B*B - C*C)/(-2 * B * C));
    double ANGLE2 = Math.acos((B*B - A*A - C*C)/(-2 * A * C));
    double ANGLE3 = Math.acos((C*C - B*B - A*A)/(-2 * A * B));
        
        angleText1.setText(String.format("%.1f", Math.toDegrees(ANGLE1)));
        angleText2.setText(String.format("%.1f", Math.toDegrees(ANGLE2)));
        angleText3.setText(String.format("%.1f", Math.toDegrees(ANGLE3)));
    }
    
  
    
    
   public void drag(Circle point, MouseEvent event){
        double X1 = event.getX();
    double X2 = circle.getCenterX();
    double Y1 = event.getY();
    double Y2 = circle.getCenterY();
    
    double ANGLE = Math.atan2(Y1-Y2, X1-X2);
    double NEWx = X2 + circle.getRadius() * Math.cos(ANGLE);
    double NEWy = Y2 + circle.getRadius() * Math.sin(ANGLE);
    
    point.setCenterX(NEWx);
    point.setCenterY(NEWy);
    
    NEWx = X2 + (circle.getRadius()-50) * Math.cos(ANGLE);
    NEWy = Y2 + (circle.getRadius()-50) * Math.sin(ANGLE);
    
    if(point.equals(point1))
    {
        angleText1.setLayoutX(NEWx);
        angleText1.setLayoutY(NEWy);
    }
    
    else if (point.equals(point2)) {
       angleText2.setLayoutX(NEWx);
        angleText2.setLayoutY(NEWy);
    }
    
    else if (point.equals(point3)) {
     angleText3.setLayoutX(NEWx);
     angleText3.setLayoutY(NEWy);
    }
        test();
    }
}
