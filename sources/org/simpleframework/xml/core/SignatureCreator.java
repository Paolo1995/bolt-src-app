package org.simpleframework.xml.core;

import java.util.List;

/* loaded from: classes5.dex */
class SignatureCreator implements Creator {
    private final List<Parameter> list;
    private final Signature signature;
    private final Class type;

    public SignatureCreator(Signature signature) {
        this.type = signature.getType();
        this.list = signature.getAll();
        this.signature = signature;
    }

    private double getAdjustment(double d8) {
        double size = this.list.size() / 1000.0d;
        if (d8 > 0.0d) {
            return size + (d8 / this.list.size());
        }
        return d8 / this.list.size();
    }

    private double getPercentage(Criteria criteria) throws Exception {
        double d8 = 0.0d;
        for (Parameter parameter : this.list) {
            if (criteria.get(parameter.getKey()) == null) {
                if (parameter.isRequired() || parameter.isPrimitive()) {
                    return -1.0d;
                }
            } else {
                d8 += 1.0d;
            }
        }
        return getAdjustment(d8);
    }

    private Object getVariable(Criteria criteria, int i8) throws Exception {
        Variable remove = criteria.remove(this.list.get(i8).getKey());
        if (remove != null) {
            return remove.getValue();
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.Creator
    public Object getInstance() throws Exception {
        return this.signature.create();
    }

    @Override // org.simpleframework.xml.core.Creator
    public double getScore(Criteria criteria) throws Exception {
        Signature copy = this.signature.copy();
        for (Object obj : criteria) {
            Parameter parameter = copy.get(obj);
            Variable variable = criteria.get(obj);
            Contact contact = variable.getContact();
            if (parameter != null && !Support.isAssignable(variable.getValue().getClass(), parameter.getType())) {
                return -1.0d;
            }
            if (contact.isReadOnly() && parameter == null) {
                return -1.0d;
            }
        }
        return getPercentage(criteria);
    }

    @Override // org.simpleframework.xml.core.Creator
    public Signature getSignature() {
        return this.signature;
    }

    @Override // org.simpleframework.xml.core.Creator
    public Class getType() {
        return this.type;
    }

    public String toString() {
        return this.signature.toString();
    }

    @Override // org.simpleframework.xml.core.Creator
    public Object getInstance(Criteria criteria) throws Exception {
        Object[] array = this.list.toArray();
        for (int i8 = 0; i8 < this.list.size(); i8++) {
            array[i8] = getVariable(criteria, i8);
        }
        return this.signature.create(array);
    }
}
