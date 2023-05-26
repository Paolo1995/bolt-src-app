package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ViewInfoStore {

    /* renamed from: a  reason: collision with root package name */
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> f7404a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    final LongSparseArray<RecyclerView.ViewHolder> f7405b = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InfoRecord {

        /* renamed from: d  reason: collision with root package name */
        static Pools$Pool<InfoRecord> f7406d = new Pools$SimplePool(20);

        /* renamed from: a  reason: collision with root package name */
        int f7407a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f7408b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f7409c;

        private InfoRecord() {
        }

        static void a() {
            do {
            } while (f7406d.b() != null);
        }

        static InfoRecord b() {
            InfoRecord b8 = f7406d.b();
            if (b8 == null) {
                return new InfoRecord();
            }
            return b8;
        }

        static void c(InfoRecord infoRecord) {
            infoRecord.f7407a = 0;
            infoRecord.f7408b = null;
            infoRecord.f7409c = null;
            f7406d.a(infoRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface ProcessCallback {
        void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder, int i8) {
        InfoRecord n8;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int g8 = this.f7404a.g(viewHolder);
        if (g8 >= 0 && (n8 = this.f7404a.n(g8)) != null) {
            int i9 = n8.f7407a;
            if ((i9 & i8) != 0) {
                int i10 = (~i8) & i9;
                n8.f7407a = i10;
                if (i8 == 4) {
                    itemHolderInfo = n8.f7408b;
                } else if (i8 == 8) {
                    itemHolderInfo = n8.f7409c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i10 & 12) == 0) {
                    this.f7404a.l(g8);
                    InfoRecord.c(n8);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f7404a.put(viewHolder, infoRecord);
        }
        infoRecord.f7407a |= 2;
        infoRecord.f7408b = itemHolderInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f7404a.put(viewHolder, infoRecord);
        }
        infoRecord.f7407a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j8, RecyclerView.ViewHolder viewHolder) {
        this.f7405b.l(j8, viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f7404a.put(viewHolder, infoRecord);
        }
        infoRecord.f7409c = itemHolderInfo;
        infoRecord.f7407a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f7404a.put(viewHolder, infoRecord);
        }
        infoRecord.f7408b = itemHolderInfo;
        infoRecord.f7407a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f7404a.clear();
        this.f7405b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder g(long j8) {
        return this.f7405b.f(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord != null && (infoRecord.f7407a & 1) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord != null && (infoRecord.f7407a & 4) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        InfoRecord.a();
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        p(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ProcessCallback processCallback) {
        for (int size = this.f7404a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder j8 = this.f7404a.j(size);
            InfoRecord l8 = this.f7404a.l(size);
            int i8 = l8.f7407a;
            if ((i8 & 3) == 3) {
                processCallback.b(j8);
            } else if ((i8 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = l8.f7408b;
                if (itemHolderInfo == null) {
                    processCallback.b(j8);
                } else {
                    processCallback.c(j8, itemHolderInfo, l8.f7409c);
                }
            } else if ((i8 & 14) == 14) {
                processCallback.a(j8, l8.f7408b, l8.f7409c);
            } else if ((i8 & 12) == 12) {
                processCallback.d(j8, l8.f7408b, l8.f7409c);
            } else if ((i8 & 4) != 0) {
                processCallback.c(j8, l8.f7408b, null);
            } else if ((i8 & 8) != 0) {
                processCallback.a(j8, l8.f7408b, l8.f7409c);
            }
            InfoRecord.c(l8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f7404a.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.f7407a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.ViewHolder viewHolder) {
        int o8 = this.f7405b.o() - 1;
        while (true) {
            if (o8 < 0) {
                break;
            } else if (viewHolder == this.f7405b.p(o8)) {
                this.f7405b.n(o8);
                break;
            } else {
                o8--;
            }
        }
        InfoRecord remove = this.f7404a.remove(viewHolder);
        if (remove != null) {
            InfoRecord.c(remove);
        }
    }
}
