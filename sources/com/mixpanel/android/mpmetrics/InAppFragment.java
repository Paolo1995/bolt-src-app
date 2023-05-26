package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ImagesContract;
import com.mixpanel.android.R$animator;
import com.mixpanel.android.R$id;
import com.mixpanel.android.R$layout;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
/* loaded from: classes3.dex */
public class InAppFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private MixpanelAPI f19137f;

    /* renamed from: g  reason: collision with root package name */
    private Activity f19138g;

    /* renamed from: h  reason: collision with root package name */
    private GestureDetector f19139h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f19140i;

    /* renamed from: j  reason: collision with root package name */
    private int f19141j;

    /* renamed from: k  reason: collision with root package name */
    private UpdateDisplayState.DisplayState.InAppNotificationState f19142k;

    /* renamed from: l  reason: collision with root package name */
    private Runnable f19143l;

    /* renamed from: m  reason: collision with root package name */
    private Runnable f19144m;

    /* renamed from: n  reason: collision with root package name */
    private View f19145n;

    /* renamed from: o  reason: collision with root package name */
    private AtomicBoolean f19146o = new AtomicBoolean();

    /* loaded from: classes3.dex */
    private class SineBounceInterpolator implements Interpolator {
        public SineBounceInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            return ((float) (-(Math.pow(2.718281828459045d, (-8.0f) * f8) * Math.cos(f8 * 12.0f)))) + 1.0f;
        }
    }

    private void g() {
        if (!this.f19146o.get()) {
            Handler handler = this.f19140i;
            if (handler != null) {
                handler.removeCallbacks(this.f19143l);
                this.f19140i.removeCallbacks(this.f19144m);
            }
            UpdateDisplayState.g(this.f19141j);
            FragmentManager fragmentManager = this.f19138g.getFragmentManager();
            try {
                fragmentManager.beginTransaction().remove(this).commit();
            } catch (IllegalStateException unused) {
                fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
            }
        }
        this.f19146o.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        boolean isDestroyed = this.f19138g.isDestroyed();
        Activity activity = this.f19138g;
        if (activity != null && !activity.isFinishing() && !isDestroyed && !this.f19146o.get()) {
            this.f19140i.removeCallbacks(this.f19143l);
            this.f19140i.removeCallbacks(this.f19144m);
            FragmentManager fragmentManager = this.f19138g.getFragmentManager();
            try {
                fragmentManager.beginTransaction().setCustomAnimations(0, R$animator.com_mixpanel_android_slide_down).remove(this).commit();
            } catch (IllegalStateException unused) {
                fragmentManager.beginTransaction().setCustomAnimations(0, R$animator.com_mixpanel_android_slide_down).remove(this).commitAllowingStateLoss();
            }
            UpdateDisplayState.g(this.f19141j);
            this.f19146o.set(true);
        }
    }

    public void i(MixpanelAPI mixpanelAPI, int i8, UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState) {
        this.f19137f = mixpanelAPI;
        this.f19141j = i8;
        this.f19142k = inAppNotificationState;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f19138g = activity;
        if (this.f19142k == null) {
            g();
            return;
        }
        this.f19140i = new Handler();
        this.f19143l = new Runnable() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.1
            @Override // java.lang.Runnable
            public void run() {
                InAppFragment.this.h();
            }
        };
        this.f19144m = new Runnable() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.2
            @Override // java.lang.Runnable
            public void run() {
                InAppFragment.this.f19145n.setVisibility(0);
                InAppFragment.this.f19145n.setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return InAppFragment.this.f19139h.onTouchEvent(motionEvent);
                    }
                });
                float applyDimension = TypedValue.applyDimension(1, 65.0f, InAppFragment.this.f19138g.getResources().getDisplayMetrics());
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, applyDimension, 0.0f);
                translateAnimation.setInterpolator(new DecelerateInterpolator());
                translateAnimation.setDuration(200L);
                InAppFragment.this.f19145n.startAnimation(translateAnimation);
                float f8 = applyDimension / 2.0f;
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, f8, f8);
                scaleAnimation.setInterpolator(new SineBounceInterpolator());
                scaleAnimation.setDuration(400L);
                scaleAnimation.setStartOffset(200L);
                ((ImageView) InAppFragment.this.f19145n.findViewById(R$id.com_mixpanel_android_notification_image)).startAnimation(scaleAnimation);
            }
        };
        this.f19139h = new GestureDetector(activity, new GestureDetector.OnGestureListener() { // from class: com.mixpanel.android.mpmetrics.InAppFragment.3
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
                if (f9 > 0.0f) {
                    InAppFragment.this.h();
                    return true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                JSONObject jSONObject;
                MiniInAppNotification miniInAppNotification = (MiniInAppNotification) InAppFragment.this.f19142k.a();
                String u7 = miniInAppNotification.u();
                JSONObject jSONObject2 = null;
                if (u7 != null && u7.length() > 0) {
                    try {
                        Uri parse = Uri.parse(u7);
                        try {
                            InAppFragment.this.f19138g.startActivity(new Intent("android.intent.action.VIEW", parse));
                        } catch (ActivityNotFoundException unused) {
                            MPLog.e("MixpanelAPI.InAppFrag", "User doesn't have an activity for notification URI " + parse);
                        }
                        try {
                            jSONObject = new JSONObject();
                        } catch (JSONException unused2) {
                        }
                        try {
                            jSONObject.put(ImagesContract.URL, u7);
                            jSONObject2 = jSONObject;
                        } catch (JSONException unused3) {
                            jSONObject2 = jSONObject;
                            MPLog.c("MixpanelAPI.InAppFrag", "Can't put url into json properties");
                            InAppFragment.this.f19137f.C().i("$campaign_open", miniInAppNotification, jSONObject2);
                            InAppFragment.this.h();
                            return true;
                        }
                    } catch (IllegalArgumentException e8) {
                        MPLog.f("MixpanelAPI.InAppFrag", "Can't parse notification URI, will not take any action", e8);
                        return true;
                    }
                }
                InAppFragment.this.f19137f.C().i("$campaign_open", miniInAppNotification, jSONObject2);
                InAppFragment.this.h();
                return true;
            }
        });
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19146o.set(false);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f19142k == null) {
            g();
        } else {
            View inflate = layoutInflater.inflate(R$layout.com_mixpanel_android_activity_notification_mini, viewGroup, false);
            this.f19145n = inflate;
            TextView textView = (TextView) inflate.findViewById(R$id.com_mixpanel_android_notification_title);
            ImageView imageView = (ImageView) this.f19145n.findViewById(R$id.com_mixpanel_android_notification_image);
            MiniInAppNotification miniInAppNotification = (MiniInAppNotification) this.f19142k.a();
            textView.setText(miniInAppNotification.b());
            textView.setTextColor(miniInAppNotification.c());
            imageView.setImageBitmap(miniInAppNotification.g());
            this.f19140i.postDelayed(this.f19143l, 10000L);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(miniInAppNotification.a());
            gradientDrawable.setCornerRadius(ViewUtils.a(7.0f, getActivity()));
            gradientDrawable.setStroke((int) ViewUtils.a(2.0f, getActivity()), miniInAppNotification.t());
            this.f19145n.setBackground(gradientDrawable);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.f19142k.a().g());
            bitmapDrawable.setColorFilter(miniInAppNotification.v(), PorterDuff.Mode.SRC_ATOP);
            imageView.setImageDrawable(bitmapDrawable);
        }
        return this.f19145n;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        g();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f19140i.postDelayed(this.f19144m, 500L);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f19146o.get()) {
            this.f19138g.getFragmentManager().beginTransaction().remove(this).commit();
        }
    }
}
