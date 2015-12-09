package com.kleber.webapp.custom.thymeleaf.processor;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Textarea extends AbstractElementProcessor {

  public Textarea() {
    super("Textarea");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    Element textarea = new Element("textarea");
    textarea.setProcessable(true);
    element.getParent().insertBefore(element, textarea);
    element.getParent().removeChild(element);
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
