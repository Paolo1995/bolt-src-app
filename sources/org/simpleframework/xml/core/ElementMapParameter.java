package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
class ElementMapParameter extends TemplateParameter {
    private final Contact contact;
    private final Expression expression;
    private final int index;
    private final Object key;
    private final Label label;
    private final String name;
    private final String path;
    private final Class type;

    /* loaded from: classes5.dex */
    private static class Contact extends ParameterContact<ElementMap> {
        public Contact(ElementMap elementMap, Constructor constructor, int i8) {
            super(elementMap, constructor, i8);
        }

        @Override // org.simpleframework.xml.core.ParameterContact, org.simpleframework.xml.core.Contact
        public String getName() {
            return ((ElementMap) this.label).name();
        }
    }

    public ElementMapParameter(Constructor constructor, ElementMap elementMap, Format format, int i8) throws Exception {
        Contact contact = new Contact(elementMap, constructor, i8);
        this.contact = contact;
        ElementMapLabel elementMapLabel = new ElementMapLabel(contact, elementMap, format);
        this.label = elementMapLabel;
        this.expression = elementMapLabel.getExpression();
        this.path = elementMapLabel.getPath();
        this.type = elementMapLabel.getType();
        this.name = elementMapLabel.getName();
        this.key = elementMapLabel.getKey();
        this.index = i8;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Annotation getAnnotation() {
        return this.contact.getAnnotation();
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Expression getExpression() {
        return this.expression;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public int getIndex() {
        return this.index;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Object getKey() {
        return this.key;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String getPath() {
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isPrimitive() {
        return this.type.isPrimitive();
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isRequired() {
        return this.label.isRequired();
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String toString() {
        return this.contact.toString();
    }
}
