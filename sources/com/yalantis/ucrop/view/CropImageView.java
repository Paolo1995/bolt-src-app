package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class WrapCropBoundsRunnable implements Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j8, float f8, float f9, float f10, float f11, float f12, float f13, boolean z7) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j8;
            this.mOldX = f8;
            this.mOldY = f9;
            this.mCenterDiffX = f10;
            this.mCenterDiffY = f11;
            this.mOldScale = f12;
            this.mDeltaScale = f13;
            this.mWillBeImageInBoundsAfterTranslate = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float easeOut = CubicEasing.easeOut(min, 0.0f, this.mCenterDiffX, (float) this.mDurationMs);
            float easeOut2 = CubicEasing.easeOut(min, 0.0f, this.mCenterDiffY, (float) this.mDurationMs);
            float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (min < ((float) this.mDurationMs)) {
                float[] fArr = cropImageView.mCurrentImageCenter;
                cropImageView.postTranslate(easeOut - (fArr[0] - this.mOldX), easeOut2 - (fArr[1] - this.mOldY));
                if (!this.mWillBeImageInBoundsAfterTranslate) {
                    cropImageView.zoomInImage(this.mOldScale + easeInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                }
                if (!cropImageView.isImageWrapCropBounds()) {
                    cropImageView.post(this);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j8, float f8, float f9, float f10, float f11) {
            this.mCropImageView = new WeakReference<>(cropImageView);
            this.mDurationMs = j8;
            this.mOldScale = f8;
            this.mDeltaScale = f9;
            this.mDestX = f10;
            this.mDestY = f11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.mCropImageView.get();
            if (cropImageView == null) {
                return;
            }
            float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
            float easeInOut = CubicEasing.easeInOut(min, 0.0f, this.mDeltaScale, (float) this.mDurationMs);
            if (min < ((float) this.mDurationMs)) {
                cropImageView.zoomInImage(this.mOldScale + easeInOut, this.mDestX, this.mDestY);
                cropImageView.post(this);
                return;
            }
            cropImageView.setImageToWrapCropBounds();
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] fArr = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        RectF trapToRect = RectUtils.trapToRect(copyOf);
        RectF trapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f8 = trapToRect.left - trapToRect2.left;
        float f9 = trapToRect.top - trapToRect2.top;
        float f10 = trapToRect.right - trapToRect2.right;
        float f11 = trapToRect.bottom - trapToRect2.bottom;
        float[] fArr2 = new float[4];
        if (f8 <= 0.0f) {
            f8 = 0.0f;
        }
        fArr2[0] = f8;
        if (f9 <= 0.0f) {
            f9 = 0.0f;
        }
        fArr2[1] = f9;
        if (f10 >= 0.0f) {
            f10 = 0.0f;
        }
        fArr2[2] = f10;
        if (f11 >= 0.0f) {
            f11 = 0.0f;
        }
        fArr2[3] = f11;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(fArr2);
        return fArr2;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        calculateImageScaleBounds(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private void setupInitialImagePosition(float f8, float f9) {
        float width = this.mCropRect.width();
        float height = this.mCropRect.height();
        float max = Math.max(this.mCropRect.width() / f8, this.mCropRect.height() / f9);
        RectF rectF = this.mCropRect;
        float f10 = ((height - (f9 * max)) / 2.0f) + rectF.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(max, max);
        this.mCurrentImageMatrix.postTranslate(((width - (f8 * max)) / 2.0f) + rectF.left, f10);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(@NonNull Bitmap.CompressFormat compressFormat, int i8, BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle()), new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i8, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    protected boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void onImageLaidOut() {
        int i8;
        int i9;
        int i10;
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
        }
        int i11 = this.mThisWidth;
        float f8 = this.mTargetAspectRatio;
        int i12 = (int) (i11 / f8);
        int i13 = this.mThisHeight;
        if (i12 > i13) {
            this.mCropRect.set((i11 - ((int) (i13 * f8))) / 2, 0.0f, i9 + i10, i13);
        } else {
            this.mCropRect.set(0.0f, (i13 - i12) / 2, i11, i12 + i8);
        }
        calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
        setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        TransformImageView.TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener != null) {
            transformImageListener.onScale(getCurrentScale());
            this.mTransformImageListener.onRotate(getCurrentAngle());
        }
    }

    public void postRotate(float f8) {
        postRotate(f8, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void postScale(float f8, float f9, float f10) {
        if (f8 > 1.0f && getCurrentScale() * f8 <= getMaxScale()) {
            super.postScale(f8, f9, f10);
        } else if (f8 < 1.0f && getCurrentScale() * f8 >= getMinScale()) {
            super.postScale(f8, f9, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processStyledAttributes(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (abs != 0.0f && abs2 != 0.0f) {
            this.mTargetAspectRatio = abs / abs2;
        } else {
            this.mTargetAspectRatio = 0.0f;
        }
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBoundsAnimDuration(long j8) {
        if (j8 > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j8;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(int i8) {
        this.mMaxResultImageSizeX = i8;
    }

    public void setMaxResultImageSizeY(int i8) {
        this.mMaxResultImageSizeY = i8;
    }

    public void setMaxScaleMultiplier(float f8) {
        this.mMaxScaleMultiplier = f8;
    }

    public void setTargetAspectRatio(float f8) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f8;
            return;
        }
        if (f8 == 0.0f) {
            this.mTargetAspectRatio = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.mTargetAspectRatio = f8;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.mCropBoundsChangeListener;
        if (cropBoundsChangeListener != null) {
            cropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zoomImageToPosition(float f8, float f9, float f10, long j8) {
        if (f8 > getMaxScale()) {
            f8 = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j8, currentScale, f8 - currentScale, f9, f10);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public void zoomInImage(float f8) {
        zoomInImage(f8, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f8) {
        zoomOutImage(f8, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(copyOf);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(copyOf).contains(RectUtils.trapToRect(cornersFromRect));
    }

    public void setImageToWrapCropBounds(boolean z7) {
        float f8;
        float max;
        float f9;
        if (!this.mBitmapLaidOut || isImageWrapCropBounds()) {
            return;
        }
        float[] fArr = this.mCurrentImageCenter;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.mCropRect.centerX() - f10;
        float centerY = this.mCropRect.centerY() - f11;
        this.mTempMatrix.reset();
        this.mTempMatrix.setTranslate(centerX, centerY);
        float[] fArr2 = this.mCurrentImageCorners;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.mTempMatrix.mapPoints(copyOf);
        boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
        if (isImageWrapCropBounds) {
            float[] calculateImageIndents = calculateImageIndents();
            f9 = -(calculateImageIndents[1] + calculateImageIndents[3]);
            f8 = -(calculateImageIndents[0] + calculateImageIndents[2]);
            max = 0.0f;
        } else {
            RectF rectF = new RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(getCurrentAngle());
            this.mTempMatrix.mapRect(rectF);
            float[] rectSidesFromCorners = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
            f8 = centerX;
            max = (Math.max(rectF.width() / rectSidesFromCorners[0], rectF.height() / rectSidesFromCorners[1]) * currentScale) - currentScale;
            f9 = centerY;
        }
        if (z7) {
            WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f10, f11, f8, f9, currentScale, max, isImageWrapCropBounds);
            this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
            post(wrapCropBoundsRunnable);
            return;
        }
        postTranslate(f8, f9);
        if (isImageWrapCropBounds) {
            return;
        }
        zoomInImage(currentScale + max, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f8, float f9, float f10) {
        if (f8 <= getMaxScale()) {
            postScale(f8 / getCurrentScale(), f9, f10);
        }
    }

    public void zoomOutImage(float f8, float f9, float f10) {
        if (f8 >= getMinScale()) {
            postScale(f8 / getCurrentScale(), f9, f10);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500L;
    }

    private void calculateImageScaleBounds(float f8, float f9) {
        float min = Math.min(Math.min(this.mCropRect.width() / f8, this.mCropRect.width() / f9), Math.min(this.mCropRect.height() / f9, this.mCropRect.height() / f8));
        this.mMinScale = min;
        this.mMaxScale = min * this.mMaxScaleMultiplier;
    }
}
