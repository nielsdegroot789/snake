package main;

import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

	@FXML
	private GridPane board;

	private Rectangle[][] boardElements = null;

	int numberOfRows = 10;
	int numberOfColumns = 10;

	public void initialize() {

		fillBoard();
		initializeGridPaneArray();

		board.setGridLinesVisible(true);
		Timer timer = new Timer();
		TimerTask tt = new TimerTask() {
			int i = 0;

			@Override
			public void run() {
				System.out.println(boardElements[2][i]);
				if (boardElements[1][i] != boardElements[1][0]) {
					boardElements[1][i - 1].setFill(Color.BLACK);
				}

				boardElements[1][i].setFill(Color.GREEN);
				i++;
			}
		};

		timer.schedule(tt, 2000, 500);

	}

	private void fillBoard() {

		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				Rectangle rc = new Rectangle(297, 138);
				board.add(rc, i, j);
			}
		}

	}

	private void initializeGridPaneArray() {
		boardElements = new Rectangle[numberOfRows][numberOfColumns];
		for (Node node : board.getChildren()) {
			boardElements[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (Rectangle) node;
		}
	}
}