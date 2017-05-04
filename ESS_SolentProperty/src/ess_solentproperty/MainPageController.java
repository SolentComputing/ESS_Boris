package ess_solentproperty;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Dean Leszman - 1LESZD34
 */
public class MainPageController implements Initializable {
    User user = new User();
    ArrayList<Subscription> subscriptions = new ArrayList<>();
    ArrayList<Client> listClients = new ArrayList<>();
    ArrayList<Stock> listStocks = new ArrayList<>();
    
    public MainPageController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /*
        FXML Elements - ordered in element hierarchy
    */
    @FXML public AnchorPane apMain;
    @FXML public MenuBar menuMain;
    @FXML public Menu menuFile;
    @FXML public MenuItem miLogout;
    @FXML public MenuItem miExit;
                
    @FXML public Menu menuAccounts;
    @FXML public MenuItem miMyAccount;
    @FXML public SeparatorMenuItem smiAccounts;
    @FXML public MenuItem miViewAccounts;
                
    @FXML public Menu menuStock;
    @FXML public MenuItem miStock;
                
    @FXML public TabPane tpMain;
    @FXML public Tab tabSummary;
    @FXML public AnchorPane apSummary;
    @FXML public GridPane gpSummary;
    @FXML public Label lblSummaryNumber;
    @FXML public Label lblSummaryAddress;
    @FXML public Button btnSummarySubscribe;
    @FXML public ListView lvSummary;
    @FXML public Button btnSummarySubscription;
                        
    @FXML public Tab tabEmployees;
            
    @FXML public Tab tabBookings;
    @FXML public AnchorPane apBookings;
    @FXML public DatePicker dpBookings;
    @FXML public TextField tfBookingsType;
    @FXML public RadioButton rbBookingsMorning;
    @FXML public RadioButton rbBookingsAfternoon;
    @FXML public RadioButton rbBookingsEvening;

    // Clients Tab
    @FXML private AnchorPane cboJobTitle;
    @FXML private Label lblclientInfo;
    @FXML private Label lblclientList;
    @FXML private Button btnViewClients;
    @FXML private ListView<Client> clientListView;
    @FXML private TextField fldName;
    @FXML private TextField fldUsername;
    @FXML private PasswordField fldPassword;
    @FXML private TextField fldEmail;
    @FXML private TextField fldMobile;
    @FXML private Button btnclientAdd;
    @FXML private TextField fldTitle;
    
    /*
        FXML Get Methods
    */
    // Main Anchor Pane
    @FXML public AnchorPane getAPMain() { return apMain; }
    // Menu Bar
    @FXML public MenuBar getMenuBar() { return menuMain; }
        // File
    @FXML public Menu getMenuFile() { return menuFile; }
    @FXML public MenuItem getMiLogout() { return miLogout; }
    @FXML public MenuItem getMiExit() { return miExit; }
        // Accounts
    @FXML public Menu getMenuAccounts() { return menuAccounts; }
    @FXML public MenuItem getMiMyAccount() { return miMyAccount; }
    @FXML public SeparatorMenuItem getSmiAccounts() { return smiAccounts; }
    @FXML public MenuItem getMiViewAccounts() { return miViewAccounts; }
        // Stock
    @FXML public Menu getMenuStock() { return menuStock; }
    @FXML public MenuItem getMiStock() { return miStock; }
    
    // Tabs
    @FXML public TabPane getTabPane() { return tpMain; }
        // Summary Tab
    @FXML public Tab getTabSummary() { return tabSummary; }
    @FXML public AnchorPane getApSummary() { return apSummary; }
    @FXML public GridPane getGpSummary() { return gpSummary; }
    @FXML public Label getLblSummaryNumber() { return lblSummaryNumber; }
    @FXML public Label getLblSummaryAddress() { return lblSummaryAddress; }
    @FXML public Button getBtnSummarySubscribe() { return btnSummarySubscribe; }
    @FXML public ListView getLvSummary() { return lvSummary; }
    @FXML public Button getBtnSummarySubscription() { return btnSummarySubscription; }
    
        // Employees Tab
    @FXML public Tab getTabEmployees() { return tabEmployees; }
        // Bookings Tab
    @FXML public Tab getTabBookings() { return tabBookings; }
    @FXML public AnchorPane getApBookings() { return apBookings; }
    @FXML public DatePicker getDpBookings() { return dpBookings; }
    @FXML public TextField getTfBookingsType() { return tfBookingsType; }
    @FXML public RadioButton getRbBookingsMorning() { return rbBookingsMorning; }
    @FXML public RadioButton getRbBookingsAfternoon() { return rbBookingsAfternoon; }
    @FXML public RadioButton getRbBookingsEvening() { return rbBookingsEvening; }
    
    /*
        FXML Set Methods
    */
    // Main Anchor Pane
    @FXML public void setApMain(AnchorPane ap) { apMain = ap; }
    // Menu Bar
    @FXML public void setMenuBar(MenuBar mb) { menuMain = mb; }
        // File
    @FXML public void setMenuFile(Menu m) { menuFile = m; }
    @FXML public void setMiLogout(MenuItem mi) { miLogout = mi; }
    @FXML public void setMiExit(MenuItem mi) { miExit = mi; }
        // Accounts
    @FXML public void setMenuAccounts(Menu m) { menuAccounts = m; }
    @FXML public void setMiMyAccount(MenuItem mi) { miMyAccount = mi; }
    @FXML public void setSmiAccounts(SeparatorMenuItem smi) { smiAccounts = smi; }
    @FXML public void setMiViewAccounts(MenuItem mi) { miViewAccounts = mi; }
        // Stock
    @FXML public void setMenuStock(Menu m) { menuStock = m; }
    @FXML public void setMiStock(MenuItem mi) { miStock = mi; }
    // Tabs
    @FXML public void setTabPane(TabPane tp) { tpMain = tp; }
        // Summary Tab
    @FXML public void setTabSummary(Tab tab) { tabSummary = tab; }
    @FXML public void setApSummary(AnchorPane ap) { apSummary = ap; }
    @FXML public void setGpSummary(GridPane gp) { gpSummary = gp; }
    @FXML public void setLblSummaryNumber(Label lbl) { lblSummaryNumber = lbl; }
    @FXML public void setLblSummaryAddress(Label lbl) { lblSummaryAddress = lbl; }
        // Employees Tab
    @FXML public void setTabEmployees(Tab tab) { tabEmployees = tab; }
        // Bookings Tab
    @FXML public void setTabBookings(Tab tab) { tabBookings = tab; }
    @FXML public void setApBookings(AnchorPane ap) { apBookings = ap; }
    @FXML public void setDpBookings(DatePicker dp) { dpBookings = dp; }
    @FXML public void setTfBookingsType(TextField tf) { tfBookingsType = tf; }
    @FXML public void setRbBookingsMorning(RadioButton rb) { rbBookingsMorning = rb; }
    @FXML public void setRbBookingsAfternoon(RadioButton rb) { rbBookingsAfternoon = rb; }
    @FXML public void setRbBookingsEvening(RadioButton rb) { rbBookingsEvening = rb; }
    
    // Called when setting which user has just logged in - will be called from the 
    protected void setUser(User user) {
        this.user = user;
    }
    
    // Log out current user from system
    @FXML public void logout(ActionEvent event) {
        user = null;
        
        // Show login page
        try {
            Stage mainStage = (Stage) menuMain.getScene().getWindow();
            mainStage.close();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));        
            Scene scene = new Scene(root);        
            stage.setScene(scene);
            stage.show();         
            System.out.println(event);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    // Exit the program
    @FXML public void exit() {
        user = null;
        System.exit(0);
    }
    
    private void getCurrentAccount() {
//        Account user = FXMLLoginController.getCurrentUser();
        user.account = new Account("Bob", "123", true);
    }

    // Create a booking
    @FXML public void book() {
        System.out.println("book()");
        
        LocalDate date = getDpBookings().getValue(); // Get the selected date from the date picker - format will be yyyy-MM-dd
        int time;
        
        // Get which radio button was checked
        if (getRbBookingsMorning().isSelected()) {
            time = 1;
        } else if (getRbBookingsAfternoon().isSelected()) {
            time = 2;
        } else if (getRbBookingsEvening().isSelected()) {
            time = 3;
        } else {
            time = 0;
        }
        
        String type = getTfBookingsType().getText(); // Get the type of work text
        
        // if any of the values are not set
        if (getDpBookings().getValue() == null || time == 0 || type.isEmpty()) {
            // Display an error
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Booking Error");
            alert.setContentText("There was an error with your booking.\nPlease ensure you select a date, time and type of work.");
            alert.showAndWait();
        } else {
            // else convert the datepicker to a calendar
            Calendar cal = new Calendar.Builder()
                    .set(Calendar.YEAR, date.getYear())
                    .set(Calendar.MONTH, date.getMonthValue())
                    .set(Calendar.DATE, date.getDayOfMonth())
                    .build();
            
            // Set the time for work to begin
            switch (time) {
                case 1:
                    cal.set(Calendar.HOUR_OF_DAY, 9);
                    break;
                case 2:
                    cal.set(Calendar.HOUR_OF_DAY, 12);
                    break;
                case 3:
                    cal.set(Calendar.HOUR_OF_DAY, 15);
                    break;
                default:
                    break;
            }
            Booking booking = new Booking(user.address, type, cal); // Create a new booking
            booking.address.print();
            System.out.println(booking.getService());
            System.out.println(booking.toString());
        }
    }
    
    // Load existing subscriptions
    @FXML public void reloadSubscriptions() {
        ObservableList<String> listSubscriptions = FXCollections.observableArrayList();
        for (Subscription s : subscriptions) {
            listSubscriptions.add(s.toString());
        }
        
        lvSummary.setItems(listSubscriptions);
    }
    
    // Create new subscription
    @FXML public void subscribe() {
        System.out.println("subscribe()");
        
        // Create the dialog
        Dialog dialog = new Dialog();
        dialog.setTitle("New Subscription");
        
        // Create the buttons
        ButtonType confirm = new ButtonType("Subscribe", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirm, ButtonType.CANCEL);
        
        GridPane grid = new GridPane(); // Create new grid pane to hold the dialog items
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        
        // Create the combo boxes
        ArrayList<String> day = new ArrayList<>(); // Create list of days to add to combobox
        day.add("Monday");
        day.add("Tuesday");
        day.add("Wednesday");
        day.add("Thursday");
        day.add("Friday");
        
        ComboBox<String> comboDay = new ComboBox<>(); // Create empty instance of combobox
        comboDay.setItems(FXCollections.observableArrayList(day));

        
        ArrayList<String> times = new ArrayList<>(); // Same for times
        times.add("Morning (9am - 12pm)");
        times.add("Afternoon (12pm - 3pm)");
        times.add("Evening (3pm - 6pm)");
        
        ComboBox<String> comboTime = new ComboBox<>();
        comboTime.setItems(FXCollections.observableArrayList(times));
        
        TextField tfType = new TextField();
        grid.add(new Label("Day:"), 0, 0); // "Day:" column 0, row 0
        grid.add(comboDay, 1, 0); // day list column 1, row 0
        grid.add(new Label("Time:"), 0, 1); // "Time:" column 0, row 1
        grid.add(comboTime, 1, 1); // times list column 1, row 1
        grid.add(new Label("Type of work:"), 0, 2); // "Type of work:" label, column 0, row 2
        grid.add(tfType, 1, 2); // textfield column 1, row 2
        dialog.getDialogPane().setContent(grid); // Add the gridpane to the dialog
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == confirm) { // if they have clicked the confirm button
                //return new String[3](comboDay.getValue(), comboTime.getValue()); // Get the two values, convert them to a String and add them to a Pair
                String[] strings = { comboDay.getValue(), comboTime.getValue(), tfType.getText() };
                return strings;
            }
            return null;
        });
        
        Optional<String[]> result = dialog.showAndWait(); // Show dialog and wait for response
        
        result.ifPresent(dayTime -> {
            Subscription subscription; // Create a new subscription with current user's address, and the day/time they selected
            subscription = new Subscription(user.address, dayTime[0], dayTime[1], dayTime[2]);
            subscriptions.add(subscription);
//            System.out.println(subscription.address.toString());
//            System.out.println(subscription.getDay());
//            System.out.println(subscription.getTime());

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("[INFO] Subscription");
            alert.setHeaderText("Your subscription was submitted successfully.");
            alert.setContentText("Here are your subscription details:\n\n"
                    + "- Address -\n"
                    + subscription.address.toStringLine()
                    + "\n\n- Day -\n"
                    + subscription.getDay()
                    + "\n\n- Time -\n"
                    + subscription.getTime()
                    + "\n\n- Type -\n"
                    + subscription.getType());
            alert.show();
        });
    }
    
    /* /Dean Leszman/ */
    
    /*
        #####
    
            CLIENT TAB
    
        #####
    */
    /**
    * @author Fraser Provan
    */
    @FXML
    public void handleSaveClient(ActionEvent event) throws IOException {
        
        String title = this.fldTitle.getText();
        String username = this.fldUsername.getText();
        String password = this.fldPassword.getText();
        String name = this.fldName.getText();
        String mobile = this.fldMobile.getText();
        String email = this.fldEmail.getText();
        
        Client Client = new Client(title, username, password, name, mobile, email);
        listClients.add(Client);
    }
    
    @FXML
    public void handleShowClients(){
                if (!clientListView.getItems().isEmpty()){
            this.clientListView.getItems().clear();
        }
                listClients.forEach((ag) -> {
                    this.clientListView.getItems().add(ag);
        });
    }
    
//    public class Jobtitles {
//
//        public Jobtitles(String string) {
//
//        }
//    }
    
    /* /Fraser Provan/ */
    
    /*
        #####
    
            Stocks Tab
    
        #####
    */
    /**
    * @author Denils Kronberg
    */
    @FXML private Label lblNewStock;
    @FXML private AnchorPane apStockBox;
    @FXML private TextField fldItem;
    @FXML private TextField fldSupplier;
    @FXML private TextField fldCount;
    @FXML private Button btnStocksAdd;
    @FXML private Label lblStockList;
    @FXML private Button btnViewStocks;
    @FXML private ListView<Stock> stockListView;
    @FXML private TextField fldStockBox;
    
    @FXML
    public void handleSaveStock(ActionEvent event) throws IOException {
        
        //String stockbox = this.fldStockBox.getText();
        String item = this.fldItem.getText();
        String supplier = this.fldSupplier.getText();
        String count = this.fldCount.getText();
      
        
        Stock stock = new Stock(item, supplier, count);
        listStocks.add(stock);
        handleShowStocks();
    }
    
    @FXML
    public void handleShowStocks(){
        if (!stockListView.getItems().isEmpty()){
            this.stockListView.getItems().clear();
        }
        
        listStocks.forEach((ag) -> {
            this.stockListView.getItems().add(ag);
        });
    }
    
    @FXML
    private Label label;
    
    @FXML
    private void btnBuyAction(ActionEvent event) {
        System.out.println("Bought more supplies!");
        label.setText("Item was ordered!");
    }  

    class StockBoxes {

        public StockBoxes(String String) {
            
        }
    }
    
    /* /Denils Kronberg/ */
    
    
    /* Auto-contructed method */
    /* Called upon initialisation of controller */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Create a template set of subscriptions
        subscriptions.add(new Subscription());
        subscriptions.add(new Subscription());
        subscriptions.add(new Subscription());
        
        // Create a template set of employees
        
        // Create template set of clients
        listClients.add(new Client("Mr", "John312", "QWERT", "John", "34457943456", "john3123@dragonmail.net"));
        listClients.add(new Client("Dr", "Hank2", "wordpass", "hanklon", "56834567345", "Hank@dragonmail.net"));
        listClients.add(new Client("Mrs", "Shelly3", "rgewtw", "Helen", "56345934545", "helenShelly@dragonmail.net"));
        
        // Create template set of clients
        listStocks.add(new Stock("Nails", "The Range", "100"));
        listStocks.add(new Stock("Laminate", "Beaver Inc.", "25"));
        listStocks.add(new Stock("Bricks", "SuperBuilder", "300"));
    }  
}
