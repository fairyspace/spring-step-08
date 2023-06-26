package io.github.fairyspace.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private final List<PropertyValue> propertyValueList=new ArrayList<>();

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValueList.add(propertyValue);
    }

}
