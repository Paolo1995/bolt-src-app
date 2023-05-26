package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
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
public class CTInAppNativeHalfInterstitialImageFragment extends CTInAppBaseFullFragment {

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f11323m;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        if (this.f11287j.U() && O()) {
            inflate = layoutInflater.inflate(R$layout.tab_inapp_half_interstitial_image, viewGroup, false);
        } else {
            inflate = layoutInflater.inflate(R$layout.inapp_half_interstitial_image, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_half_interstitial_image_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.half_interstitial_image_relative_layout);
        this.f11323m = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        ImageView imageView = (ImageView) this.f11323m.findViewById(R$id.half_interstitial_image);
        int i8 = this.f11286i;
        if (i8 != 1) {
            if (i8 == 2) {
                this.f11323m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getLayoutParams();
                        if (CTInAppNativeHalfInterstitialImageFragment.this.f11287j.U() && CTInAppNativeHalfInterstitialImageFragment.this.O()) {
                            layoutParams.width = (int) (CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getMeasuredHeight() * 1.3f);
                            layoutParams.gravity = 17;
                            CTInAppNativeHalfInterstitialImageFragment.this.f11323m.setLayoutParams(layoutParams);
                            new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    closeImageView.setX(CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getRight() - measuredWidth);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    closeImageView.setY(CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getTop() - measuredWidth);
                                }
                            });
                        } else if (CTInAppNativeHalfInterstitialImageFragment.this.O()) {
                            layoutParams.setMargins(CTInAppNativeHalfInterstitialImageFragment.this.K(140), CTInAppNativeHalfInterstitialImageFragment.this.K(100), CTInAppNativeHalfInterstitialImageFragment.this.K(140), CTInAppNativeHalfInterstitialImageFragment.this.K(100));
                            int measuredHeight = CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getMeasuredHeight() - CTInAppNativeHalfInterstitialImageFragment.this.K(130);
                            layoutParams.height = measuredHeight;
                            layoutParams.width = (int) (measuredHeight * 1.3f);
                            layoutParams.gravity = 17;
                            CTInAppNativeHalfInterstitialImageFragment.this.f11323m.setLayoutParams(layoutParams);
                            new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    closeImageView.setX(CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getRight() - measuredWidth);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    closeImageView.setY(CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getTop() - measuredWidth);
                                }
                            });
                        } else {
                            layoutParams.width = (int) (CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getMeasuredHeight() * 1.3f);
                            layoutParams.gravity = 1;
                            CTInAppNativeHalfInterstitialImageFragment.this.f11323m.setLayoutParams(layoutParams);
                            new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    closeImageView.setX(CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getRight() - measuredWidth);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    closeImageView.setY(CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getTop() - measuredWidth);
                                }
                            });
                        }
                        CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            this.f11323m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getLayoutParams();
                    if (CTInAppNativeHalfInterstitialImageFragment.this.f11287j.U() && CTInAppNativeHalfInterstitialImageFragment.this.O()) {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment = CTInAppNativeHalfInterstitialImageFragment.this;
                        cTInAppNativeHalfInterstitialImageFragment.P(cTInAppNativeHalfInterstitialImageFragment.f11323m, layoutParams, closeImageView);
                    } else if (CTInAppNativeHalfInterstitialImageFragment.this.O()) {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment2 = CTInAppNativeHalfInterstitialImageFragment.this;
                        cTInAppNativeHalfInterstitialImageFragment2.Q(cTInAppNativeHalfInterstitialImageFragment2.f11323m, layoutParams, closeImageView);
                    } else {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment3 = CTInAppNativeHalfInterstitialImageFragment.this;
                        cTInAppNativeHalfInterstitialImageFragment3.P(cTInAppNativeHalfInterstitialImageFragment3.f11323m, layoutParams, closeImageView);
                    }
                    CTInAppNativeHalfInterstitialImageFragment.this.f11323m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
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
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialImageFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CTInAppNativeHalfInterstitialImageFragment.this.F(null);
                CTInAppNativeHalfInterstitialImageFragment.this.getActivity().finish();
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
