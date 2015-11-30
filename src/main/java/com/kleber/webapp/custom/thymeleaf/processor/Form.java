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
    Element form = new Element("form");
    form.setProcessable(true);

    for( Map.Entry<String, Attribute> entry : element.getAttributeMap().entrySet() )
      form.setAttribute(entry.getKey(), entry.getValue().getValue());

    Model target = (Model) arguments.getContext().getVariables().get("command");
    for(int i=0; i<target.getFields().size(); i++) {
      for(Node child : element.getElementChildren()) {
        child.setNodeProperty("field", target.getFields().get(i));
        child.setProcessable(true);
        form.addChild(child);
      }
    }

    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
