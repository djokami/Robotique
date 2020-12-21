package Robot;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

/**
 * <b>Ultrason represente les capteurs sonor du projet.</b>
 * <p> Classe qui permet d'avoir accËs au capteur de distance de type Sonar.</p>
 * @author Calvignac SÈbastien, Simon Dorian, Kamissoko Djoko, Auray CÈdric
 * @version 8.0
 */
public class Ultrason /*extends Capteurs*/ {
	/**
	 *  @see Port#s2
	 * attribut de classe qui d√©finit le port sur lequel est branch√© le capteur Touche
	 */
	Port s2;
	/**
	 * @see EV3TouchSensor#ultraCapteur#ultraCapteur
	 * Attribut de classe permettant d'interagir avec le capteur
	 */
	EV3UltrasonicSensor ultraCapteur;
	/**
	 * @see SampleProvider#recup
	 * Attribut de classe permettant d'obtenir un √©chantillon du capteur
	 */
	SampleProvider recup;
	/**
	 * tableau de float permettant de garder en m√©moire la valeur enregistr√©
	 */
	float[] echantillon;
	/**
	 * Attribut permettant de stockÈ sla distance mesur√©e
	 */
	float distance;
	/**
	 * @constructor
	 * DÈfinit les attributs s2, ultraCapteur, recup.
	 * Le tableau echantillon est initialis√© avec la taille appropri√© d√©finit par buteeCapteur
	 * l'attribut distance lui est initiialis√© avec la fonction actualise()
	 * 
	 */
	public Ultrason() {
		s2 = LocalEV3.get().getPort("S1");
		ultraCapteur = new EV3UltrasonicSensor(s2);
		recup = ultraCapteur.getDistanceMode();
		echantillon = new float[recup.sampleSize()];
		recup.fetchSample(echantillon, 0);
		actualise();
		//ultraCapteur.close();
	}
	/**
	 * @see SampleProvider#fetchSample(float[] sample, int offset)
	 * MÈthode qui permet de mesurer la distance et de la stocker dans l'attribut distance
	 * @return void
	 */
	public void actualise() {
		recup.fetchSample(echantillon, 0);
		this.distance = echantillon[0]; 
		//ultraCapteur.close();
	}
	
	/*public static void main(String[] args) {
		Ultrason u = new Ultrason();
		while (Button.ESCAPE.isUp())  {
			u.actualise();
			System.out.println(u.distance);
		}
	}*/

}
