package com.kleber.webapp.custom.thymeleaf.processor;

import java.util.Locale;
import java.util.ResourceBundle;

import org.thymeleaf.processor.element.AbstractElementProcessor;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

public class Label extends AbstractElementProcessor {

  public Label() {
    super("Label");
  }

  public ProcessorResult processElement(Arguments arguments, Element element) {
    return ProcessorResult.OK;
  }

  public int getPrecedence() {
    return 1000;
  }

}
