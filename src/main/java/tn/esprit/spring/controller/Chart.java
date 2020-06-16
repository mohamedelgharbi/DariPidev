package tn.esprit.spring.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.BankOffers;
import tn.esprit.spring.entity.LoanSimulation;
import tn.esprit.spring.service.IBankOffersService;
import tn.esprit.spring.service.IBankService;
import tn.esprit.spring.service.ILoanSimulationService;

@Controller(value = "chartsimulation")
@ELBeanName(value = "chartsimulation")
@Join(path = "/chart", to = "/ChartSimulation.jsf")
@ViewScoped
public class Chart {
	@Autowired
	ILoanSimulationService iLoanSemulationService;
	@Autowired
	IBankOffersService ibankOffersService;
	@Autowired
	IBankService iBankService;

	private LineChartModel animatedModel1;
	private LineChartModel animatedModel4;

	private BarChartModel animatedModel2;
	private BarChartModel animatedModel3;
	private BarChartModel animatedModel5;
	private BarChartModel animatedModel6;
	private BarChartModel animatedModel7;
	private BarChartModel animatedModel8;
	private BarChartModel animatedModel9;

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private PieChartModel pieModel3;
	private PieChartModel pieModel4;
	private PieChartModel pieModel5;
	

	private List<LoanSimulation> loans;

	@PostConstruct
	public void init() {

		createAnimatedModels();
		createPieModels();

	}

	private void createAnimatedModels() {
		animatedModel1 = initLinearModel();
		animatedModel1.setTitle("Loan Simulations TAEA");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setLabel("TAEA");
		yAxis.setMin(0);
		yAxis.setMax(0.5);

		animatedModel4 = initLinearModel1();
		animatedModel4.setTitle("Loans Payment");
		animatedModel4.setAnimate(true);
		animatedModel4.setLegendPosition("se");
		Axis yyAxis = animatedModel4.getAxis(AxisType.Y);
		yyAxis.setLabel("Monthly Payment");
		yyAxis.setMin(0);
		yyAxis.setMax(10000);

		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Loan Simulations TAEG - Insurance Included");
		animatedModel2.setSeriesColors("6b89ff");

		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(2);
		yAxis.setLabel("TAEG Insurance");

		animatedModel3 = initBarModel1();
		animatedModel3.setTitle("Loan Simulations TAEG - Insurance Excluded");
		animatedModel3.setSeriesColors("99ffa0");

		animatedModel3.setAnimate(true);
		animatedModel3.setLegendPosition("ne");
		yAxis = animatedModel3.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(2);
		yAxis.setLabel("TAEG");

		animatedModel5 = initBarMode2();
		animatedModel5.setTitle("Top Bank Offer - Interest Rate");
		animatedModel5.setSeriesColors("c2cc08");

		animatedModel5.setAnimate(true);
		animatedModel5.setLegendPosition("ne");
		yAxis = animatedModel5.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(2);
		yAxis.setLabel("Interest Rate");

		animatedModel6 = initBarMode3();
		animatedModel6.setTitle("Top Bank - Insurance ");
		animatedModel6.setSeriesColors("727806");

		animatedModel6.setAnimate(true);
		animatedModel6.setLegendPosition("ne");
		yAxis = animatedModel6.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(200000);
		yAxis.setLabel("Total Insurance");

		animatedModel7 = initBarMode4();
		animatedModel7.setTitle("Bank Offers - Insurance ");
		animatedModel7.setSeriesColors("ff0000");

		animatedModel7.setAnimate(true);
		animatedModel7.setLegendPosition("ne");
		yAxis = animatedModel7.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(200000);
		yAxis.setLabel("Total Insurance");

		animatedModel8 = initBarMode5();
		animatedModel8.setTitle("Bank Offers - Additinal Fees ");
		animatedModel8.setSeriesColors("ff0000");

		animatedModel8.setAnimate(true);
		animatedModel8.setLegendPosition("ne");
		yAxis = animatedModel8.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(1000);
		yAxis.setLabel("Additinal Fees");

		animatedModel9 = initBarMode6();
		animatedModel9.setTitle("Bank Offers - Interest Rate ");
		animatedModel9.setSeriesColors("ff0000");

		animatedModel9.setAnimate(true);
		animatedModel9.setLegendPosition("ne");
		yAxis = animatedModel9.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(2);
		yAxis.setLabel("Interest Rate");
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		List<LoanSimulation> ls = iLoanSemulationService.getAllSimulations();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Amount");

		for (LoanSimulation ls1 : ls) {

			amounts.set(ls1.getAmount(), ls1.getTaeg_insurance());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarModel1() {
		BarChartModel model = new BarChartModel();
		List<LoanSimulation> ls = iLoanSemulationService.getAllSimulations();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Amount");

		for (LoanSimulation ls1 : ls) {

			amounts.set(ls1.getAmount(), ls1.getTaeg());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarMode2() {
		BarChartModel model = new BarChartModel();
		List<LoanSimulation> ls = iLoanSemulationService.getAllSimulations();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Bank Offers");

		for (LoanSimulation ls1 : ls) {

			amounts.set(ls1.getBankOffers().getName_bankoffer(), ls1.getBankOffers().getInterest_rate());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarMode3() {
		BarChartModel model = new BarChartModel();
		List<LoanSimulation> ls = iLoanSemulationService.getAllSimulations();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Banks");

		for (LoanSimulation ls1 : ls) {

			amounts.set(ls1.getBankOffers().getBank().getName_bank(), ls1.getBankOffers().getTotal_insurance());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarMode4() {
		BarChartModel model = new BarChartModel();
		List<BankOffers> ls = ibankOffersService.getAllBankOffers();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Bank Offers");

		for (BankOffers ls1 : ls) {

			amounts.set(ls1.getName_bankoffer(), ls1.getTotal_insurance());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarMode5() {
		BarChartModel model = new BarChartModel();
		List<BankOffers> ls = ibankOffersService.getAllBankOffers();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Bank Offers");

		for (BankOffers ls1 : ls) {

			amounts.set(ls1.getName_bankoffer(), ls1.getAdditional_fees());
		}
		model.addSeries(amounts);

		return model;

	}

	private BarChartModel initBarMode6() {
		BarChartModel model = new BarChartModel();
		List<BankOffers> ls = ibankOffersService.getAllBankOffers();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Bank Offers");

		for (BankOffers ls1 : ls) {

			amounts.set(ls1.getName_bankoffer(), ls1.getInterest_rate());
		}
		model.addSeries(amounts);

		return model;

	}

	private void createPieModels() {
		pieModel1 = new PieChartModel();
		pieModel2 = new PieChartModel();
		pieModel3 = new PieChartModel();
		pieModel4 = new PieChartModel();

		pieModel1.set("Total Simulations ", iLoanSemulationService.getLoanSimulationNumberJPQL());
		pieModel1.set("Total Simulations Accepted", iLoanSemulationService.countByResult());

		pieModel1.setTitle("Accepted Loans");
		pieModel1.setLegendPosition("w");
		pieModel1.setShadow(false);

		pieModel2.set("Total Simulations ", iLoanSemulationService.getLoanSimulationNumberJPQL());
		pieModel2.set("Total Simulations Denied", iLoanSemulationService.countByResultDenied());

		pieModel2.setTitle("Denied Loans");
		pieModel2.setLegendPosition("w");
		pieModel2.setShadow(false);

		pieModel3.set("Loans Accepted", iLoanSemulationService.countByResult());
		pieModel3.set("Loans Denied", iLoanSemulationService.countByResultDenied());

		pieModel3.setTitle("Accepted / Denied ");
		pieModel3.setLegendPosition("w");
		pieModel3.setShadow(false);

		pieModel4.set("Total Simulations ", iLoanSemulationService.getLoanSimulationNumberJPQL());
		pieModel4.set("Houses", iLoanSemulationService.countByHouse());
		pieModel4.set("Appartments", iLoanSemulationService.countByApartment());
		pieModel4.set("Lands", iLoanSemulationService.countByLand());
		pieModel4.set("Offices", iLoanSemulationService.countByLocalCommercial());

		pieModel4.setTitle("Loan Types");
		pieModel4.setLegendPosition("w");
		pieModel4.setShadow(false);



	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		List<LoanSimulation> ls = iLoanSemulationService.getAllSimulations();
		ChartSeries amounts = new ChartSeries();

		amounts.setLabel("Amount");

		for (LoanSimulation ls1 : ls) {

			amounts.set(ls1.getAmount(), ls1.getTaea());
		}
		model.addSeries(amounts);

		return model;
	}

	private LineChartModel initLinearModel1() {
		LineChartModel model = new LineChartModel();

		List<LoanSimulation> ls = iLoanSemulationService.getAllSimulations();
		ChartSeries amounts = new ChartSeries();

		amounts.setLabel("Amount");

		for (LoanSimulation ls1 : ls) {

			amounts.set(ls1.getAmount(), ls1.getMonthly_payment());
		}
		model.addSeries(amounts);

		return model;
	}

	public PieChartModel getPieModel5() {
		return pieModel5;
	}

	public void setPieModel5(PieChartModel pieModel5) {
		this.pieModel5 = pieModel5;
	}

	public BarChartModel getAnimatedModel9() {
		return animatedModel9;
	}

	public void setAnimatedModel9(BarChartModel animatedModel9) {
		this.animatedModel9 = animatedModel9;
	}

	public BarChartModel getAnimatedModel7() {
		return animatedModel7;
	}

	public void setAnimatedModel7(BarChartModel animatedModel7) {
		this.animatedModel7 = animatedModel7;
	}

	public BarChartModel getAnimatedModel8() {
		return animatedModel8;
	}

	public void setAnimatedModel8(BarChartModel animatedModel8) {
		this.animatedModel8 = animatedModel8;
	}

	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public void setAnimatedModel1(LineChartModel animatedModel1) {
		this.animatedModel1 = animatedModel1;
	}

	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	public void setAnimatedModel2(BarChartModel animatedModel2) {
		this.animatedModel2 = animatedModel2;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public List<LoanSimulation> getLoans() {
		return loans;
	}

	public void setLoans(List<LoanSimulation> loans) {
		this.loans = loans;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	public PieChartModel getPieModel3() {
		return pieModel3;
	}

	public void setPieModel3(PieChartModel pieModel3) {
		this.pieModel3 = pieModel3;
	}

	public PieChartModel getPieModel4() {
		return pieModel4;
	}

	public void setPieModel4(PieChartModel pieModel4) {
		this.pieModel4 = pieModel4;
	}

	public BarChartModel getAnimatedModel3() {
		return animatedModel3;
	}

	public void setAnimatedModel3(BarChartModel animatedModel3) {
		this.animatedModel3 = animatedModel3;
	}

	public LineChartModel getAnimatedModel4() {
		return animatedModel4;
	}

	public void setAnimatedModel4(LineChartModel animatedModel4) {
		this.animatedModel4 = animatedModel4;
	}

	public BarChartModel getAnimatedModel5() {
		return animatedModel5;
	}

	public void setAnimatedModel5(BarChartModel animatedModel5) {
		this.animatedModel5 = animatedModel5;
	}

	public BarChartModel getAnimatedModel6() {
		return animatedModel6;
	}

	public void setAnimatedModel6(BarChartModel animatedModel6) {
		this.animatedModel6 = animatedModel6;
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}