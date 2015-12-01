package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Map;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Attribute;
import org.thymeleaf.dom.Node;

import com.kleber.webapp.generic.persistence.Model;

public class Form extends AbstractElementProcessor {

  public Form() {
    super("form");
  }

  public ProcessorResult	processElement(Arguments arguments, Element element) {
    Model target = (Model) arguments.getContext().getVariables().get("command");
    String action = element.getAttributeValue("action");

    Element form = new Element("form");
    form.setProcessable(true);

    form.setAttribute("method", "post");
    form.setAttribute("action", "/"+action+"/"+target.getClass().getSimpleName());

    for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
      form.setAttribute(entry.getKey(), entry.getValue().getValue());

    for(int i=0; i<target.getFields().size(); i++) {
      for(Node child : element.getElementChildren()) {
        child.setNodeProperty("field", target.getFields().get(i));
        child.setProcessable(true);
        form.addChild(child);
      }
    }

    element.getParent().insertBefore(element, form);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
