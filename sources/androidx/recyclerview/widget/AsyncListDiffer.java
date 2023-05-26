package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class AsyncListDiffer<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f6910h = new MainThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private final ListUpdateCallback f6911a;

    /* renamed from: b  reason: collision with root package name */
    final AsyncDifferConfig<T> f6912b;

    /* renamed from: c  reason: collision with root package name */
    Executor f6913c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ListListener<T>> f6914d;

    /* renamed from: e  reason: collision with root package name */
    private List<T> f6915e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private List<T> f6916f;

    /* renamed from: g  reason: collision with root package name */
    int f6917g;

    /* loaded from: classes.dex */
    public interface ListListener<T> {
        void a(@NonNull List<T> list, @NonNull List<T> list2);
    }

    /* loaded from: classes.dex */
    private static class MainThreadExecutor implements Executor {

        /* renamed from: f  reason: collision with root package name */
        final Handler f6926f = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f6926f.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).a());
    }

    private void c(@NonNull List<T> list, Runnable runnable) {
        for (ListListener<T> listListener : this.f6914d) {
            listListener.a(list, this.f6916f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    @NonNull
    public List<T> a() {
        return this.f6916f;
    }

    void b(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, Runnable runnable) {
        List<T> list2 = this.f6916f;
        this.f6915e = list;
        this.f6916f = Collections.unmodifiableList(list);
        diffResult.b(this.f6911a);
        c(list2, runnable);
    }

    public void d(List<T> list) {
        e(list, null);
    }

    public void e(final List<T> list, final Runnable runnable) {
        final int i8 = this.f6917g + 1;
        this.f6917g = i8;
        final List<T> list2 = this.f6915e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f6916f;
        if (list == null) {
            int size = list2.size();
            this.f6915e = null;
            this.f6916f = Collections.emptyList();
            this.f6911a.b(0, size);
            c(list3, runnable);
        } else if (list2 == null) {
            this.f6915e = list;
            this.f6916f = Collections.unmodifiableList(list);
            this.f6911a.a(0, list.size());
            c(list3, runnable);
        } else {
            this.f6912b.a().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult b8 = DiffUtil.b(new DiffUtil.Callback() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean a(int i9, int i10) {
                            Object obj = list2.get(i9);
                            Object obj2 = list.get(i10);
                            if (obj != null && obj2 != null) {
                                return AsyncListDiffer.this.f6912b.b().a(obj, obj2);
                            }
                            if (obj == null && obj2 == null) {
                                return true;
                            }
                            throw new AssertionError();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean b(int i9, int i10) {
                            Object obj = list2.get(i9);
                            Object obj2 = list.get(i10);
                            if (obj != null && obj2 != null) {
                                return AsyncListDiffer.this.f6912b.b().b(obj, obj2);
                            }
                            if (obj == null && obj2 == null) {
                                return true;
                            }
                            return false;
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public Object c(int i9, int i10) {
                            Object obj = list2.get(i9);
                            Object obj2 = list.get(i10);
                            if (obj != null && obj2 != null) {
                                return AsyncListDiffer.this.f6912b.b().c(obj, obj2);
                            }
                            throw new AssertionError();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int d() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int e() {
                            return list2.size();
                        }
                    });
                    AsyncListDiffer.this.f6913c.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.f6917g == i8) {
                                asyncListDiffer.b(list, b8, runnable);
                            }
                        }
                    });
                }
            });
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.f6914d = new CopyOnWriteArrayList();
        this.f6916f = Collections.emptyList();
        this.f6911a = listUpdateCallback;
        this.f6912b = asyncDifferConfig;
        if (asyncDifferConfig.c() != null) {
            this.f6913c = asyncDifferConfig.c();
        } else {
            this.f6913c = f6910h;
        }
    }
}
