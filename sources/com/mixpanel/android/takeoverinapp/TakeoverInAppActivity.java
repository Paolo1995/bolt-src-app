package com.mixpanel.android.takeoverinapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.api.Api;
import com.mixpanel.android.R$anim;
import com.mixpanel.android.R$id;
import com.mixpanel.android.R$layout;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.TakeoverInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
/* loaded from: classes3.dex */
public class TakeoverInAppActivity extends Activity {

    /* renamed from: f  reason: collision with root package name */
    private MixpanelAPI f19411f;

    /* renamed from: g  reason: collision with root package name */
    private UpdateDisplayState f19412g;

    /* renamed from: h  reason: collision with root package name */
    private int f19413h = -1;

    private void c() {
        setContentView(R$layout.com_mixpanel_android_activity_notification_full);
        ImageView imageView = (ImageView) findViewById(R$id.com_mixpanel_android_notification_gradient);
        FadingImageView fadingImageView = (FadingImageView) findViewById(R$id.com_mixpanel_android_notification_image);
        TextView textView = (TextView) findViewById(R$id.com_mixpanel_android_notification_title);
        TextView textView2 = (TextView) findViewById(R$id.com_mixpanel_android_notification_subtext);
        ArrayList<Button> arrayList = new ArrayList<>();
        Button button = (Button) findViewById(R$id.com_mixpanel_android_notification_button);
        arrayList.add(button);
        arrayList.add((Button) findViewById(R$id.com_mixpanel_android_notification_second_button));
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.com_mixpanel_android_button_exit_wrapper);
        ImageView imageView2 = (ImageView) findViewById(R$id.com_mixpanel_android_image_close);
        TakeoverInAppNotification takeoverInAppNotification = (TakeoverInAppNotification) ((UpdateDisplayState.DisplayState.InAppNotificationState) this.f19412g.b()).a();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, (int) (point.y * 0.06f));
            linearLayout.setLayoutParams(layoutParams);
        }
        fadingImageView.b(takeoverInAppNotification.B());
        imageView.setBackgroundColor(takeoverInAppNotification.a());
        if (takeoverInAppNotification.A()) {
            textView.setVisibility(0);
            textView.setText(takeoverInAppNotification.x());
            textView.setTextColor(takeoverInAppNotification.z());
        } else {
            textView.setVisibility(8);
        }
        if (takeoverInAppNotification.o()) {
            textView2.setVisibility(0);
            textView2.setText(takeoverInAppNotification.b());
            textView2.setTextColor(takeoverInAppNotification.c());
        } else {
            textView2.setVisibility(8);
        }
        fadingImageView.setImageBitmap(takeoverInAppNotification.g());
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            d(arrayList.get(i8), takeoverInAppNotification.t(i8), takeoverInAppNotification, i8);
        }
        if (takeoverInAppNotification.v() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams2.weight = 0.0f;
            layoutParams2.width = -2;
            button.setLayoutParams(layoutParams2);
        }
        imageView2.setColorFilter(takeoverInAppNotification.u());
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TakeoverInAppActivity.this.finish();
                UpdateDisplayState.g(TakeoverInAppActivity.this.f19413h);
            }
        });
        e(fadingImageView, textView, textView2, arrayList, linearLayout);
    }

    private void d(Button button, final InAppButton inAppButton, final InAppNotification inAppNotification, final int i8) {
        if (inAppButton != null) {
            button.setVisibility(0);
            button.setText(inAppButton.d());
            button.setTextColor(inAppButton.e());
            button.setTransformationMethod(null);
            final GradientDrawable gradientDrawable = new GradientDrawable();
            final int i9 = 864454278;
            if (inAppButton.a() != 0) {
                i9 = ViewUtils.b(inAppButton.a(), 864454278);
            }
            button.setOnTouchListener(new View.OnTouchListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        gradientDrawable.setColor(i9);
                        return false;
                    }
                    gradientDrawable.setColor(inAppButton.a());
                    return false;
                }
            });
            gradientDrawable.setColor(inAppButton.a());
            gradientDrawable.setStroke((int) ViewUtils.a(2.0f, this), inAppButton.b());
            gradientDrawable.setCornerRadius((int) ViewUtils.a(5.0f, this));
            button.setBackground(gradientDrawable);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.3
                /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onClick(android.view.View r6) {
                    /*
                        r5 = this;
                        com.mixpanel.android.mpmetrics.InAppButton r6 = r2
                        java.lang.String r6 = r6.c()
                        java.lang.String r0 = "MixpanelAPI.TakeoverInAppActivity"
                        r1 = 0
                        if (r6 == 0) goto L41
                        int r2 = r6.length()
                        if (r2 <= 0) goto L41
                        android.net.Uri r2 = android.net.Uri.parse(r6)     // Catch: java.lang.IllegalArgumentException -> L3a
                        android.content.Intent r3 = new android.content.Intent     // Catch: android.content.ActivityNotFoundException -> L22
                        java.lang.String r4 = "android.intent.action.VIEW"
                        r3.<init>(r4, r2)     // Catch: android.content.ActivityNotFoundException -> L22
                        com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r2 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this     // Catch: android.content.ActivityNotFoundException -> L22
                        r2.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L22
                        goto L27
                    L22:
                        java.lang.String r2 = "User doesn't have an activity for notification URI"
                        com.mixpanel.android.util.MPLog.e(r0, r2)
                    L27:
                        org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L34
                        r2.<init>()     // Catch: org.json.JSONException -> L34
                        java.lang.String r1 = "url"
                        r2.put(r1, r6)     // Catch: org.json.JSONException -> L33
                        r1 = r2
                        goto L41
                    L33:
                        r1 = r2
                    L34:
                        java.lang.String r6 = "Can't put url into json properties"
                        com.mixpanel.android.util.MPLog.c(r0, r6)
                        goto L41
                    L3a:
                        r6 = move-exception
                        java.lang.String r1 = "Can't parse notification URI, will not take any action"
                        com.mixpanel.android.util.MPLog.f(r0, r1, r6)
                        return
                    L41:
                        com.mixpanel.android.mpmetrics.InAppNotification r6 = r3
                        com.mixpanel.android.mpmetrics.TakeoverInAppNotification r6 = (com.mixpanel.android.mpmetrics.TakeoverInAppNotification) r6
                        int r6 = r6.v()
                        r2 = 2
                        java.lang.String r3 = "primary"
                        if (r6 != r2) goto L55
                        int r6 = r4
                        if (r6 != 0) goto L55
                        java.lang.String r6 = "secondary"
                        r3 = r6
                    L55:
                        if (r1 != 0) goto L5d
                        org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L63
                        r6.<init>()     // Catch: org.json.JSONException -> L63
                        r1 = r6
                    L5d:
                        java.lang.String r6 = "button"
                        r1.put(r6, r3)     // Catch: org.json.JSONException -> L63
                        goto L68
                    L63:
                        java.lang.String r6 = "Can't put button type into json properties"
                        com.mixpanel.android.util.MPLog.c(r0, r6)
                    L68:
                        com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this
                        com.mixpanel.android.mpmetrics.MixpanelAPI r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.b(r6)
                        com.mixpanel.android.mpmetrics.MixpanelAPI$People r6 = r6.C()
                        com.mixpanel.android.mpmetrics.InAppNotification r0 = r3
                        java.lang.String r2 = "$campaign_open"
                        r6.i(r2, r0, r1)
                        com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this
                        r6.finish()
                        com.mixpanel.android.takeoverinapp.TakeoverInAppActivity r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.this
                        int r6 = com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.a(r6)
                        com.mixpanel.android.mpmetrics.UpdateDisplayState.g(r6)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.AnonymousClass3.onClick(android.view.View):void");
                }
            });
            return;
        }
        button.setVisibility(8);
    }

    private void e(ImageView imageView, TextView textView, TextView textView2, ArrayList<Button> arrayList, LinearLayout linearLayout) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(200L);
        imageView.startAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(200L);
        textView.startAnimation(translateAnimation);
        textView2.startAnimation(translateAnimation);
        Iterator<Button> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().startAnimation(translateAnimation);
        }
        linearLayout.startAnimation(AnimationUtils.loadAnimation(this, R$anim.com_mixpanel_android_fade_in));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        UpdateDisplayState.g(this.f19413h);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f19413h = intExtra;
        UpdateDisplayState a8 = UpdateDisplayState.a(intExtra);
        this.f19412g = a8;
        if (a8 == null) {
            MPLog.c("MixpanelAPI.TakeoverInAppActivity", "TakeoverInAppActivity intent received, but nothing was found to show.");
            finish();
            return;
        }
        this.f19411f = MixpanelAPI.z(this, a8.d());
        c();
    }
}
