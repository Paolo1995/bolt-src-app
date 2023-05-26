package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$bool;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.CloseImageView;

/* loaded from: classes.dex */
public abstract class CTInAppBaseFullFragment extends CTInAppBaseFragment {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment
    public void D() {
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment
    void I() {
        Context context = this.f11285h;
        if (context instanceof InAppNotificationActivity) {
            M((InAppListener) context);
        }
    }

    void N(final RelativeLayout relativeLayout, final CloseImageView closeImageView) {
        new Handler().post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.CTInAppBaseFullFragment.1
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                closeImageView.setX(relativeLayout.getRight() - measuredWidth);
                closeImageView.setY(relativeLayout.getTop() - measuredWidth);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O() {
        if (Utils.u(getActivity())) {
            return false;
        }
        try {
            return getResources().getBoolean(R$bool.ctIsTablet);
        } catch (Exception e8) {
            Logger.a("Failed to decide whether device is a smart phone or tablet!");
            e8.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.height = (int) (relativeLayout.getMeasuredWidth() * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.setMargins(K(140), K(140), K(140), K(140));
        int measuredWidth = relativeLayout.getMeasuredWidth() - K(210);
        layoutParams.width = measuredWidth;
        layoutParams.height = (int) (measuredWidth * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.height = (int) (relativeLayout.getMeasuredWidth() * 1.78f);
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredWidth = (int) ((relativeLayout.getMeasuredWidth() - K(200)) * 1.78f);
        int measuredHeight = frameLayout.getMeasuredHeight() - K(280);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (measuredHeight / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
            layoutParams.width = relativeLayout.getMeasuredWidth() - K(200);
        }
        layoutParams.setMargins(K(140), K(140), K(140), K(140));
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredWidth = (int) (relativeLayout.getMeasuredWidth() * 1.78f);
        int measuredHeight = frameLayout.getMeasuredHeight() - K(80);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (measuredHeight / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
        }
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.width = (int) (relativeLayout.getMeasuredHeight() * 1.78f);
        layoutParams.gravity = 1;
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredHeight = (int) ((relativeLayout.getMeasuredHeight() - K(120)) * 1.78f);
        int measuredWidth = frameLayout.getMeasuredWidth() - K(280);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (measuredWidth / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
            layoutParams.height = relativeLayout.getMeasuredHeight() - K(120);
        }
        layoutParams.setMargins(K(140), K(100), K(140), K(100));
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredHeight = (int) (relativeLayout.getMeasuredHeight() * 1.78f);
        int measuredWidth = frameLayout.getMeasuredWidth() - K(80);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (measuredWidth / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
        }
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        N(relativeLayout, closeImageView);
    }
}
