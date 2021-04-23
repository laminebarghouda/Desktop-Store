package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {

    // Class Variables
    static ArrayList<Product> currentProducts  = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();
    BorderPane border = new BorderPane();

    /**
     * Initializing App layouts
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Setting App Title
        primaryStage.setTitle("TP2 IHM - BARGHOUDA Mohamed Lamine & SNOUSSI Anis & GUEDRI Oussema");

        // Setting Header
        border.setTop(addHeader());

        // Setting Sidebar
        border.setLeft(addSideBar(primaryStage));

        // Setting App Main Grid
        border.setCenter(addProductsGrid(primaryStage));
        StackPane root = new StackPane();
        root.getChildren().add(border);
        primaryStage.setScene(new Scene(root,1010,600));
        primaryStage.show();
    }

    /**
     * Defining App header
     *
     * @return HBox
     * @throws FileNotFoundException
     */
    public HBox addHeader() throws FileNotFoundException {
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

    /**
     * Defining App Sidebar that will handle products categories
     *
     * @param primaryStage
     * @return VBox
     */
    public VBox addSideBar(Stage primaryStage){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #801f1f;");

        // For each product category, defining it and it's logic
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
        buttonElectronics.setOnAction(event -> {
            try {
                displayCategory("electronics", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonElectronics.setPrefSize(120, 20);

        Button buttonVideoGames = new Button("Jeux Vidéos");
        buttonVideoGames.setOnAction(event -> {
            try {
                displayCategory("videogames", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonVideoGames.setPrefSize(120, 20);

        Button buttonSports = new Button("Sports");
        buttonSports.setOnAction(event -> {
            try {
                displayCategory("sports", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonSports.setPrefSize(120, 20);

        Button buttonVehicles = new Button("Auto & Moto");
        buttonVehicles.setOnAction(event -> {
            try {
                displayCategory("vehicles", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonVehicles.setPrefSize(120, 20);

        Button buttonGardening = new Button("Jardinage");
        buttonGardening.setOnAction(event -> {
            try {
                displayCategory("gardening", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonGardening.setPrefSize(120, 20);

        Button buttonOthers = new Button("Autres Produits");
        buttonOthers.setOnAction(event -> {
            try {
                displayCategory("others", primaryStage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        buttonOthers.setPrefSize(120, 20);

        // Adding all category buttons to the sidebar component
        vbox.getChildren().addAll(buttonAll, buttonMiniMarket, buttonHouseAndOffice, buttonHealthAndBeauty, buttonFushion, buttonMultimedia, buttonElectronics, buttonVideoGames, buttonSports, buttonVehicles, buttonGardening, buttonOthers);
        return vbox;
    }

    /**
     * Defines and shows Products Grid according to category chosen
     *
     * @param primaryStage
     * @return ScrollPane
     * @throws FileNotFoundException
     */
    public ScrollPane addProductsGrid(Stage primaryStage) throws FileNotFoundException {
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
            // Reading Product Image
            FileInputStream imageData = new FileInputStream(product.productImage);
            Image image = new Image(imageData);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            // Defining Image on click actions
            imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                try {
                    displayDetails(product, primaryStage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            });
            // Adding image to the grid
            grid.add(imageView,column,row);
            column++;
            if(column==4){
                row++;
                column=0;
            }
        }
        return scrollPane;
    }

    /**
     * Displays a specific product details
     *
     * @param product
     * @param primaryStage
     * @throws FileNotFoundException
     */
    public void displayDetails(Product product, Stage primaryStage) throws FileNotFoundException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        HBox dialogVbox = new HBox(20);
        VBox details = new VBox(10);
        Label name = new Label(product.productName);
        name.setStyle("-fx-font-weight: bold; -fx-padding: 5px");
        Label brand = new Label("Marque: " + product.productBrand);
        brand.setStyle("-fx-font-weight: bold; -fx-padding: 5px");
        Label price = new Label("Prix: " + product.productPrice + " TND");
        price.setStyle("-fx-font-weight: bold; -fx-padding: 5px");
        details.getChildren().add(name);
        details.getChildren().add(brand);
        details.getChildren().add(price);
        GridPane quantityGrid = new GridPane();
        Label quantityLabel = new Label("Quantité: ");
        TextField quantityField = new TextField();
        quantityGrid.add(quantityLabel, 0, 0);
        quantityGrid.add(quantityField,1,0);
        details.getChildren().add(quantityGrid);
        Button buyButton = new Button("Acheter Maintenant");
        buyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showPurchaseForm(product, primaryStage, Integer.parseInt(quantityField.getText()), dialog);
            }
        });
        details.getChildren().add(buyButton);
        FileInputStream t = new FileInputStream(product.productImage);
        Image tt = new Image(t);
        ImageView ttt = new ImageView(tt);
        ttt.setFitHeight(200);
        ttt.setFitWidth(200);
        dialogVbox.getChildren().add(ttt);
        dialogVbox.getChildren().add(details);
        Scene dialogScene = new Scene(dialogVbox, 600, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    /**
     * Once commanding, shows Purchase form
     *
     * @param product
     * @param primaryStage
     * @param quantity
     * @param productDialog
     */
    public void showPurchaseForm(Product product, Stage primaryStage, int quantity, Stage productDialog){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle;
        Scene scene = new Scene(grid, 500, 350);
        // If product quantity is insufficient, shows error dialog
        if(product.getProductQuantityAvailable() <= quantity){

            scenetitle = new Text("Nous sommes désolé! Quantité non suffisante\n(Quantité Disponible : " + product.getProductQuantityAvailable() + ")");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle, 0, 0, 2, 1);
        }
        // If product quantity sufficient, shows error address form
        else {
            product.buyProduct(quantity);
            productDialog.hide();
            scenetitle = new Text("Veuillez saisir vos informations de livraison");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle, 0, 0, 2, 1);

            Label lastname = new Label("Nom:");
            grid.add(lastname, 0, 1);

            TextField lastnameField = new TextField();
            grid.add(lastnameField, 1, 1);

            Label firstname = new Label("Prénom:");
            grid.add(firstname, 0, 2);

            TextField firstnameField = new TextField();
            grid.add(firstnameField, 1, 2);

            Label adress = new Label("Adresse:");
            grid.add(adress, 0, 3);

            TextField adressField = new TextField();
            grid.add(adressField, 1, 3);

            Label region = new Label("Etat/Region:");
            grid.add(region, 0, 4);

            TextField regionField = new TextField();
            grid.add(regionField, 1, 4);

            Label city = new Label("Ville:");
            grid.add(city, 0, 5);

            TextField cityField = new TextField();
            grid.add(cityField, 1, 5);

            Label postalCode = new Label("Code Postal:");
            grid.add(postalCode, 0, 6);

            TextField postalCodeField = new TextField();
            grid.add(postalCodeField, 1, 6);

            Label phone = new Label("Téléphone:");
            grid.add(phone, 0, 7);

            TextField phoneField = new TextField();
            grid.add(phoneField, 1, 7);

            Button validateButton = new Button("Valider la Commande");
            validateButton.setOnAction(event -> {
                dialog.hide();
                showPayment(primaryStage);
            });
            HBox hbBtn = new HBox(10);
            hbBtn.setMargin(validateButton, new Insets(0, 0, 0, 90));
            hbBtn.getChildren().add(validateButton);
            grid.add(hbBtn, 1, 8);
        }
        dialog.setScene(scene);
        dialog.show();
    }

    /**
     * Once purchase form filled, shows payment infos
     *
     * @param primaryStage
     */
    public void showPayment(Stage primaryStage){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle;
        Scene scene = new Scene(grid, 500, 350);
            scenetitle = new Text("Veuillez saisir vos informations de paiement");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle, 0, 0, 2, 1);

            Label type = new Label("Type Carte Bancaire:");
            grid.add(type, 0, 1);

            TextField typeField = new TextField();
            grid.add(typeField, 1, 1);

            Label numberCard = new Label("Numéro Carte Bancaire:");
            grid.add(numberCard, 0, 2);

            TextField numberField = new TextField();
            grid.add(numberField, 1, 2);

            Label adress = new Label("Date D'expiration:");
            grid.add(adress, 0, 3);

        DatePicker date = new DatePicker();
        grid.add(date, 1, 3);

            Label code = new Label("Code:");
            grid.add(code, 0, 4);

            PasswordField codeField = new PasswordField();
            grid.add(codeField, 1, 4);

            Button validateButton = new Button("Valider le Paiement");
            validateButton.setOnAction(event -> {
                dialog.hide();
                showValidation(primaryStage);
            });
            HBox hbBtn = new HBox(10);
            hbBtn.setMargin(validateButton, new Insets(0, 0, 0, 40));
            hbBtn.getChildren().add(validateButton);
            grid.add(hbBtn, 1, 8);
        dialog.setScene(scene);
        dialog.show();
    }

    /**
     * Shows up successfully ordered screen
     * @param primaryStage
     */
    public void showValidation(Stage primaryStage){
        final Stage dialog = new Stage();
        dialog.initOwner(primaryStage);
        GridPane gridOK = new GridPane();
        gridOK.setAlignment(Pos.CENTER);
        gridOK.setHgap(10);
        gridOK.setVgap(10);
        gridOK.setPadding(new Insets(25, 25, 25, 25));
        Text sceneTitle = new Text("Commande bien validé! Vous recevrez bientôt votre commande\nMerci pour votre confiance \uD83D\uDE0A");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridOK.add(sceneTitle, 0, 0, 2, 1);
        Scene OKscene = new Scene(gridOK, 600, 100);
        dialog.setScene(OKscene);
        dialog.show();
    }



    /**
     * Filter products according to a specific category
     *
     * @param category
     * @param primaryStage
     * @throws FileNotFoundException
     */
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
        border.setCenter(addProductsGrid(primaryStage));
    }


    /**
     * This method charge the app with data for test goals
     */
    public static void loadTestData(){
        products.add(new Product(
                "Nutella Pâte à tartiner à La Noisette & Au Cacao 600 G",
                24.40,
                "Nutella",
                "minimarket",
                1000,
                "assets/nutella.jpg")
        );
        products.add(new Product(
                "El Manar Boite Thon entier A l'huile d'olive vierge 400 Gr",
                13.00,
                "El Manar",
                "minimarket",
                500,
                "assets/thon-el-manar.jpg")
        );
        products.add(new Product(
                "Biolinge 1+1 Gratuit Lessive liquide concentrée Au Savon de Marseille 1,8 L",
                16.00,
                " Biolinge",
                "minimarket",
                248,
                "assets/biolinge.jpg")
        );
        products.add(new Product(
                "Gillette 4 x Lames de rasoir Gillette Fusion5",
                40.90,
                "Gilette",
                "minimarket",
                2540,
                "assets/gilette.jpg")
        );
        products.add(new Product(
                "Sanabel Carthage Farine Paquet De 1Kg",
                0.85,
                "Sanabel Carthage",
                "minimarket",
                10200,
                "assets/farina.jpg"
        ));
        products.add(new Product(
                "Dettol Pack - 6 Savons Dettol Antibacterien",
                10.00,
                "Dettol",
                "minimarket",
                250,
                "assets/dettol.jpg"
        ));
        products.add(new Product(
                "Bonna Mayonnaise 260ML",
                3.00,
                "Bonna",
                "minimarket",
                0,
                "assets/mayonnaise.jpg"
        ));
        products.add(new Product(
                "Sanabel Carthage Coude 1 De 500 Gr",
                0.410,
                "Sanabel",
                "minimarket",
                1500,
                "assets/coude.jpg"
        ));
        products.add(new Product(
                "Tomate Concentré - 800 g",
                4.16,
                "Le Petit Paris",
                "minimarket",
                3500,
                "assets/tomate.jpg"
        ));
        products.add(new Product(
                "J'en Rêve Fleurie Couette 2 places Protection Active Extra Douce - 400gr",
                36.90,
                "Reve",
                "house_office",
                0,
                "assets/couette.jpg")
        );
        products.add(new Product(
                "Plaque 4 feux Inox Garantie - 1an",
                175.00,
                "STAR ONE",
                "house_office",
                10,
                "assets/plaque.jpg")
        );
        products.add(new Product(
                "Ampoule LED - RGB Bluetooth - Haut parleur",
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
                "miroir alarme chargeur USB électrique Affichage numérique LCD BLANC",
                33.75,
                "Sans marque",
                "house_office",
                25,
                "assets/alarme.jpg")
        );
        products.add(new Product(
                "Étagère Murale Moderne Noir et Marron 60 x 50 x 10 cm",
                49.00,
                "Sans marque",
                "house_office",
                130,
                "assets/etagere.jpg")
        );
        products.add(new Product(
                "Evertek Home Fer à repasser - Iron Speed - Blanc/Violet",
                52.00,
                "Evertek Home",
                "house_office",
                35,
                "assets/ferarepasser.jpg"
        ));
        products.add(new Product(
                "Ingco Rabot Electrique 1050 W - PL10508 - Jaune & Noir",
                195.00,
                "Ingco",
                "house_office",
                30,
                "assets/robotelectrigue.jpg"
        ));
        products.add(new Product(
                "Franco Hotte Aspirante Incliné 60cm 2Vitres - FR1061 - Noir",
                359.00,
                "Franco",
                "house_office",
                120,
                "assets/hotteaspirante.jpg"
        ));
        products.add(new Product(
                "Pompe à eau périphérique QB60-Garantie 1 an",
                179.00,
                "Sans Marque",
                "house_office",
                1020,
                "assets/pompeaeau.jpg"
        ));
        products.add(new Product(
                "Plaque De Cuisson - Inox - CPG75SWGX - 5 Feux",
                899.00,
                "Candy",
                "house_office",
                50,
                "assets/plaquecandy.jpg"
        ));
        products.add(new Product(
                "Silverline Hotte - Inox - 3180.100 - Coin - Pyramidale",
                1099.00,
                "Silverline",
                "house_office",
                150,
                "assets/silverlinehotte.jpg"
        ));
        products.add(new Product(
                "Parfum Ice Chill Eau de Toilette pour Homme",
                29.00,
                "Axe",
                "health_beauty",
                300,
                "assets/axe.jpg")
        );
        products.add(new Product(
                "PROTABAR Barres Protéinées Boite de 12 barres 50gr",
                60.00,
                "PROTABAR",
                "health_beauty",
                500,
                "assets/protabar.jpg")
        );
        products.add(new Product(
                "Thermomètre Infrarouge sans Contact Corps et Objet - Certifier Garanti 1 An",
                59.00,
                "Sans marque",
                "health_beauty",
                10000,
                "assets/thermometre.jpg")
        );
        products.add(new Product(
                "Frank Oliver Oud Touch - Eau de parfum",
                73.90,
                "Frank Oliver",
                "health_beauty",
                200,
                "assets/frankoliveroudtouch.jpg"
        ));
        products.add(new Product(
                "Sonar Tondeuse à cheveux nez et barbe professionnelle",
                27.00,
                "Sonar",
                "health_beauty",
                100,
                "assets/tondeuse.jpg"
        ));
        products.add(new Product(
                "Fa 2 Déodorants roll-on anti-transpirant - Pink Passion - 50ml - 1 + 1 Gratuit",
                5.90,
                "Fa",
                "health_beauty",
                360,
                "assets/deodorants.jpg"
        ));
        products.add(new Product(
                "Perruque Synthétique Bouclés - Violet - 26 Pouces",
                85.00,
                "Armin",
                "health_beauty",
                10,
                "assets/perruque.jpg"
        ));
        products.add(new Product(
                "Crème Anti Age Eclaircissante - Visage et Cou - Aloé Vera",
                11.50,
                "Fiore",
                "health_beauty",
                360,
                "assets/cremeantiage.jpg"
        ));
        products.add(new Product(
                "Le Coq Sportif Basket Flag Twill Pure Red",
                88.00,
                "Le Coq Sportif",
                "fashion",
                360,
                "assets/basket.jpg"
        ));
        products.add(new Product(
                "Pantalon jean femme - Boyfriend",
                42.00,
                "Sans Marque",
                "fashion",
                120,
                "assets/pantalon.jpg"
        ));
        products.add(new Product(
                "Montre pour homme - Argent - Garantie 1An",
                170.00,
                "Beverly Hills Polo Club",
                "fashion",
                20,
                "assets/montrehomme.jpg"
        ));
        products.add(new Product(
                "Montre pour femme - Rose Gold - Garantie 2 Ans",
                224.00,
                "Esprit",
                "fashion",
                30,
                "assets/montrefemme.jpg"
        ));
        products.add(new Product(
                "Capuche - Noir - Attack - On - Titan",
                39.90,
                "WHITELEAD",
                "fashion",
                120,
                "assets/capuche.jpg"
        ));
        products.add(new Product(
                "Collier Pendentif A116 - Or",
                27.00,
                "Liva Girl",
                "fashion",
                5,
                "assets/collier.jpg"
        ));
        products.add(new Product(
                "Boitier Sog - RGB - Gamer - ATX/ARGB/120MM*2",
                165.00,
                "Spirit Of Gamer",
                "multimedia",
                10,
                "assets/boitier.jpg"
        ));
        products.add(new Product(
                "Pc portable inspiron 3501 I3 10e gen 8GO 256GO ssd",
                1410.00,
                "DELL",
                "multimedia",
                5,
                "assets/pc.jpg"
        ));
        products.add(new Product(
                "MacBook Air 13 pouces M1 - 256 Go - Or - Garantie 1 an",
                3919.00,
                "Apple",
                "multimedia",
                120,
                "assets/macbook.jpg"
        ));
        products.add(new Product(
                "Souris optique - Sans fil - Noir",
                11.00,
                "Sans Marque",
                "multimedia",
                100,
                "assets/souris.jpg"
        ));
        products.add(new Product(
                "Imprimante 3en1 WIFI Jet d'encre Pixma - G3411 - Couleur",
                89.00,
                "Sans Marque",
                "multimedia",
                1300,
                "assets/imprimantewifi.jpg"
        ));
        products.add(new Product(
                "Scanner A3 PageExpress - 2400s",
                1240.00,
                "Mustek",
                "multimedia",
                10,
                "assets/scanner.jpg"
        ));
        products.add(new Product(
                "Imprimante Jet d'encre - PIXMA MG-2540 - 3en1- Garantie 1 an",
                539.00,
                "Canon",
                "multimedia",
                20,
                "assets/imprimantejetancre.jpg"
        ));
        products.add(new Product(
                "Casque P47- sans fils -MP3- Bluetooth -Rouge",
                24.00,
                "Canon",
                "multimedia",
                120,
                "assets/casque.jpg"
        ));
        products.add(new Product(
                "Lecteur de Carte memoire + Otg",
                10.00,
                "Sans Marque",
                "multimedia",
                1000,
                "assets/lecteurcartememoire.jpg"
        ));
        products.add(new Product(
                "LG Téléviseur 43\" - LED FHD - 43LM5500 - Garantie 2 ans",
                1039.00,
                "LG",
                "electronics",
                100,
                "assets/tv.jpg"
        ));
        products.add(new Product(
                "Icone Wegoo 4K",
                242.00,
                "Wegoo",
                "electronics",
                1500,
                "assets/wegooicone.jpg"
        ));
        products.add(new Product(
                "Caméra wifi smart speede Dome IP - Couleur jour et nuit",
                249.00,
                "Sans Marque",
                "electronics",
                320,
                "assets/camerawifi.jpg"
        ));
        products.add(new Product(
                "Haut parleur F18M - 80 W - 4400 mAh -micro sans fils",
                345.00,
                "SPARK",
                "electronics",
                120,
                "assets/hautparleur.jpg"
        ));

        products.add(new Product(
                "Manette PS3 - Noir",
                24.00,
                "Sans Marque",
                "videogames",
                450,
                "assets/manette.jpg"
        ));
        products.add(new Product(
                "Gta 5 Edition premium ps4",
                119.00,
                "Sony",
                "videogames",
                900,
                "assets/gta.jpg"
        ));
        products.add(new Product(
                "Clavier Gamer GK100 + Souris Gamer 4D - Led - Noir",
                26.90,
                "Jedel",
                "videogames",
                30,
                "assets/clavier.jpg"
        ));
        products.add(new Product(
                "Casque Micro Gaming RGB - HG15 - Noir",
                95.00,
                "Fantech",
                "videogames",
                501,
                "assets/casquefantech.jpg"
        ));

        products.add(new Product(
                "Barre fixe démontable",
                69.00,
                "Iron Gym",
                "sports",
                1500,
                "assets/barrefixe.jpg"
        ));
        products.add(new Product(
                "Couteau Multifonction - Couteau Suisse 13 en 1",
                69.00,
                "Sans Marque",
                "sports",
                100,
                "assets/couteau.jpg"
        ));
        products.add(new Product(
                "Power résistance bands",
                99.00,
                "Sans Marque",
                "sports",
                140,
                "assets/powerresistance.jpg"
        ));
        products.add(new Product(
                "Matelas nbr - Bleu foncé",
                50.00,
                "Sans Marque",
                "sports",
                1400,
                "assets/matelassport.jpg"
        ));

        products.add(new Product(
                "Huile Moteur VX 1000 FAP 5W40 C3 - 5L",
                91.00,
                "YACCO",
                "vehicles",
                4500,
                "assets/huilemoteur.jpg"
        ));
        products.add(new Product(
                "Éponge Spéciale de Lavage microfibre Clown",
                22.00,
                "Lampa",
                "vehicles",
                1400,
                "assets/eponge.jpg"
        ));
        products.add(new Product(
                "Cal-DOS avec 2 Poches - Marron",
                35.00,
                "Sans Marque",
                "vehicles",
                602,
                "assets/caldos.jpg"
        ));
        products.add(new Product(
                "Tapis coffre - Renault Megane 2 casquette",
                54.00,
                "Sans Marque",
                "vehicles",
                450,
                "assets/tapiscoffre.jpg"
        ));

        products.add(new Product(
                "Pulvérisateur à Dos Contre Les virus - Pompes À Pression 16 litres",
                69.00,
                "Sans Marque",
                "gardening",
                10,
                "assets/pulverisateur.jpg"
        ));
        products.add(new Product(
                "Lot de 4 bordures pvc plastiques pour jardin - Clôture 50*55 cm",
                89.00,
                "Sans Marque",
                "gardening",
                450,
                "assets/bordures.jpg"
        ));
        products.add(new Product(
                "Tuyau d' arrosage- Magic hose - Vert",
                36.00,
                "Sans Marque",
                "gardening",
                560,
                "assets/tuyau.jpg"
        ));
        products.add(new Product(
                "Tondeuses à gazon - Electrique - PowerMax - 1200W - 32 cm",
                439.00,
                "Gardena",
                "gardening",
                45,
                "assets/gardenatondeuse.jpg"
        ));

        products.add(new Product(
                "Carte à gratter - Pour visionner le film Rebelote",
                10,
                "Sans Marque",
                "others",
                30,
                "assets/carteagratter.jpg"
        ));
        products.add(new Product(
                "Pack -De 8 surligneurs- Pastel",
                26.00,
                "Stabilo",
                "others",
                30,
                "assets/stabilo.jpg"
        ));
        products.add(new Product(
                "Calculatrice scientifique - EL531THB GY",
                48.50,
                "Sharp",
                "others",
                30,
                "assets/calculatrice.jpg"
        ));
        products.add(new Product(
                "Trieur de courrier en métal",
                15.00,
                "Sans Marque",
                "others",
                30,
                "assets/trieur.jpg"
        ));
        products.add(new Product(
                "Mitigeur bain douche Cosmo",
                120.00,
                "Tema",
                "others",
                30,
                "assets/mitigeur.jpg"
        ));
        products.add(new Product(
                "100 x Boite en carton - Emballage 10 x 10 x 18 cm - kraft",
                39.00,
                "Sans Marque",
                "others",
                30,
                "assets/boitecarton.jpg"
        ));
        products.add(new Product(
                "Raticide 50 green - Contre rats et souris - 20 sachet de 3 g",
                49.00,
                "Fatalexpert",
                "others",
                30,
                "assets/raticide.jpg"
        ));
        products.add(new Product(
                "8*Piles Duracell CopperTop Plus Power AA",
                16.50,
                "Duracell",
                "others",
                30,
                "assets/duracell.jpg"
        ));
        currentProducts.addAll(products);
    }



    public static void main(String[] args) {
        loadTestData();
        launch(args);
    }
}
