package eu.bolt.android.maps.core.container;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileDrawable.kt */
/* loaded from: classes5.dex */
public final class TileDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f36958a;

    public TileDrawable(final Drawable drawable, final Shader.TileMode tileMode) {
        Lazy b8;
        Intrinsics.f(drawable, "drawable");
        Intrinsics.f(tileMode, "tileMode");
        b8 = LazyKt__LazyJVMKt.b(new Function0<Paint>() { // from class: eu.bolt.android.maps.core.container.TileDrawable$paint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Paint invoke() {
                Bitmap b9;
                Paint paint = new Paint();
                TileDrawable tileDrawable = TileDrawable.this;
                Drawable drawable2 = drawable;
                Shader.TileMode tileMode2 = tileMode;
                b9 = tileDrawable.b(drawable2);
                paint.setShader(new BitmapShader(b9, tileMode2, tileMode2));
                return paint;
            }
        });
        this.f36958a = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.e(bitmap, "drawable.bitmap");
            return bitmap;
        }
        Bitmap bitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        Intrinsics.e(bitmap2, "bitmap");
        return bitmap2;
    }

    private final Paint c() {
        return (Paint) this.f36958a.getValue();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        canvas.drawPaint(c());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        c().setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c().setColorFilter(colorFilter);
    }
}
