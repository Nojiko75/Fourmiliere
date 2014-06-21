package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Constants;
import model.Environment;
import model.EnvironmentChangedEvent;
import model.Simulation;
import model.SimulationModel;
import controller.Controller;

public class Rendu extends View implements ActionListener {
	private SimulationModel simulationModel;
	private Environment environment;
	private GraphicalPanel graphicalPanel;
	private JPanel commandPanel;
	
	public Rendu(Controller controller, SimulationModel simulationModel) {
		super(controller);
		this.getContentPane().setLayout(new BorderLayout());
		this.setTitle(Constants.FRAME_TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.simulationModel = simulationModel;
		this.environment = this.simulationModel.getEnvironment();
		this.initPanels();
		this.setBounds(this.getFrameCoordinates());
//		this.pack();
		this.setVisible(true);
	}
	
	private Rectangle getFrameCoordinates() {
		Toolkit aTk = Toolkit.getDefaultToolkit();
		Dimension screenSize = aTk.getScreenSize();
		return new Rectangle((int) (screenSize.getWidth() - Constants.FRAME_WIDTH) / 2, (int) (screenSize.getHeight() - Constants.FRAME_HEIGHT) / 2, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
	}
	
	public void initPanels() {
		this.graphicalPanel = new GraphicalPanel(this.environment);
		Dimension dim = new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
//		this.graphicalPanel.setPreferredSize(dim);
//		this.graphicalPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		this.graphicalPanel.setBackground(Color.GREEN);
//		this.add(graphicalPanel, BorderLayout.PAGE_START);
		this.add(graphicalPanel, BorderLayout.CENTER);
		
//		this.commandPanel = new JPanel();
//		this.commandPanel.setBorder(BorderFactory.createBevelBorder(1));
//		this.commandPanel.setBackground(Color.YELLOW);
//		JButton button = new JButton("Go");
//		this.commandPanel.add(button);
//		this.add(commandPanel, BorderLayout.CENTER);
	}
	
	public void paint(SimulationModel sim) {
		this.simulationModel = sim;
		this.graphicalPanel.setEnvironment(this.simulationModel.getEnvironment());
		this.graphicalPanel.repaint();
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void close() {
		this.dispose();
	}

	@Override
	public void environmentChanged(EnvironmentChangedEvent event) {
		// maj graphiquement -> paint ?
		this.environment = event.getEnvironment();
		this.paint(this.simulationModel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// appel au controller
	}
}
