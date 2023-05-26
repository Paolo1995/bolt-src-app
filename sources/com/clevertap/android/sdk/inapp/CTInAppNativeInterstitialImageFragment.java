package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment;

/* loaded from: classes.dex */
public class CTInAppNativeInterstitialImageFragment extends CTInAppBaseFullFragment {

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f11354m;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        if (this.f11287j.U() && O()) {
            inflate = layoutInflater.inflate(R$layout.tab_inapp_interstitial_image, viewGroup, false);
        } else {
            inflate = layoutInflater.inflate(R$layout.inapp_interstitial_image, viewGroup, false);
        }
        final FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_interstitial_image_frame_layout);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.interstitial_image_relative_layout);
        this.f11354m = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        ImageView imageView = (ImageView) this.f11354m.findViewById(R$id.interstitial_image);
        int i8 = this.f11286i;
        if (i8 != 1) {
            if (i8 == 2) {
                this.f11354m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialImageFragment.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeInterstitialImageFragment.this.f11354m.getLayoutParams();
                        if (CTInAppNativeInterstitialImageFragment.this.f11287j.U() && CTInAppNativeInterstitialImageFragment.this.O()) {
                            CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment = CTInAppNativeInterstitialImageFragment.this;
                            cTInAppNativeInterstitialImageFragment.W(cTInAppNativeInterstitialImageFragment.f11354m, layoutParams, frameLayout, closeImageView);
                        } else if (CTInAppNativeInterstitialImageFragment.this.O()) {
                            CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment2 = CTInAppNativeInterstitialImageFragment.this;
                            cTInAppNativeInterstitialImageFragment2.V(cTInAppNativeInterstitialImageFragment2.f11354m, layoutParams, frameLayout, closeImageView);
                        } else {
                            CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment3 = CTInAppNativeInterstitialImageFragment.this;
                            cTInAppNativeInterstitialImageFragment3.U(cTInAppNativeInterstitialImageFragment3.f11354m, layoutParams, closeImageView);
                        }
                        CTInAppNativeInterstitialImageFragment.this.f11354m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            this.f11354m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialImageFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeInterstitialImageFragment.this.f11354m.getLayoutParams();
                    if (CTInAppNativeInterstitialImageFragment.this.f11287j.U() && CTInAppNativeInterstitialImageFragment.this.O()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment.T(cTInAppNativeInterstitialImageFragment.f11354m, layoutParams, frameLayout, closeImageView);
                    } else if (CTInAppNativeInterstitialImageFragment.this.O()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment2 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment2.S(cTInAppNativeInterstitialImageFragment2.f11354m, layoutParams, frameLayout, closeImageView);
                    } else {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment3 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment3.R(cTInAppNativeInterstitialImageFragment3.f11354m, layoutParams, closeImageView);
                    }
                    CTInAppNativeInterstitialImageFragment.this.f11354m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (this.f11287j.q(this.f11286i) != null) {
            CTInAppNotification cTInAppNotification = this.f11287j;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f11286i)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f11287j;
                imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f11286i)));
                imageView.setTag(0);
                imageView.setOnClickListener(new CTInAppBaseFragment.CTInAppNativeButtonClickListener());
            }
        }
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeInterstitialImageFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CTInAppNativeInterstitialImageFragment.this.F(null);
                CTInAppNativeInterstitialImageFragment.this.getActivity().finish();
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
