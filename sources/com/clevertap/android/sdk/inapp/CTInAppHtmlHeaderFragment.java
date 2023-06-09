package com.clevertap.android.sdk.inapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;

/* loaded from: classes.dex */
public class CTInAppHtmlHeaderFragment extends CTInAppBasePartialHtmlFragment {
    @Override // com.clevertap.android.sdk.inapp.CTInAppBasePartialHtmlFragment
    ViewGroup P(View view) {
        return (ViewGroup) view.findViewById(R$id.inapp_html_header_frame_layout);
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppBasePartialHtmlFragment
    View Q(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R$layout.inapp_html_header, viewGroup, false);
    }
}
