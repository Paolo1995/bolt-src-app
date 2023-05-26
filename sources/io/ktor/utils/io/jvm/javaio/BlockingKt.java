package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: Blocking.kt */
/* loaded from: classes5.dex */
public final class BlockingKt {

    /* renamed from: a */
    private static final Lazy f47486a;

    /* renamed from: b */
    private static final Object f47487b;

    /* renamed from: c */
    private static final Object f47488c;

    static {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Logger>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt$ADAPTER_LOGGER$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Logger invoke() {
                return LoggerFactory.i(BlockingAdapter.class);
            }
        });
        f47486a = b8;
        f47487b = new Object();
        f47488c = new Object();
    }

    public static final /* synthetic */ Logger a() {
        return b();
    }

    public static final Logger b() {
        return (Logger) f47486a.getValue();
    }

    public static final InputStream c(ByteReadChannel byteReadChannel, Job job) {
        Intrinsics.f(byteReadChannel, "<this>");
        return new InputAdapter(job, byteReadChannel);
    }

    public static /* synthetic */ InputStream d(ByteReadChannel byteReadChannel, Job job, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            job = null;
        }
        return c(byteReadChannel, job);
    }
}
