package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;

/* loaded from: classes5.dex */
class SignatureScanner {
    private final SignatureBuilder builder;
    private final Constructor constructor;
    private final ParameterFactory factory;
    private final ParameterMap registry;
    private final Class type;

    public SignatureScanner(Constructor constructor, ParameterMap parameterMap, Support support) throws Exception {
        this.builder = new SignatureBuilder(constructor);
        this.factory = new ParameterFactory(support);
        Class declaringClass = constructor.getDeclaringClass();
        this.type = declaringClass;
        this.constructor = constructor;
        this.registry = parameterMap;
        scan(declaringClass);
    }

    private List<Parameter> create(Annotation annotation, int i8) throws Exception {
        Parameter parameterFactory = this.factory.getInstance(this.constructor, annotation, i8);
        if (parameterFactory != null) {
            register(parameterFactory);
        }
        return Collections.singletonList(parameterFactory);
    }

    private Annotation[] extract(Annotation annotation) throws Exception {
        Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return (Annotation[]) declaredMethods[0].invoke(annotation, new Object[0]);
        }
        throw new UnionException("Annotation '%s' is not a valid union for %s", annotation, this.type);
    }

    private List<Parameter> process(Annotation annotation, int i8) throws Exception {
        if (annotation instanceof Attribute) {
            return create(annotation, i8);
        }
        if (annotation instanceof Element) {
            return create(annotation, i8);
        }
        if (annotation instanceof ElementList) {
            return create(annotation, i8);
        }
        if (annotation instanceof ElementArray) {
            return create(annotation, i8);
        }
        if (annotation instanceof ElementMap) {
            return create(annotation, i8);
        }
        if (annotation instanceof ElementListUnion) {
            return union(annotation, i8);
        }
        if (annotation instanceof ElementMapUnion) {
            return union(annotation, i8);
        }
        if (annotation instanceof ElementUnion) {
            return union(annotation, i8);
        }
        if (annotation instanceof Text) {
            return create(annotation, i8);
        }
        return Collections.emptyList();
    }

    private void register(Parameter parameter) throws Exception {
        String path = parameter.getPath();
        Object key = parameter.getKey();
        if (this.registry.containsKey(key)) {
            validate(parameter, key);
        }
        if (this.registry.containsKey(path)) {
            validate(parameter, path);
        }
        this.registry.put(path, parameter);
        this.registry.put(key, parameter);
    }

    private void scan(Class cls) throws Exception {
        Class<?>[] parameterTypes = this.constructor.getParameterTypes();
        for (int i8 = 0; i8 < parameterTypes.length; i8++) {
            scan(parameterTypes[i8], i8);
        }
    }

    private List<Parameter> union(Annotation annotation, int i8) throws Exception {
        Signature signature = new Signature(this.constructor);
        for (Annotation annotation2 : extract(annotation)) {
            Parameter parameterFactory = this.factory.getInstance(this.constructor, annotation, annotation2, i8);
            String path = parameterFactory.getPath();
            if (!signature.contains(path)) {
                signature.set(path, parameterFactory);
                register(parameterFactory);
            } else {
                throw new UnionException("Annotation name '%s' used more than once in %s for %s", path, annotation, this.type);
            }
        }
        return signature.getAll();
    }

    private void validate(Parameter parameter, Object obj) throws Exception {
        Parameter parameter2 = this.registry.get(obj);
        if (parameter.isText() != parameter2.isText()) {
            Annotation annotation = parameter.getAnnotation();
            Annotation annotation2 = parameter2.getAnnotation();
            String path = parameter.getPath();
            if (annotation.equals(annotation2)) {
                if (parameter2.getType() != parameter.getType()) {
                    throw new ConstructorException("Parameter types do not match for '%s' in %s", path, this.type);
                }
                return;
            }
            throw new ConstructorException("Annotations do not match for '%s' in %s", path, this.type);
        }
    }

    public List<Signature> getSignatures() throws Exception {
        return this.builder.build();
    }

    public boolean isValid() {
        return this.builder.isValid();
    }

    private void scan(Class cls, int i8) throws Exception {
        Annotation[][] parameterAnnotations = this.constructor.getParameterAnnotations();
        int i9 = 0;
        while (true) {
            Annotation[] annotationArr = parameterAnnotations[i8];
            if (i9 >= annotationArr.length) {
                return;
            }
            for (Parameter parameter : process(annotationArr[i9], i8)) {
                this.builder.insert(parameter, i8);
            }
            i9++;
        }
    }
}
