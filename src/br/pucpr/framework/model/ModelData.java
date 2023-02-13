package br.pucpr.framework.model;

import br.pucpr.framework.code.general.TableData;

import java.util.List;

public class ModelData implements TableData {

    private static final int COL_PROP1 = 0;
    private static final int COL_PROP2 = 1;

    private List<Model> model;

    public ModelData(List<Model> model){
        this.model = model;
    }

    @Override
    public int getRows() { return this.model.size(); }

    @Override
    public int getColumns() { return 2; }

    @Override
    public Object get(int row, int column) {
        var mod = this.model.get(row);

        return switch (column) {
            case COL_PROP1 -> mod.getProperty1();
            case COL_PROP2 -> mod.getProperty2();
            default -> throw new IllegalStateException(
                    "Invalid column: " + column
            );
        };
    }

    @Override
    public String getTitle(int column) {
        return switch (column){
            case COL_PROP1 -> "Property1";
            case COL_PROP2 -> "Property2";
            default ->throw new IllegalStateException(
                    "Invalid column: " + column
            );
        };
    }

    @Override
    public int getWidth(int column) { return 30; }
}
