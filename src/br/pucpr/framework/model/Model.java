package br.pucpr.framework.model;

import br.pucpr.framework.code.meta.Column;

import java.util.Objects;

public class Model {

    @Column(title = "Property1", order = 1)
    private String property1;

    @Column(title = "Property2", order = 2)
    private String property2;

    public Model(String property1, String property2){
        this.property1 = property1;
        this.property2 = property2;
    }

    public String getProperty1() { return property1; }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() { return property2; }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Model model = (Model) object;

        return property1.equals(model.property1) && property2.equals(model.property2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property1, property2);
    }

    @Override
    public String toString() {
        return "Model{" +
                "property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                '}';
    }
}
