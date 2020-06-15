package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.repository.PrixParM2Repository;
import tn.esprit.spring.service.IEstimationService;

//@Scope(value = "session")
@Controller(value = "estimationController")
@ELBeanName(value = "estimationController")
// @Join(path = "/", to = "/Estimation.jsf")
public class EstimationController {
	@Autowired
	IEstimationService iEstimationService;
	@Autowired
	PrixParM2Repository prixParM2Repository;

	private String ville;

	private List<String> villes;
	// Estimation Input
	float surfaceTotal;
	float surfaceConstruit;

	int nbpiece;
	int nbchambre;
	int nbbathrooms;

	Boolean balcon = false;
	Boolean terrace = false;
	Boolean garden = false;
	Boolean garage = false;
	Boolean swimmingpool = false;
	Boolean airconditioning = false;
	Boolean heater = false;
	Boolean cave = false;
	Boolean alarme = false;
	Boolean calme = false;
	Boolean dependance = false;

	float result;

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public float getSurfaceTotal() {
		return surfaceTotal;
	}

	public void setSurfaceTotal(float surfaceTotal) {
		this.surfaceTotal = surfaceTotal;
	}

	public float getSurfaceConstruit() {
		return surfaceConstruit;
	}

	public void setSurfaceConstruit(float surfaceConstruit) {
		this.surfaceConstruit = surfaceConstruit;
	}

	public int getNbpiece() {
		return nbpiece;
	}

	public void setNbpiece(int nbpiece) {
		this.nbpiece = nbpiece;
	}

	public int getNbchambre() {
		return nbchambre;
	}

	public void setNbchambre(int nbchambre) {
		this.nbchambre = nbchambre;
	}

	public int getNbbathrooms() {
		return nbbathrooms;
	}

	public void setNbbathrooms(int nbbathrooms) {
		this.nbbathrooms = nbbathrooms;
	}

	public Boolean getBalcon() {
		return balcon;
	}

	public void setBalcon(Boolean balcon) {
		this.balcon = balcon;
	}

	public Boolean getTerrace() {
		return terrace;
	}

	public void setTerrace(Boolean terrace) {
		this.terrace = terrace;
	}

	public Boolean getGarden() {
		return garden;
	}

	public void setGarden(Boolean garden) {
		this.garden = garden;
	}

	public Boolean getGarage() {
		return garage;
	}

	public void setGarage(Boolean garage) {
		this.garage = garage;
	}

	public Boolean getSwimmingpool() {
		return swimmingpool;
	}

	public void setSwimmingpool(Boolean swimmingpool) {
		this.swimmingpool = swimmingpool;
	}

	public Boolean getAirconditioning() {
		return airconditioning;
	}

	public void setAirconditioning(Boolean airconditioning) {
		this.airconditioning = airconditioning;
	}

	public Boolean getHeater() {
		return heater;
	}

	public void setHeater(Boolean heater) {
		this.heater = heater;
	}

	public Boolean getCave() {
		return cave;
	}

	public void setCave(Boolean cave) {
		this.cave = cave;
	}

	public Boolean getAlarme() {
		return alarme;
	}

	public void setAlarme(Boolean alarme) {
		this.alarme = alarme;
	}

	public Boolean getCalme() {
		return calme;
	}

	public void setCalme(Boolean calme) {
		this.calme = calme;
	}

	public Boolean getDependance() {
		return dependance;
	}

	public void setDependance(Boolean dependance) {
		this.dependance = dependance;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	public List<String> getVilles() {
		villes = prixParM2Repository.villeList();
		return villes;
	}

	public void setVilles(List<String> villes) {
		this.villes = villes;
	}

	@Override
	public String toString() {
		return "EstimationController [iEstimationService=" + iEstimationService + ", ville=" + ville + ", surfaceTotal="
				+ surfaceTotal + ", surfaceConstruit=" + surfaceConstruit + ", nbpiece=" + nbpiece + ", nbchambre="
				+ nbchambre + ", nbbathrooms=" + nbbathrooms + ", balcon=" + balcon + ", terrace=" + terrace
				+ ", garden=" + garden + ", garage=" + garage + ", swimmingpool=" + swimmingpool + ", airconditioning="
				+ airconditioning + ", heater=" + heater + ", cave=" + cave + ", alarme=" + alarme + ", calme=" + calme
				+ ", dependance=" + dependance + ", result=" + result + "]";
	}

	public float estimate() {

		float result = iEstimationService.EstimationMaison(ville, surfaceTotal, surfaceConstruit, nbpiece, nbchambre,
				nbbathrooms, balcon, terrace, garden, garage, swimmingpool, airconditioning, heater, cave, alarme,
				calme, dependance);
		setResult(result);
		return result;

	}

	public float estimateapp() {

		float result = iEstimationService.EstimationApp(ville, surfaceTotal, surfaceConstruit, nbpiece, nbchambre,
				nbbathrooms, balcon, terrace, garden, garage, swimmingpool, airconditioning, heater, cave, alarme,
				calme, dependance);

		setResult(result);
		return result;

	}

	public void allcity() {

		iEstimationService.RemplissageTablePrix();

	}
	

}
