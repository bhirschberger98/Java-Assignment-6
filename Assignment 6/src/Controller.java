import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {
	private File file;
	
    @FXML
    private TextArea txtField;
    
	public void exit() {
		System.exit(0);
	}
	public void openFileExplorer() {
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Resource File");
		 fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.csv"));
		 file = fileChooser.showOpenDialog(null);
		 try {
			printFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void printAvg() throws FileNotFoundException {
		Scanner inputFile=new Scanner(file);
		int inputs=0;
		int total=0;
		while(inputFile.hasNext()) {
			//gets line in file
			String line=inputFile.next();
			String arr[]=line.split(",");
			for(String s: arr) {
				total+=Integer.parseInt(s.trim());
				inputs++;
			}
		}
		txtField.setText("Average: "+(total/inputs));
	}
	
	public void printFile() throws FileNotFoundException {
		Scanner inputFile=new Scanner(file);
		txtField.clear();
		txtField.setText(" ");
		while(inputFile.hasNext()) {
			String line=inputFile.next().concat("\n");
			String arr[]=line.split(",");
			for(String s: arr) {
				txtField.setText(txtField.getText().concat(s)+" ");
			}
			//txtField.setText(txtField.getText().concat("\n"));
		}
	}
	
	public void displayAbout() {
		txtField.setText("Made By Brett Hirschberger");
	}
	
	public void clear() {
		txtField.clear();
	}
}
