package com.winston.oiadsl.apt.annotation;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.winston.oiadsl.apt.annotation.MyAnnotation"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_21)
public class MyProcessor extends AbstractProcessor {

    private Elements elementUtils;
    private Types typeUtils;
    private Filer filer;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {

        super.init(processingEnvironment);

        elementUtils = processingEnvironment.getElementUtils();
        typeUtils = processingEnvironment.getTypeUtils();
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();

    }

    @SneakyThrows
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        if (annotations.isEmpty()) {
            return false;
        }

        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(MyAnnotation.class);
        for (Element element : elements) {
            parseElement(element);
        }
        return true;

    }


    private void parseElement(Element element) throws Exception {

        String packageName = elementUtils.getPackageOf(element).getQualifiedName().toString();
        String className = element.getSimpleName().toString();

        messager.printMessage(Diagnostic.Kind.NOTE, "=HelloProcessor=" + packageName + "/" + className);

        FieldSpec id = FieldSpec.builder(Long.class, "id")
                .addModifiers(Modifier.PRIVATE)
                .addJavadoc("ID")
                .build();
        FieldSpec name = FieldSpec.builder(String.class, "name")
                .addModifiers(Modifier.PRIVATE)
                .addJavadoc("NAME")
                .build();

        TypeSpec typeSpec = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Getter.class)
                .addAnnotation(Setter.class)
                .addField(id)
                .addField(name)
                .build();

        JavaFile javaFile = JavaFile.builder(packageName, typeSpec)
                .build();

        javaFile.writeTo(filer);

    }

}
