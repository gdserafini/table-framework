package br.pucpr.framework.code;

import br.pucpr.framework.code.general.TableData;

public class PrintTable {
    private static char rowSeparator = '-';
    private static char columnSeparator = '|';

    private static void printLine(int width){
        for(int i = 0; i < width; i++){
            System.out.print(rowSeparator);
        };

        System.out.println();
    }

    private static StringBuilder buildTitle(TableData table){
        var title = new StringBuilder();
        title.append(columnSeparator);

        for(int col = 0; col < table.getColumns(); col++){
            title.append(String.format(" %" + table.getWidth(col) + "s %s",
                    table.getTitle(col), columnSeparator));
        };

        return title;
    }

    public static void print(TableData table){
        var title = buildTitle(table);

        printLine(title.length());
        System.out.println(title);
        printLine(title.length());

        for(int row = 0; row < table.getRows(); row++){
            System.out.print(columnSeparator);

            for(int col = 0; col < table.getColumns(); col++){
                printData(table, col, row);
            };

            System.out.println();
        };

        printLine(title.length());
    }

    private static void printData(TableData table, int column, int row){
        System.out.printf(" %" + table.getWidth(column) +
                "s %s", table.get(row, column), columnSeparator);
    }
}
