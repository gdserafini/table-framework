package br.pucpr.framework.model;

import br.pucpr.framework.code.column.ColumnData;

public enum ModelColumn implements ColumnData<Model> {
    PROPERTY1(30){
        @Override
        public Object get(Model value){
            return value.getProperty1();
        }
    },
    PROPERTY2(30){
        @Override
        public Object get(Model value){
            return value.getProperty2();
        }
    };

    private int width;
    ModelColumn(int width){
        this.width = width;
    };

    @Override
    public String getTitle() {
        return name();
    };

    @Override
    public int getWidth() {
        return this.width;
    };
}
