package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

/* loaded from: classes3.dex */
public class HorizontalProgressWheelView extends View {
    private final Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private Paint mProgressMiddleLinePaint;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    /* loaded from: classes3.dex */
    public interface ScrollingListener {
        void onScroll(float f8, float f9);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    private void init() {
        this.mMiddleLineColor = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.mProgressLinePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth(this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.mProgressLinePaint);
        this.mProgressMiddleLinePaint = paint2;
        paint2.setColor(this.mMiddleLineColor);
        this.mProgressMiddleLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressMiddleLinePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void onScrollEvent(MotionEvent motionEvent, float f8) {
        this.mTotalScrollDistance -= f8;
        postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        ScrollingListener scrollingListener = this.mScrollingListener;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f8, this.mTotalScrollDistance);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int width = this.mCanvasClipBounds.width();
        int i8 = this.mProgressLineWidth;
        int i9 = this.mProgressLineMargin;
        int i10 = width / (i8 + i9);
        float f8 = this.mTotalScrollDistance % (i9 + i8);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i10 / 4;
            if (i11 < i12) {
                this.mProgressLinePaint.setAlpha((int) ((i11 / i12) * 255.0f));
            } else if (i11 > (i10 * 3) / 4) {
                this.mProgressLinePaint.setAlpha((int) (((i10 - i11) / i12) * 255.0f));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            float f9 = -f8;
            Rect rect = this.mCanvasClipBounds;
            float f10 = rect.left + f9 + ((this.mProgressLineWidth + this.mProgressLineMargin) * i11);
            float centerY = rect.centerY() - (this.mProgressLineHeight / 4.0f);
            Rect rect2 = this.mCanvasClipBounds;
            canvas.drawLine(f10, centerY, f9 + rect2.left + ((this.mProgressLineWidth + this.mProgressLineMargin) * i11), rect2.centerY() + (this.mProgressLineHeight / 4.0f), this.mProgressLinePaint);
        }
        canvas.drawLine(this.mCanvasClipBounds.centerX(), this.mCanvasClipBounds.centerY() - (this.mProgressLineHeight / 2.0f), this.mCanvasClipBounds.centerX(), (this.mProgressLineHeight / 2.0f) + this.mCanvasClipBounds.centerY(), this.mProgressMiddleLinePaint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x7 = motionEvent.getX() - this.mLastTouchedPosition;
                    if (x7 != 0.0f) {
                        if (!this.mScrollStarted) {
                            this.mScrollStarted = true;
                            ScrollingListener scrollingListener = this.mScrollingListener;
                            if (scrollingListener != null) {
                                scrollingListener.onScrollStart();
                            }
                        }
                        onScrollEvent(motionEvent, x7);
                    }
                }
            } else {
                ScrollingListener scrollingListener2 = this.mScrollingListener;
                if (scrollingListener2 != null) {
                    this.mScrollStarted = false;
                    scrollingListener2.onScrollEnd();
                }
            }
        } else {
            this.mLastTouchedPosition = motionEvent.getX();
        }
        return true;
    }

    public void setMiddleLineColor(int i8) {
        this.mMiddleLineColor = i8;
        this.mProgressMiddleLinePaint.setColor(i8);
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.mCanvasClipBounds = new Rect();
        init();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        this.mCanvasClipBounds = new Rect();
    }
}
