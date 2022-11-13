 

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


//Alex was here too
public class Main extends Application
{
    private Button swapScreen, closeProgram;
    private int screen;
    private ArrayList<Order> orderList;
    
    
    @Override    
    public void start(Stage stage) {       
        
        screen = 0;
        
        orderList = new ArrayList<>();
        String path = System.getProperty("user.dir");
        System.out.println(path + "\\TESTING.txt");
        File file = new File(path + "\\TESTING.txt");   
        try{
            Scanner sc = new Scanner(file);
            if (file.exists() && sc.hasNextLine())
            {
                while (sc.hasNextLine())
                {
                    String name = sc.nextLine();
                    int orderID = Integer.parseInt(sc.nextLine()); 
                    ArrayList<Pizza> pizzaList = new ArrayList<>();
                    boolean end = false;
                    while(end == false)
                    {
                        int size = 0;
                        int type = 0;
                        int mush = 0;
                        int olive = 0;
                        int EC = 0;
                        int onion = 0;   
                        boolean [] temp = {false,false, false, false};
                        for(int i = 0; i < 6; i++)
                        {
                            if(i == 0){
                                String input = sc.nextLine();
                                if(input.equals("@"))
                                {
                                    end = true;
                                    break;
                                }
                                size = Integer.parseInt(input);
                            }
                            if(i == 1)
                                type = Integer.parseInt(sc.nextLine());
                            if(i == 2)
                            {
                                mush = Integer.parseInt(sc.nextLine());
                                if(mush == 1)
                                    temp[0] = true;
                            }
                            if(i == 3)
                            {
                                olive = Integer.parseInt(sc.nextLine());
                                if(olive == 1)
                                    temp[1] = true;
                            }
                            if(i == 4)
                            {
                                EC = Integer.parseInt(sc.nextLine());
                                if(EC == 1)
                                    temp[2] = true;
                            }
                            if(i == 5)
                            {
                                onion = Integer.parseInt(sc.nextLine());
                                if(onion == 1)
                                    temp[3] = true;
                            }
                        }
                        Pizza piz = new Pizza(size, type, temp);
                        if(end != true)
                            pizzaList.add(piz);                        

                    }
                    Order tempOrder = new Order(pizzaList, orderID, name);
                    orderList.add(tempOrder);
                }
            }
        
        }
        catch (FileNotFoundException ex)       
        {
            System.out.println("File not found");
        }
        for(int k = 0; k < orderList.size(); k++)
        {
            System.out.println("order:" + orderList.get(k).getID() );
            for(int d = 0; d < orderList.get(k).getPizzaList().size(); d++)
            {
                System.out.println("pizza" + orderList.get(k).getPizzaList().get(d).getSize());
            
            }  
        
        }
        
        StackPane rootPane = new StackPane();
        CustomerGUI gui = new CustomerGUI(orderList);
        Scene scene = new Scene(rootPane, 630, 540);
        rootPane.getChildren().add(gui);
        
        StackPane secondPane = new StackPane();
        //CookGUI cookGUI = new CookGUI(dummy);
        Scene scene2 = new Scene(secondPane, 630, 540); 
        //secondPane.getChildren().add(cookGUI);
        
        StackPane thirdPane = new StackPane();
        cashierUI cashierGUI = new cashierUI();
        Scene scene3 = new Scene(thirdPane, 630, 540); 
        thirdPane.getChildren().add(cashierGUI);
        
        //StackPane fourthPane = new StackPane();
        //LoginGUI loginGUI = new LoginGUI();
        //Scene scene4 = new Scene(thirdPane, 630, 540); 
        //thirdPane.getChildren().add(loginGUI);
        
        closeProgram = new Button("Close Program");   
        closeProgram.setTranslateY(230);
        closeProgram.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event)
            {
            try {
              File myObj = new File("TESTING.txt");
              if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
              } else {
                System.out.println("File already exists.");
              }
              FileWriter myWriter = new FileWriter("TESTING.txt");
              for(int i = 0; i < orderList.size(); i++)
              {
                Order ord = orderList.get(i);
                myWriter.write(ord.getName() + "\n");
                myWriter.write(ord.getID() + "\n");
                for(int j = 0; j < ord.getPizzaList().size(); j++)
                {
                    myWriter.write(ord.getPizzaList().get(j).getSize() + "\n");
                    myWriter.write(ord.getPizzaList().get(j).getType() + "\n");
                    
                    boolean top[] = ord.getPizzaList().get(j).getToppings();
                    if(top[0] == true){
                        myWriter.write("1\n");
                    }
                    else
                        myWriter.write("0\n"); 
                    if(top[1] == true){
                        myWriter.write("1\n");
                    }
                    else
                        myWriter.write("0\n"); 
                    if(top[2] == true){
                        myWriter.write("1\n");
                    }
                    else
                        myWriter.write("0\n"); 
                    if(top[3] == true){
                        myWriter.write("1\n");
                    }
                    else
                        myWriter.write("0\n"); 

                }
                myWriter.write("@" + "\n");
              }
                
              myWriter.close();
            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }               
                stage.close();
            }      
        
        });
        
        swapScreen = new Button("Swap GUI");   
        swapScreen.setTranslateX(270);
        swapScreen.setTranslateY(240);
        swapScreen.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event)
            {
                if(screen == 0){
                    stage.setScene(scene); 
                    screen = 1;
                    rootPane.getChildren().addAll(swapScreen,closeProgram);
                }
                else if(screen == 1){
                    stage.setScene(scene2);
                    screen = 2;
                    secondPane.getChildren().addAll(swapScreen,closeProgram);
                }
                else if(screen == 2){
                    stage.setScene(scene3);
                    screen = 0;
                    thirdPane.getChildren().addAll(swapScreen,closeProgram);
                }
                //else if(screen == 3) {
                //    stage.setScene(scene4);
                //    screen = 0;
                //    fourthPane.getChildren().add(swapScreen);
                //}
            }
        });
        
        
 
        stage.setTitle("Pizza GUI"); 
           
        //Adding scene to the stage
        rootPane.getChildren().addAll(swapScreen,closeProgram); 
        stage.setScene(scene); 
        //Displaying the contents of the stage 
        stage.show(); 
        
     }//end start
     
    public static void main(String[] args)
    {
        launch(args);
    }//end main
    //changes
    
    
    
}
