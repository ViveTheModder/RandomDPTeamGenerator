package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application 
{
	//data fields (technically the equivalent of global variables)
	private int[] charDPs = new int[5];
	private int charCNT=0;
	private int DPLimit=0;
	BT3Char[] charNames;
	
	private static void getCharNames(int[] charDPs, int charCNT, int DPLimit, TextField[] fields, Tooltip[] tooltips)
	{
		boolean reset=true;
		
		do
		{
			/* two things:
			 * the maximum amount of characters a team can have in Tenkaichi 3 is 5
			 * the array contents must be set to zero each time there is a reset */
			charDPs = new int[5];
			Functions.setRandomDPs(charDPs, charCNT, DPLimit);
			//correct DP values higher than 10
			Functions.fixWrongDPs(charDPs, charCNT);
			//check if the array DOESN'T contain incorrect DPs (equal to zero) 
			if(Functions.hasZeroes(charDPs,charCNT)==false)
			{
				reset=false;
				//afterwards, check if there is more than one DP set to 1 in the DP array 
				if(Functions.countFixedDPs(charDPs,charCNT,1)>1)
					reset=true;
			}
		} 
		while (reset);
		
		BT3Char[] charNames = new BT3Char[5]; //initialize array		
		for (int i=0; i<5; i++)
		{
			charNames[i] = new BT3Char(charDPs[i]); //get each DP value, then assign their corresponding character names
			fields[i].setText(charNames[i].toString()); //display character names in each text field
			tooltips[i] = new Tooltip(); //initialize each tooltip
			
			fields[i].setTooltip(tooltips[i]); //assign tooltip to text field
			/* display character DPs in each tooltip if said DPs are greater than zero - otherwise, make tooltip null 
			 * this if condition can also be done by checking if the text field contains text or if the index (variable i) is greater than the chosen character amount */
			if (charDPs[i]>0)
				tooltips[i].setText("Score: "+charDPs[i]+" DP");
			else
				fields[i].setTooltip(null);
		}
	}
	private static void setControlNodes(GridPane pane, Label[] labels, TextField[] fields)
	{
		for (int i=0; i<5; i++)
		{
			pane.getStylesheets().add("style.css"); //get stylesheets from css file
			
			labels[i] = new Label("Character "+(i+1)+":   "); //create new label
			labels[i].getStyleClass().add("normal-label"); //recolor current label
			fields[i] = new TextField(); //create new text field
			fields[i].setMinWidth(220); //change size of current text field
			fields[i].setEditable(false); //make current text field read-only
			pane.add(labels[i], 0, (i+1)); //add current label to output pane
			pane.add(fields[i], 1, (i+1)); //add current text field to output pane
			
			//change current text field's background and border colors, set its text to white and bold
			fields[i].getStyleClass().add("char-txt-field");
		}
	}
	
	public static void main(String[] args) 
	{
		launch();
	}

	@Override
	public void start(Stage stg0) throws Exception 
	{
		//create panes
		BorderPane rootPane = new BorderPane();
		GridPane inputPane = new GridPane();
		GridPane outputPane1P = new GridPane();
		GridPane outputPane2P = new GridPane();
		//get styles from css file
		rootPane.getStylesheets().add("style.css");
		
		//create label, text field and tooltip arrays for the output pane
		Label[] charLabels1P = new Label[5];
		Label[] charLabels2P = new Label[5];
		TextField[] charFields1P = new TextField[5];
		TextField[] charFields2P = new TextField[5];
		Tooltip[] charTooltips1P = new Tooltip[5];
		Tooltip[] charTooltips2P = new Tooltip[5];
		
		//create button as well as its tooltip
		Button outputBtn = new Button("Generate");
		Tooltip outputTooltip = new Tooltip("NOTE: This button does NOT take transformation restrictions and\nrepeatable characters into consideration. The next version might.");
		outputBtn.setTooltip(outputTooltip);
		
		//customize button style (change background color, set text to bold, and disable button borders)
		outputBtn.getStyleClass().add("output-btn");
		//generate two random teams upon clicking the button
		outputBtn.setOnAction(e -> 
		{
			getCharNames(charDPs, charCNT, DPLimit, charFields1P, charTooltips1P);
			getCharNames(charDPs, charCNT, DPLimit, charFields2P, charTooltips2P);
		});
		
		//place the button and the horizontal boxes in the input pane, with the limit box being above the character box
		inputPane.add(getLimitBox(), 0, 0);
		inputPane.add(getCharBox(), 0, 1);
		
		//set node alignments
		inputPane.setAlignment(Pos.CENTER);
		
		//add "Player 1" and "Player 2" labels to indicate which team is which (left team is 1P, right team is 2P)
		Label Text1P = new Label("Player 1 Team");
		Label Text2P = new Label("Player 2 Team");
		outputPane1P.add(Text1P, 1, 0);
		outputPane2P.add(Text2P, 1, 0);
		//set styles for each label
		Text1P.getStyleClass().add("label-1P");
		Text2P.getStyleClass().add("label-2P");		
		
		//assign control nodes to both teams
		setControlNodes(outputPane1P, charLabels1P, charFields1P);
		setControlNodes(outputPane2P, charLabels2P, charFields2P);
		
		//set padding (extra space around the edges) 
		rootPane.setPadding(new Insets(15, 15, 15, 15));
		//position input pane on top, the output panes at the left/right, and the Generate button at the bottom
		rootPane.setTop(inputPane);
		rootPane.setLeft(outputPane1P);
		rootPane.setRight(outputPane2P);
		rootPane.setBottom(outputBtn);
		
		//change root pane color 
		rootPane.getStyleClass().add("background");
		
		//create new scene
		Scene scn1 = new Scene(rootPane,640,276); //set window size to 640x288
		stg0.setTitle("Random DP Team Generator"); //set window title
		stg0.setResizable(false); //disable maximize button
		stg0.setScene(scn1);
		stg0.show();
	}

	private HBox getLimitBox() 
	{
		HBox LimitBox = new HBox();
		LimitBox.getStylesheets().add("style.css"); //get stylesheets from css file
		
		//create radio buttons and labels for each DP limit
		Label limitLabel = new Label("DP Limit: ");
		RadioButton limitBtn1 = new RadioButton("10   ");
		RadioButton limitBtn2 = new RadioButton("15   ");
		RadioButton limitBtn3 = new RadioButton("20   ");

		//recolor all labels and radio button text
		limitLabel.getStyleClass().add("bold-label");
		limitBtn1.getStyleClass().add("normal-label");;
		limitBtn2.getStyleClass().add("normal-label");
		limitBtn3.getStyleClass().add("normal-label");

		//group the buttons together using two separate toggle groups
		ToggleGroup limitBtnGroup = new ToggleGroup();
		limitBtn1.setToggleGroup(limitBtnGroup);
		limitBtn2.setToggleGroup(limitBtnGroup);
		limitBtn3.setToggleGroup(limitBtnGroup);
	
		//set first button to be selected by default (and as a result, overwrite chosen limit)
		limitBtn1.setSelected(true); DPLimit=10;
		
		//limit button handlers (which set the DP limit based on which button the user has clicked)
		limitBtn1.setOnAction(e ->
		{
			if(limitBtn1.isSelected())
				DPLimit=10;
				
		});
		limitBtn2.setOnAction(e ->
		{
			if(limitBtn2.isSelected())
				DPLimit=15;

		});
		limitBtn3.setOnAction(e ->
		{
			if(limitBtn3.isSelected())
				DPLimit=20;
		});
		
		//create general tooltip
		Tooltip limitTooltip = new Tooltip("DP stands for Destruction Points, a scoring system that\n(inaccurately) depicts a character's worth in Team Battles.");
		limitLabel.setTooltip(limitTooltip);
		
		//add buttons to horizontal box
		LimitBox.getChildren().addAll(limitLabel, limitBtn1, limitBtn2, limitBtn3);
		return LimitBox;
	}
	
	private HBox getCharBox() 
	{
		HBox CharBox = new HBox();
		CharBox.getStylesheets().add("style.css"); //get stylesheets from css file
		
		//create radio buttons and labels for the DP limits and the number of teammates
		Label teamLabel = new Label("Number of Characters: ");
		RadioButton charCountBtn1 = new RadioButton("2   ");
		RadioButton charCountBtn2 = new RadioButton("3   ");
		RadioButton charCountBtn3 = new RadioButton("4   ");
		RadioButton charCountBtn4 = new RadioButton("5   ");
		
		//recolor all labels and radio button text
		teamLabel.getStyleClass().add("bold-label");
		charCountBtn1.getStyleClass().add("normal-label");
		charCountBtn2.getStyleClass().add("normal-label");
		charCountBtn3.getStyleClass().add("normal-label");
		charCountBtn4.getStyleClass().add("normal-label");
		
		//group the buttons together using two separate toggle groups
		ToggleGroup charBtnGroup = new ToggleGroup();
		charCountBtn1.setToggleGroup(charBtnGroup);
		charCountBtn2.setToggleGroup(charBtnGroup);
		charCountBtn3.setToggleGroup(charBtnGroup);
		charCountBtn4.setToggleGroup(charBtnGroup);
			
		//set first button to be selected by default (and as a result, overwrite character count)
		charCountBtn1.setSelected(true); charCNT=2;
		
		//limit button handlers
		charCountBtn1.setOnAction(e ->
		{
			if(charCountBtn1.isSelected())
				charCNT=2;
	
		});
		charCountBtn2.setOnAction(e ->
		{
			if(charCountBtn2.isSelected())
				charCNT=3;
		});
		charCountBtn3.setOnAction(e ->
		{
			if(charCountBtn3.isSelected())
				charCNT=4;
		});
		charCountBtn4.setOnAction(e ->
		{
			if(charCountBtn4.isSelected())
				charCNT=5;
		});		
		
		//create general tooltip
		Tooltip teamTooltip = new Tooltip("Self-explanatory. For now, both teams share the same character count.");
		teamLabel.setTooltip(teamTooltip);
		
		//add buttons to horizontal box
		CharBox.getChildren().addAll(teamLabel, charCountBtn1, charCountBtn2, charCountBtn3, charCountBtn4);
		return CharBox;
	}
}