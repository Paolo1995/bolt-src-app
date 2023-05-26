package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DecideMessages {

    /* renamed from: l  reason: collision with root package name */
    private static final Set<Integer> f19111l = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final String f19113b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Integer> f19114c;

    /* renamed from: f  reason: collision with root package name */
    private final OnNewResultsListener f19117f;

    /* renamed from: g  reason: collision with root package name */
    private final UpdatesFromMixpanel f19118g;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f19120i;

    /* renamed from: j  reason: collision with root package name */
    private Context f19121j;

    /* renamed from: a  reason: collision with root package name */
    private String f19112a = null;

    /* renamed from: d  reason: collision with root package name */
    private final List<InAppNotification> f19115d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    private final List<InAppNotification> f19116e = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    private JSONArray f19119h = null;

    /* renamed from: k  reason: collision with root package name */
    private Set<String> f19122k = new HashSet();

    /* loaded from: classes3.dex */
    public interface OnNewResultsListener {
        void a();
    }

    public DecideMessages(Context context, String str, OnNewResultsListener onNewResultsListener, UpdatesFromMixpanel updatesFromMixpanel, HashSet<Integer> hashSet) {
        this.f19121j = context;
        this.f19113b = str;
        this.f19117f = onNewResultsListener;
        this.f19118g = updatesFromMixpanel;
        this.f19114c = new HashSet(hashSet);
    }

    public synchronized String a() {
        return this.f19112a;
    }

    public synchronized Set<String> b() {
        return this.f19122k;
    }

    public synchronized InAppNotification c(AnalyticsMessages.EventDescription eventDescription, boolean z7) {
        if (this.f19116e.isEmpty()) {
            MPLog.i("MixpanelAPI.DecideUpdts", "No unseen triggered notifications exist, none will be returned.");
            return null;
        }
        for (int i8 = 0; i8 < this.f19116e.size(); i8++) {
            InAppNotification inAppNotification = this.f19116e.get(i8);
            if (inAppNotification.q(eventDescription)) {
                if (!z7) {
                    this.f19116e.remove(i8);
                    MPLog.i("MixpanelAPI.DecideUpdts", "recording triggered notification " + inAppNotification.f() + " as seen " + eventDescription.c());
                }
                return inAppNotification;
            }
            MPLog.i("MixpanelAPI.DecideUpdts", "triggered notification " + inAppNotification.f() + " does not match event " + eventDescription.c());
        }
        return null;
    }

    public synchronized InAppNotification d(boolean z7) {
        if (this.f19115d.isEmpty()) {
            MPLog.i("MixpanelAPI.DecideUpdts", "No unseen notifications exist, none will be returned.");
            return null;
        }
        InAppNotification remove = this.f19115d.remove(0);
        if (z7) {
            this.f19115d.add(remove);
        } else {
            MPLog.i("MixpanelAPI.DecideUpdts", "Recording notification " + remove + " as seen.");
        }
        return remove;
    }

    public String e() {
        return this.f19113b;
    }

    public synchronized JSONArray f() {
        return this.f19119h;
    }

    public Boolean g() {
        return this.f19120i;
    }

    public synchronized void h(InAppNotification inAppNotification) {
        if (!MPConfig.F) {
            if (inAppNotification.p()) {
                this.f19116e.add(inAppNotification);
            } else {
                this.f19115d.add(inAppNotification);
            }
        }
    }

    public synchronized void i(List<InAppNotification> list, List<InAppNotification> list2, JSONArray jSONArray, JSONArray jSONArray2, boolean z7, JSONArray jSONArray3) {
        boolean z8;
        boolean z9;
        OnNewResultsListener onNewResultsListener;
        int length = jSONArray2.length();
        this.f19118g.a(jSONArray);
        Iterator<InAppNotification> it = list.iterator();
        boolean z10 = false;
        while (true) {
            z8 = true;
            if (!it.hasNext()) {
                break;
            }
            InAppNotification next = it.next();
            int f8 = next.f();
            if (!this.f19114c.contains(Integer.valueOf(f8))) {
                this.f19114c.add(Integer.valueOf(f8));
                this.f19115d.add(next);
                z10 = true;
            }
        }
        for (InAppNotification inAppNotification : list2) {
            int f9 = inAppNotification.f();
            if (!this.f19114c.contains(Integer.valueOf(f9))) {
                this.f19114c.add(Integer.valueOf(f9));
                this.f19116e.add(inAppNotification);
                z10 = true;
            }
        }
        this.f19119h = jSONArray2;
        int i8 = 0;
        while (true) {
            if (i8 < length) {
                try {
                } catch (JSONException e8) {
                    MPLog.d("MixpanelAPI.DecideUpdts", "Could not convert variants[" + i8 + "] into a JSONObject while comparing the new variants", e8);
                }
                if (!f19111l.contains(Integer.valueOf(jSONArray2.getJSONObject(i8).getInt(Name.MARK)))) {
                    z9 = true;
                    z10 = true;
                    break;
                }
                i8++;
            } else {
                z9 = false;
                break;
            }
        }
        if (z9 && this.f19119h != null) {
            f19111l.clear();
            for (int i9 = 0; i9 < length; i9++) {
                try {
                    f19111l.add(Integer.valueOf(this.f19119h.getJSONObject(i9).getInt(Name.MARK)));
                } catch (JSONException e9) {
                    MPLog.d("MixpanelAPI.DecideUpdts", "Could not convert variants[" + i9 + "] into a JSONObject while updating the map", e9);
                }
            }
        }
        if (length == 0) {
            this.f19119h = new JSONArray();
            Set<Integer> set = f19111l;
            if (set.size() > 0) {
                set.clear();
                z10 = true;
            }
        }
        this.f19118g.f(this.f19119h);
        if (this.f19120i == null && !z7) {
            MPDbAdapter.s(this.f19121j).m(this.f19113b);
        }
        this.f19120i = Boolean.valueOf(z7);
        if (jSONArray3 != null) {
            try {
                HashSet hashSet = new HashSet();
                for (int i10 = 0; i10 < jSONArray3.length(); i10++) {
                    hashSet.add(jSONArray3.getString(i10));
                }
                if (!this.f19122k.equals(hashSet)) {
                    this.f19122k = hashSet;
                } else {
                    z8 = z10;
                }
                z10 = z8;
            } catch (JSONException e10) {
                MPLog.d("MixpanelAPI.DecideUpdts", "Got an integration id from " + jSONArray3.toString() + " that wasn't an int", e10);
            }
        }
        MPLog.i("MixpanelAPI.DecideUpdts", "New Decide content has become available. " + list.size() + " notifications and " + jSONArray2.length() + " experiments have been added.");
        if (z10 && (onNewResultsListener = this.f19117f) != null) {
            onNewResultsListener.a();
        }
    }

    public synchronized void j(String str) {
        String str2 = this.f19112a;
        if (str2 == null || !str2.equals(str)) {
            this.f19115d.clear();
        }
        this.f19112a = str;
    }

    public boolean k() {
        if (g() == null) {
            return true;
        }
        return g().booleanValue();
    }
}
