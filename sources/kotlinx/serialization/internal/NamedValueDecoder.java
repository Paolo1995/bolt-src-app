package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Tagged.kt */
/* loaded from: classes5.dex */
public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    protected String b0(String parentName, String childName) {
        boolean z7;
        Intrinsics.f(parentName, "parentName");
        Intrinsics.f(childName, "childName");
        if (parentName.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return parentName + '.' + childName;
        }
        return childName;
    }

    protected String c0(SerialDescriptor desc, int i8) {
        Intrinsics.f(desc, "desc");
        return desc.f(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: d0 */
    public final String X(SerialDescriptor serialDescriptor, int i8) {
        Intrinsics.f(serialDescriptor, "<this>");
        return e0(c0(serialDescriptor, i8));
    }

    protected final String e0(String nestedName) {
        Intrinsics.f(nestedName, "nestedName");
        String W = W();
        if (W == null) {
            W = "";
        }
        return b0(W, nestedName);
    }
}
