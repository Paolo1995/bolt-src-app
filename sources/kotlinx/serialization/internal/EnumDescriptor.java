package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: Enums.kt */
/* loaded from: classes5.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: m  reason: collision with root package name */
    private final SerialKind f52169m;

    /* renamed from: n  reason: collision with root package name */
    private final Lazy f52170n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(final String name, final int i8) {
        super(name, null, i8, 2, null);
        Lazy b8;
        Intrinsics.f(name, "name");
        this.f52169m = SerialKind.ENUM.f52123a;
        b8 = LazyKt__LazyJVMKt.b(new Function0<SerialDescriptor[]>() { // from class: kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SerialDescriptor[] invoke() {
                int i9 = i8;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i9];
                for (int i10 = 0; i10 < i9; i10++) {
                    serialDescriptorArr[i10] = SerialDescriptorsKt.d(name + '.' + this.f(i10), StructureKind.OBJECT.f52127a, new SerialDescriptor[0], null, 8, null);
                }
                return serialDescriptorArr;
            }
        });
        this.f52170n = b8;
    }

    private final SerialDescriptor[] s() {
        return (SerialDescriptor[]) this.f52170n.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f52169m;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (serialDescriptor.d() == SerialKind.ENUM.f52123a && Intrinsics.a(i(), serialDescriptor.i()) && Intrinsics.a(Platform_commonKt.a(this), Platform_commonKt.a(serialDescriptor))) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i8) {
        return s()[i8];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int i8;
        int hashCode = i().hashCode();
        int i9 = 1;
        for (String str : SerialDescriptorKt.b(this)) {
            int i10 = i9 * 31;
            if (str != null) {
                i8 = str.hashCode();
            } else {
                i8 = 0;
            }
            i9 = i10 + i8;
        }
        return (hashCode * 31) + i9;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public String toString() {
        String f02;
        Iterable<String> b8 = SerialDescriptorKt.b(this);
        f02 = CollectionsKt___CollectionsKt.f0(b8, ", ", i() + '(', ")", 0, null, null, 56, null);
        return f02;
    }
}
