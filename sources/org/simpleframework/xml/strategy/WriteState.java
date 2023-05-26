package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

/* loaded from: classes5.dex */
class WriteState extends WeakCache<WriteGraph> {
    private Contract contract;

    public WriteState(Contract contract) {
        this.contract = contract;
    }

    public WriteGraph find(Object obj) {
        WriteGraph fetch = fetch(obj);
        if (fetch == null) {
            WriteGraph writeGraph = new WriteGraph(this.contract);
            cache(obj, writeGraph);
            return writeGraph;
        }
        return fetch;
    }
}
