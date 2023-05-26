package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class GestureDetectorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetectorCompatImpl f5937a;

    /* loaded from: classes.dex */
    interface GestureDetectorCompatImpl {
        boolean a(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f5938a;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f5938a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean a(MotionEvent motionEvent) {
            return this.f5938a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(@NonNull Context context, @NonNull GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(@NonNull MotionEvent motionEvent) {
        return this.f5937a.a(motionEvent);
    }

    public GestureDetectorCompat(@NonNull Context context, @NonNull GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f5937a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
    }
}
