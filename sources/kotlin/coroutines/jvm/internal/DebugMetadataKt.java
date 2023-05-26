package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes5.dex */
public final class DebugMetadataKt {
    private static final void a(int i8, int i9) {
        if (i9 <= i8) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i8 + ", got " + i9 + ". Please update the Kotlin standard library.").toString());
    }

    private static final DebugMetadata b(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i8;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i8 = num.intValue();
            } else {
                i8 = 0;
            }
            return i8 - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        int i8;
        String str;
        Intrinsics.f(baseContinuationImpl, "<this>");
        DebugMetadata b8 = b(baseContinuationImpl);
        if (b8 == null) {
            return null;
        }
        a(1, b8.v());
        int c8 = c(baseContinuationImpl);
        if (c8 < 0) {
            i8 = -1;
        } else {
            i8 = b8.l()[c8];
        }
        String b9 = ModuleNameRetriever.f50928a.b(baseContinuationImpl);
        if (b9 == null) {
            str = b8.c();
        } else {
            str = b9 + '/' + b8.c();
        }
        return new StackTraceElement(str, b8.m(), b8.f(), i8);
    }
}
