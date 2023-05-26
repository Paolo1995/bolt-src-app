package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i8) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zaa(Drawable drawable, boolean z7, boolean z8, boolean z9);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zab(Context context, zam zamVar, boolean z7) {
        Drawable drawable;
        int i8 = this.zab;
        if (i8 != 0) {
            drawable = context.getResources().getDrawable(i8);
        } else {
            drawable = null;
        }
        zaa(drawable, z7, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zac(Context context, Bitmap bitmap, boolean z7) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
