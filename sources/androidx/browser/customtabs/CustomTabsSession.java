package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;

/* loaded from: classes.dex */
public final class CustomTabsSession {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2366a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ICustomTabsService f2367b;

    /* renamed from: c  reason: collision with root package name */
    private final ICustomTabsCallback f2368c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f2369d;

    /* renamed from: e  reason: collision with root package name */
    private final PendingIntent f2370e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.f2367b = iCustomTabsService;
        this.f2368c = iCustomTabsCallback;
        this.f2369d = componentName;
        this.f2370e = pendingIntent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.f2368c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComponentName b() {
        return this.f2369d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingIntent c() {
        return this.f2370e;
    }
}
