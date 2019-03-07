package poke.view;

import javax.swing.JFrame;
import poke.controller.PokedexController;

public class PokedexFrame extends JFrame
{
	private PokedexController app;
	private PokedexPanel appPanel;
	
	public PokedexFrame(PokedexController app)
	{
		super();
		this.app = app;
		this.appPanel = new PokedexPanel(app);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Pokedex");
		this.setSize(1000, 500);
		this.setResizable(false);
		this.setVisible(true);
	}
}