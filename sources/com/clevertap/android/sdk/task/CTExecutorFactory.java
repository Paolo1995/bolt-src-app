package com.clevertap.android.sdk.task;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CTExecutorFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, CTExecutors> f11781a = DesugarCollections.synchronizedMap(new HashMap());

    public static CTExecutors a(CleverTapInstanceConfig cleverTapInstanceConfig) {
        if (cleverTapInstanceConfig != null) {
            Map<String, CTExecutors> map = f11781a;
            CTExecutors cTExecutors = map.get(cleverTapInstanceConfig.c());
            if (cTExecutors == null) {
                synchronized (CTExecutorFactory.class) {
                    cTExecutors = map.get(cleverTapInstanceConfig.c());
                    if (cTExecutors == null) {
                        cTExecutors = new CTExecutors(cleverTapInstanceConfig);
                        map.put(cleverTapInstanceConfig.c(), cTExecutors);
                    }
                }
            }
            return cTExecutors;
        }
        throw new IllegalArgumentException("Can't create task for null config");
    }
}
