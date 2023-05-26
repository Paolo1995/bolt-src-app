package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: classes5.dex */
class ReadGraph extends HashMap {
    private final String label;
    private final String length;
    private final Loader loader;
    private final String mark;
    private final String refer;

    public ReadGraph(Contract contract, Loader loader) {
        this.refer = contract.getReference();
        this.mark = contract.getIdentity();
        this.length = contract.getLength();
        this.label = contract.getLabel();
        this.loader = loader;
    }

    private Value readArray(Type type, Class cls, NodeMap nodeMap) throws Exception {
        int i8;
        Node remove = nodeMap.remove(this.length);
        if (remove != null) {
            i8 = Integer.parseInt(remove.getValue());
        } else {
            i8 = 0;
        }
        return new ArrayValue(cls, i8);
    }

    private Value readInstance(Type type, Class cls, NodeMap nodeMap) throws Exception {
        Node remove = nodeMap.remove(this.mark);
        if (remove == null) {
            return readReference(type, cls, nodeMap);
        }
        String value = remove.getValue();
        if (!containsKey(value)) {
            return readValue(type, cls, nodeMap, value);
        }
        throw new CycleException("Element '%s' already exists", value);
    }

    private Value readReference(Type type, Class cls, NodeMap nodeMap) throws Exception {
        Node remove = nodeMap.remove(this.refer);
        if (remove == null) {
            return readValue(type, cls, nodeMap);
        }
        String value = remove.getValue();
        V v7 = get(value);
        if (containsKey(value)) {
            return new Reference(v7, cls);
        }
        throw new CycleException("Invalid reference '%s' found", value);
    }

    private Value readValue(Type type, Class cls, NodeMap nodeMap) throws Exception {
        if (type.getType().isArray()) {
            return readArray(type, cls, nodeMap);
        }
        return new ObjectValue(cls);
    }

    public Value read(Type type, NodeMap nodeMap) throws Exception {
        Node remove = nodeMap.remove(this.label);
        Class<?> type2 = type.getType();
        if (type2.isArray()) {
            type2 = type2.getComponentType();
        }
        if (remove != null) {
            type2 = this.loader.load(remove.getValue());
        }
        return readInstance(type, type2, nodeMap);
    }

    private Value readValue(Type type, Class cls, NodeMap nodeMap, String str) throws Exception {
        Value readValue = readValue(type, cls, nodeMap);
        return str != null ? new Allocate(readValue, this, str) : readValue;
    }
}
