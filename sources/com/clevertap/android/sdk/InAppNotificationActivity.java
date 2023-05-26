package com.clevertap.android.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.inapp.CTInAppBaseFullFragment;
import com.clevertap.android.sdk.inapp.CTInAppHtmlCoverFragment;
import com.clevertap.android.sdk.inapp.CTInAppHtmlHalfInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppHtmlInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeCoverFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeCoverImageFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialFragment;
import com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialImageFragment;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.CTInAppType;
import com.clevertap.android.sdk.inapp.InAppListener;
import j$.util.Spliterator;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class InAppNotificationActivity extends FragmentActivity implements InAppListener {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f11034i = false;

    /* renamed from: f  reason: collision with root package name */
    private CleverTapInstanceConfig f11035f;

    /* renamed from: g  reason: collision with root package name */
    private CTInAppNotification f11036g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<InAppListener> f11037h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.clevertap.android.sdk.InAppNotificationActivity$6  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11041a;

        static {
            int[] iArr = new int[CTInAppType.values().length];
            f11041a = iArr;
            try {
                iArr[CTInAppType.CTInAppTypeCoverHTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeInterstitialHTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeHalfInterstitialHTML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeCover.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeInterstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeHalfInterstitial.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeCoverImageOnly.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeInterstitialImageOnly.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeHalfInterstitialImageOnly.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f11041a[CTInAppType.CTInAppTypeAlert.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private CTInAppBaseFullFragment M() {
        AlertDialog alertDialog;
        CTInAppType r7 = this.f11036g.r();
        switch (AnonymousClass6.f11041a[r7.ordinal()]) {
            case 1:
                return new CTInAppHtmlCoverFragment();
            case 2:
                return new CTInAppHtmlInterstitialFragment();
            case 3:
                return new CTInAppHtmlHalfInterstitialFragment();
            case 4:
                return new CTInAppNativeCoverFragment();
            case 5:
                return new CTInAppNativeInterstitialFragment();
            case 6:
                return new CTInAppNativeHalfInterstitialFragment();
            case 7:
                return new CTInAppNativeCoverImageFragment();
            case 8:
                return new CTInAppNativeInterstitialImageFragment();
            case 9:
                return new CTInAppNativeHalfInterstitialImageFragment();
            case 10:
                if (this.f11036g.f().size() > 0) {
                    alertDialog = new AlertDialog.Builder(this, 16974394).setCancelable(false).setTitle(this.f11036g.B()).setMessage(this.f11036g.v()).setPositiveButton(this.f11036g.f().get(0).f(), new DialogInterface.OnClickListener() { // from class: com.clevertap.android.sdk.InAppNotificationActivity.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i8) {
                            Bundle bundle = new Bundle();
                            bundle.putString("wzrk_id", InAppNotificationActivity.this.f11036g.g());
                            bundle.putString("wzrk_c2a", InAppNotificationActivity.this.f11036g.f().get(0).f());
                            InAppNotificationActivity.this.N(bundle, null);
                            String a8 = InAppNotificationActivity.this.f11036g.f().get(0).a();
                            if (a8 != null) {
                                InAppNotificationActivity.this.Q(a8, bundle);
                            } else {
                                InAppNotificationActivity.this.O(bundle);
                            }
                        }
                    }).create();
                    if (this.f11036g.f().size() == 2) {
                        alertDialog.setButton(-2, this.f11036g.f().get(1).f(), new DialogInterface.OnClickListener() { // from class: com.clevertap.android.sdk.InAppNotificationActivity.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i8) {
                                Bundle bundle = new Bundle();
                                bundle.putString("wzrk_id", InAppNotificationActivity.this.f11036g.g());
                                bundle.putString("wzrk_c2a", InAppNotificationActivity.this.f11036g.f().get(1).f());
                                InAppNotificationActivity.this.N(bundle, null);
                                String a8 = InAppNotificationActivity.this.f11036g.f().get(1).a();
                                if (a8 != null) {
                                    InAppNotificationActivity.this.Q(a8, bundle);
                                } else {
                                    InAppNotificationActivity.this.O(bundle);
                                }
                            }
                        });
                    }
                    if (this.f11036g.f().size() > 2) {
                        alertDialog.setButton(-3, this.f11036g.f().get(2).f(), new DialogInterface.OnClickListener() { // from class: com.clevertap.android.sdk.InAppNotificationActivity.5
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i8) {
                                Bundle bundle = new Bundle();
                                bundle.putString("wzrk_id", InAppNotificationActivity.this.f11036g.g());
                                bundle.putString("wzrk_c2a", InAppNotificationActivity.this.f11036g.f().get(2).f());
                                InAppNotificationActivity.this.N(bundle, null);
                                String a8 = InAppNotificationActivity.this.f11036g.f().get(2).a();
                                if (a8 != null) {
                                    InAppNotificationActivity.this.Q(a8, bundle);
                                } else {
                                    InAppNotificationActivity.this.O(bundle);
                                }
                            }
                        });
                    }
                } else {
                    alertDialog = null;
                }
                if (alertDialog != null) {
                    alertDialog.show();
                    f11034i = true;
                    P(null);
                    return null;
                }
                this.f11035f.n().e("InAppNotificationActivity: Alert Dialog is null, not showing Alert InApp");
                return null;
            default:
                this.f11035f.n().r("InAppNotificationActivity: Unhandled InApp Type: " + r7);
                return null;
        }
    }

    private String R() {
        return this.f11035f.c() + ":CT_INAPP_CONTENT_FRAGMENT";
    }

    void N(Bundle bundle, HashMap<String, String> hashMap) {
        InAppListener S = S();
        if (S != null) {
            S.m(this.f11036g, bundle, hashMap);
        }
    }

    void O(Bundle bundle) {
        if (f11034i) {
            f11034i = false;
        }
        finish();
        InAppListener S = S();
        if (S != null && getBaseContext() != null) {
            S.r(getBaseContext(), this.f11036g, bundle);
        }
    }

    void P(Bundle bundle) {
        InAppListener S = S();
        if (S != null) {
            S.y(this.f11036g, bundle);
        }
    }

    void Q(String str, Bundle bundle) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace("\n", "").replace("\r", ""))));
        } catch (Throwable unused) {
        }
        O(bundle);
    }

    InAppListener S() {
        InAppListener inAppListener;
        try {
            inAppListener = this.f11037h.get();
        } catch (Throwable unused) {
            inAppListener = null;
        }
        if (inAppListener == null) {
            Logger n8 = this.f11035f.n();
            String c8 = this.f11035f.c();
            n8.s(c8, "InAppActivityListener is null for notification: " + this.f11036g.s());
        }
        return inAppListener;
    }

    void T(InAppListener inAppListener) {
        this.f11037h = new WeakReference<>(inAppListener);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(17432576, 17432577);
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void m(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap) {
        N(bundle, hashMap);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(17432576, 17432577);
        finish();
        O(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i8 = getResources().getConfiguration().orientation;
        if (i8 == 2) {
            getWindow().addFlags(Spliterator.IMMUTABLE);
        }
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.f11036g = (CTInAppNotification) extras.getParcelable("inApp");
                Bundle bundle2 = extras.getBundle("configBundle");
                if (bundle2 != null) {
                    this.f11035f = (CleverTapInstanceConfig) bundle2.getParcelable("config");
                }
                T(CleverTapAPI.K(this, this.f11035f).v().h());
                CTInAppNotification cTInAppNotification = this.f11036g;
                if (cTInAppNotification == null) {
                    finish();
                    return;
                }
                if (cTInAppNotification.S() && !this.f11036g.R()) {
                    if (i8 == 2) {
                        Logger.a("App in Landscape, dismissing portrait InApp Notification");
                        finish();
                        O(null);
                        return;
                    }
                    Logger.a("App in Portrait, displaying InApp Notification anyway");
                }
                if (!this.f11036g.S() && this.f11036g.R()) {
                    if (i8 == 1) {
                        Logger.a("App in Portrait, dismissing landscape InApp Notification");
                        finish();
                        O(null);
                        return;
                    }
                    Logger.a("App in Landscape, displaying InApp Notification anyway");
                }
                if (bundle == null) {
                    CTInAppBaseFullFragment M = M();
                    if (M != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("inApp", this.f11036g);
                        bundle3.putParcelable("config", this.f11035f);
                        M.setArguments(bundle3);
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(17498112, 17498113).add(16908290, M, R()).commit();
                        return;
                    }
                    return;
                } else if (f11034i) {
                    M();
                    return;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException();
        } catch (Throwable th) {
            Logger.q("Cannot find a valid notification bundle to show!", th);
            finish();
        }
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void r(Context context, CTInAppNotification cTInAppNotification, Bundle bundle) {
        O(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i8) {
        super.setTheme(16973840);
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void y(CTInAppNotification cTInAppNotification, Bundle bundle) {
        P(bundle);
    }
}
