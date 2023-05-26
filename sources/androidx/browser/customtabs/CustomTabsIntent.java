package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CustomTabsIntent {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final Intent f2353a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f2354b;

    CustomTabsIntent(@NonNull Intent intent, Bundle bundle) {
        this.f2353a = intent;
        this.f2354b = bundle;
    }

    public void a(@NonNull Context context, @NonNull Uri uri) {
        this.f2353a.setData(uri);
        ContextCompat.startActivity(context, this.f2353a, this.f2354b);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<Bundle> f2357c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f2358d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Bundle> f2359e;

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<Bundle> f2360f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f2361g;

        /* renamed from: a  reason: collision with root package name */
        private final Intent f2355a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        private final CustomTabColorSchemeParams.Builder f2356b = new CustomTabColorSchemeParams.Builder();

        /* renamed from: h  reason: collision with root package name */
        private int f2362h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f2363i = true;

        public Builder() {
        }

        private void d(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            BundleCompat.a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f2355a.putExtras(bundle);
        }

        @NonNull
        public CustomTabsIntent a() {
            if (!this.f2355a.hasExtra("android.support.customtabs.extra.SESSION")) {
                d(null, null);
            }
            ArrayList<Bundle> arrayList = this.f2357c;
            if (arrayList != null) {
                this.f2355a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f2359e;
            if (arrayList2 != null) {
                this.f2355a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f2355a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2363i);
            this.f2355a.putExtras(this.f2356b.a().a());
            Bundle bundle = this.f2361g;
            if (bundle != null) {
                this.f2355a.putExtras(bundle);
            }
            if (this.f2360f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f2360f);
                this.f2355a.putExtras(bundle2);
            }
            this.f2355a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f2362h);
            return new CustomTabsIntent(this.f2355a, this.f2358d);
        }

        @NonNull
        public Builder b(@NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
            this.f2361g = customTabColorSchemeParams.a();
            return this;
        }

        @NonNull
        public Builder c(@NonNull CustomTabsSession customTabsSession) {
            this.f2355a.setPackage(customTabsSession.b().getPackageName());
            d(customTabsSession.a(), customTabsSession.c());
            return this;
        }

        @NonNull
        @Deprecated
        public Builder e(int i8) {
            this.f2356b.b(i8);
            return this;
        }

        public Builder(CustomTabsSession customTabsSession) {
            if (customTabsSession != null) {
                c(customTabsSession);
            }
        }
    }
}
