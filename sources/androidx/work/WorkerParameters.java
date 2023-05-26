package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class WorkerParameters {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private UUID f8331a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private Data f8332b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f8333c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private RuntimeExtras f8334d;

    /* renamed from: e  reason: collision with root package name */
    private int f8335e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private Executor f8336f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private TaskExecutor f8337g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private WorkerFactory f8338h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private ProgressUpdater f8339i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private ForegroundUpdater f8340j;

    /* loaded from: classes.dex */
    public static class RuntimeExtras {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public List<String> f8341a = Collections.emptyList();
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f8342b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f8343c;
    }

    public WorkerParameters(@NonNull UUID uuid, @NonNull Data data, @NonNull Collection<String> collection, @NonNull RuntimeExtras runtimeExtras, int i8, @NonNull Executor executor, @NonNull TaskExecutor taskExecutor, @NonNull WorkerFactory workerFactory, @NonNull ProgressUpdater progressUpdater, @NonNull ForegroundUpdater foregroundUpdater) {
        this.f8331a = uuid;
        this.f8332b = data;
        this.f8333c = new HashSet(collection);
        this.f8334d = runtimeExtras;
        this.f8335e = i8;
        this.f8336f = executor;
        this.f8337g = taskExecutor;
        this.f8338h = workerFactory;
        this.f8339i = progressUpdater;
        this.f8340j = foregroundUpdater;
    }

    @NonNull
    public Executor a() {
        return this.f8336f;
    }

    @NonNull
    public ForegroundUpdater b() {
        return this.f8340j;
    }

    @NonNull
    public UUID c() {
        return this.f8331a;
    }

    @NonNull
    public Data d() {
        return this.f8332b;
    }

    @NonNull
    public TaskExecutor e() {
        return this.f8337g;
    }

    @NonNull
    public WorkerFactory f() {
        return this.f8338h;
    }
}
