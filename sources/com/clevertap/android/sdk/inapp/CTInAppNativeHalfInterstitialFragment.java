package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CTInAppNativeHalfInterstitialFragment extends CTInAppBaseFullNativeFragment {

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f11313m;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        ArrayList arrayList = new ArrayList();
        if (this.f11287j.U() && O()) {
            inflate = layoutInflater.inflate(R$layout.tab_inapp_half_interstitial, viewGroup, false);
        } else {
            inflate = layoutInflater.inflate(R$layout.inapp_half_interstitial, viewGroup, false);
        }
        final FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_half_interstitial_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.half_interstitial_relative_layout);
        this.f11313m = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        int i8 = this.f11286i;
        if (i8 != 1) {
            if (i8 == 2) {
                this.f11313m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        RelativeLayout relativeLayout2 = (RelativeLayout) frameLayout.findViewById(R$id.half_interstitial_relative_layout);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout2.getLayoutParams();
                        if (CTInAppNativeHalfInterstitialFragment.this.f11287j.U() && CTInAppNativeHalfInterstitialFragment.this.O()) {
                            layoutParams.width = (int) (relativeLayout2.getMeasuredHeight() * 1.3f);
                            layoutParams.gravity = 17;
                            relativeLayout2.setLayoutParams(layoutParams);
                            new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment.2.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    closeImageView.setX(CTInAppNativeHalfInterstitialFragment.this.f11313m.getRight() - measuredWidth);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    closeImageView.setY(CTInAppNativeHalfInterstitialFragment.this.f11313m.getTop() - measuredWidth);
                                }
                            });
                        } else if (CTInAppNativeHalfInterstitialFragment.this.O()) {
                            layoutParams.setMargins(CTInAppNativeHalfInterstitialFragment.this.K(140), CTInAppNativeHalfInterstitialFragment.this.K(100), CTInAppNativeHalfInterstitialFragment.this.K(140), CTInAppNativeHalfInterstitialFragment.this.K(100));
                            int measuredHeight = relativeLayout2.getMeasuredHeight() - CTInAppNativeHalfInterstitialFragment.this.K(130);
                            layoutParams.height = measuredHeight;
                            layoutParams.width = (int) (measuredHeight * 1.3f);
                            layoutParams.gravity = 17;
                            relativeLayout2.setLayoutParams(layoutParams);
                            new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    closeImageView.setX(CTInAppNativeHalfInterstitialFragment.this.f11313m.getRight() - measuredWidth);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    closeImageView.setY(CTInAppNativeHalfInterstitialFragment.this.f11313m.getTop() - measuredWidth);
                                }
                            });
                        } else {
                            layoutParams.width = (int) (relativeLayout2.getMeasuredHeight() * 1.3f);
                            layoutParams.gravity = 1;
                            relativeLayout2.setLayoutParams(layoutParams);
                            new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    closeImageView.setX(CTInAppNativeHalfInterstitialFragment.this.f11313m.getRight() - measuredWidth);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    closeImageView.setY(CTInAppNativeHalfInterstitialFragment.this.f11313m.getTop() - measuredWidth);
                                }
                            });
                        }
                        CTInAppNativeHalfInterstitialFragment.this.f11313m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        } else {
            this.f11313m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) CTInAppNativeHalfInterstitialFragment.this.f11313m.getLayoutParams();
                    if (CTInAppNativeHalfInterstitialFragment.this.f11287j.U() && CTInAppNativeHalfInterstitialFragment.this.O()) {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment = CTInAppNativeHalfInterstitialFragment.this;
                        cTInAppNativeHalfInterstitialFragment.P(cTInAppNativeHalfInterstitialFragment.f11313m, layoutParams, closeImageView);
                    } else if (CTInAppNativeHalfInterstitialFragment.this.O()) {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment2 = CTInAppNativeHalfInterstitialFragment.this;
                        cTInAppNativeHalfInterstitialFragment2.Q(cTInAppNativeHalfInterstitialFragment2.f11313m, layoutParams, closeImageView);
                    } else {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment3 = CTInAppNativeHalfInterstitialFragment.this;
                        cTInAppNativeHalfInterstitialFragment3.P(cTInAppNativeHalfInterstitialFragment3.f11313m, layoutParams, closeImageView);
                    }
                    CTInAppNativeHalfInterstitialFragment.this.f11313m.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (this.f11287j.q(this.f11286i) != null) {
            CTInAppNotification cTInAppNotification = this.f11287j;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f11286i)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f11287j;
                ((ImageView) this.f11313m.findViewById(R$id.backgroundImage)).setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f11286i)));
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.f11313m.findViewById(R$id.half_interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(R$id.half_interstitial_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R$id.half_interstitial_button2);
        arrayList.add(button2);
        TextView textView = (TextView) this.f11313m.findViewById(R$id.half_interstitial_title);
        textView.setText(this.f11287j.B());
        textView.setTextColor(Color.parseColor(this.f11287j.C()));
        TextView textView2 = (TextView) this.f11313m.findViewById(R$id.half_interstitial_message);
        textView2.setText(this.f11287j.v());
        textView2.setTextColor(Color.parseColor(this.f11287j.x()));
        ArrayList<CTInAppNotificationButton> f8 = this.f11287j.f();
        if (f8.size() == 1) {
            int i9 = this.f11286i;
            if (i9 == 2) {
                button.setVisibility(8);
            } else if (i9 == 1) {
                button.setVisibility(4);
            }
            Y(button2, f8.get(0), 0);
        } else if (!f8.isEmpty()) {
            for (int i10 = 0; i10 < f8.size(); i10++) {
                if (i10 < 2) {
                    Y((Button) arrayList.get(i10), f8.get(i10), i10);
                }
            }
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHalfInterstitialFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CTInAppNativeHalfInterstitialFragment.this.F(null);
                CTInAppNativeHalfInterstitialFragment.this.getActivity().finish();
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
