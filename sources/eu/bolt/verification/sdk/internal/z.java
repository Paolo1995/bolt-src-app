package eu.bolt.verification.sdk.internal;

import android.util.AttributeSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class z {
    public static final int a(AttributeSet attributeSet, String attributeName) {
        Intrinsics.f(attributeSet, "<this>");
        Intrinsics.f(attributeName, "attributeName");
        int attributeCount = attributeSet.getAttributeCount();
        for (int i8 = 0; i8 < attributeCount; i8++) {
            if (Intrinsics.a(attributeName, attributeSet.getAttributeName(i8))) {
                return attributeSet.getAttributeResourceValue(i8, 0);
            }
        }
        return 0;
    }
}
