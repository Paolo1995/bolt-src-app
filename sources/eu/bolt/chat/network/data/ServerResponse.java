package eu.bolt.chat.network.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ServerResponse.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ServerResponse<DATA> {
    public static final Companion Companion = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final SerialDescriptor f39284e;

    /* renamed from: a  reason: collision with root package name */
    private final int f39285a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39286b;

    /* renamed from: c  reason: collision with root package name */
    private final DATA f39287c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39288d;

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T0> KSerializer<ServerResponse<T0>> serializer(KSerializer<T0> typeSerial0) {
            Intrinsics.f(typeSerial0, "typeSerial0");
            return new ServerResponse$$serializer(typeSerial0);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("eu.bolt.chat.network.data.ServerResponse", null, 4);
        pluginGeneratedSerialDescriptor.l("code", false);
        pluginGeneratedSerialDescriptor.l("message", false);
        pluginGeneratedSerialDescriptor.l("data", true);
        pluginGeneratedSerialDescriptor.l("error_hint", true);
        f39284e = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ServerResponse(int i8, int i9, String str, Object obj, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.a(i8, 3, f39284e);
        }
        this.f39285a = i9;
        this.f39286b = str;
        if ((i8 & 4) == 0) {
            this.f39287c = null;
        } else {
            this.f39287c = obj;
        }
        if ((i8 & 8) == 0) {
            this.f39288d = null;
        } else {
            this.f39288d = str2;
        }
    }

    public static final <T0> void d(ServerResponse<T0> self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer<T0> typeSerial0) {
        boolean z7;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        Intrinsics.f(typeSerial0, "typeSerial0");
        boolean z8 = false;
        output.w(serialDesc, 0, ((ServerResponse) self).f39285a);
        output.y(serialDesc, 1, ((ServerResponse) self).f39286b);
        if (output.z(serialDesc, 2) || ((ServerResponse) self).f39287c != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 2, typeSerial0, ((ServerResponse) self).f39287c);
        }
        if (output.z(serialDesc, 3) || ((ServerResponse) self).f39288d != null) {
            z8 = true;
        }
        if (z8) {
            output.i(serialDesc, 3, StringSerializer.f52262a, ((ServerResponse) self).f39288d);
        }
    }

    public final int a() {
        return this.f39285a;
    }

    public final DATA b() {
        return this.f39287c;
    }

    public final String c() {
        return this.f39288d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerResponse) {
            ServerResponse serverResponse = (ServerResponse) obj;
            return this.f39285a == serverResponse.f39285a && Intrinsics.a(this.f39286b, serverResponse.f39286b) && Intrinsics.a(this.f39287c, serverResponse.f39287c) && Intrinsics.a(this.f39288d, serverResponse.f39288d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f39285a * 31) + this.f39286b.hashCode()) * 31;
        DATA data = this.f39287c;
        int hashCode2 = (hashCode + (data == null ? 0 : data.hashCode())) * 31;
        String str = this.f39288d;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ServerResponse(code=" + this.f39285a + ", message=" + this.f39286b + ", data=" + this.f39287c + ", errorHint=" + this.f39288d + ')';
    }
}
