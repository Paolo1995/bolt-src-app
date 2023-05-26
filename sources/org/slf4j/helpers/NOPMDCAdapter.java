package org.slf4j.helpers;

import java.util.Map;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes5.dex */
public class NOPMDCAdapter implements MDCAdapter {
    @Override // org.slf4j.spi.MDCAdapter
    public Map<String, String> a() {
        return null;
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void b(Map<String, String> map) {
    }

    @Override // org.slf4j.spi.MDCAdapter
    public void clear() {
    }
}
