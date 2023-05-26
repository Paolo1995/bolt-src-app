package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

/* loaded from: classes3.dex */
public class GestureTracker {
    public GestureTracker(MixpanelAPI mixpanelAPI, Activity activity) {
        b(mixpanelAPI, activity);
    }

    private View.OnTouchListener a(final MixpanelAPI mixpanelAPI) {
        return new View.OnTouchListener() { // from class: com.mixpanel.android.viewcrawler.GestureTracker.1

            /* renamed from: f  reason: collision with root package name */
            private long f19479f = -1;

            /* renamed from: g  reason: collision with root package name */
            private long f19480g = -1;

            /* renamed from: h  reason: collision with root package name */
            private int f19481h = 0;

            /* renamed from: i  reason: collision with root package name */
            private long f19482i = -1;

            /* renamed from: j  reason: collision with root package name */
            private boolean f19483j = false;

            /* renamed from: k  reason: collision with root package name */
            private final int f19484k = 100;

            /* renamed from: l  reason: collision with root package name */
            private final int f19485l = 1000;

            /* renamed from: m  reason: collision with root package name */
            private final int f19486m = 2500;

            private void a() {
                this.f19480g = -1L;
                this.f19479f = -1L;
                this.f19481h = 0;
                this.f19482i = -1L;
                this.f19483j = false;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() > 2) {
                    a();
                    return false;
                }
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                if (this.f19483j) {
                                    this.f19480g = System.currentTimeMillis();
                                } else {
                                    a();
                                }
                            }
                        } else if (System.currentTimeMillis() - this.f19480g < 100) {
                            if (System.currentTimeMillis() - this.f19482i > 1000) {
                                a();
                            }
                            this.f19479f = System.currentTimeMillis();
                            this.f19483j = true;
                        } else {
                            a();
                        }
                    } else if (System.currentTimeMillis() - this.f19480g < 100) {
                        if (System.currentTimeMillis() - this.f19479f >= 2500) {
                            if (this.f19481h == 3) {
                                mixpanelAPI.U("$ab_gesture1");
                                a();
                            }
                            this.f19481h = 0;
                        } else {
                            this.f19482i = System.currentTimeMillis();
                            int i8 = this.f19481h;
                            if (i8 < 4) {
                                this.f19481h = i8 + 1;
                            } else if (i8 == 4) {
                                mixpanelAPI.U("$ab_gesture2");
                                a();
                            } else {
                                a();
                            }
                        }
                    }
                } else {
                    this.f19480g = System.currentTimeMillis();
                }
                return false;
            }
        };
    }

    private void b(MixpanelAPI mixpanelAPI, Activity activity) {
        activity.getWindow().getDecorView().setOnTouchListener(a(mixpanelAPI));
    }
}
