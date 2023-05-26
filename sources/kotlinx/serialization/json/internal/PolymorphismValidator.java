package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.modules.SerializersModuleCollector;

/* compiled from: PolymorphismValidator.kt */
/* loaded from: classes5.dex */
public final class PolymorphismValidator implements SerializersModuleCollector {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f52421a;

    /* renamed from: b  reason: collision with root package name */
    private final String f52422b;

    public PolymorphismValidator(boolean z7, String discriminator) {
        Intrinsics.f(discriminator, "discriminator");
        this.f52421a = z7;
        this.f52422b = discriminator;
    }

    private final void f(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        int e8 = serialDescriptor.e();
        for (int i8 = 0; i8 < e8; i8++) {
            String f8 = serialDescriptor.f(i8);
            if (Intrinsics.a(f8, this.f52422b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + kClass + " has property '" + f8 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void g(SerialDescriptor serialDescriptor, KClass<?> kClass) {
        SerialKind d8 = serialDescriptor.d();
        if (!(d8 instanceof PolymorphicKind) && !Intrinsics.a(d8, SerialKind.CONTEXTUAL.f52122a)) {
            if (this.f52421a) {
                return;
            }
            if (!Intrinsics.a(d8, StructureKind.LIST.f52125a) && !Intrinsics.a(d8, StructureKind.MAP.f52126a) && !(d8 instanceof PrimitiveKind) && !(d8 instanceof SerialKind.ENUM)) {
                return;
            }
            throw new IllegalArgumentException("Serializer for " + kClass.d() + " of kind " + d8 + " cannot be serialized polymorphically with class discriminator.");
        }
        throw new IllegalArgumentException("Serializer for " + kClass.d() + " can't be registered as a subclass for polymorphic serialization because its kind " + d8 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void a(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer) {
        Intrinsics.f(baseClass, "baseClass");
        Intrinsics.f(actualClass, "actualClass");
        Intrinsics.f(actualSerializer, "actualSerializer");
        SerialDescriptor a8 = actualSerializer.a();
        g(a8, actualClass);
        if (!this.f52421a) {
            f(a8, actualClass);
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void b(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.f(baseClass, "baseClass");
        Intrinsics.f(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void c(KClass<T> kClass, KSerializer<T> kSerializer) {
        SerializersModuleCollector.DefaultImpls.a(this, kClass, kSerializer);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void d(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider) {
        Intrinsics.f(baseClass, "baseClass");
        Intrinsics.f(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void e(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        Intrinsics.f(kClass, "kClass");
        Intrinsics.f(provider, "provider");
    }
}
