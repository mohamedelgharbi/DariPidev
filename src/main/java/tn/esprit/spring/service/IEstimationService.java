package tn.esprit.spring.service;

public interface IEstimationService {

	public float EstimationMaison(String Ville, float surfaceTotal, float surfaceConstruit, int nbPiece, int NbChambre,
			int NbBathrooms, Boolean balcon, Boolean Terrace, Boolean Garden, Boolean Garage, Boolean SwimmingPool,
			Boolean AirConditioning, Boolean heater, Boolean cave, Boolean Alarme, Boolean calme, Boolean dependance);

	public float EstimationApp(String Ville, float surfaceTotal, float surfaceConstruit, int nbPiece, int NbChambre,
			int NbBathrooms, Boolean balcon, Boolean Terrace, Boolean Garden, Boolean Garage, Boolean SwimmingPool,
			Boolean AirConditioning, Boolean heater, Boolean cave, Boolean Alarme, Boolean calme, Boolean dependance);

	public void RemplissageTablePrix();
	
	public void deleteAll();
}
