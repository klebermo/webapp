package com.kleber.webapp.custom.thymeleaf.dialect;

import java.util.Set;
import java.util.HashSet;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Form extends AbstractDialect {

  public Form() {
    super();
  }

  public String getPrefix() {
    return null;
  }

  public Set<IProcessor> getProcessors() {
    final Set<IProcessor> processor = new HashSet<IProcessor>();
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Form());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.FieldBox());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Checkbox());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Input());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Radio());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Select());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Textarea());
    processor.add(new com.kleber.webapp.custom.thymeleaf.processor.Label());
    return processor;
  }
}
