package Robot;

import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

/**
 * <b>Touche represente le bouton touche du projet.</b>
 * <p> Classe qui permet d'avoir accès au capteur de butée ( plus commodément appelés bouton touche).</p>
 * @author Calvignac Sébastien, Simon Dorian, Kamissoko Djoko, Auray Cédric
 * @version 8.0
 *
 */
public class Touche /*extends Capteurs*/ {
	/**
	 *  @see Port#s4
	 * attribut de classe qui définit le port sur lequel est branché le capteur Touche
	 */
	Port s4;
	/**
	 * @see EV3TouchSensor
	 * Attribut de classe permettant d'interagir avec le capteur
	 */
	EV3TouchSensor buteeCapteur;
	/**
	 * @see SampleProvider
	 * Attribut de classe permettant d'obtenir un échantillon du capteur
	 */
	SampleProvider recup;
	/**
	 * tableau de float permettant de garder en mémoire la valeur enregistré
	 */
	float[] echantillon;
	/**
	 * Attribut permettant de stocké si le bouton est activé ou non
	 */
	boolean touche;
/**
 * @constructor
 * définit les attributs s4, buteeCapteur, recup.
 * Le tableau echantillon est initialisé avec la taille approprié définit par buteeCapteur
 * l'attribut touche lui est initiialisé avec la fonction .
 */
	public Touche() {
		s4 = LocalEV3.get().getPort("S4");
		buteeCapteur = new EV3TouchSensor(s4);
		recup = buteeCapteur.getTouchMode();
		echantillon = new float[recup.sampleSize()];
		actualise();
		//touchProvider.fetchSample(touchSample,0);
		//Delay.msDelay(250);
		//touchSensor.close();
	}
	/**
	 * @see SampleProvider#fetchSample(float[] sample, int offset)
	 * Methode qui permet de prendre un échantillon puis de savoir si la valeur correspond à la pression du bouton.
	 * Cette méthode actualise la valeur de l'attribut touche
	 * @return void
	 */
	public void actualise() {
		recup.fetchSample(echantillon,0);
		//touchSensor.close();
		touche = echantillon[0]==1;	
		}
	
	/*public static void main(String[] args) {
		Touche t = new Touche();
		while (Button.ESCAPE.isUp())  {
			t.actualise();
			System.out.println(t.touche);
		}
	}*/

}
