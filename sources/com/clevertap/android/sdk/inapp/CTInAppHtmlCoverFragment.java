package com.clevertap.android.sdk.inapp;

import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class CTInAppHtmlCoverFragment extends CTInAppBaseFullHtmlFragment {
    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFullHtmlFragment
    protected RelativeLayout.LayoutParams Y() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(11, this.f11294m.getId());
        layoutParams.addRule(10, this.f11294m.getId());
        int K = K(40) / 4;
        layoutParams.setMargins(0, K, K, 0);
        return layoutParams;
    }
}
