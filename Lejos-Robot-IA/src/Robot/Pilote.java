package Robot;


import lejos.robotics.chassis.Chassis;
import lejos.robotics.navigation.MovePilot;
import lejos.hardware.motor.*;

/**
 * <b>Pilote represente la generation des déplacements du projet.</b>
 * <p> Classe permettant de gérer les déplacements du robot.</p>
 * @author Calvignac Sébastien, Simon Dorian, Kamissoko Djoko, Auray Cédric
 * @version 8.0
 *
 */
public class Pilote extends MovePilot{
	/**
	 *  @see EV3MediumRegulatedMotor#pince
	 * Attribut de classe permettant d'interragir avec le moteur de la pince du robot. 
	 */
	 EV3MediumRegulatedMotor pince;
	 /**
	  * @see Chassis#chassis
	  * Attribut de classe permettant de définir le chassis du robot. 
	  * Ce chassis permettra de faire tourner le robot
	  */
	 Chassis chassis;
	 /**
	  * attribut de classe définissant la rotation totale éffectué par le robot
	  */
	 double rotation = 0;	
	 
	 /**
	  * @constructor
	  * @see Chassis#chassis
	  * @see EV3MediumRegulatedMotor#pince
	  * @param chassis
	  * @param pince
	  */
	public Pilote(Chassis chassis, EV3MediumRegulatedMotor pince) {
		super(chassis);
		this.chassis = chassis;
		this.pince = pince;
	}
	
	/**
	 * La methode getAngle represente la rotation du Robot.
	 * @return double;
	 */
	public double getAngle() {
		return rotation % 360;
	}
	/**
	 * La méthode setAngle est la rotation en fonction. 
	 * Elle est une valeur à rotation en fonction du paramètre donné en degrés. 
	 * @return void
	 */
	public void setAngle(double angle) {
		rotation = angle;
	}
	/**
	 * La methode prendre() permet de fermer la pince sur un objet.
	 * Elle ferme la pince de 600 (rotation demandé au moteur). 
	 * @return void
	 */
	
	public void prendre() {
		this.pince.rotate(-600);
	}
	/**
	 * La methode lacher() 
	 * Fais ouvrir la pince de 600 (rotation demandé au moteur) . 
	 * @return void
	 */
	public void lacher() {
		this.pince.rotate(600);
	}
	/**
	 * La methode vitesseMax() deplace le robot aux maximuns.
	 * @return void
	 * @deprecated
	 */
	public void vitesseMax() {
		chassis.getMaxLinearSpeed();
		chassis.getMaxAngularSpeed();
	}
	/**
	 * @see chassis#setSpeed(linear, angular)
	 * La méthode reglerVitesse précise la vitesse de déplacement.
	 *Elle  Définit la vitesse de déplacement en fonction de deux paramètres.
	 * @param linear
	 * @param angular
	 * @return void
	 */
	public void reglerVitesse(double linear, double angular) {
		chassis.setSpeed(linear, angular);
	}
	/**
	 * @see MovePilot#rotate(double,boolean)
	 * La methode rotate gère la rotation des Robots.
	 * Elle permet au robot de tourner d’un angle donné en paramètre tout en mettant à jour l’attribut rotation.   
	 * @param angle
	 * @return void
	 */
	public void rotate(double angle) {
		if(angle > 180) {
			rotate(angle - 360,false);
			rotation=rotation+(angle - 360);
		}
		else {	    
			rotate(angle, false);
			rotation=rotation+angle;
		}
	  }
}
