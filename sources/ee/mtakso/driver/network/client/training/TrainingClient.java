package ee.mtakso.driver.network.client.training;

import eu.bolt.driver.core.network.response.BasicServerResponseKt;
import eu.bolt.driver.core.network.response.ServerResponse;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrainingClient.kt */
/* loaded from: classes3.dex */
public final class TrainingClient {

    /* renamed from: a  reason: collision with root package name */
    private TrainingApi f22874a;

    @Inject
    public TrainingClient(TrainingApi api) {
        Intrinsics.f(api, "api");
        this.f22874a = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrainingModal e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (TrainingModal) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Training g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Training) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrainingModal i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (TrainingModal) tmp0.invoke(obj);
    }

    public final Single<TrainingModal> d() {
        Single<ServerResponse<TrainingModal>> b8 = this.f22874a.b();
        final TrainingClient$completeStoriesTraining$1 trainingClient$completeStoriesTraining$1 = new Function1<ServerResponse<TrainingModal>, TrainingModal>() { // from class: ee.mtakso.driver.network.client.training.TrainingClient$completeStoriesTraining$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final TrainingModal invoke(ServerResponse<TrainingModal> it) {
                Intrinsics.f(it, "it");
                return (TrainingModal) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = b8.x(new Function() { // from class: ee.mtakso.driver.network.client.training.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TrainingModal e8;
                e8 = TrainingClient.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "api.completeStoriesTrain…).map { it.exposeData() }");
        return x7;
    }

    public final Single<Training> f() {
        Single<ServerResponse<Training>> a8 = this.f22874a.a();
        final TrainingClient$getStartTraining$1 trainingClient$getStartTraining$1 = new Function1<ServerResponse<Training>, Training>() { // from class: ee.mtakso.driver.network.client.training.TrainingClient$getStartTraining$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Training invoke(ServerResponse<Training> it) {
                Intrinsics.f(it, "it");
                return (Training) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = a8.x(new Function() { // from class: ee.mtakso.driver.network.client.training.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Training g8;
                g8 = TrainingClient.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(x7, "api.getStartTraining().map { it.exposeData() }");
        return x7;
    }

    public final Single<TrainingModal> h() {
        Single<ServerResponse<TrainingModal>> c8 = this.f22874a.c();
        final TrainingClient$getStartTrainingDialog$1 trainingClient$getStartTrainingDialog$1 = new Function1<ServerResponse<TrainingModal>, TrainingModal>() { // from class: ee.mtakso.driver.network.client.training.TrainingClient$getStartTrainingDialog$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final TrainingModal invoke(ServerResponse<TrainingModal> it) {
                Intrinsics.f(it, "it");
                return (TrainingModal) BasicServerResponseKt.a(it);
            }
        };
        Single x7 = c8.x(new Function() { // from class: ee.mtakso.driver.network.client.training.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TrainingModal i8;
                i8 = TrainingClient.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(x7, "api.getStartTrainingModa…).map { it.exposeData() }");
        return x7;
    }
}
