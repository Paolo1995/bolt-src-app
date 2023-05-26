package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class BytesResource implements Resource<byte[]> {

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f10514f;

    public BytesResource(byte[] bArr) {
        this.f10514f = (byte[]) Preconditions.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: a */
    public byte[] get() {
        return this.f10514f;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.f10514f.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<byte[]> d() {
        return byte[].class;
    }
}
