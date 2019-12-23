package com.hossainshanjida.stocks.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.hossainshanjida.stocks.dao.CategoryDAO;
import com.hossainshanjida.stocks.dao.IQuery;
import com.hossainshanjida.stocks.dao.SectorDAO;
import com.hossainshanjida.stocks.dao.StockDAO;
import com.hossainshanjida.stocks.model.Sector;
import com.hossainshanjida.stocks.model.Stock;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class StockController implements Initializable {

	public static List<Sector> sectors = new ArrayList<Sector>();

	@FXML
	private AnchorPane apStock;

	@FXML
	private FlowPane fpSector;

	@FXML
	private TableView<Stock> tvStock;

	@FXML
	private TableColumn<Stock, String> colSymbol;

	@FXML
	private TableColumn<Stock, String> colName;

	@FXML
	private TableColumn<Stock, Float> colPrice;

	@FXML
	private TableColumn<?, ?> colNetIncome;

	@FXML
	private TableColumn<?, ?> colCategory;

	@FXML
	private TableColumn<?, ?> colDividendYield;

	@FXML
	private TableColumn<String, String> colSector;

	@FXML
	private ComboBox<String> cbCategory;

	@FXML
	private TableColumn<?, ?> colFrequency;

	@FXML
	private TableColumn<?, ?> colExchange;

	@FXML
	private Label lblTitle, lblMessage, countMessage;

	@FXML
	private TextField txtField;

	@FXML
	private Button btnSearch;

	@FXML
	private RadioButton rbSimple, rbAdvanced, rbCategory, rbTopDividend;;

	@FXML
	private ToggleGroup tgSearchMode;

	private void simpleSearch() {
		ObservableList<Stock> stocks = tvStock.getItems();

		tvStock.getItems().clear();

		IQuery<Stock> dao = new StockDAO();

		Map<String, String> map = new HashMap<>();
		String symbol = txtField.getText();

		map.put("symbol", "eq:" + symbol);

		List<Stock> allStocks = dao.findBy(map);

		for (Stock stock : allStocks) {
			stocks.add(stock);
		}
		countMessage.setText("Number Of Stocks returned: " + stocks.size());

		// int count = countMessage.getText().length();
	}

	private void advancedSearch() {
		ObservableList<Stock> stocks = tvStock.getItems();

		tvStock.getItems().clear();

		IQuery<Stock> dao = new StockDAO();

		Map<String, String> map = new HashMap<>();
		String category = cbCategory.getValue();

		map.put("category", "eq:" + category);
		map.put("price", "gt:" + txtField.getText());

		List<Stock> allStocks = dao.findBy(map);

		for (Stock stock : allStocks) {
			stocks.add(stock);
		}
		countMessage.setText("Number Of Stocks returned: " + stocks.size());
	}

	private void categorySearch() {
		ObservableList<Stock> stocks = tvStock.getItems();
		tvStock.getItems().clear();

		IQuery<Stock> dao = new StockDAO();

		Map<String, String> map = new HashMap<>();
		String price = txtField.getText();

		ObservableList<Node> selectCat = fpSector.getChildren();
		ArrayList<String> items = new ArrayList<>();
		for (Node node : selectCat) {
			CheckBox cb = (CheckBox) node;
			if (cb.isSelected()) {
				items.add(cb.getUserData().toString());
			}
		}
		countMessage.setText("Number Of Stocks returned: " + items.size());

		String[] selectedCategories = items.stream().toArray(String[]::new);
		System.out.println(items);

		String categories = String.join(",", selectedCategories);
		map.put("price", "gt:" + price);
		map.put("categories", categories);

		List<Stock> allStocks = dao.findBy(map);
		stocks.addAll(allStocks);

	}

	private void topDividendSearch() {
		ObservableList<Stock> stocks = tvStock.getItems();

		tvStock.getItems().clear();

		IQuery<Stock> dao = new StockDAO();

		Map<String, String> map = new HashMap<>();
		String category = cbCategory.getValue();

		map.put("category", "eq:" + category);
		map.put("price", "gt:" + txtField.getText());

		List<Stock> allStocks = dao.findBy(map);

		for (Stock stock : allStocks) {
			stocks.add(stock);
		}
		countMessage.setText("Number Of Stocks returned: " + stocks.size());
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		if (cbCategory != null) {
			CategoryDAO dao = new CategoryDAO();
			List<String> caregories = dao.findAll();
			cbCategory.getItems().addAll("All");
			cbCategory.getItems().addAll(caregories);
			cbCategory.setValue("All");
		}
		if (fpSector != null) {

			SectorDAO sectorDAO = new SectorDAO();
			sectors = sectorDAO.findAll();

			for (Sector sector : sectors) {
				CheckBox chBox = new CheckBox(sector.getSector() + "-" + sector.getSectorDescriptions());
				chBox.getStyleClass().add("sector");
				chBox.setUserData(sector.getSector());
				fpSector.getChildren().add(chBox);

			}
			if (rbTopDividend != null) {

				SectorDAO sDAO = new SectorDAO();
				sectors = sectorDAO.findAll();

				for (Sector sector : sectors) {
					CheckBox chBox = new CheckBox(sector.getSector() + "-" + sector.getSectorDescriptions());
					chBox.getStyleClass().add("sector");
					chBox.setUserData(sector.getSector());
					fpSector.getChildren().add(chBox);

				}
			}
		}

	}

	// This is completed
	@FXML
	void onKeyReleased(KeyEvent event) {
		int size = txtField.getText().length();
		if (size > 0) {
			btnSearch.setDisable(false);
		} else {
			btnSearch.setDisable(true);
		}
	}

	// This is completed
	@FXML
	void search(ActionEvent event) {
		if (rbSimple.isSelected()) {
			simpleSearch();
		} else if (rbAdvanced.isSelected()) {
			advancedSearch();
		} else if (rbCategory.isSelected()) {
			categorySearch();
		} else if (rbTopDividend.isSelected()) {
			topDividendSearch();
		}

	}

	// This is completed
	@FXML
	void searchMode(ActionEvent event) throws IOException {

		Object o = event.getSource();
		String message = "";

		Stage stage = null;
		Parent root = null;

		if (o == rbSimple) {
			message = "simple mode selected ";
			stage = (Stage) rbAdvanced.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("StockView.fxml"));
		} else if (o == rbAdvanced) {
			message = "advanced mode selected ";
			stage = (Stage) rbAdvanced.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("StockAdvancedView.fxml"));

		} else if (o == rbCategory) {
			message = "advanced mode selected ";
			stage = (Stage) rbCategory.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("StockAdvancedViewWithCheckBoxes.fxml"));

		} else if (o == rbTopDividend) {
			message = "Top Dividend Mode Selected ";
			stage = (Stage) rbTopDividend.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("TopDividendStock.fxml"));
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		lblMessage.setText(message + Math.random());

	}

}
