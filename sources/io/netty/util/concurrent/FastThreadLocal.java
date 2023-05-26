package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PlatformDependent;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes5.dex */
public class FastThreadLocal<V> {
    private static final int variablesToRemoveIndex = InternalThreadLocalMap.nextVariableIndex();
    private final int index = InternalThreadLocalMap.nextVariableIndex();

    private static void addToVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Set newSetFromMap;
        int i8 = variablesToRemoveIndex;
        Object indexedVariable = internalThreadLocalMap.indexedVariable(i8);
        if (indexedVariable != InternalThreadLocalMap.UNSET && indexedVariable != null) {
            newSetFromMap = (Set) indexedVariable;
        } else {
            newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            internalThreadLocalMap.setIndexedVariable(i8, newSetFromMap);
        }
        newSetFromMap.add(fastThreadLocal);
    }

    private V initialize(InternalThreadLocalMap internalThreadLocalMap) {
        V v7;
        try {
            v7 = initialValue();
        } catch (Exception e8) {
            PlatformDependent.throwException(e8);
            v7 = null;
        }
        internalThreadLocalMap.setIndexedVariable(this.index, v7);
        addToVariablesToRemove(internalThreadLocalMap, this);
        return v7;
    }

    public static void removeAll() {
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet == null) {
            return;
        }
        try {
            Object indexedVariable = ifSet.indexedVariable(variablesToRemoveIndex);
            if (indexedVariable != null && indexedVariable != InternalThreadLocalMap.UNSET) {
                for (FastThreadLocal fastThreadLocal : (FastThreadLocal[]) ((Set) indexedVariable).toArray(new FastThreadLocal[0])) {
                    fastThreadLocal.remove(ifSet);
                }
            }
        } finally {
            InternalThreadLocalMap.remove();
        }
    }

    private static void removeFromVariablesToRemove(InternalThreadLocalMap internalThreadLocalMap, FastThreadLocal<?> fastThreadLocal) {
        Object indexedVariable = internalThreadLocalMap.indexedVariable(variablesToRemoveIndex);
        if (indexedVariable != InternalThreadLocalMap.UNSET && indexedVariable != null) {
            ((Set) indexedVariable).remove(fastThreadLocal);
        }
    }

    private void setKnownNotUnset(InternalThreadLocalMap internalThreadLocalMap, V v7) {
        if (internalThreadLocalMap.setIndexedVariable(this.index, v7)) {
            addToVariablesToRemove(internalThreadLocalMap, this);
        }
    }

    public final V get() {
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        V v7 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v7 != InternalThreadLocalMap.UNSET ? v7 : initialize(internalThreadLocalMap);
    }

    public final V getIfExists() {
        V v7;
        InternalThreadLocalMap ifSet = InternalThreadLocalMap.getIfSet();
        if (ifSet != null && (v7 = (V) ifSet.indexedVariable(this.index)) != InternalThreadLocalMap.UNSET) {
            return v7;
        }
        return null;
    }

    protected V initialValue() throws Exception {
        return null;
    }

    public final boolean isSet() {
        return isSet(InternalThreadLocalMap.getIfSet());
    }

    protected void onRemoval(V v7) throws Exception {
    }

    public final void remove() {
        remove(InternalThreadLocalMap.getIfSet());
    }

    public final void set(V v7) {
        if (v7 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(InternalThreadLocalMap.get(), v7);
        } else {
            remove();
        }
    }

    public final boolean isSet(InternalThreadLocalMap internalThreadLocalMap) {
        return internalThreadLocalMap != null && internalThreadLocalMap.isIndexedVariableSet(this.index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void remove(InternalThreadLocalMap internalThreadLocalMap) {
        if (internalThreadLocalMap == null) {
            return;
        }
        Object removeIndexedVariable = internalThreadLocalMap.removeIndexedVariable(this.index);
        removeFromVariablesToRemove(internalThreadLocalMap, this);
        if (removeIndexedVariable != InternalThreadLocalMap.UNSET) {
            try {
                onRemoval(removeIndexedVariable);
            } catch (Exception e8) {
                PlatformDependent.throwException(e8);
            }
        }
    }

    public final V get(InternalThreadLocalMap internalThreadLocalMap) {
        V v7 = (V) internalThreadLocalMap.indexedVariable(this.index);
        return v7 != InternalThreadLocalMap.UNSET ? v7 : initialize(internalThreadLocalMap);
    }

    public final void set(InternalThreadLocalMap internalThreadLocalMap, V v7) {
        if (v7 != InternalThreadLocalMap.UNSET) {
            setKnownNotUnset(internalThreadLocalMap, v7);
        } else {
            remove(internalThreadLocalMap);
        }
    }
}
