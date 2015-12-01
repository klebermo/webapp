package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Map;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import java.lang.reflect.Field;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Node;
import org.thymeleaf.dom.Text;

import com.kleber.webapp.generic.persistence.Model;

public class Table extends AbstractElementProcessor {

  public Table() {
    super("table");
  }

  public ProcessorResult	processElement(Arguments arguments, Element element) {
    List<?> target = (List) arguments.getContext().getVariables().get("lista");
    Locale currentLocale = Locale.getDefault();
		ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);

    Class<?> classElement = target.get(0).getClass();

    Element node = new Element("table");
    node.setProcessable(true);

    for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
      node.setAttribute(entry.getKey(), entry.getValue().getValue());

    Element thead = new Element("thead");
    thead.setProcessable(true);
    Element tr = new Element("tr");
    tr.setProcessable(true);
    for(Field field : classElement.getFields()) {
      Element th = new Element("th");
      th.setProcessable(true);
      th.addChild(new Text(messages.getString(field.getName())));
      tr.addChild(th);
    }
    thead.addChild(tr);
    node.addChild(thead);

    Element tbody = new Element("tbody");
    tbody.setProcessable(true);
    for(Object item : target) {
      Element tr2 = new Element("tr");
      tr2.setProcessable(true);
      for(Field field : classElement.getFields()) {
        if(field.isAnnotationPresent(com.kleber.webapp.custom.annotation.form_control.Input.class) || field.isAnnotationPresent(com.kleber.webapp.custom.annotation.form_control.Select.class)) {
          Element td = new Element("td");
          td.setProcessable(true);
          String value = ((Model)item).getValue(field.getName()).toString();
          td.addChild(new Text(value));
          tr2.addChild(td);
        }
      }
      tbody.addChild(tr2);
    }

    element.getParent().insertBefore(element, node);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }
}
