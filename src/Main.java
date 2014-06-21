import controller.Controller;
import view.Rendu;
import view.View;
import model.Constants;
import model.Environment;
import model.SimulationModel;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello Noji!");
		
		SimulationModel model = new SimulationModel(new Environment(Constants.ENVIRONMENT_WIDTH, Constants.ENVIRONMENT_HEIGHT));
		
		View view = new Rendu(null, model);
		model.addEnvironmentListener(view);
		view.display();
		
		Controller controller = new Controller(model, view);

		view.setController(controller);
		
		controller.run();
	}
}
