package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment;

/* loaded from: classes.dex */
public class CTInAppNativeCoverImageFragment extends CTInAppBaseFullFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.inapp_cover_image, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_cover_image_frame_layout);
        frameLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        ImageView imageView = (ImageView) ((RelativeLayout) frameLayout.findViewById(R$id.cover_image_relative_layout)).findViewById(R$id.cover_image);
        if (this.f11287j.q(this.f11286i) != null) {
            CTInAppNotification cTInAppNotification = this.f11287j;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f11286i)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f11287j;
                imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f11286i)));
                imageView.setTag(0);
                imageView.setOnClickListener(new CTInAppBaseFragment.CTInAppNativeButtonClickListener());
            }
        }
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeCoverImageFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CTInAppNativeCoverImageFragment.this.F(null);
                CTInAppNativeCoverImageFragment.this.getActivity().finish();
            }
        });
        if (!this.f11287j.M()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return inflate;
    }
}
