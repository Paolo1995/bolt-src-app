package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class ClassInstantiator implements Instantiator {
    private final List<Creator> creators;
    private final Detail detail;
    private final Creator primary;
    private final ParameterMap registry;

    public ClassInstantiator(List<Creator> list, Creator creator, ParameterMap parameterMap, Detail detail) {
        this.creators = list;
        this.registry = parameterMap;
        this.primary = creator;
        this.detail = detail;
    }

    private Creator getCreator(Criteria criteria) throws Exception {
        Creator creator = this.primary;
        double d8 = 0.0d;
        for (Creator creator2 : this.creators) {
            double score = creator2.getScore(criteria);
            if (score > d8) {
                creator = creator2;
                d8 = score;
            }
        }
        return creator;
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public List<Creator> getCreators() {
        return new ArrayList(this.creators);
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public Object getInstance() throws Exception {
        return this.primary.getInstance();
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public Parameter getParameter(String str) {
        return this.registry.get(str);
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public List<Parameter> getParameters() {
        return this.registry.getAll();
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public boolean isDefault() {
        if (this.creators.size() > 1 || this.primary == null) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("creator for %s", this.detail);
    }

    @Override // org.simpleframework.xml.core.Instantiator
    public Object getInstance(Criteria criteria) throws Exception {
        Creator creator = getCreator(criteria);
        if (creator != null) {
            return creator.getInstance(criteria);
        }
        throw new PersistenceException("Constructor not matched for %s", this.detail);
    }
}
