package poke.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import poke.controller.PokedexController;

public class PokedexPanel extends JPanel
{
	private PokedexController app;
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JButton saveButton;
	private JComboBox<String> pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController app)
	{
		super();
		this.app = app;
		
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/poke/view/Images/pokeball3.jpeg"));
		
		numberField = new JTextField("0");
		nameField = new JTextField("A Pokemon");
		evolveField = new JTextField("true");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		healthLabel = new JLabel("Health: ");
		numberLabel = new JLabel("# ");
		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("Attack: ");
		enhanceLabel = new JLabel("Enhancements: ");
		nameLabel = new JLabel("Name: ");
		imageLabel = new JLabel("Pokemon: ", pokemonIcon, JLabel.CENTER);
		
		changeButton = new JButton("Change");
		saveButton = new JButton("Save");
		
		pokedexDropdown = new JComboBox<String>();
		
		setupDropdown();
		setupPanel();
		setupLayout();
		sendDataToController();
		setupListeners();
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokedexDropdown.setModel(temp);
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setBackground(Color.WHITE);
		
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(healthLabel);
		this.add(numberLabel);
		this.add(evolveLabel);
		this.add(attackLabel);
		this.add(enhanceLabel);
		this.add(nameLabel);
		this.add(imageLabel);
		this.add(changeButton);
		this.add(saveButton);
		this.add(pokedexDropdown);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.EAST, numberField, -421, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 14, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 510, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 26, SpringLayout.SOUTH, evolveField);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 15, SpringLayout.SOUTH, numberField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, 15, SpringLayout.SOUTH, attackField);
		appLayout.putConstraint(SpringLayout.WEST, enhancementField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 22, SpringLayout.SOUTH, enhancementField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, 0, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolveField, 21, SpringLayout.EAST, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 64, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, evolveLabel, 353, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -14, SpringLayout.WEST, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 5, SpringLayout.NORTH, attackField);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 5, SpringLayout.NORTH, enhancementField);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -14, SpringLayout.WEST, enhancementField);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -18, SpringLayout.WEST, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, changeButton, -4, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, changeButton, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, changeButton, 46, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, changeButton, 101, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 1, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 81, SpringLayout.EAST, changeButton);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -61, SpringLayout.WEST, evolveLabel);
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, evolveField);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, imageLabel);
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			
			app.updatePokemon(index, data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/poke/view/Images/";
		String defaultName = "pokeball3";
		String extension = ".jpeg";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch(NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void updateFields(int index)
	{
		String [] data = app.getPokeData(index);
		
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				updateFields(pokedexDropdown.getSelectedIndex());
				changeImageDisplay(name);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.savePokedex();
			}
		});
	}
}