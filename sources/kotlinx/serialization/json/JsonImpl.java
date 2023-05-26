package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.PolymorphismValidator;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/* compiled from: Json.kt */
/* loaded from: classes5.dex */
final class JsonImpl extends Json {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonImpl(JsonConfiguration configuration, SerializersModule module) {
        super(configuration, module, null);
        Intrinsics.f(configuration, "configuration");
        Intrinsics.f(module, "module");
        i();
    }

    private final void i() {
        if (Intrinsics.a(a(), SerializersModuleBuildersKt.a())) {
            return;
        }
        a().a(new PolymorphismValidator(g().k(), g().c()));
    }
}
