package ee.mtakso.driver.utils.gesture_detector;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class IntermediateSimpleOnGestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(@NonNull MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(@NonNull MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
        return false;
    }
}
