package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.PrixParM2;
import tn.esprit.spring.entity.ValeurEstim;
import tn.esprit.spring.repository.PrixParM2Repository;

@Service
public class EstimationService implements IEstimationService {

	@Autowired
	PrixParM2Repository prixRepository;
	@Autowired
	IValeurEstimService iValeurEstimService;

	@Override
	public float EstimationMaison(String Ville, float surfaceTotal, float surfaceConstruit, int nbPiece, int NbChambre,
			int NbBathrooms, Boolean balcon, Boolean Terrace, Boolean Garden, Boolean Garage, Boolean SwimmingPool,
			Boolean AirConditioning, Boolean heater, Boolean cave, Boolean Alarme, Boolean calme, Boolean dependance) {
		// TODO Auto-generated method stub

		float S = 0;
		// nbniveeaux
		S += ((surfaceTotal * prixRepository.PrixTerrain(Ville))
				+ (surfaceConstruit * prixRepository.PrixMaison(Ville)));
		if (NbChambre >= 5) {
			S += S * 0.02;
		}
		if (nbPiece >= 5) {
			S += S * 0.05;
		}
		if (NbBathrooms >= 2) {
			S += S * 0.05;
		}
		if (Garage) {
			S += S * 0.05;
		}
		if (AirConditioning) {
			S += S * 0.02;
		}
		if (heater) {
			S += S * 0.03;
		}
		if (Terrace) {
			S += S * 0.02;
		}
		if (balcon) {
			S += S * 0.02;
		}
		if (SwimmingPool) {
			S += S * 0.08;
		}
		if (cave) {
			S += S * 0.05;
		}
		if (dependance) {
			S -= S * 0.05;
		}
		if (calme) {
			S += S * 0.1;
		}
		iValeurEstimService.addEstimVal(new ValeurEstim(S));
		System.out.println("*********************************************************Estimation" + S);
		return S;

	}

	@Override
	public float EstimationApp(String Ville, float surfaceTotal, float surfaceConstruit, int nbPiece, int NbChambre,
			int NbBathrooms, Boolean balcon, Boolean Terrace, Boolean Garden, Boolean Garage, Boolean SwimmingPool,
			Boolean AirConditioning, Boolean heater, Boolean cave, Boolean Alarme, Boolean calme, Boolean dependance) {
		// TODO Auto-generated method stub

		float S = 0;
		// nbniveeaux

		S += ((surfaceConstruit * prixRepository.PrixMaison(Ville)));

		if (NbChambre >= 5) {
			S += S * 0.02;
		}
		if (nbPiece >= 5) {
			S += S * 0.05;
		}
		if (NbBathrooms >= 2) {
			S += S * 0.05;
		}
		if (Garage) {
			S += S * 0.05;
		}
		if (AirConditioning) {
			S += S * 0.02;
		}
		if (heater) {
			S += S * 0.03;
		}
		if (Terrace) {
			S += S * 0.02;
		}
		if (balcon) {
			S += S * 0.02;
		}
		if (SwimmingPool) {
			S += S * 0.08;
		}
		if (cave) {
			S += S * 0.05;
		}
		if (dependance) {
			S -= S * 0.05;
		}
		if (calme) {
			S += S * 0.1;
		}

		return S;

	}

	@Override
	public void RemplissageTablePrix() {
		List<PrixParM2> p = new ArrayList<>();
		PrixParM2 p1 = new PrixParM2(1, "Ariana", 1041, 1381, 800);
		PrixParM2 p2 = new PrixParM2(2, "Bizert", 1000, 1167, 900);
		PrixParM2 p3 = new PrixParM2(3, "Béja", 800, 961, 600);
		PrixParM2 p4 = new PrixParM2(4, "Ben Arous", 938, 1043, 600);

		PrixParM2 p5 = new PrixParM2(5, "Gabes", 660, 638, 0);
		PrixParM2 p6 = new PrixParM2(6, "Gafsa", 593, 822, 0);
		PrixParM2 p7 = new PrixParM2(7, "Jendouba", 677, 943, 0);
		PrixParM2 p8 = new PrixParM2(8, "Kairaouen", 615, 700, 0);
		PrixParM2 p9 = new PrixParM2(9, "kasserine", 544, 785, 0);
		PrixParM2 p10 = new PrixParM2(10, "Kebli", 520, 568, 0);

		PrixParM2 p11 = new PrixParM2(11, "Kef", 473, 685, 350);
		PrixParM2 p12 = new PrixParM2(12, "Mahdia", 747, 1075);
		PrixParM2 p13 = new PrixParM2(13, "Manouba", 800, 900, 600);
		PrixParM2 p14 = new PrixParM2(14, "Medenine", 1030, 1292, 400);
		PrixParM2 p15 = new PrixParM2(15, "Monastir", 900, 1200, 600);
		PrixParM2 p16 = new PrixParM2(16, "Nabeul", 1100, 1300, 650);
		PrixParM2 p17 = new PrixParM2(17, "Sfax", 1200, 1500, 700);
		PrixParM2 p18 = new PrixParM2(18, "Sidi Bouzid", 700, 700, 450);
		PrixParM2 p19 = new PrixParM2(19, "Siliana", 800, 750, 500);
		PrixParM2 p20 = new PrixParM2(20, "Sousse", 1500, 1600, 750);
		PrixParM2 p21 = new PrixParM2(21, "Tataouine", 700, 800, 400);
		PrixParM2 p22 = new PrixParM2(22, "Tozeur", 552, 720, 400);
		PrixParM2 p23 = new PrixParM2(33, "Tunis", 1500, 1600, 800);
		PrixParM2 p24 = new PrixParM2(24, "Zaghouan", 800, 900, 500);

		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);
		p.add(p8);
		p.add(p9);
		p.add(p10);
		p.add(p11);
		p.add(p12);
		p.add(p13);
		p.add(p14);
		p.add(p15);
		p.add(p16);
		p.add(p17);
		p.add(p18);
		p.add(p19);
		p.add(p20);
		p.add(p21);
		p.add(p22);
		p.add(p23);
		p.add(p24);
		prixRepository.saveAll(p);
	}

	@Override
	public void deleteAll() {
		prixRepository.deleteAll();

	}
}
