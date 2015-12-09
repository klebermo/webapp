package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Form extends AbstractElementProcessor {

  public Form() {
    super("form");
  }

  public ProcessorResult	processElement(Arguments arguments, Element element) {
    Element form = new Element("form");
    form.setProcessable(true);
    form.setAttribute("method", "post");
    form.setAttribute("action", "#");
    element.getParent().insertBefore(element, form);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
