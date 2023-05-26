package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Bundle.kt */
/* loaded from: classes.dex */
public final class BundleKt {
    public static final Bundle a(Pair<String, ? extends Object>... pairs) {
        Intrinsics.f(pairs, "pairs");
        Bundle bundle = new Bundle(pairs.length);
        for (Pair<String, ? extends Object> pair : pairs) {
            String a8 = pair.a();
            Object b8 = pair.b();
            if (b8 == null) {
                bundle.putString(a8, null);
            } else if (b8 instanceof Boolean) {
                bundle.putBoolean(a8, ((Boolean) b8).booleanValue());
            } else if (b8 instanceof Byte) {
                bundle.putByte(a8, ((Number) b8).byteValue());
            } else if (b8 instanceof Character) {
                bundle.putChar(a8, ((Character) b8).charValue());
            } else if (b8 instanceof Double) {
                bundle.putDouble(a8, ((Number) b8).doubleValue());
            } else if (b8 instanceof Float) {
                bundle.putFloat(a8, ((Number) b8).floatValue());
            } else if (b8 instanceof Integer) {
                bundle.putInt(a8, ((Number) b8).intValue());
            } else if (b8 instanceof Long) {
                bundle.putLong(a8, ((Number) b8).longValue());
            } else if (b8 instanceof Short) {
                bundle.putShort(a8, ((Number) b8).shortValue());
            } else if (b8 instanceof Bundle) {
                bundle.putBundle(a8, (Bundle) b8);
            } else if (b8 instanceof CharSequence) {
                bundle.putCharSequence(a8, (CharSequence) b8);
            } else if (b8 instanceof Parcelable) {
                bundle.putParcelable(a8, (Parcelable) b8);
            } else if (b8 instanceof boolean[]) {
                bundle.putBooleanArray(a8, (boolean[]) b8);
            } else if (b8 instanceof byte[]) {
                bundle.putByteArray(a8, (byte[]) b8);
            } else if (b8 instanceof char[]) {
                bundle.putCharArray(a8, (char[]) b8);
            } else if (b8 instanceof double[]) {
                bundle.putDoubleArray(a8, (double[]) b8);
            } else if (b8 instanceof float[]) {
                bundle.putFloatArray(a8, (float[]) b8);
            } else if (b8 instanceof int[]) {
                bundle.putIntArray(a8, (int[]) b8);
            } else if (b8 instanceof long[]) {
                bundle.putLongArray(a8, (long[]) b8);
            } else if (b8 instanceof short[]) {
                bundle.putShortArray(a8, (short[]) b8);
            } else if (b8 instanceof Object[]) {
                Class<?> componentType = b8.getClass().getComponentType();
                Intrinsics.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Intrinsics.d(b8, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(a8, (Parcelable[]) b8);
                } else if (String.class.isAssignableFrom(componentType)) {
                    Intrinsics.d(b8, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(a8, (String[]) b8);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    Intrinsics.d(b8, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(a8, (CharSequence[]) b8);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(a8, (Serializable) b8);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + a8 + '\"');
                }
            } else if (b8 instanceof Serializable) {
                bundle.putSerializable(a8, (Serializable) b8);
            } else if (b8 instanceof IBinder) {
                BundleApi18ImplKt.a(bundle, a8, (IBinder) b8);
            } else if (b8 instanceof Size) {
                BundleApi21ImplKt.a(bundle, a8, (Size) b8);
            } else if (b8 instanceof SizeF) {
                BundleApi21ImplKt.b(bundle, a8, (SizeF) b8);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b8.getClass().getCanonicalName() + " for key \"" + a8 + '\"');
            }
        }
        return bundle;
    }
}
