package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CustomTabsClient {

    /* renamed from: a  reason: collision with root package name */
    private final ICustomTabsService f2331a;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f2332b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f2333c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f2331a = iCustomTabsService;
        this.f2332b = componentName;
        this.f2333c = context;
    }

    public static boolean a(@NonNull Context context, String str, @NonNull CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.b(context.getApplicationContext());
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    private ICustomTabsCallback.Stub b(final CustomTabsCallback customTabsCallback) {
        return new ICustomTabsCallback.Stub() { // from class: androidx.browser.customtabs.CustomTabsClient.2

            /* renamed from: a  reason: collision with root package name */
            private Handler f2334a = new Handler(Looper.getMainLooper());

            @Override // android.support.customtabs.ICustomTabsCallback
            public Bundle d(@NonNull String str, Bundle bundle) throws RemoteException {
                CustomTabsCallback customTabsCallback2 = customTabsCallback;
                if (customTabsCallback2 == null) {
                    return null;
                }
                return customTabsCallback2.b(str, bundle);
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void j(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2334a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.a(str, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void r(final int i8, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2334a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.d(i8, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void t(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2334a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.4
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.e(str, bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void u(final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2334a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.c(bundle);
                    }
                });
            }

            @Override // android.support.customtabs.ICustomTabsCallback
            public void w(final int i8, final Uri uri, final boolean z7, final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.f2334a.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.f(i8, uri, z7, bundle);
                    }
                });
            }
        };
    }

    private CustomTabsSession d(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
        boolean q8;
        ICustomTabsCallback.Stub b8 = b(customTabsCallback);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                q8 = this.f2331a.i(b8, bundle);
            } else {
                q8 = this.f2331a.q(b8);
            }
            if (!q8) {
                return null;
            }
            return new CustomTabsSession(this.f2331a, b8, this.f2332b, pendingIntent);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public CustomTabsSession c(CustomTabsCallback customTabsCallback) {
        return d(customTabsCallback, null);
    }

    public boolean e(long j8) {
        try {
            return this.f2331a.o(j8);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
