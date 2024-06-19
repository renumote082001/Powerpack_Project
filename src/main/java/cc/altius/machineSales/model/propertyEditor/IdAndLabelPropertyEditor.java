/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.model.propertyEditor;

import cc.altius.machineSales.model.IdAndLabel;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author altius
 */
public class IdAndLabelPropertyEditor extends PropertyEditorSupport{
     @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new IdAndLabel(text, text));
    }

    @Override
    public String getAsText() {
        if (getValue() == null) {
            return null;
        } else {
            return ((IdAndLabel) getValue()).getId();
        }
    }
    
    
}
