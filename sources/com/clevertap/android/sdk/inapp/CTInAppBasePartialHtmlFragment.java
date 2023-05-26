package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.utils.UriHelper;
import java.net.URLDecoder;

/* loaded from: classes.dex */
public abstract class CTInAppBasePartialHtmlFragment extends CTInAppBasePartialFragment implements View.OnTouchListener, View.OnLongClickListener {

    /* renamed from: m  reason: collision with root package name */
    private final GestureDetector f11297m = new GestureDetector(new GestureListener());

    /* renamed from: n  reason: collision with root package name */
    private CTInAppWebView f11298n;

    /* loaded from: classes.dex */
    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: f  reason: collision with root package name */
        private final int f11299f;

        /* renamed from: g  reason: collision with root package name */
        private final int f11300g;

        private GestureListener() {
            this.f11299f = 120;
            this.f11300g = 200;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z7) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (z7) {
                translateAnimation = new TranslateAnimation(0.0f, CTInAppBasePartialHtmlFragment.this.K(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, -CTInAppBasePartialHtmlFragment.this.K(50), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300L);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppBasePartialHtmlFragment.GestureListener.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CTInAppBasePartialHtmlFragment.this.F(null);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            CTInAppBasePartialHtmlFragment.this.f11298n.startAnimation(animationSet);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class InAppWebViewClient extends WebViewClient {
        InAppWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String string;
            try {
                Bundle a8 = UriHelper.a(str, false);
                if (a8.containsKey("wzrk_c2a") && (string = a8.getString("wzrk_c2a")) != null) {
                    String[] split = string.split("__dl__");
                    if (split.length == 2) {
                        a8.putString("wzrk_c2a", URLDecoder.decode(split[0], "UTF-8"));
                        str = split[1];
                    }
                }
                CTInAppBasePartialHtmlFragment.this.E(a8, null);
                Logger.a("Executing call to action for in-app: " + str);
                CTInAppBasePartialHtmlFragment.this.H(str, a8);
            } catch (Throwable th) {
                Logger.q("Error parsing the in-app notification action!", th);
            }
            return true;
        }
    }

    private View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            View Q = Q(layoutInflater, viewGroup);
            ViewGroup P = P(Q);
            this.f11298n = new CTInAppWebView(this.f11285h, this.f11287j.getWidth(), this.f11287j.getHeight(), this.f11287j.H(), this.f11287j.l());
            this.f11298n.setWebViewClient(new InAppWebViewClient());
            this.f11298n.setOnTouchListener(this);
            this.f11298n.setOnLongClickListener(this);
            if (P != null) {
                P.addView(this.f11298n);
            }
            return Q;
        } catch (Throwable th) {
            this.f11284g.n().t(this.f11284g.c(), "Fragment view not created", th);
            return null;
        }
    }

    private void R() {
        this.f11298n.a();
        Point point = this.f11298n.f11417f;
        int i8 = point.y;
        int i9 = point.x;
        float f8 = getResources().getDisplayMetrics().density;
        String replaceFirst = this.f11287j.n().replaceFirst("<head>", "<head>" + ("<style>body{width:" + ((int) (i9 / f8)) + "px; height: " + ((int) (i8 / f8)) + "px; margin: 0; padding:0;}</style>"));
        Logger.n("Density appears to be " + f8);
        this.f11298n.setInitialScale((int) (f8 * 100.0f));
        this.f11298n.loadDataWithBaseURL(null, replaceFirst, "text/html", "utf-8", null);
    }

    abstract ViewGroup P(View view);

    abstract View Q(LayoutInflater layoutInflater, ViewGroup viewGroup);

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        R();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return O(layoutInflater, viewGroup);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f11297m.onTouchEvent(motionEvent) && motionEvent.getAction() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.clevertap.android.sdk.inapp.CTInAppBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        R();
    }
}
