package br.pucpr.framework.code.general;

public interface TableData {
    int getRows();
    int getColumns();
    Object get(int row, int column);
    String getTitle(int column);
    int getWidth(int column);

}
