package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import java.io.IOException;

/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f12036a = new AutoProtoEncoderDoNotUseEncoder();

    /* loaded from: classes.dex */
    private static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientMetricsEncoder f12037a = new ClientMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12038b = FieldDescriptor.a("window").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f12039c = FieldDescriptor.a("logSourceMetrics").b(AtProtobuf.b().c(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f12040d = FieldDescriptor.a("globalMetrics").b(AtProtobuf.b().c(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f12041e = FieldDescriptor.a("appNamespace").b(AtProtobuf.b().c(4).a()).a();

        private ClientMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f12038b, clientMetrics.d());
            objectEncoderContext.f(f12039c, clientMetrics.c());
            objectEncoderContext.f(f12040d, clientMetrics.b());
            objectEncoderContext.f(f12041e, clientMetrics.a());
        }
    }

    /* loaded from: classes.dex */
    private static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final GlobalMetricsEncoder f12042a = new GlobalMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12043b = FieldDescriptor.a("storageMetrics").b(AtProtobuf.b().c(1).a()).a();

        private GlobalMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f12043b, globalMetrics.a());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventDroppedEncoder f12044a = new LogEventDroppedEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12045b = FieldDescriptor.a("eventsDroppedCount").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f12046c = FieldDescriptor.a("reason").b(AtProtobuf.b().c(3).a()).a();

        private LogEventDroppedEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f12045b, logEventDropped.a());
            objectEncoderContext.f(f12046c, logEventDropped.b());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final LogSourceMetricsEncoder f12047a = new LogSourceMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12048b = FieldDescriptor.a("logSource").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f12049c = FieldDescriptor.a("logEventDropped").b(AtProtobuf.b().c(2).a()).a();

        private LogSourceMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f12048b, logSourceMetrics.b());
            objectEncoderContext.f(f12049c, logSourceMetrics.a());
        }
    }

    /* loaded from: classes.dex */
    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a  reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f12050a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12051b = FieldDescriptor.d("clientMetrics");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.f(f12051b, protoEncoderDoNotUse.b());
        }
    }

    /* loaded from: classes.dex */
    private static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final StorageMetricsEncoder f12052a = new StorageMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12053b = FieldDescriptor.a("currentCacheSizeBytes").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f12054c = FieldDescriptor.a("maxCacheSizeBytes").b(AtProtobuf.b().c(2).a()).a();

        private StorageMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f12053b, storageMetrics.a());
            objectEncoderContext.b(f12054c, storageMetrics.b());
        }
    }

    /* loaded from: classes.dex */
    private static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {

        /* renamed from: a  reason: collision with root package name */
        static final TimeWindowEncoder f12055a = new TimeWindowEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f12056b = FieldDescriptor.a("startMs").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f12057c = FieldDescriptor.a("endMs").b(AtProtobuf.b().c(2).a()).a();

        private TimeWindowEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: b */
        public void a(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f12056b, timeWindow.b());
            objectEncoderContext.b(f12057c, timeWindow.a());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void a(EncoderConfig<?> encoderConfig) {
        encoderConfig.a(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f12050a);
        encoderConfig.a(ClientMetrics.class, ClientMetricsEncoder.f12037a);
        encoderConfig.a(TimeWindow.class, TimeWindowEncoder.f12055a);
        encoderConfig.a(LogSourceMetrics.class, LogSourceMetricsEncoder.f12047a);
        encoderConfig.a(LogEventDropped.class, LogEventDroppedEncoder.f12044a);
        encoderConfig.a(GlobalMetrics.class, GlobalMetricsEncoder.f12042a);
        encoderConfig.a(StorageMetrics.class, StorageMetricsEncoder.f12052a);
    }
}
