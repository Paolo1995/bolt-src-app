package eu.bolt.chat.network.engine;

import eu.bolt.chat.data.AuthenticatedUser;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.network.CredentialsProvider;
import eu.bolt.chat.network.data.ChatConfig;
import eu.bolt.chat.network.data.MqttConnection;
import eu.bolt.chat.network.data.MqttWebSocketConfig;
import eu.bolt.chat.network.data.QoS;
import eu.bolt.chat.util.DataEncoderUtilsKt;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLUtilsKt;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: MqttSettings.kt */
/* loaded from: classes5.dex */
public final class BoltMqttSettings implements MqttSettings {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f39394k = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static final short f39395l = UShort.c((short) 443);

    /* renamed from: m  reason: collision with root package name */
    private static final short f39396m = UShort.c((short) 10);

    /* renamed from: a  reason: collision with root package name */
    private final ChatConnectionSettings f39397a;

    /* renamed from: b  reason: collision with root package name */
    private final short f39398b;

    /* renamed from: c  reason: collision with root package name */
    private final short f39399c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39400d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39401e;

    /* renamed from: f  reason: collision with root package name */
    private final QoS f39402f;

    /* renamed from: g  reason: collision with root package name */
    private final QoS f39403g;

    /* renamed from: h  reason: collision with root package name */
    private final String f39404h;

    /* renamed from: i  reason: collision with root package name */
    private final String f39405i;

    /* renamed from: j  reason: collision with root package name */
    private final String f39406j;

    /* compiled from: MqttSettings.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BoltMqttSettings(ChatConnectionSettings chatConnectionSettings) {
        Intrinsics.f(chatConnectionSettings, "chatConnectionSettings");
        this.f39397a = chatConnectionSettings;
        this.f39398b = f39395l;
        this.f39399c = f39396m;
        this.f39401e = true;
        QoS qoS = QoS.AT_LEAST_ONCE;
        this.f39402f = qoS;
        this.f39403g = qoS;
        this.f39404h = "sub/" + chatConnectionSettings.m();
        this.f39405i = "pub/" + chatConnectionSettings.m();
        this.f39406j = "/mqtt";
    }

    private final MqttWebSocketConfig d() {
        boolean H0;
        StringBuilder sb = new StringBuilder();
        ParametersBuilder b8 = ParametersKt.b(0, 1, null);
        DataEncoderUtilsKt.a(b8, "version", this.f39397a.a());
        DataEncoderUtilsKt.a(b8, "device_id", this.f39397a.e());
        DataEncoderUtilsKt.a(b8, "device_name", this.f39397a.f());
        DataEncoderUtilsKt.a(b8, "device_type", this.f39397a.h());
        DataEncoderUtilsKt.a(b8, "session_id", this.f39397a.l());
        DataEncoderUtilsKt.a(b8, "mqtt_client_id", this.f39397a.b());
        if (this.f39397a.c() != null) {
            DataEncoderUtilsKt.a(b8, "country", this.f39397a.c());
        }
        DataEncoderUtilsKt.a(b8, "language", this.f39397a.j());
        URLUtilsKt.e(sb, "", b8, false);
        H0 = StringsKt__StringsKt.H0(sb, '?', false, 2, null);
        if (H0) {
            Intrinsics.e(sb.deleteCharAt(0), "this.deleteCharAt(index)");
        }
        String str = this.f39406j;
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "queryStringBuilder.toString()");
        return new MqttWebSocketConfig(str, sb2);
    }

    @Override // eu.bolt.chat.network.engine.MqttSettings
    public ChatConfig a() {
        return new ChatConfig(this.f39404h, this.f39405i, this.f39402f, this.f39403g, new AuthenticatedUser(this.f39397a.o(), this.f39397a.m(), this.f39397a.n()));
    }

    @Override // eu.bolt.chat.network.engine.MqttSettings
    public CredentialsProvider b() {
        return this.f39397a.d();
    }

    @Override // eu.bolt.chat.network.engine.MqttSettings
    public MqttConnection c() {
        return new MqttConnection(this.f39397a.b(), this.f39397a.k(), this.f39398b, d(), this.f39399c, this.f39400d, this.f39401e, null);
    }
}
