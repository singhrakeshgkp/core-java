package com.java.generics;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.java.generics.Immutable")//can provide array of annotations

public class ImmutableAnnotationProcessor extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
	System.out.println("in process method");
	if(
		annotations.stream()
		.flatMap(annotation->
		roundEnv.getElementsAnnotatedWith(annotation).stream())
		.flatMap(element->element.getEnclosedElements().stream())
		.filter(element->element.getKind() ==ElementKind.FIELD)
		.filter(element->element.getModifiers().contains(Modifier.FINAL)?false:true)
		.count()>0
		) {
	    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "At least one field is non final");
	    return false;
	}
	 return true;   
    }

}
