package br.pucpr.framework;

import br.pucpr.framework.code.PrintTable;
import br.pucpr.framework.model.Model;
import br.pucpr.framework.model.ModelData;
import java.util.List;

public class Main {

    public static void main(String[] args){

        //interface based
        var modelGeneral = List.of(
                new Model("p1.1", "p2.1"),
                new Model("p1.2", "p2.2")
        );

        var table = new ModelData(modelGeneral);
        PrintTable.print(table);

        //columns based

        //meta programming based

        //extra
    }
}
