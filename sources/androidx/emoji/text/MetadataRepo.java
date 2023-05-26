package androidx.emoji.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.text.emoji.flatbuffer.MetadataList;
import j$.util.Spliterator;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class MetadataRepo {

    /* renamed from: a  reason: collision with root package name */
    private final MetadataList f6381a;

    /* renamed from: b  reason: collision with root package name */
    private final char[] f6382b;

    /* renamed from: c  reason: collision with root package name */
    private final Node f6383c;

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f6384d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Node {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Node> f6385a;

        /* renamed from: b  reason: collision with root package name */
        private EmojiMetadata f6386b;

        private Node() {
            this(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Node a(int i8) {
            SparseArray<Node> sparseArray = this.f6385a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final EmojiMetadata b() {
            return this.f6386b;
        }

        void c(@NonNull EmojiMetadata emojiMetadata, int i8, int i9) {
            Node a8 = a(emojiMetadata.b(i8));
            if (a8 == null) {
                a8 = new Node();
                this.f6385a.put(emojiMetadata.b(i8), a8);
            }
            if (i9 > i8) {
                a8.c(emojiMetadata, i8 + 1, i9);
            } else {
                a8.f6386b = emojiMetadata;
            }
        }

        Node(int i8) {
            this.f6385a = new SparseArray<>(i8);
        }
    }

    MetadataRepo() {
        this.f6384d = null;
        this.f6381a = null;
        this.f6383c = new Node(Spliterator.IMMUTABLE);
        this.f6382b = new char[0];
    }

    private void a(MetadataList metadataList) {
        int j8 = metadataList.j();
        for (int i8 = 0; i8 < j8; i8++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i8);
            Character.toChars(emojiMetadata.f(), this.f6382b, i8 * 2);
            i(emojiMetadata);
        }
    }

    public static MetadataRepo b(@NonNull AssetManager assetManager, String str) throws IOException {
        return new MetadataRepo(Typeface.createFromAsset(assetManager, str), MetadataListReader.b(assetManager, str));
    }

    public static MetadataRepo c(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        return new MetadataRepo(typeface, MetadataListReader.d(byteBuffer));
    }

    public char[] d() {
        return this.f6382b;
    }

    public MetadataList e() {
        return this.f6381a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f6381a.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node g() {
        return this.f6383c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface h() {
        return this.f6384d;
    }

    void i(@NonNull EmojiMetadata emojiMetadata) {
        boolean z7;
        Preconditions.h(emojiMetadata, "emoji metadata cannot be null");
        if (emojiMetadata.c() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "invalid metadata codepoint length");
        this.f6383c.c(emojiMetadata, 0, emojiMetadata.c() - 1);
    }

    private MetadataRepo(@NonNull Typeface typeface, @NonNull MetadataList metadataList) {
        this.f6384d = typeface;
        this.f6381a = metadataList;
        this.f6383c = new Node(Spliterator.IMMUTABLE);
        this.f6382b = new char[metadataList.j() * 2];
        a(metadataList);
    }
}
