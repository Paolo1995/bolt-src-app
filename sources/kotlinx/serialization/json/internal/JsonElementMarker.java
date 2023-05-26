package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

/* compiled from: JsonElementMarker.kt */
/* loaded from: classes5.dex */
public final class JsonElementMarker {

    /* renamed from: a  reason: collision with root package name */
    private final ElementMarker f52386a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52387b;

    public JsonElementMarker(SerialDescriptor descriptor) {
        Intrinsics.f(descriptor, "descriptor");
        this.f52386a = new ElementMarker(descriptor, new JsonElementMarker$origin$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(SerialDescriptor serialDescriptor, int i8) {
        boolean z7;
        if (!serialDescriptor.j(i8) && serialDescriptor.h(i8).b()) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f52387b = z7;
        return z7;
    }

    public final boolean b() {
        return this.f52387b;
    }

    public final void c(int i8) {
        this.f52386a.a(i8);
    }

    public final int d() {
        return this.f52386a.d();
    }
}
