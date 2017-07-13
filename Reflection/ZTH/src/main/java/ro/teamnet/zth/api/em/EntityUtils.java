package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milan on 13-Jul-17.
 */
public class  EntityUtils {

    private EntityUtils() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

   public static String getTableName(Class entity){
       String tableName = entity.getName();
       return tableName;
   }

   public static List<ColumnInfo> getColumns(Class entity){
       Field[] columns = entity.getDeclaredFields();
       List<ColumnInfo> columnInfoList = new ArrayList<>();
       Annotation annotInstance;
       ColumnInfo columnInfo;
       for (Field field: columns) {
           if(field.isAnnotationPresent(entity)){
               annotInstance = field.getAnnotation(entity);
               Class<? extends Annotation> annotClass = annotInstance.annotationType();
               if (annotClass.equals(Id.class)
                       || annotClass.equals(Column.class)){
                   columnInfo = new ColumnInfo();
//                   columnInfo.setColumnName(field.getName());
                   columnInfo.setColumnType(field.getType());
//                   columnInfo.setId(false);
//                   if(annotInstance.equals(Id.class))
//                       columnInfo.setId(true);
                   columnInfoList.add(columnInfo);
               }
           }
       }
       return columnInfoList;
   }

}
