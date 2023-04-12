package edu.eci.agronomo.production.model.production;

import edu.eci.agronomo.production.model.prod.Prod;

import java.util.List;

public class ProductionDto {
    private String idAnimal;
    private List<Prod> productions;
    private float totalProduction;

    public ProductionDto(String idAnimal, List<Prod> productions) {
        this.idAnimal = idAnimal;
        this.productions = productions;
        this.totalProduction = getTotalProduction();
    }

    public ProductionDto() {

    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public List<Prod> getProductions() {
        return productions;
    }

    public void setProductions(List<Prod> productions) {
        this.productions = productions;
    }

    public float getTotalProduction() {
        totalProduction = 0;
        productions.forEach(prod -> {totalProduction+= prod.getQuantity();});
        return totalProduction;
    }

    public void setTotalProduction(float totalProduction) {
        this.totalProduction = totalProduction;
    }
}
