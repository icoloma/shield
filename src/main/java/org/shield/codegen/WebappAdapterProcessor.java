package org.shield.codegen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Generates an implementation of WebappAdapter
 */
@SupportedAnnotationTypes({ "javax.ws.rs.*" })
public class WebappAdapterProcessor extends AbstractProcessor {

    private final Logger log = LoggerFactory.getLogger(WebappAdapterProcessor.class);

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        log.info(annotations.toString());
        return false;
    }

}
