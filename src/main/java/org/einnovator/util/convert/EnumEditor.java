package org.einnovator.util.convert;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class EnumEditor<T extends Enum<T>> extends PropertyEditorSupport {
	 private Class<T> clazz;

	 public EnumEditor(Class<T> clazz) {
	  this.clazz = clazz;
	 };

	 public String getAsText() {
	  return (getValue() == null ? "" : ((Enum<?>) getValue()).name());
	 }

	 public void setAsText(String text) throws IllegalArgumentException {
		 T value = StringUtils.hasText(text) ? Enum.valueOf(clazz, text) : null;
		 setValue(value);
	 }
}