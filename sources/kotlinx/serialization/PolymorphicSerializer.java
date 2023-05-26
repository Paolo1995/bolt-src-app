package kotlinx.serialization;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* compiled from: PolymorphicSerializer.kt */
/* loaded from: classes5.dex */
public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final KClass<T> f52055a;

    /* renamed from: b  reason: collision with root package name */
    private List<? extends Annotation> f52056b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f52057c;

    public PolymorphicSerializer(KClass<T> baseClass) {
        List<? extends Annotation> k8;
        Lazy a8;
        Intrinsics.f(baseClass, "baseClass");
        this.f52055a = baseClass;
        k8 = CollectionsKt__CollectionsKt.k();
        this.f52056b = k8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<SerialDescriptor>(this) { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ PolymorphicSerializer<T> f52058f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f52058f = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SerialDescriptor invoke() {
                final PolymorphicSerializer<T> polymorphicSerializer = this.f52058f;
                return ContextAwareKt.c(SerialDescriptorsKt.c("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.f52090a, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: kotlinx.serialization.PolymorphicSerializer$descriptor$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                        List<? extends Annotation> list;
                        Intrinsics.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "type", BuiltinSerializersKt.H(StringCompanionObject.f51021a).a(), null, false, 12, null);
                        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, AppMeasurementSdk.ConditionalUserProperty.VALUE, SerialDescriptorsKt.d("kotlinx.serialization.Polymorphic<" + polymorphicSerializer.j().d() + '>', SerialKind.CONTEXTUAL.f52122a, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
                        list = ((PolymorphicSerializer) polymorphicSerializer).f52056b;
                        buildSerialDescriptor.h(list);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                        b(classSerialDescriptorBuilder);
                        return Unit.f50853a;
                    }
                }), this.f52058f.j());
            }
        });
        this.f52057c = a8;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor a() {
        return (SerialDescriptor) this.f52057c.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass<T> j() {
        return this.f52055a;
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + j() + ')';
    }
}
