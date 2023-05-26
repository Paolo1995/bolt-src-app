package ee.mtakso.driver.uikit.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/* compiled from: ImageDelegate.kt */
/* loaded from: classes5.dex */
public interface ImageDelegate {
    <V extends View> void a(ImageRequest imageRequest, V v7, ImageCallback<V> imageCallback);

    void b(ImageRequest imageRequest, ImageView imageView);

    Bitmap c(ImageRequest imageRequest, Context context) throws Exception;
}
