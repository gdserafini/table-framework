package br.pucpr.framework.code.meta;

import br.pucpr.framework.code.column.ColumnData;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InspectedColumn<T> implements ColumnData<T>, Comparable<InspectedColumn<T>>{
    int order;
    int width;
    String title;
    String format;

    Field field;
    Method method;

    @Override
    public String getTitle() { return this.title; }

    @Override
    public int getWidth() { return this.width; }

    @Override
    public Object get(T value) {
        try {
            Object obj;
            if (field != null) obj = field.get(value);
            else if (method != null) obj = method.invoke(value);
            else return "?";

            if (format == null) return obj;
            return String.format(format, obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return "?";
        }
    }

    @Override
    public int compareTo(InspectedColumn<T> obj) {
        return order - obj.order;
    }
}

public class Inspector<T> {

    private List<InspectedColumn<T>> columns = new ArrayList<>();
    private InspectedColumn<T> column = new InspectedColumn<>();
    private int defaultOrder = 3;

    private void setInfo(Column info, Field field){
        column.order = info.order() < 0 ? defaultOrder++ : info.order();
        column.title = info.title().isEmpty() ? field.getName() : info.title();
        column.width = info.width();
    }

    private void setFormat(Format format, Field field){
        column.format = format == null ? null : format.value();
        column.field = field;
        columns.add(column);
    }

    public List<ColumnData<T>> inspect(Class<T> clazz) {

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            Column info = field.getAnnotation(Column.class);
            if (info == null) continue;
            setInfo(info, field);

            Format format = field.getAnnotation(Format.class);
            setFormat(format, field);
        };

        Collections.sort(columns);
        return new ArrayList<>(columns);
    }

}
