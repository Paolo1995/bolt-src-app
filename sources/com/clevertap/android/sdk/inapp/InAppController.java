package com.clevertap.android.sdk.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.InAppNotificationListener;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.MainLooperHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppController implements CTInAppNotification.CTInAppNotificationListener, InAppListener {

    /* renamed from: p  reason: collision with root package name */
    private static CTInAppNotification f11422p;

    /* renamed from: q  reason: collision with root package name */
    private static final List<CTInAppNotification> f11423q = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    private final AnalyticsManager f11424f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseCallbackManager f11425g;

    /* renamed from: h  reason: collision with root package name */
    private final CleverTapInstanceConfig f11426h;

    /* renamed from: i  reason: collision with root package name */
    private final Context f11427i;

    /* renamed from: j  reason: collision with root package name */
    private final ControllerManager f11428j;

    /* renamed from: k  reason: collision with root package name */
    private final CoreMetaData f11429k;

    /* renamed from: n  reason: collision with root package name */
    private final Logger f11432n;

    /* renamed from: o  reason: collision with root package name */
    private final MainLooperHandler f11433o;

    /* renamed from: m  reason: collision with root package name */
    private HashSet<String> f11431m = null;

    /* renamed from: l  reason: collision with root package name */
    private InAppState f11430l = InAppState.RESUMED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.clevertap.android.sdk.inapp.InAppController$8  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11450a;

        static {
            int[] iArr = new int[CTInAppType.values().length];
            f11450a = iArr;
            try {
                iArr[CTInAppType.CTInAppTypeCoverHTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeInterstitialHTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeHalfInterstitialHTML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeCover.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeHalfInterstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeInterstitial.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeAlert.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeInterstitialImageOnly.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeHalfInterstitialImageOnly.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeCoverImageOnly.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeFooterHTML.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeHeaderHTML.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeFooter.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f11450a[CTInAppType.CTInAppTypeHeader.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum InAppState {
        DISCARDED(-1),
        SUSPENDED(0),
        RESUMED(1);
        

        /* renamed from: f  reason: collision with root package name */
        final int f11455f;

        InAppState(int i8) {
            this.f11455f = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class NotificationPrepareRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final WeakReference<InAppController> f11456f;

        /* renamed from: g  reason: collision with root package name */
        private final JSONObject f11457g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f11458h = Utils.f11091a;

        NotificationPrepareRunnable(InAppController inAppController, JSONObject jSONObject) {
            this.f11456f = new WeakReference<>(inAppController);
            this.f11457g = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            CTInAppNotification J = new CTInAppNotification().J(this.f11457g, this.f11458h);
            if (J.getError() != null) {
                Logger logger = InAppController.this.f11432n;
                String c8 = InAppController.this.f11426h.c();
                logger.f(c8, "Unable to parse inapp notification " + J.getError());
                return;
            }
            J.f11362f = this.f11456f.get();
            J.W();
        }
    }

    public InAppController(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, MainLooperHandler mainLooperHandler, ControllerManager controllerManager, BaseCallbackManager baseCallbackManager, AnalyticsManager analyticsManager, CoreMetaData coreMetaData) {
        this.f11427i = context;
        this.f11426h = cleverTapInstanceConfig;
        this.f11432n = cleverTapInstanceConfig.n();
        this.f11433o = mainLooperHandler;
        this.f11428j = controllerManager;
        this.f11425g = baseCallbackManager;
        this.f11424f = analyticsManager;
        this.f11429k = coreMetaData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        SharedPreferences g8 = StorageHelper.g(context);
        try {
            if (!j()) {
                Logger.n("Not showing notification on blacklisted activity");
            } else if (this.f11430l == InAppState.SUSPENDED) {
                this.f11432n.f(this.f11426h.c(), "InApp Notifications are set to be suspended, not showing the InApp Notification");
            } else {
                n(context, this.f11426h, this);
                JSONArray jSONArray = new JSONArray(StorageHelper.k(context, this.f11426h, "inApp", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                if (jSONArray.length() < 1) {
                    return;
                }
                if (this.f11430l != InAppState.DISCARDED) {
                    q(jSONArray.getJSONObject(0));
                } else {
                    this.f11432n.f(this.f11426h.c(), "InApp Notifications are set to be discarded, dropping the InApp Notification");
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                    if (i8 != 0) {
                        jSONArray2.put(jSONArray.get(i8));
                    }
                }
                StorageHelper.l(g8.edit().putString(StorageHelper.s(this.f11426h, "inApp"), jSONArray2.toString()));
            }
        } catch (Throwable th) {
            this.f11432n.t(this.f11426h.c(), "InApp: Couldn't parse JSON array string from prefs", th);
        }
    }

    private boolean j() {
        v();
        Iterator<String> it = this.f11431m.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String i8 = CoreMetaData.i();
            if (i8 != null && i8.contains(next)) {
                return false;
            }
        }
        return true;
    }

    private static void n(final Context context, final CleverTapInstanceConfig cleverTapInstanceConfig, final InAppController inAppController) {
        Logger.o(cleverTapInstanceConfig.c(), "checking Pending Notifications");
        List<CTInAppNotification> list = f11423q;
        if (list != null && !list.isEmpty()) {
            try {
                final CTInAppNotification cTInAppNotification = list.get(0);
                list.remove(0);
                new MainLooperHandler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.InAppController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        InAppController.s(context, cTInAppNotification, cleverTapInstanceConfig, inAppController);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final CTInAppNotification cTInAppNotification) {
        boolean z7;
        HashMap<String, Object> hashMap;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f11433o.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.InAppController.4
                @Override // java.lang.Runnable
                public void run() {
                    InAppController.this.o(cTInAppNotification);
                }
            });
        } else if (this.f11428j.h() != null) {
            if (!this.f11428j.h().d(cTInAppNotification)) {
                Logger logger = this.f11432n;
                String c8 = this.f11426h.c();
                logger.s(c8, "InApp has been rejected by FC, not showing " + cTInAppNotification.g());
                t();
                return;
            }
            this.f11428j.h().g(this.f11427i, cTInAppNotification);
            InAppNotificationListener g8 = this.f11425g.g();
            if (g8 != null) {
                if (cTInAppNotification.h() != null) {
                    hashMap = Utils.g(cTInAppNotification.h());
                } else {
                    hashMap = new HashMap<>();
                }
                z7 = g8.a(hashMap);
            } else {
                z7 = true;
            }
            if (!z7) {
                Logger logger2 = this.f11432n;
                String c9 = this.f11426h.c();
                logger2.s(c9, "Application has decided to not show this in-app notification: " + cTInAppNotification.g());
                t();
                return;
            }
            s(this.f11427i, cTInAppNotification, this.f11426h, this);
        } else {
            Logger logger3 = this.f11432n;
            String c10 = this.f11426h.c();
            logger3.s(c10, "getCoreState().getInAppFCManager() is NULL, not showing " + cTInAppNotification.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, CTInAppNotification cTInAppNotification, InAppController inAppController) {
        Logger.o(cleverTapInstanceConfig.c(), "Running inAppDidDismiss");
        CTInAppNotification cTInAppNotification2 = f11422p;
        if (cTInAppNotification2 != null && cTInAppNotification2.g().equals(cTInAppNotification.g())) {
            f11422p = null;
            n(context, cleverTapInstanceConfig, inAppController);
        }
    }

    private void q(final JSONObject jSONObject) {
        Logger logger = this.f11432n;
        String c8 = this.f11426h.c();
        logger.f(c8, "Preparing In-App for display: " + jSONObject.toString());
        CTExecutorFactory.a(this.f11426h).d("TAG_FEATURE_IN_APPS").d("InappController#prepareNotificationForDisplay", new Callable<Void>() { // from class: com.clevertap.android.sdk.inapp.InAppController.5
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InAppController inAppController = InAppController.this;
                new NotificationPrepareRunnable(inAppController, jSONObject).run();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Context context, CTInAppNotification cTInAppNotification, CleverTapInstanceConfig cleverTapInstanceConfig, InAppController inAppController) {
        Logger.o(cleverTapInstanceConfig.c(), "Attempting to show next In-App");
        if (!CoreMetaData.v()) {
            f11423q.add(cTInAppNotification);
            Logger.o(cleverTapInstanceConfig.c(), "Not in foreground, queueing this In App");
        } else if (f11422p != null) {
            f11423q.add(cTInAppNotification);
            Logger.o(cleverTapInstanceConfig.c(), "In App already displaying, queueing this In App");
        } else if (System.currentTimeMillis() / 1000 > cTInAppNotification.A()) {
            Logger.a("InApp has elapsed its time to live, not showing the InApp");
        } else {
            f11422p = cTInAppNotification;
            CTInAppType r7 = cTInAppNotification.r();
            Fragment fragment = null;
            switch (AnonymousClass8.f11450a[r7.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    Intent intent = new Intent(context, InAppNotificationActivity.class);
                    intent.putExtra("inApp", cTInAppNotification);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("config", cleverTapInstanceConfig);
                    intent.putExtra("configBundle", bundle);
                    try {
                        Activity h8 = CoreMetaData.h();
                        if (h8 != null) {
                            Logger n8 = cleverTapInstanceConfig.n();
                            String c8 = cleverTapInstanceConfig.c();
                            n8.s(c8, "calling InAppActivity for notification: " + cTInAppNotification.s());
                            h8.startActivity(intent);
                            Logger.a("Displaying In-App: " + cTInAppNotification.s());
                            break;
                        } else {
                            throw new IllegalStateException("Current activity reference not found");
                        }
                    } catch (Throwable th) {
                        Logger.q("Please verify the integration of your app. It is not setup to support in-app notifications yet.", th);
                        break;
                    }
                case 11:
                    fragment = new CTInAppHtmlFooterFragment();
                    break;
                case 12:
                    fragment = new CTInAppHtmlHeaderFragment();
                    break;
                case 13:
                    fragment = new CTInAppNativeFooterFragment();
                    break;
                case 14:
                    fragment = new CTInAppNativeHeaderFragment();
                    break;
                default:
                    String c9 = cleverTapInstanceConfig.c();
                    Logger.b(c9, "Unknown InApp Type found: " + r7);
                    f11422p = null;
                    return;
            }
            if (fragment != null) {
                Logger.a("Displaying In-App: " + cTInAppNotification.s());
                try {
                    FragmentTransaction beginTransaction = ((FragmentActivity) CoreMetaData.h()).getSupportFragmentManager().beginTransaction();
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("inApp", cTInAppNotification);
                    bundle2.putParcelable("config", cleverTapInstanceConfig);
                    fragment.setArguments(bundle2);
                    beginTransaction.setCustomAnimations(17498112, 17498113);
                    beginTransaction.add(16908290, fragment, cTInAppNotification.G());
                    String c10 = cleverTapInstanceConfig.c();
                    Logger.o(c10, "calling InAppFragment " + cTInAppNotification.g());
                    beginTransaction.commit();
                } catch (ClassCastException e8) {
                    String c11 = cleverTapInstanceConfig.c();
                    Logger.o(c11, "Fragment not able to render, please ensure your Activity is an instance of AppCompatActivity" + e8.getMessage());
                } catch (Throwable th2) {
                    Logger.p(cleverTapInstanceConfig.c(), "Fragment not able to render", th2);
                }
            }
        }
    }

    private void t() {
        if (!this.f11426h.p()) {
            CTExecutorFactory.a(this.f11426h).d("TAG_FEATURE_IN_APPS").d("InAppController#showInAppNotificationIfAny", new Callable<Void>() { // from class: com.clevertap.android.sdk.inapp.InAppController.6
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    InAppController inAppController = InAppController.this;
                    inAppController.b(inAppController.f11427i);
                    return null;
                }
            });
        }
    }

    private void v() {
        if (this.f11431m == null) {
            this.f11431m = new HashSet<>();
            try {
                String g8 = ManifestInfo.i(this.f11427i).g();
                if (g8 != null) {
                    for (String str : g8.split(",")) {
                        this.f11431m.add(str.trim());
                    }
                }
            } catch (Throwable unused) {
            }
            this.f11432n.f(this.f11426h.c(), "In-app notifications will not be shown on " + Arrays.toString(this.f11431m.toArray()));
        }
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppNotification.CTInAppNotificationListener
    public void a(final CTInAppNotification cTInAppNotification) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f11433o.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.InAppController.2
                @Override // java.lang.Runnable
                public void run() {
                    InAppController.this.a(cTInAppNotification);
                }
            });
        } else if (cTInAppNotification.getError() != null) {
            Logger logger = this.f11432n;
            String c8 = this.f11426h.c();
            logger.f(c8, "Unable to process inapp notification " + cTInAppNotification.getError());
        } else {
            Logger logger2 = this.f11432n;
            String c9 = this.f11426h.c();
            logger2.f(c9, "Notification ready: " + cTInAppNotification.s());
            o(cTInAppNotification);
        }
    }

    public void k(Activity activity) {
        if (j() && f11422p != null && System.currentTimeMillis() / 1000 < f11422p.A()) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            Fragment fragment = fragmentActivity.getSupportFragmentManager().getFragment(new Bundle(), f11422p.G());
            if (CoreMetaData.h() != null && fragment != null) {
                FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putParcelable("inApp", f11422p);
                bundle.putParcelable("config", this.f11426h);
                fragment.setArguments(bundle);
                beginTransaction.setCustomAnimations(17498112, 17498113);
                beginTransaction.add(16908290, fragment, f11422p.G());
                String c8 = this.f11426h.c();
                Logger.o(c8, "calling InAppFragment " + f11422p.g());
                beginTransaction.commit();
            }
        }
    }

    public void l(Activity activity) {
        String str;
        if (j()) {
            if (this.f11433o.a() != null) {
                this.f11432n.s(this.f11426h.c(), "Found a pending inapp runnable. Scheduling it");
                MainLooperHandler mainLooperHandler = this.f11433o;
                mainLooperHandler.postDelayed(mainLooperHandler.a(), 200L);
                this.f11433o.b(null);
                return;
            }
            u(this.f11427i);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("In-app notifications will not be shown for this activity (");
        if (activity != null) {
            str = activity.getLocalClassName();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(")");
        Logger.a(sb.toString());
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void m(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap) {
        this.f11424f.C(true, cTInAppNotification, bundle);
        if (hashMap != null && !hashMap.isEmpty() && this.f11425g.f() != null) {
            this.f11425g.f().a(hashMap);
        }
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void r(final Context context, final CTInAppNotification cTInAppNotification, Bundle bundle) {
        HashMap<String, Object> hashMap;
        cTInAppNotification.b();
        if (this.f11428j.h() != null) {
            this.f11428j.h().f(cTInAppNotification);
            Logger logger = this.f11432n;
            String c8 = this.f11426h.c();
            logger.s(c8, "InApp Dismissed: " + cTInAppNotification.g());
        } else {
            Logger logger2 = this.f11432n;
            String c9 = this.f11426h.c();
            logger2.s(c9, "Not calling InApp Dismissed: " + cTInAppNotification.g() + " because InAppFCManager is null");
        }
        try {
            InAppNotificationListener g8 = this.f11425g.g();
            if (g8 != null) {
                if (cTInAppNotification.h() != null) {
                    hashMap = Utils.g(cTInAppNotification.h());
                } else {
                    hashMap = new HashMap<>();
                }
                Logger.n("Calling the in-app listener on behalf of " + this.f11429k.r());
                if (bundle != null) {
                    g8.b(hashMap, Utils.d(bundle));
                } else {
                    g8.b(hashMap, null);
                }
            }
        } catch (Throwable th) {
            this.f11432n.t(this.f11426h.c(), "Failed to call the in-app notification listener", th);
        }
        CTExecutorFactory.a(this.f11426h).d("TAG_FEATURE_IN_APPS").d("InappController#inAppNotificationDidDismiss", new Callable<Void>() { // from class: com.clevertap.android.sdk.inapp.InAppController.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InAppController.p(context, InAppController.this.f11426h, cTInAppNotification, InAppController.this);
                InAppController.this.b(context);
                return null;
            }
        });
    }

    public void u(final Context context) {
        if (!this.f11426h.p()) {
            CTExecutorFactory.a(this.f11426h).d("TAG_FEATURE_IN_APPS").d("InappController#showNotificationIfAvailable", new Callable<Void>() { // from class: com.clevertap.android.sdk.inapp.InAppController.3
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    InAppController.this.b(context);
                    return null;
                }
            });
        }
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void y(CTInAppNotification cTInAppNotification, Bundle bundle) {
        this.f11424f.C(false, cTInAppNotification, bundle);
    }
}
