package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.CloseImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class CTInAppBaseFragment extends Fragment {

    /* renamed from: g  reason: collision with root package name */
    CleverTapInstanceConfig f11284g;

    /* renamed from: h  reason: collision with root package name */
    Context f11285h;

    /* renamed from: i  reason: collision with root package name */
    int f11286i;

    /* renamed from: j  reason: collision with root package name */
    CTInAppNotification f11287j;

    /* renamed from: l  reason: collision with root package name */
    private WeakReference<InAppListener> f11289l;

    /* renamed from: f  reason: collision with root package name */
    CloseImageView f11283f = null;

    /* renamed from: k  reason: collision with root package name */
    AtomicBoolean f11288k = new AtomicBoolean();

    /* loaded from: classes.dex */
    class CTInAppNativeButtonClickListener implements View.OnClickListener {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CTInAppNativeButtonClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CTInAppBaseFragment.this.L(((Integer) view.getTag()).intValue());
        }
    }

    abstract void D();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(Bundle bundle, HashMap<String, String> hashMap) {
        InAppListener J = J();
        if (J != null) {
            J.m(this.f11287j, bundle, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(Bundle bundle) {
        D();
        InAppListener J = J();
        if (J != null && getActivity() != null && getActivity().getBaseContext() != null) {
            J.r(getActivity().getBaseContext(), this.f11287j, bundle);
        }
    }

    void G(Bundle bundle) {
        InAppListener J = J();
        if (J != null) {
            J.y(this.f11287j, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, Bundle bundle) {
        try {
            Uri parse = Uri.parse(str.replace("\n", "").replace("\r", ""));
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Bundle bundle2 = new Bundle();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String str2 : queryParameterNames) {
                    bundle2.putString(str2, parse.getQueryParameter(str2));
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            if (!bundle2.isEmpty()) {
                intent.putExtras(bundle2);
            }
            Utils.w(getActivity(), intent);
            startActivity(intent);
        } catch (Throwable unused) {
        }
        F(bundle);
    }

    abstract void I();

    InAppListener J() {
        InAppListener inAppListener;
        try {
            inAppListener = this.f11289l.get();
        } catch (Throwable unused) {
            inAppListener = null;
        }
        if (inAppListener == null) {
            Logger n8 = this.f11284g.n();
            String c8 = this.f11284g.c();
            n8.s(c8, "InAppListener is null for notification: " + this.f11287j.s());
        }
        return inAppListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int K(int i8) {
        return (int) TypedValue.applyDimension(1, i8, getResources().getDisplayMetrics());
    }

    void L(int i8) {
        try {
            CTInAppNotificationButton cTInAppNotificationButton = this.f11287j.f().get(i8);
            Bundle bundle = new Bundle();
            bundle.putString("wzrk_id", this.f11287j.g());
            bundle.putString("wzrk_c2a", cTInAppNotificationButton.f());
            E(bundle, cTInAppNotificationButton.e());
            String a8 = cTInAppNotificationButton.a();
            if (a8 != null) {
                H(a8, bundle);
            } else {
                F(bundle);
            }
        } catch (Throwable th) {
            Logger n8 = this.f11284g.n();
            n8.e("Error handling notification button click: " + th.getCause());
            F(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(InAppListener inAppListener) {
        this.f11289l = new WeakReference<>(inAppListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f11285h = context;
        Bundle arguments = getArguments();
        this.f11287j = (CTInAppNotification) arguments.getParcelable("inApp");
        this.f11284g = (CleverTapInstanceConfig) arguments.getParcelable("config");
        this.f11286i = getResources().getConfiguration().orientation;
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        G(null);
    }
}
