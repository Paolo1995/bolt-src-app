package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class InsetDialogOnTouchListener implements View.OnTouchListener {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Dialog f13386f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13387g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13388h;

    /* renamed from: i  reason: collision with root package name */
    private final int f13389i;

    public InsetDialogOnTouchListener(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f13386f = dialog;
        this.f13387g = rect.left;
        this.f13388h = rect.top;
        this.f13389i = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f13387g + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f13388h + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i8 = this.f13389i;
            obtain.setLocation((-i8) - 1, (-i8) - 1);
        }
        view.performClick();
        return this.f13386f.onTouchEvent(obtain);
    }
}
