package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

/* loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f11881a = new AutoBatchedLogRequestEncoder();

    /* loaded from: classes.dex */
    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final AndroidClientInfoEncoder f11882a = new AndroidClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f11883b = FieldDescriptor.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f11884c = FieldDescriptor.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f11885d = FieldDescriptor.d("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f11886e = FieldDescriptor.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f11887f = FieldDescriptor.d("product");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f11888g = FieldDescriptor.d("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f11889h = FieldDescriptor.d("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f11890i = FieldDescriptor.d("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f11891j = FieldDescriptor.d("locale");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f11892k = FieldDescriptor.d("country");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f11893l = FieldDescriptor.d("mccMnc");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f11894m = FieldDescriptor.d("applicationBuild");

        private AndroidClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f11883b, androidClientInfo.m());
            objectEncoderContext.f(f11884c, androidClientInfo.j());
            objectEncoderContext.f(f11885d, androidClientInfo.f());
            objectEncoderContext.f(f11886e, androidClientInfo.d());
            objectEncoderContext.f(f11887f, androidClientInfo.l());
            objectEncoderContext.f(f11888g, androidClientInfo.k());
            objectEncoderContext.f(f11889h, androidClientInfo.h());
            objectEncoderContext.f(f11890i, androidClientInfo.e());
            objectEncoderContext.f(f11891j, androidClientInfo.g());
            objectEncoderContext.f(f11892k, androidClientInfo.c());
            objectEncoderContext.f(f11893l, androidClientInfo.i());
            objectEncoderContext.f(f11894m, androidClientInfo.b());
        }
    }

    /* loaded from: classes.dex */
    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final BatchedLogRequestEncoder f11895a = new BatchedLogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f11896b = FieldDescriptor.d("logRequest");

        private BatchedLogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f11896b, batchedLogRequest.c());
        }
    }

    /* loaded from: classes.dex */
    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientInfoEncoder f11897a = new ClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f11898b = FieldDescriptor.d("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f11899c = FieldDescriptor.d("androidClientInfo");

        private ClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f11898b, clientInfo.c());
            objectEncoderContext.f(f11899c, clientInfo.b());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventEncoder f11900a = new LogEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f11901b = FieldDescriptor.d("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f11902c = FieldDescriptor.d("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f11903d = FieldDescriptor.d("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f11904e = FieldDescriptor.d("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f11905f = FieldDescriptor.d("sourceExtensionJsonProto3");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f11906g = FieldDescriptor.d("timezoneOffsetSeconds");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f11907h = FieldDescriptor.d("networkConnectionInfo");

        private LogEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f11901b, logEvent.c());
            objectEncoderContext.f(f11902c, logEvent.b());
            objectEncoderContext.b(f11903d, logEvent.d());
            objectEncoderContext.f(f11904e, logEvent.f());
            objectEncoderContext.f(f11905f, logEvent.g());
            objectEncoderContext.b(f11906g, logEvent.h());
            objectEncoderContext.f(f11907h, logEvent.e());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final LogRequestEncoder f11908a = new LogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f11909b = FieldDescriptor.d("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f11910c = FieldDescriptor.d("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f11911d = FieldDescriptor.d("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f11912e = FieldDescriptor.d("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f11913f = FieldDescriptor.d("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f11914g = FieldDescriptor.d("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f11915h = FieldDescriptor.d("qosTier");

        private LogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f11909b, logRequest.g());
            objectEncoderContext.b(f11910c, logRequest.h());
            objectEncoderContext.f(f11911d, logRequest.b());
            objectEncoderContext.f(f11912e, logRequest.d());
            objectEncoderContext.f(f11913f, logRequest.e());
            objectEncoderContext.f(f11914g, logRequest.c());
            objectEncoderContext.f(f11915h, logRequest.f());
        }
    }

    /* loaded from: classes.dex */
    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final NetworkConnectionInfoEncoder f11916a = new NetworkConnectionInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f11917b = FieldDescriptor.d("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f11918c = FieldDescriptor.d("mobileSubtype");

        private NetworkConnectionInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f11917b, networkConnectionInfo.c());
            objectEncoderContext.f(f11918c, networkConnectionInfo.b());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig<?> encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.f11895a;
        encoderConfig.a(BatchedLogRequest.class, batchedLogRequestEncoder);
        encoderConfig.a(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.f11908a;
        encoderConfig.a(LogRequest.class, logRequestEncoder);
        encoderConfig.a(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.f11897a;
        encoderConfig.a(ClientInfo.class, clientInfoEncoder);
        encoderConfig.a(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.f11882a;
        encoderConfig.a(AndroidClientInfo.class, androidClientInfoEncoder);
        encoderConfig.a(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.f11900a;
        encoderConfig.a(LogEvent.class, logEventEncoder);
        encoderConfig.a(AutoValue_LogEvent.class, logEventEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.f11916a;
        encoderConfig.a(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        encoderConfig.a(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
    }
}
