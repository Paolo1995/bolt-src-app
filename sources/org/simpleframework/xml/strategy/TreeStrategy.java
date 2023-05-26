package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

/* loaded from: classes5.dex */
public class TreeStrategy implements Strategy {
    private final String label;
    private final String length;
    private final Loader loader;

    public TreeStrategy() {
        this(Name.LABEL, Name.LENGTH);
    }

    private Value readArray(Class cls, NodeMap nodeMap) throws Exception {
        int i8;
        Node remove = nodeMap.remove(this.length);
        if (remove != null) {
            i8 = Integer.parseInt(remove.getValue());
        } else {
            i8 = 0;
        }
        return new ArrayValue(cls, i8);
    }

    private Class readValue(Type type, NodeMap nodeMap) throws Exception {
        Node remove = nodeMap.remove(this.label);
        Class<?> type2 = type.getType();
        if (type2.isArray()) {
            type2 = type2.getComponentType();
        }
        if (remove != null) {
            return this.loader.load(remove.getValue());
        }
        return type2;
    }

    private Class writeArray(Class cls, Object obj, NodeMap nodeMap) {
        int length = Array.getLength(obj);
        String str = this.length;
        if (str != null) {
            nodeMap.put(str, String.valueOf(length));
        }
        return cls.getComponentType();
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public Value read(Type type, NodeMap nodeMap, Map map) throws Exception {
        Class readValue = readValue(type, nodeMap);
        Class type2 = type.getType();
        if (type2.isArray()) {
            return readArray(readValue, nodeMap);
        }
        if (type2 != readValue) {
            return new ObjectValue(readValue);
        }
        return null;
    }

    @Override // org.simpleframework.xml.strategy.Strategy
    public boolean write(Type type, Object obj, NodeMap nodeMap, Map map) {
        Class<?> cls;
        Class<?> cls2 = obj.getClass();
        Class<?> type2 = type.getType();
        if (cls2.isArray()) {
            cls = writeArray(type2, obj, nodeMap);
        } else {
            cls = cls2;
        }
        if (cls2 != type2) {
            nodeMap.put(this.label, cls.getName());
            return false;
        }
        return false;
    }

    public TreeStrategy(String str, String str2) {
        this.loader = new Loader();
        this.length = str2;
        this.label = str;
    }
}
