package animalCounter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import animalCounter.AnimalCounterGUI;
import animalCounter.Alligator;
import animalCounter.Sheep;


public class AnimalCounterGUIApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			
			// Instantiate the GUI
			AnimalCounterGUI.animalCounterGUI();
			
			// Instantiate Animals
			Alligator alligator = new animalCounter.Alligator(0);
			Sheep sheep = new animalCounter.Sheep(0);
			
			// Event and Handlers
            class ButtonHandler implements ActionListener {
            	
            	@Override
                public void actionPerformed(ActionEvent event) {
                    String command = event.getActionCommand();
                    
                	// Incrementing
                    if (command.equals("Add Alligator")) {
                        alligator.incrementCount(sheep);
                    }
                    else if (command.equals("Add Sheep")) {
                        sheep.incrementCount(null);
                    }
                    else if (command.equals("Display")) {
                        JOptionPane.showMessageDialog(null,
                            "Alligators: " + alligator.getCount() + "\n" +
                            "Sheep: " + sheep.getCount());
                    }
                    else if (command.equals("Reset")) {
                        if (AnimalCounterGUI.radioAlligator.isSelected()) {
                            alligator.resetCounter();
                        } else {
                            sheep.resetCounter();
                        }
                    }
                    else if (command.equals("EXIT")) {
                        System.exit(0);
                    }

                    // Update Numbers
                    AnimalCounterGUI.counterAlligator.setText(String.valueOf(alligator.getCount()));
                    AnimalCounterGUI.counterSheep.setText(String.valueOf(sheep.getCount()));
                    
                    
                    // Message Logic
                    if (alligator.count > sheep.count) {
                    	JOptionPane.showMessageDialog(null, "Please add more sheep for the hungry alligators");
                    } else if (alligator.count == 0) {
                    	JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe");
                    }
                }
            }

        	// Attach Listeners
            ButtonHandler handler = new ButtonHandler();
            AnimalCounterGUI.addAlligator.addActionListener(handler);
            AnimalCounterGUI.addSheep.addActionListener(handler);
            AnimalCounterGUI.displayCNT.addActionListener(handler);
            AnimalCounterGUI.resetCNT.addActionListener(handler);
            AnimalCounterGUI.exitBtn.addActionListener(handler);

            // Group Radio Buttons
            ButtonGroup group = new ButtonGroup();
            group.add(AnimalCounterGUI.radioAlligator);
            group.add(AnimalCounterGUI.radioSheep);
        });
		
	}

}
