package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class UCropFragment extends Fragment {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    public static final String TAG = "UCropFragment";
    private UCropFragmentCallback callback;
    private int mActiveControlsWidgetColor;
    private View mBlockingView;
    private Transition mControlsTransition;
    private GestureCropImageView mGestureCropImageView;
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    private boolean mShowBottomControls;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private int[] mAllowedGestures = {1, 2, 3};
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() { // from class: com.yalantis.ucrop.UCropFragment.1
        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            UCropFragment.this.mUCropView.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.mBlockingView.setClickable(false);
            UCropFragment.this.callback.loadingProgress(false);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(@NonNull Exception exc) {
            UCropFragment.this.callback.onCropFinish(UCropFragment.this.getError(exc));
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f8) {
            UCropFragment.this.setAngleText(f8);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f8) {
            UCropFragment.this.setScaleText(f8);
        }
    };
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropFragment.this.setWidgetState(view.getId());
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GestureTypes {
    }

    /* loaded from: classes3.dex */
    public class UCropResult {
        public int mResultCode;
        public Intent mResultData;

        public UCropResult(int i8, Intent intent) {
            this.mResultCode = i8;
            this.mResultData = intent;
        }
    }

    static {
        AppCompatDelegate.S(true);
    }

    private void addBlockingView(View view) {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(getContext());
            this.mBlockingView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    private void changeSelectedTab(int i8) {
        int i9;
        int i10;
        if (getView() != null) {
            TransitionManager.b((ViewGroup) getView().findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        }
        View findViewById = this.mWrapperStateScale.findViewById(R.id.text_view_scale);
        int i11 = 0;
        if (i8 == R.id.state_scale) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        findViewById.setVisibility(i9);
        View findViewById2 = this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop);
        if (i8 == R.id.state_aspect_ratio) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        findViewById2.setVisibility(i10);
        View findViewById3 = this.mWrapperStateRotate.findViewById(R.id.text_view_rotate);
        if (i8 != R.id.state_rotate) {
            i11 = 8;
        }
        findViewById3.setVisibility(i11);
    }

    private void initiateRootViews(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    public static UCropFragment newInstance(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    private void processOptions(@NonNull Bundle bundle) {
        Bitmap.CompressFormat compressFormat;
        String string = bundle.getString(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        if (!TextUtils.isEmpty(string)) {
            compressFormat = Bitmap.CompressFormat.valueOf(string);
        } else {
            compressFormat = null;
        }
        if (compressFormat == null) {
            compressFormat = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormat;
        this.mCompressQuality = bundle.getInt(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArray = bundle.getIntArray(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArray != null && intArray.length == 3) {
            this.mAllowedGestures = intArray;
        }
        this.mGestureCropImageView.setMaxBitmapSize(bundle.getInt(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(bundle.getFloat(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(bundle.getInt(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION));
        this.mOverlayView.setFreestyleCropEnabled(bundle.getBoolean(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDimmedColor(bundle.getInt(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(bundle.getBoolean(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(bundle.getBoolean(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(bundle.getInt(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(bundle.getInt(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(bundle.getBoolean(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f8 = bundle.getFloat(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float f9 = bundle.getFloat(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int i8 = bundle.getInt(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (f8 > 0.0f && f9 > 0.0f) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(f8 / f9);
        } else if (parcelableArrayList != null && i8 < parcelableArrayList.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio) parcelableArrayList.get(i8)).getAspectRatioX() / ((AspectRatio) parcelableArrayList.get(i8)).getAspectRatioY());
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        }
        int i9 = bundle.getInt(UCrop.EXTRA_MAX_SIZE_X, 0);
        int i10 = bundle.getInt(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (i9 > 0 && i10 > 0) {
            this.mGestureCropImageView.setMaxResultImageSizeX(i9);
            this.mGestureCropImageView.setMaxResultImageSizeY(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateByAngle(int i8) {
        this.mGestureCropImageView.postRotate(i8);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int i8) {
        boolean z7;
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        int i9 = this.mAllowedGestures[i8];
        boolean z8 = false;
        if (i9 != 3 && i9 != 1) {
            z7 = false;
        } else {
            z7 = true;
        }
        gestureCropImageView.setScaleEnabled(z7);
        GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
        int i10 = this.mAllowedGestures[i8];
        gestureCropImageView2.setRotateEnabled((i10 == 3 || i10 == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngleText(float f8) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f8)));
        }
    }

    private void setAngleTextColor(int i8) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setTextColor(i8);
        }
    }

    private void setImageData(@NonNull Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) bundle.getParcelable(UCrop.EXTRA_OUTPUT_URI);
        processOptions(bundle);
        if (uri != null && uri2 != null) {
            try {
                this.mGestureCropImageView.setImageUri(uri, uri2);
                return;
            } catch (Exception e8) {
                this.callback.onCropFinish(getError(e8));
                return;
            }
        }
        this.callback.onCropFinish(getError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
    }

    private void setInitialState() {
        if (this.mShowBottomControls) {
            if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
                setWidgetState(R.id.state_aspect_ratio);
                return;
            } else {
                setWidgetState(R.id.state_scale);
                return;
            }
        }
        setAllowedGestures(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleText(float f8) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f8 * 100.0f))));
        }
    }

    private void setScaleTextColor(int i8) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setTextColor(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetState(int i8) {
        boolean z7;
        boolean z8;
        boolean z9;
        int i9;
        int i10;
        if (!this.mShowBottomControls) {
            return;
        }
        ViewGroup viewGroup = this.mWrapperStateAspectRatio;
        int i11 = R.id.state_aspect_ratio;
        if (i8 == i11) {
            z7 = true;
        } else {
            z7 = false;
        }
        viewGroup.setSelected(z7);
        ViewGroup viewGroup2 = this.mWrapperStateRotate;
        int i12 = R.id.state_rotate;
        if (i8 == i12) {
            z8 = true;
        } else {
            z8 = false;
        }
        viewGroup2.setSelected(z8);
        ViewGroup viewGroup3 = this.mWrapperStateScale;
        int i13 = R.id.state_scale;
        if (i8 == i13) {
            z9 = true;
        } else {
            z9 = false;
        }
        viewGroup3.setSelected(z9);
        ViewGroup viewGroup4 = this.mLayoutAspectRatio;
        int i14 = 8;
        if (i8 == i11) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        viewGroup4.setVisibility(i9);
        ViewGroup viewGroup5 = this.mLayoutRotate;
        if (i8 == i12) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        viewGroup5.setVisibility(i10);
        ViewGroup viewGroup6 = this.mLayoutScale;
        if (i8 == i13) {
            i14 = 0;
        }
        viewGroup6.setVisibility(i14);
        changeSelectedTab(i8);
        if (i8 == i13) {
            setAllowedGestures(0);
        } else if (i8 == i12) {
            setAllowedGestures(1);
        } else {
            setAllowedGestures(2);
        }
    }

    private void setupAspectRatioWidget(@NonNull Bundle bundle, View view) {
        int i8 = bundle.getInt(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            i8 = 2;
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(i8).setSelected(true);
        for (ViewGroup viewGroup : this.mCropAspectRatioViews) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean z7;
                    UCropFragment.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view2).getChildAt(0)).getAspectRatio(view2.isSelected()));
                    UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (!view2.isSelected()) {
                        for (ViewGroup viewGroup2 : UCropFragment.this.mCropAspectRatioViews) {
                            if (viewGroup2 == view2) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            viewGroup2.setSelected(z7);
                        }
                    }
                }
            });
        }
    }

    private void setupRotateWidget(View view) {
        this.mTextViewRotateAngle = (TextView) view.findViewById(R.id.text_view_rotate);
        int i8 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i8)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropFragment.3
            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f8, float f9) {
                UCropFragment.this.mGestureCropImageView.postRotate(f8 / 42.0f);
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropFragment.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) view.findViewById(i8)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UCropFragment.this.resetRotation();
            }
        });
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UCropFragment.this.rotateByAngle(90);
            }
        });
        setAngleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupScaleWidget(View view) {
        this.mTextViewScalePercent = (TextView) view.findViewById(R.id.text_view_scale);
        int i8 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i8)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropFragment.6
            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f8, float f9) {
                if (f8 > 0.0f) {
                    UCropFragment.this.mGestureCropImageView.zoomInImage(UCropFragment.this.mGestureCropImageView.getCurrentScale() + (f8 * ((UCropFragment.this.mGestureCropImageView.getMaxScale() - UCropFragment.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropFragment.this.mGestureCropImageView.zoomOutImage(UCropFragment.this.mGestureCropImageView.getCurrentScale() + (f8 * ((UCropFragment.this.mGestureCropImageView.getMaxScale() - UCropFragment.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropFragment.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropFragment.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) view.findViewById(i8)).setMiddleLineColor(this.mActiveControlsWidgetColor);
        setScaleTextColor(this.mActiveControlsWidgetColor);
    }

    private void setupStatesWrapper(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    public void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.callback.loadingProgress(true);
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() { // from class: com.yalantis.ucrop.UCropFragment.8
            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public void onBitmapCropped(@NonNull Uri uri, int i8, int i9, int i10, int i11) {
                UCropFragmentCallback uCropFragmentCallback = UCropFragment.this.callback;
                UCropFragment uCropFragment = UCropFragment.this;
                uCropFragmentCallback.onCropFinish(uCropFragment.getResult(uri, uCropFragment.mGestureCropImageView.getTargetAspectRatio(), i8, i9, i10, i11));
                UCropFragment.this.callback.loadingProgress(false);
            }

            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public void onCropFailure(@NonNull Throwable th) {
                UCropFragment.this.callback.onCropFinish(UCropFragment.this.getError(th));
            }
        });
    }

    protected UCropResult getError(Throwable th) {
        return new UCropResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    protected UCropResult getResult(Uri uri, float f8, int i8, int i9, int i10, int i11) {
        return new UCropResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f8).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i10).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i11).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i8).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i9));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof UCropFragmentCallback) {
            this.callback = (UCropFragmentCallback) getParentFragment();
        } else if (context instanceof UCropFragmentCallback) {
            this.callback = (UCropFragmentCallback) context;
        } else {
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        setupViews(inflate, arguments);
        setImageData(arguments);
        setInitialState();
        addBlockingView(inflate);
        return inflate;
    }

    public void setCallback(UCropFragmentCallback uCropFragmentCallback) {
        this.callback = uCropFragmentCallback;
    }

    public void setupViews(View view, Bundle bundle) {
        this.mActiveControlsWidgetColor = bundle.getInt(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_active));
        this.mLogoColor = bundle.getInt(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !bundle.getBoolean(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = bundle.getInt(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(getContext(), R.color.ucrop_color_crop_background));
        initiateRootViews(view);
        this.callback.loadingProgress(true);
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.mControlsTransition = autoTransition;
            autoTransition.c0(CONTROLS_ANIMATION_DURATION);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(bundle, view);
            setupRotateWidget(view);
            setupScaleWidget(view);
            setupStatesWrapper(view);
            return;
        }
        int i8 = R.id.ucrop_frame;
        ((RelativeLayout.LayoutParams) view.findViewById(i8).getLayoutParams()).bottomMargin = 0;
        view.findViewById(i8).requestLayout();
    }
}
