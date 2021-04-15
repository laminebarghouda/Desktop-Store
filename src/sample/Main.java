package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {


    static ArrayList<Product> currentProducts  = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();
    BorderPane border = new BorderPane();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("TP2 IHM - BARGHOUDA Mohamed Lamine & SNOUSSI Anis & GUEDRI Oussema");
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox(primaryStage));
        border.setCenter(addGridPane(primaryStage));
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root,1050,600));
        primaryStage.show();

    }

    public HBox addHBox() throws FileNotFoundException {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);

        hbox.setStyle("-fx-background-color: #801f1f;");
        Label label = new Label("Besoin d'aide pour commander ? Appelez le 58 014 893!");
        label.setFont(Font.font("Cambria", 32));
        label.setTextFill(Color.web("#FFFFFF"));
        label.setPadding(new Insets(20, 12, 15, 12));
        FileInputStream imageData = new FileInputStream("assets/shop.jpg");
        Image image = new Image(imageData);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        hbox.getChildren().addAll(imageView, label);

        return hbox;
    }

    public VBox addVBox(Stage primaryStage){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #801f1f;");

        Button buttonAll = new Button("Tout");
        buttonAll.setOnAction(event -> {
            try {
                displayCategory("all", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonAll.setPrefSize(120, 20);

        Button buttonMiniMarket = new Button("Superette");
        buttonMiniMarket.setOnAction(event -> {
            try {
                displayCategory("minimarket", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonMiniMarket.setPrefSize(120, 20);

        Button buttonHouseAndOffice = new Button("Maison & Bureau");
        buttonHouseAndOffice.setOnAction(event -> {
            try {
                displayCategory("house_office", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonHouseAndOffice.setPrefSize(120, 20);

        Button buttonHealthAndBeauty = new Button("Santé & Beauté");
        buttonHealthAndBeauty.setOnAction(event -> {
            try {
                displayCategory("health_beauty", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonHealthAndBeauty.setPrefSize(120, 20);

        Button buttonFushion = new Button("Mode");
        buttonFushion.setOnAction(event -> {
            try {
                displayCategory("fashion", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonFushion.setPrefSize(120, 20);

        Button buttonMultimedia = new Button("Informatique");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("multimedia", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonMultimedia.setPrefSize(120, 20);

        Button buttonElectronics = new Button("Electroniques");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("electronics", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonElectronics.setPrefSize(120, 20);

        Button buttonVideoGames = new Button("Jeux Vidéos");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("videogames", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonVideoGames.setPrefSize(120, 20);

        Button buttonSports = new Button("Sports");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("sports", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonSports.setPrefSize(120, 20);

        Button buttonVehicles = new Button("Auto & Moto");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("vehicles", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonVehicles.setPrefSize(120, 20);

        Button buttonGardening = new Button("Jardinage");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("gardening", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonGardening.setPrefSize(120, 20);

        Button buttonOthers = new Button("Autres Produits");
        buttonMultimedia.setOnAction(event -> {
            try {
                displayCategory("others", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonOthers.setPrefSize(120, 20);

        vbox.getChildren().addAll(buttonAll, buttonMiniMarket, buttonHouseAndOffice, buttonHealthAndBeauty, buttonFushion, buttonMultimedia, buttonElectronics, buttonVideoGames, buttonSports, buttonVehicles, buttonGardening, buttonOthers);
        return vbox;
    }

    public ScrollPane addGridPane(Stage primaryStage) throws FileNotFoundException {
        GridPane grid = new GridPane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        grid.getChildren().add(new ScrollBar());
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        int row = 0, column = 0;
        for(int i=0;i<currentProducts.size();i++){
            Product product = currentProducts.get(i);
            FileInputStream imageData = new FileInputStream(product.productImage);
            Image image = new Image(imageData);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                try {
                    displayDetails(product, primaryStage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            });
            grid.add(imageView,column,row);
            column++;
            if(column==4){
                row++;
                column=0;
            }
        }
        return scrollPane;
    }

    public void displayDetails(Product product, Stage primaryStage) throws FileNotFoundException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        HBox dialogVbox = new HBox(20);
        VBox details = new VBox(40);
        Label name = new Label(product.productName);
        name.setStyle("-fx-font-weight: bold; -fx-padding: 5px");
        Label brand = new Label("Marque: " + product.productBrand);
        brand.setStyle("-fx-font-weight: bold; -fx-padding: 5px");
        Label price = new Label("Prix: " + product.productPrice + " TND");
        price.setStyle("-fx-font-weight: bold; -fx-padding: 5px");
        details.getChildren().add(name);
        details.getChildren().add(brand);
        details.getChildren().add(price);
        details.getChildren().add(new Button("Acheter Maintenant"));
        FileInputStream t = new FileInputStream(product.productImage);
        Image tt = new Image(t);
        ImageView ttt = new ImageView(tt);
        ttt.setFitHeight(300);
        ttt.setFitWidth(200);
        dialogVbox.getChildren().add(ttt);
        dialogVbox.getChildren().add(details);
        Scene dialogScene = new Scene(dialogVbox, 400, 300);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public static void loadTestData(){
        products.add(new Product(
                "Nutella Pâte à tartiner\nà La Noisette & Au Cacao\n600 G",
                24.40,
                "Nutella",
                "minimarket",
                1000,
                "assets/nutella.jpg")
        );
        products.add(new Product(
                "El Manar Boite Thon entier\nA l'huile d'olive vierge\n400 Gr",
                13.00,
                "El Manar",
                "minimarket",
                500,
                "assets/thon-el-manar.jpg")
        );
        products.add(new Product(
                "Biolinge 1+1 Gratuit\nLessive liquide concentrée\nAu Savon de Marseille\n1,8 L",
                16.00,
                " Biolinge",
                "minimarket",
                248,
                "assets/biolinge.jpg")
        );
        products.add(new Product(
                "Gillette 4 x Lames de rasoir\nGillette Fusion5",
                40.90,
                "Gilette",
                "minimarket",
                2540,
                "assets/gilette.jpg")
        );
        products.add(new Product(
                "J'en Rêve Fleurie Couette\n2 places Protection Active\nExtra Douce - 400gr",
                36.90,
                "Reve",
                "house_office",
                0,
                "assets/couette.jpg")
        );
        products.add(new Product(
                "Plaque 4 feux Inox\nGarantie - 1an",
                175.00,
                "STAR ONE",
                "house_office",
                10,
                "assets/plaque.jpg")
        );
        products.add(new Product(
                "Ampoule LED - RGB\nBluetooth - Haut parleur",
                29.00,
                "Sans marque",
                "house_office",
                1500,
                "assets/ampoule.jpg")
        );
        products.add(new Product(
                "Organisateur Cosmétiques Transparent",
                15.00,
                "Sans marque",
                "house_office",
                0,
                "assets/organisateurcosmetique.jpg")
        );
        products.add(new Product(
                "miroir alarme chargeur USB électrique\nAffichage numérique LCD BLANC",
                33.75,
                "Sans marque",
                "house_office",
                25,
                "assets/alarme.jpg")
        );
        products.add(new Product(
                "Étagère Murale Moderne\nNoir et Marron\n60 x 50 x 10 cm",
                49.00,
                "Sans marque",
                "house_office",
                130,
                "assets/etagere.jpg")
        );
        products.add(new Product(
                "Parfum Ice Chill\nEau de Toilette pour Homme",
                29.00,
                "Axe",
                "health_beauty",
                300,
                "assets/axe.jpg")
        );
        products.add(new Product(
                "PROTABAR Barres Protéinées\nBoite de 12 barres 50gr",
                60.00,
                "PROTABAR",
                "health_beauty",
                500,
                "assets/protabar.jpg")
        );
        products.add(new Product(
                "Thermomètre Infrarouge sans Contact\nCorps et Objet - Certifier\nGaranti 1 An",
                59.00,
                "Sans marque",
                "health_beauty",
                10000,
                "assets/thermometre.jpg")
        );
        products.add(new Product(
                "Durex Performax Intense\n3 préservatifs",
                9.66,
                "Durex",
                "health_beauty",
                1305,
                "assets/durex.jpg")
        );
        currentProducts.addAll(products);

    }

    public void displayCategory(String category, Stage primaryStage) throws FileNotFoundException {
        currentProducts.clear();
        if(category.equals("all")){
            currentProducts.addAll(products);
        }
        else {
            for (Product p : products) {
                if (p.productCategory.equals(category)) {
                    currentProducts.add(p);
                }
            }
        }
        border.setCenter(addGridPane(primaryStage));

    }



    public static void main(String[] args) {
        loadTestData();
        launch(args);
    }
}
