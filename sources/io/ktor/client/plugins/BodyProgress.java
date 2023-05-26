package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyProgress.kt */
/* loaded from: classes5.dex */
public final class BodyProgress {

    /* renamed from: a  reason: collision with root package name */
    public static final Plugin f46230a = new Plugin(null);

    /* renamed from: b  reason: collision with root package name */
    private static final AttributeKey<BodyProgress> f46231b = new AttributeKey<>("BodyProgress");

    /* compiled from: BodyProgress.kt */
    /* loaded from: classes5.dex */
    public static final class Plugin implements HttpClientPlugin<Unit, BodyProgress> {
        private Plugin() {
        }

        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: c */
        public void a(BodyProgress plugin, HttpClient scope) {
            Intrinsics.f(plugin, "plugin");
            Intrinsics.f(scope, "scope");
            plugin.c(scope);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        /* renamed from: d */
        public BodyProgress b(Function1<? super Unit, Unit> block) {
            Intrinsics.f(block, "block");
            return new BodyProgress();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<BodyProgress> getKey() {
            return BodyProgress.f46231b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(HttpClient httpClient) {
        PipelinePhase pipelinePhase = new PipelinePhase("ObservableContent");
        httpClient.k().j(HttpRequestPipeline.f46627h.b(), pipelinePhase);
        httpClient.k().l(pipelinePhase, new BodyProgress$handle$1(null));
        httpClient.h().l(HttpReceivePipeline.f46657h.a(), new BodyProgress$handle$2(null));
    }
}
