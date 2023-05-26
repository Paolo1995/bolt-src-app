package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

/* loaded from: classes.dex */
class AppCompatProgressBarHelper {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1876c = {16843067, 16843068};

    /* renamed from: a  reason: collision with root package name */
    private final ProgressBar f1877a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f1878b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i8) {
            int layerGravity;
            int layerWidth;
            int layerHeight;
            int layerInsetLeft;
            int layerInsetRight;
            int layerInsetTop;
            int layerInsetBottom;
            int layerInsetStart;
            int layerInsetEnd;
            layerGravity = layerDrawable.getLayerGravity(i8);
            layerDrawable2.setLayerGravity(i8, layerGravity);
            layerWidth = layerDrawable.getLayerWidth(i8);
            layerDrawable2.setLayerWidth(i8, layerWidth);
            layerHeight = layerDrawable.getLayerHeight(i8);
            layerDrawable2.setLayerHeight(i8, layerHeight);
            layerInsetLeft = layerDrawable.getLayerInsetLeft(i8);
            layerDrawable2.setLayerInsetLeft(i8, layerInsetLeft);
            layerInsetRight = layerDrawable.getLayerInsetRight(i8);
            layerDrawable2.setLayerInsetRight(i8, layerInsetRight);
            layerInsetTop = layerDrawable.getLayerInsetTop(i8);
            layerDrawable2.setLayerInsetTop(i8, layerInsetTop);
            layerInsetBottom = layerDrawable.getLayerInsetBottom(i8);
            layerDrawable2.setLayerInsetBottom(i8, layerInsetBottom);
            layerInsetStart = layerDrawable.getLayerInsetStart(i8);
            layerDrawable2.setLayerInsetStart(i8, layerInsetStart);
            layerInsetEnd = layerDrawable.getLayerInsetEnd(i8);
            layerDrawable2.setLayerInsetEnd(i8, layerInsetEnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.f1877a = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable e(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i8 = 0; i8 < numberOfFrames; i8++) {
                Drawable d8 = d(animationDrawable.getFrame(i8), true);
                d8.setLevel(10000);
                animationDrawable2.addFrame(d8, animationDrawable.getDuration(i8));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b() {
        return this.f1878b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i8) {
        TintTypedArray v7 = TintTypedArray.v(this.f1877a.getContext(), attributeSet, f1876c, i8, 0);
        Drawable h8 = v7.h(0);
        if (h8 != null) {
            this.f1877a.setIndeterminateDrawable(e(h8));
        }
        Drawable h9 = v7.h(1);
        if (h9 != null) {
            this.f1877a.setProgressDrawable(d(h9, false));
        }
        v7.w();
    }

    Drawable d(Drawable drawable, boolean z7) {
        boolean z8;
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable a8 = wrappedDrawable.a();
            if (a8 != null) {
                wrappedDrawable.b(d(a8, z7));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i8 = 0; i8 < numberOfLayers; i8++) {
                int id = layerDrawable.getId(i8);
                Drawable drawable2 = layerDrawable.getDrawable(i8);
                if (id != 16908301 && id != 16908303) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                drawableArr[i8] = d(drawable2, z8);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i9 = 0; i9 < numberOfLayers; i9++) {
                layerDrawable2.setId(i9, layerDrawable.getId(i9));
                if (Build.VERSION.SDK_INT >= 23) {
                    Api23Impl.a(layerDrawable, layerDrawable2, i9);
                }
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1878b == null) {
                this.f1878b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(a());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z7) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
        return drawable;
    }
}
