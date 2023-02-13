package br.pucpr.framework.code.column;

import br.pucpr.framework.code.general.TableData;
import java.util.List;

public class ColumnTableData<T> implements TableData {

    private List<T> data;
    private List<ColumnData<T>> columns;

    public ColumnTableData(
            List<T> data, List<ColumnData<T>> columns){

        this.data = data;
        this.columns = columns;
    }

    @Override
    public int getRows() { return this.data.size(); }

    @Override
    public int getColumns() { return this.columns.size(); }

    @Override
    public Object get(int row, int column) {
        T object = data.get(row);
        ColumnData<T> col = columns.get(column);
        return col.get(object);
    }

    @Override
    public String getTitle(int column) {
        return columns.get(column).getTitle();
    }

    @Override
    public int getWidth(int column) {
        return columns.get(column).getWidth();
    }

    public T get(int row){
        return data.get(row);
    }
}
