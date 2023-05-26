package org.slf4j.spi;

import java.util.Map;

/* loaded from: classes5.dex */
public interface MDCAdapter {
    Map<String, String> a();

    void b(Map<String, String> map);

    void clear();
}
