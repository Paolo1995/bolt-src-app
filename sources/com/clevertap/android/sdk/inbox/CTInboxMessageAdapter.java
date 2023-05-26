package com.clevertap.android.sdk.inbox;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.R$layout;
import java.util.ArrayList;

/* loaded from: classes.dex */
class CTInboxMessageAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    private CTInboxListViewFragment f11560d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CTInboxMessage> f11561e;

    /* renamed from: com.clevertap.android.sdk.inbox.CTInboxMessageAdapter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11562a;

        static {
            int[] iArr = new int[CTInboxMessageType.values().length];
            f11562a = iArr;
            try {
                iArr[CTInboxMessageType.SimpleMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11562a[CTInboxMessageType.IconMessage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11562a[CTInboxMessageType.CarouselMessage.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11562a[CTInboxMessageType.CarouselImageMessage.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxMessageAdapter(ArrayList<CTInboxMessage> arrayList, CTInboxListViewFragment cTInboxListViewFragment) {
        this.f11561e = arrayList;
        this.f11560d = cTInboxListViewFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void E(@NonNull RecyclerView.ViewHolder viewHolder, int i8) {
        ((CTInboxBaseMessageViewHolder) viewHolder).R(this.f11561e.get(i8), this.f11560d, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: P */
    public CTInboxBaseMessageViewHolder G(@NonNull ViewGroup viewGroup, int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return null;
                    }
                    return new CTCarouselImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_carousel_layout, viewGroup, false));
                }
                return new CTCarouselMessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_carousel_text_layout, viewGroup, false));
            }
            return new CTIconMessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_icon_message_layout, viewGroup, false));
        }
        return new CTSimpleMessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_simple_message_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f11561e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int t(int i8) {
        int i9 = AnonymousClass1.f11562a[this.f11561e.get(i8).l().ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                return 1;
            }
            if (i9 == 3) {
                return 2;
            }
            if (i9 == 4) {
                return 3;
            }
            return -1;
        }
        return 0;
    }
}
