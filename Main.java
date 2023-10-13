import src.App;

public class Main{
    App app;
    Main(){
        app = new App();
    }

    public void runApp(){
        app.refreshApp();
    }

    public static void main(String args[]){
        Main mainApp = new Main();
        mainApp.runApp();
    }
}
