package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TimePickerView extends ConstraintLayout {
    private final Chip E;
    private final Chip F;
    private final ClockHandView G;
    private final ClockFaceView H;
    private final MaterialButtonToggleGroup I;
    private final View.OnClickListener J;
    private OnPeriodChangeListener K;
    private OnSelectionChange L;
    private OnDoubleTapListener M;

    /* loaded from: classes.dex */
    interface OnDoubleTapListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnPeriodChangeListener {
        void a(int i8);
    }

    /* loaded from: classes.dex */
    interface OnSelectionChange {
        void a(int i8);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(MaterialButtonToggleGroup materialButtonToggleGroup, int i8, boolean z7) {
        OnPeriodChangeListener onPeriodChangeListener;
        int i9;
        if (z7 && (onPeriodChangeListener = this.K) != null) {
            if (i8 == R$id.material_clock_period_pm_button) {
                i9 = 1;
            } else {
                i9 = 0;
            }
            onPeriodChangeListener.a(i9);
        }
    }

    private void F() {
        Chip chip = this.E;
        int i8 = R$id.selection_type;
        chip.setTag(i8, 12);
        this.F.setTag(i8, 10);
        this.E.setOnClickListener(this.J);
        this.F.setOnClickListener(this.J);
        this.E.setAccessibilityClassName("android.view.View");
        this.F.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void G() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                OnDoubleTapListener onDoubleTapListener = TimePickerView.this.M;
                if (onDoubleTapListener != null) {
                    onDoubleTapListener.a();
                    return true;
                }
                return false;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.E.setOnTouchListener(onTouchListener);
        this.F.setOnTouchListener(onTouchListener);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i8) {
        super.onVisibilityChanged(view, i8);
        if (view == this && i8 == 0) {
            this.F.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.J = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TimePickerView.this.L != null) {
                    TimePickerView.this.L.a(((Integer) view.getTag(R$id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.H = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.I = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.d
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i9, boolean z7) {
                TimePickerView.this.E(materialButtonToggleGroup2, i9, z7);
            }
        });
        this.E = (Chip) findViewById(R$id.material_minute_tv);
        this.F = (Chip) findViewById(R$id.material_hour_tv);
        this.G = (ClockHandView) findViewById(R$id.material_clock_hand);
        G();
        F();
    }
}
