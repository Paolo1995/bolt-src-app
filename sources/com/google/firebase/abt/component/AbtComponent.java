package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AbtComponent {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseABTesting> f15411a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f15412b;

    /* renamed from: c  reason: collision with root package name */
    private final AnalyticsConnector f15413c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbtComponent(Context context, AnalyticsConnector analyticsConnector) {
        this.f15412b = context;
        this.f15413c = analyticsConnector;
    }

    protected FirebaseABTesting a(String str) {
        return new FirebaseABTesting(this.f15412b, this.f15413c, str);
    }

    public synchronized FirebaseABTesting b(String str) {
        if (!this.f15411a.containsKey(str)) {
            this.f15411a.put(str, a(str));
        }
        return this.f15411a.get(str);
    }
}
