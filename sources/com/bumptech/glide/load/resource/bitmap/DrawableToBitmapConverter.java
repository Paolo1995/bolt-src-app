package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class DrawableToBitmapConverter {

    /* renamed from: a  reason: collision with root package name */
    private static final BitmapPool f10460a = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.1
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public void c(Bitmap bitmap) {
        }
    };

    private DrawableToBitmapConverter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resource<Bitmap> a(BitmapPool bitmapPool, Drawable drawable, int i8, int i9) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z7 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(bitmapPool, current, i8, i9);
            z7 = true;
        } else {
            bitmap = null;
        }
        if (!z7) {
            bitmapPool = f10460a;
        }
        return BitmapResource.f(bitmap, bitmapPool);
    }

    private static Bitmap b(BitmapPool bitmapPool, Drawable drawable, int i8, int i9) {
        if (i8 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i9 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i8 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i9 = drawable.getIntrinsicHeight();
            }
            Lock i10 = TransformationUtils.i();
            i10.lock();
            Bitmap d8 = bitmapPool.d(i8, i9, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(d8);
                drawable.setBounds(0, 0, i8, i9);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return d8;
            } finally {
                i10.unlock();
            }
        }
    }
}
