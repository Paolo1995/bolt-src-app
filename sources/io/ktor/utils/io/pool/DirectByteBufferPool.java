package io.ktor.utils.io.pool;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteBufferPools.kt */
/* loaded from: classes5.dex */
public final class DirectByteBufferPool extends DefaultPool<ByteBuffer> {

    /* renamed from: m  reason: collision with root package name */
    private final int f47518m;

    public DirectByteBufferPool() {
        this(0, 0, 3, null);
    }

    public /* synthetic */ DirectByteBufferPool(int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE : i8, (i10 & 2) != 0 ? 4096 : i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: q */
    public ByteBuffer c(ByteBuffer instance) {
        Intrinsics.f(instance, "instance");
        instance.clear();
        instance.order(ByteOrder.BIG_ENDIAN);
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: t */
    public ByteBuffer h() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f47518m);
        Intrinsics.c(allocateDirect);
        return allocateDirect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.ktor.utils.io.pool.DefaultPool
    /* renamed from: w */
    public void m(ByteBuffer instance) {
        boolean z7;
        Intrinsics.f(instance, "instance");
        if (instance.capacity() == this.f47518m) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (instance.isDirect()) {
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public DirectByteBufferPool(int i8, int i9) {
        super(i8);
        this.f47518m = i9;
    }
}
