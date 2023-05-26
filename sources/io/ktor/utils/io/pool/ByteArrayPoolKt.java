package io.ktor.utils.io.pool;

/* compiled from: ByteArrayPool.kt */
/* loaded from: classes5.dex */
public final class ByteArrayPoolKt {

    /* renamed from: a  reason: collision with root package name */
    private static final ObjectPool<byte[]> f47509a = new DefaultPool<byte[]>() { // from class: io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        /* renamed from: q */
        public byte[] h() {
            return new byte[4096];
        }
    };

    public static final ObjectPool<byte[]> a() {
        return f47509a;
    }
}
