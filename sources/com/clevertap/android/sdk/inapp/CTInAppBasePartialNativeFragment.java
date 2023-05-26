package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment;

/* loaded from: classes.dex */
public abstract class CTInAppBasePartialNativeFragment extends CTInAppBasePartialFragment implements View.OnTouchListener, View.OnLongClickListener {

    /* renamed from: m  reason: collision with root package name */
    final GestureDetector f11304m = new GestureDetector(this.f11285h, new GestureListener());

    /* renamed from: n  reason: collision with root package name */
    View f11305n;

    /* loaded from: classes.dex */
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: f  reason: collision with root package name */
        private final int f11306f;

        /* renamed from: g  reason: collision with root package name */
        private final int f11307g;

        private GestureListener() {
            this.f11306f = 120;
            this.f11307g = 200;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z7) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (z7) {
                translateAnimation = new TranslateAnimation(0.0f, CTInAppBasePartialNativeFragment.this.K(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, -CTInAppBasePartialNativeFragment.this.K(50), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300L);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppBasePartialNativeFragment.GestureListener.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CTInAppBasePartialNativeFragment.this.F(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            CTInAppBasePartialNativeFragment.this.f11305n.startAnimation(animationSet);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
            if (motionEvent.getX() - motionEvent2.getX() > 120.0f && Math.abs(f8) > 200.0f) {
                return a(motionEvent, motionEvent2, false);
            }
            if (motionEvent2.getX() - motionEvent.getX() <= 120.0f || Math.abs(f8) <= 200.0f) {
                return false;
            }
            return a(motionEvent, motionEvent2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Button button, Button button2) {
        button2.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 2.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(Button button, CTInAppNotificationButton cTInAppNotificationButton, int i8) {
        if (cTInAppNotificationButton != null) {
            button.setTag(Integer.valueOf(i8));
            button.setVisibility(0);
            button.setText(cTInAppNotificationButton.f());
            button.setTextColor(Color.parseColor(cTInAppNotificationButton.g()));
            button.setBackgroundColor(Color.parseColor(cTInAppNotificationButton.b()));
            button.setOnClickListener(new CTInAppBaseFragment.CTInAppNativeButtonClickListener());
            return;
        }
        button.setVisibility(8);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f11304m.onTouchEvent(motionEvent) && motionEvent.getAction() != 2) {
            return false;
        }
        return true;
    }
}
