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
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.ValeurEstim;
import tn.esprit.spring.service.IValeurEstimService;
import tn.esprit.spring.service.ValeurEstimService;

@Controller(value = "chartestim")
@ELBeanName(value = "chartestim")
@Join(path = "/chart", to = "/Estimation.jsf")
@ViewScoped
public class Chart {
	@Autowired
	IValeurEstimService iValeurEstimService;
	
	
	
	private BarChartModel animatedModel1;

	private PieChartModel pieModel1;

	private List<ValeurEstimService> vals;

	@PostConstruct
	public void init() {

		createAnimatedModels();
		createPieModels();

	}

	private void createAnimatedModels() {
		animatedModel1 = initBarModel();
		animatedModel1.setTitle("Estimation Amounts");
		animatedModel1.setSeriesColors("99ffa0");

		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("ne");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(1000000);
		yAxis.setLabel("Amount");

	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		List<ValeurEstim> ls = iValeurEstimService.getAll();
		ChartSeries amounts = new ChartSeries();
		amounts.setLabel("Number");

		for (ValeurEstim ls1 : ls) {

			amounts.set(ls1.getId(), ls1.getResult());
		}
		model.addSeries(amounts);

		return model;

	}

	private void createPieModels() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Total Estimations", iValeurEstimService.getValsNumberJPQL());

		pieModel1.setTitle("Estimations");
		pieModel1.setLegendPosition("w");
		pieModel1.setShadow(false);

	}

	public IValeurEstimService getiValeurEstimService() {
		return iValeurEstimService;
	}

	public void setiValeurEstimService(IValeurEstimService iValeurEstimService) {
		this.iValeurEstimService = iValeurEstimService;
	}

	public BarChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public void setAnimatedModel1(BarChartModel animatedModel1) {
		this.animatedModel1 = animatedModel1;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public List<ValeurEstimService> getVals() {
		return vals;
	}

	public void setVals(List<ValeurEstimService> vals) {
		this.vals = vals;
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}