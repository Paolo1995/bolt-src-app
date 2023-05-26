package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f13533l = {16842912};

    /* renamed from: i  reason: collision with root package name */
    private boolean f13534i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13535j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13536k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.internal.CheckableImageButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        boolean f13538h;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(@NonNull Parcel parcel) {
            boolean z7 = true;
            if (parcel.readInt() != 1) {
                z7 = false;
            }
            this.f13538h = z7;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f13538h ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.C);
    }

    public boolean a() {
        return this.f13535j;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13534i;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i8) {
        if (this.f13534i) {
            int[] iArr = f13533l;
            return View.mergeDrawableStates(super.onCreateDrawableState(i8 + iArr.length), iArr);
        }
        return super.onCreateDrawableState(i8);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f13538h);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13538h = this.f13534i;
        return savedState;
    }

    public void setCheckable(boolean z7) {
        if (this.f13535j != z7) {
            this.f13535j = z7;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z7) {
        if (this.f13535j && this.f13534i != z7) {
            this.f13534i = z7;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z7) {
        this.f13536k = z7;
    }

    @Override // android.view.View
    public void setPressed(boolean z7) {
        if (this.f13536k) {
            super.setPressed(z7);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f13534i);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f13535j = true;
        this.f13536k = true;
        ViewCompat.s0(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.CheckableImageButton.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void f(View view, @NonNull AccessibilityEvent accessibilityEvent) {
                super.f(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.W(CheckableImageButton.this.a());
                accessibilityNodeInfoCompat.X(CheckableImageButton.this.isChecked());
            }
        });
    }
}
