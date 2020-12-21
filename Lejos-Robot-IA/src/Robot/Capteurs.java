package Robot;

 import lejos.hardware.Button;
import lejos.utility.Delay;

/**
 *<b>Capteurs represente la classe distributeurs des informations du projet.</b>
 *<p> Classe permettant de centralisée les informations concernant les différents 
 * capteurs.</p>
 *
 * @author Calvignac Sébastien, Simon Dorian, Kamissoko Djoko, Auray Cédric
 *@version 8.0
 *
 */
public class Capteurs {

	/**
	 * Attribut de classe définissant si le capteur touche est activé ou non
	 */
	boolean touche;
	
	/**
	 * Attribut de classe permettant de connaitre la distance de l'objet 
	 */
	
	float distance;
	
	/**
	 *Attribut de classe permettant de savoir sur quel couleur on ce trouve 
	 */
	String couleur;
	/**
	 * @see Touche#t
	 * Objet de la classe Touche
	 */
	private Touche t = new Touche();
	/**
	 * @see Couleur#c
	 * Objet de la Classe Touche
	 */
	private Couleur c = new Couleur();
	
	/**
	 *  @see Ultrason#u
	 * Objet de la Classe Ultrason
	 */
	private Ultrason u = new Ultrason();
	/**
	 *  @constructor 
	 * définit les attributs touche, distance et couleur avec les objet t, u, c 
	 */
	public Capteurs() {
		this.distance = u.distance;
		this.touche = t.touche;
		this.couleur = c.couleur;
		
	}
	/**
	 * La methode isTouche donne l'etat si toucher ou pas.
	 * Elle permet de d'envoyer true si le bouton est enfoncé et false si le bouton n'est pas appuyé
	 * @return un boolean 
	 */
	public boolean isTouche() {
		return touche;
	}
	/**
	 * La methode getDistance est la distance parcourue.
	 * Elle correspondant à la distance mesurée.
	 * @return un float 
	 */

	public float getDistance() {
		return distance;
	}
/**
 * La methode getCouleur represente les couleurs.
 * Elle donne le nom de la couleur rencontrée.
 * @return une String de couleur.
 */
	public String getCouleur() {
		return couleur;
	}
	/**
	 * la méthode actualise, actualise les données des capteurs.
	 * @see Touche#actualise()
	 * @see Couleur#actualise()
	 * @see Ultrason#actualise()
	 * @return void
	 */
	public void actualise() {
		//c.actualise();
		t.actualise();
		u.actualise();
		this.distance = u.distance;
		this.touche = t.touche;
		this.couleur = c.couleur;
	}

	/*
	 * public static void main(String[] args) {
		Capteurs capt = new Capteurs();
		while (Button.ESCAPE.isUp())  {
			capt.actualise();
			//System.out.println(capt.distance);
			//System.out.println(capt.touche);
			System.out.println(capt.couleur);
		}

	}
	 */
}

