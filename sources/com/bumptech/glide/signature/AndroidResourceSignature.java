package com.bumptech.glide.signature;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class AndroidResourceSignature implements Key {

    /* renamed from: b  reason: collision with root package name */
    private final int f10756b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f10757c;

    private AndroidResourceSignature(int i8, Key key) {
        this.f10756b = i8;
        this.f10757c = key;
    }

    @NonNull
    public static Key c(@NonNull Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.c(context));
    }

    @Override // com.bumptech.glide.load.Key
    public void b(@NonNull MessageDigest messageDigest) {
        this.f10757c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f10756b).array());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof AndroidResourceSignature)) {
            return false;
        }
        AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
        if (this.f10756b != androidResourceSignature.f10756b || !this.f10757c.equals(androidResourceSignature.f10757c)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.o(this.f10757c, this.f10756b);
    }
}
