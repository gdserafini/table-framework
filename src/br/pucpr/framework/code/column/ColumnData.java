package br.pucpr.framework.code.column;

public interface ColumnData<T> {
    String getTitle();
    int getWidth();
    Object get(T value);
}
