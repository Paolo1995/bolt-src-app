package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
class ModelAssembler {
    private final ExpressionBuilder builder;
    private final Detail detail;
    private final Format format;

    public ModelAssembler(ExpressionBuilder expressionBuilder, Detail detail, Support support) throws Exception {
        this.format = support.getFormat();
        this.builder = expressionBuilder;
        this.detail = detail;
    }

    private void assembleAttributes(Model model, Order order) throws Exception {
        String[] attributes;
        for (String str : order.attributes()) {
            Expression build = this.builder.build(str);
            if (!build.isAttribute() && build.isPath()) {
                throw new PathException("Ordered attribute '%s' references an element in %s", build, this.detail);
            }
            if (!build.isPath()) {
                model.registerAttribute(this.format.getStyle().getAttribute(str));
            } else {
                registerAttributes(model, build);
            }
        }
    }

    private void assembleElements(Model model, Order order) throws Exception {
        for (String str : order.elements()) {
            Expression build = this.builder.build(str);
            if (!build.isAttribute()) {
                registerElements(model, build);
            } else {
                throw new PathException("Ordered element '%s' references an attribute in %s", build, this.detail);
            }
        }
    }

    private void registerAttribute(Model model, Expression expression) throws Exception {
        String first = expression.getFirst();
        if (first != null) {
            model.registerAttribute(first);
        }
    }

    private void registerAttributes(Model model, Expression expression) throws Exception {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (expression.isPath()) {
            Model register = model.register(first, prefix, index);
            Expression path = expression.getPath(1);
            if (register != null) {
                registerAttributes(register, path);
                return;
            }
            throw new PathException("Element '%s' does not exist in %s", first, this.detail);
        }
        registerAttribute(model, expression);
    }

    private void registerElement(Model model, Expression expression) throws Exception {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (index > 1 && model.lookup(first, index - 1) == null) {
            throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", first, expression, this.detail);
        }
        model.register(first, prefix, index);
    }

    private void registerElements(Model model, Expression expression) throws Exception {
        String prefix = expression.getPrefix();
        String first = expression.getFirst();
        int index = expression.getIndex();
        if (first != null) {
            Model register = model.register(first, prefix, index);
            Expression path = expression.getPath(1);
            if (expression.isPath()) {
                registerElements(register, path);
            }
        }
        registerElement(model, expression);
    }

    public void assemble(Model model, Order order) throws Exception {
        assembleElements(model, order);
        assembleAttributes(model, order);
    }
}
