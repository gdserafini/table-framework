package br.pucpr.framework;

import br.pucpr.framework.code.PrintTable;
import br.pucpr.framework.code.column.ColumnData;
import br.pucpr.framework.code.column.ColumnTableData;
import br.pucpr.framework.code.meta.Inspector;
import br.pucpr.framework.model.Model;
import br.pucpr.framework.model.ModelColumn;
import br.pucpr.framework.model.ModelData;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        var modelGeneral = List.of(
                new Model("p1.1", "p2.1"),
                new Model("p1.2", "p2.2")
        );

        //interface based
        var table1 = new ModelData(modelGeneral);
        PrintTable.print(table1);

        //columns based
        List<ColumnData<Model>> columns = new ArrayList<>();
        columns.add(ModelColumn.PROPERTY1);
        columns.add(ModelColumn.PROPERTY2);

        ColumnTableData<Model> table2 = new ColumnTableData<>(
                modelGeneral, columns
        );

        PrintTable.print(table2);

        //meta programming based
        var inspector = new Inspector<Model>();

        ColumnTableData<Model> columns2 = new ColumnTableData<>(
                modelGeneral, inspector.inspect(Model.class)
        );

        PrintTable.print(columns2);

        //extra
    }
}
