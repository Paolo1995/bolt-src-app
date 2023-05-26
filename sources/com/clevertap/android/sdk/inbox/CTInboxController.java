package com.clevertap.android.sdk.inbox;

import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class CTInboxController {

    /* renamed from: a  reason: collision with root package name */
    private final DBAdapter f11518a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CTMessageDAO> f11519b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11520c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final String f11521d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11522e;

    /* renamed from: f  reason: collision with root package name */
    private final CTLockManager f11523f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseCallbackManager f11524g;

    /* renamed from: h  reason: collision with root package name */
    private final CleverTapInstanceConfig f11525h;

    public CTInboxController(CleverTapInstanceConfig cleverTapInstanceConfig, String str, DBAdapter dBAdapter, CTLockManager cTLockManager, BaseCallbackManager baseCallbackManager, boolean z7) {
        this.f11521d = str;
        this.f11518a = dBAdapter;
        this.f11519b = dBAdapter.F(str);
        this.f11522e = z7;
        this.f11523f = cTLockManager;
        this.f11524g = baseCallbackManager;
        this.f11525h = cleverTapInstanceConfig;
    }

    private CTMessageDAO h(String str) {
        synchronized (this.f11520c) {
            Iterator<CTMessageDAO> it = this.f11519b.iterator();
            while (it.hasNext()) {
                CTMessageDAO next = it.next();
                if (next.e().equals(str)) {
                    return next;
                }
            }
            Logger.n("Inbox Message for message id - " + str + " not found");
            return null;
        }
    }

    private void m() {
        boolean z7;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f11520c) {
            Iterator<CTMessageDAO> it = this.f11519b.iterator();
            while (it.hasNext()) {
                CTMessageDAO next = it.next();
                if (!this.f11522e && next.a()) {
                    Logger.a("Removing inbox message containing video/audio as app does not support video. For more information checkout CleverTap documentation.");
                    arrayList.add(next);
                } else {
                    long d8 = next.d();
                    if (d8 > 0 && System.currentTimeMillis() / 1000 > d8) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        Logger.n("Inbox Message: " + next.e() + " is expired - removing");
                        arrayList.add(next);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                a(((CTMessageDAO) it2.next()).e());
            }
        }
    }

    boolean a(final String str) {
        CTMessageDAO h8 = h(str);
        if (h8 == null) {
            return false;
        }
        synchronized (this.f11520c) {
            this.f11519b.remove(h8);
        }
        CTExecutorFactory.a(this.f11525h).c().d("RunDeleteMessage", new Callable<Void>() { // from class: com.clevertap.android.sdk.inbox.CTInboxController.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                CTInboxController.this.f11518a.w(str, CTInboxController.this.f11521d);
                return null;
            }
        });
        return true;
    }

    boolean b(final String str) {
        CTMessageDAO h8 = h(str);
        if (h8 == null) {
            return false;
        }
        synchronized (this.f11520c) {
            h8.r(1);
        }
        CTExecutorFactory.a(this.f11525h).c().d("RunMarkMessageRead", new Callable<Void>() { // from class: com.clevertap.android.sdk.inbox.CTInboxController.4
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                CTInboxController.this.f11518a.G(str, CTInboxController.this.f11521d);
                return null;
            }
        });
        return true;
    }

    public int g() {
        return j().size();
    }

    public CTMessageDAO i(String str) {
        return h(str);
    }

    public ArrayList<CTMessageDAO> j() {
        ArrayList<CTMessageDAO> arrayList;
        synchronized (this.f11520c) {
            m();
            arrayList = this.f11519b;
        }
        return arrayList;
    }

    public ArrayList<CTMessageDAO> k() {
        ArrayList<CTMessageDAO> arrayList = new ArrayList<>();
        synchronized (this.f11520c) {
            Iterator<CTMessageDAO> it = j().iterator();
            while (it.hasNext()) {
                CTMessageDAO next = it.next();
                if (next.l() == 0) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void l(final CTInboxMessage cTInboxMessage) {
        CTExecutorFactory.a(this.f11525h).c().d("markReadInboxMessage", new Callable<Void>() { // from class: com.clevertap.android.sdk.inbox.CTInboxController.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                synchronized (CTInboxController.this.f11523f.b()) {
                    if (CTInboxController.this.b(cTInboxMessage.g())) {
                        CTInboxController.this.f11524g.b();
                    }
                }
                return null;
            }
        });
    }

    public int n() {
        return k().size();
    }

    public boolean o(JSONArray jSONArray) {
        ArrayList<CTMessageDAO> arrayList = new ArrayList<>();
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            try {
                CTMessageDAO k8 = CTMessageDAO.k(jSONArray.getJSONObject(i8), this.f11521d);
                if (k8 != null) {
                    if (!this.f11522e && k8.a()) {
                        Logger.a("Dropping inbox message containing video/audio as app does not support video. For more information checkout CleverTap documentation.");
                    } else {
                        arrayList.add(k8);
                        Logger.n("Inbox Message for message id - " + k8.e() + " added");
                    }
                }
            } catch (JSONException e8) {
                Logger.a("Unable to update notification inbox messages - " + e8.getLocalizedMessage());
            }
        }
        if (arrayList.size() <= 0) {
            return false;
        }
        this.f11518a.O(arrayList);
        Logger.n("New Notification Inbox messages added");
        synchronized (this.f11520c) {
            this.f11519b = this.f11518a.F(this.f11521d);
            m();
        }
        return true;
    }
}
