package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class SignatureBuilder {
    private final Constructor factory;
    private final ParameterTable table = new ParameterTable();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ParameterList extends ArrayList<Parameter> {
        public ParameterList() {
        }

        public ParameterList(ParameterList parameterList) {
            super(parameterList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ParameterTable extends ArrayList<ParameterList> {
        /* JADX INFO: Access modifiers changed from: private */
        public int height() {
            if (width() <= 0) {
                return 0;
            }
            return get(0).size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int width() {
            return size();
        }

        public void insert(Parameter parameter, int i8) {
            ParameterList parameterList = get(i8);
            if (parameterList != null) {
                parameterList.add(parameter);
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public ParameterList get(int i8) {
            for (int size = size(); size <= i8; size++) {
                add(new ParameterList());
            }
            return (ParameterList) super.get(i8);
        }

        public Parameter get(int i8, int i9) {
            return get(i8).get(i9);
        }
    }

    public SignatureBuilder(Constructor constructor) {
        this.factory = constructor;
    }

    private List<Signature> create() throws Exception {
        ArrayList arrayList = new ArrayList();
        Signature signature = new Signature(this.factory);
        if (isValid()) {
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void populate(ParameterTable parameterTable, ParameterList parameterList, int i8) {
        ParameterList parameterList2 = this.table.get(i8);
        int size = parameterList.size();
        int size2 = parameterList2.size();
        for (int i9 = 0; i9 < size2; i9++) {
            for (int i10 = 0; i10 < size; i10++) {
                parameterTable.get(i10).add(parameterList.get(i10));
            }
            parameterTable.get(i8).add(parameterList2.get(i9));
        }
    }

    public List<Signature> build() throws Exception {
        return build(new ParameterTable());
    }

    public void insert(Parameter parameter, int i8) {
        this.table.insert(parameter, i8);
    }

    public boolean isValid() {
        Class<?>[] parameterTypes = this.factory.getParameterTypes();
        if (parameterTypes.length == this.table.width()) {
            return true;
        }
        return false;
    }

    private List<Signature> build(ParameterTable parameterTable) throws Exception {
        if (this.table.isEmpty()) {
            return create();
        }
        build(parameterTable, 0);
        return create(parameterTable);
    }

    private List<Signature> create(ParameterTable parameterTable) throws Exception {
        ArrayList arrayList = new ArrayList();
        int height = parameterTable.height();
        int width = parameterTable.width();
        for (int i8 = 0; i8 < height; i8++) {
            Signature signature = new Signature(this.factory);
            for (int i9 = 0; i9 < width; i9++) {
                Parameter parameter = parameterTable.get(i9, i8);
                String path = parameter.getPath();
                if (!signature.contains(parameter.getKey())) {
                    signature.add(parameter);
                } else {
                    throw new ConstructorException("Parameter '%s' is a duplicate in %s", path, this.factory);
                }
            }
            arrayList.add(signature);
        }
        return arrayList;
    }

    private void build(ParameterTable parameterTable, int i8) {
        build(parameterTable, new ParameterList(), i8);
    }

    private void build(ParameterTable parameterTable, ParameterList parameterList, int i8) {
        ParameterList parameterList2 = this.table.get(i8);
        int size = parameterList2.size();
        if (this.table.width() - 1 <= i8) {
            populate(parameterTable, parameterList, i8);
            return;
        }
        for (int i9 = 0; i9 < size; i9++) {
            ParameterList parameterList3 = new ParameterList(parameterList);
            if (parameterList != null) {
                parameterList3.add(parameterList2.get(i9));
                build(parameterTable, parameterList3, i8 + 1);
            }
        }
    }
}
