package com.google.firebase.abt;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class FirebaseABTesting {

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsConnector f15408a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15409b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f15410c = null;

    public FirebaseABTesting(Context context, AnalyticsConnector analyticsConnector, String str) {
        this.f15408a = analyticsConnector;
        this.f15409b = str;
    }

    private void a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        this.f15408a.a(conditionalUserProperty);
    }

    private void b(List<AbtExperimentInfo> list) {
        ArrayDeque arrayDeque = new ArrayDeque(d());
        int g8 = g();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            while (arrayDeque.size() >= g8) {
                i(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).f15418b);
            }
            AnalyticsConnector.ConditionalUserProperty d8 = abtExperimentInfo.d(this.f15409b);
            a(d8);
            arrayDeque.offer(d8);
        }
    }

    private static List<AbtExperimentInfo> c(List<Map<String, String>> list) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            arrayList.add(AbtExperimentInfo.a(map));
        }
        return arrayList;
    }

    private List<AnalyticsConnector.ConditionalUserProperty> d() {
        return this.f15408a.f(this.f15409b, "");
    }

    private ArrayList<AbtExperimentInfo> e(List<AbtExperimentInfo> list, Set<String> set) {
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<>();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            if (!set.contains(abtExperimentInfo.b())) {
                arrayList.add(abtExperimentInfo);
            }
        }
        return arrayList;
    }

    private ArrayList<AnalyticsConnector.ConditionalUserProperty> f(List<AnalyticsConnector.ConditionalUserProperty> list, Set<String> set) {
        ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList<>();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : list) {
            if (!set.contains(conditionalUserProperty.f15418b)) {
                arrayList.add(conditionalUserProperty);
            }
        }
        return arrayList;
    }

    private int g() {
        if (this.f15410c == null) {
            this.f15410c = Integer.valueOf(this.f15408a.e(this.f15409b));
        }
        return this.f15410c.intValue();
    }

    private void i(String str) {
        this.f15408a.clearConditionalUserProperty(str, null, null);
    }

    private void j(Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : collection) {
            i(conditionalUserProperty.f15418b);
        }
    }

    private void l(List<AbtExperimentInfo> list) throws AbtException {
        if (list.isEmpty()) {
            h();
            return;
        }
        HashSet hashSet = new HashSet();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            hashSet.add(abtExperimentInfo.b());
        }
        List<AnalyticsConnector.ConditionalUserProperty> d8 = d();
        HashSet hashSet2 = new HashSet();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : d8) {
            hashSet2.add(conditionalUserProperty.f15418b);
        }
        j(f(d8, hashSet));
        b(e(list, hashSet2));
    }

    private void m() throws AbtException {
        if (this.f15408a != null) {
            return;
        }
        throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
    }

    public void h() throws AbtException {
        m();
        j(d());
    }

    public void k(List<Map<String, String>> list) throws AbtException {
        m();
        if (list != null) {
            l(c(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }
}
