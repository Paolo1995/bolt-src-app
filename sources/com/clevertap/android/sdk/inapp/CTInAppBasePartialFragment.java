package com.clevertap.android.sdk.inapp;

import androidx.fragment.app.FragmentManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Utils;

/* loaded from: classes.dex */
public abstract class CTInAppBasePartialFragment extends CTInAppBaseFragment {
    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment
    void D() {
        FragmentManager fragmentManager;
        if (!Utils.u(getActivity()) && !this.f11288k.get() && (fragmentManager = getFragmentManager()) != null) {
            try {
                fragmentManager.beginTransaction().remove(this).commit();
            } catch (IllegalStateException unused) {
                fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
            }
        }
        this.f11288k.set(true);
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment
    void I() {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f11284g;
        if (cleverTapInstanceConfig != null) {
            M(CleverTapAPI.K(this.f11285h, cleverTapInstanceConfig).v().h());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        F(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f11288k.get()) {
            D();
        }
    }
}
