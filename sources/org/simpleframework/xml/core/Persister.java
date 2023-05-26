package org.simpleframework.xml.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeBuilder;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.transform.Matcher;

/* loaded from: classes5.dex */
public class Persister implements Serializer {
    private final Format format;
    private final SessionManager manager;
    private final Strategy strategy;
    private final Support support;

    public Persister() {
        this(new HashMap());
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, String str) throws Exception {
        return (T) read((Class<? extends Object>) cls, str, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, String str) throws Exception {
        return validate(cls, str, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, OutputNode outputNode) throws Exception {
        try {
            write(obj, outputNode, this.manager.open());
        } finally {
            this.manager.close();
        }
    }

    public Persister(Format format) {
        this(new TreeStrategy(), format);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, File file) throws Exception {
        return (T) read((Class<? extends Object>) cls, file, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, File file) throws Exception {
        return validate(cls, file, true);
    }

    public Persister(Map map) {
        this(new PlatformFilter(map));
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputStream inputStream) throws Exception {
        return (T) read((Class<? extends Object>) cls, inputStream, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputStream inputStream) throws Exception {
        return validate(cls, inputStream, true);
    }

    public Persister(Map map, Format format) {
        this(new PlatformFilter(map));
    }

    private void write(Object obj, OutputNode outputNode, Session session) throws Exception {
        write(obj, outputNode, new Source(this.strategy, this.support, session));
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, Reader reader) throws Exception {
        return (T) read((Class<? extends Object>) cls, reader, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, Reader reader) throws Exception {
        return validate(cls, reader, true);
    }

    public Persister(Filter filter) {
        this(new TreeStrategy(), filter);
    }

    private void write(Object obj, OutputNode outputNode, Context context) throws Exception {
        new Traverser(context).write(outputNode, obj);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputNode inputNode) throws Exception {
        return (T) read((Class<? extends Object>) cls, inputNode, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputNode inputNode) throws Exception {
        return validate(cls, inputNode, true);
    }

    public Persister(Filter filter, Format format) {
        this(new TreeStrategy(), filter, format);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, String str, boolean z7) throws Exception {
        return (T) read((Class<? extends Object>) cls, (Reader) new StringReader(str), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, String str, boolean z7) throws Exception {
        return validate(cls, new StringReader(str), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, File file) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(obj, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    public Persister(Matcher matcher) {
        this(new TreeStrategy(), matcher);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, File file, boolean z7) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return (T) read((Class<? extends Object>) cls, (InputStream) fileInputStream, z7);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, File file, boolean z7) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return validate(cls, fileInputStream, z7);
        } finally {
            fileInputStream.close();
        }
    }

    public Persister(Matcher matcher, Format format) {
        this(new TreeStrategy(), matcher, format);
    }

    public Persister(Strategy strategy) {
        this(strategy, new HashMap());
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, OutputStream outputStream) throws Exception {
        write(obj, outputStream, "utf-8");
    }

    public Persister(Strategy strategy, Format format) {
        this(strategy, new HashMap(), format);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputStream inputStream, boolean z7) throws Exception {
        return (T) read((Class<? extends Object>) cls, NodeBuilder.read(inputStream), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputStream inputStream, boolean z7) throws Exception {
        return validate(cls, NodeBuilder.read(inputStream), z7);
    }

    public void write(Object obj, OutputStream outputStream, String str) throws Exception {
        write(obj, new OutputStreamWriter(outputStream, str));
    }

    public Persister(Filter filter, Matcher matcher) {
        this(new TreeStrategy(), filter, matcher);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, Reader reader, boolean z7) throws Exception {
        return (T) read((Class<? extends Object>) cls, NodeBuilder.read(reader), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, Reader reader, boolean z7) throws Exception {
        return validate(cls, NodeBuilder.read(reader), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public void write(Object obj, Writer writer) throws Exception {
        write(obj, NodeBuilder.write(writer, this.format));
    }

    public Persister(Filter filter, Matcher matcher, Format format) {
        this(new TreeStrategy(), filter, matcher, format);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(Class<? extends T> cls, InputNode inputNode, boolean z7) throws Exception {
        try {
            return (T) read((Class<? extends Object>) cls, inputNode, this.manager.open(z7));
        } finally {
            this.manager.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public boolean validate(Class cls, InputNode inputNode, boolean z7) throws Exception {
        try {
            return validate(cls, inputNode, this.manager.open(z7));
        } finally {
            this.manager.close();
        }
    }

    public Persister(Strategy strategy, Map map) {
        this(strategy, new PlatformFilter(map));
    }

    public Persister(Strategy strategy, Map map, Format format) {
        this(strategy, new PlatformFilter(map), format);
    }

    public Persister(Strategy strategy, Filter filter) {
        this(strategy, filter, new Format());
    }

    private <T> T read(Class<? extends T> cls, InputNode inputNode, Session session) throws Exception {
        return (T) read((Class<? extends Object>) cls, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private boolean validate(Class cls, InputNode inputNode, Session session) throws Exception {
        return validate(cls, inputNode, new Source(this.strategy, this.support, session));
    }

    public Persister(Strategy strategy, Filter filter, Format format) {
        this(strategy, filter, new EmptyMatcher(), format);
    }

    private <T> T read(Class<? extends T> cls, InputNode inputNode, Context context) throws Exception {
        return (T) new Traverser(context).read(inputNode, (Class) cls);
    }

    private boolean validate(Class cls, InputNode inputNode, Context context) throws Exception {
        return new Traverser(context).validate(inputNode, cls);
    }

    public Persister(Strategy strategy, Matcher matcher) {
        this(strategy, new PlatformFilter(), matcher);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, String str) throws Exception {
        return (T) read((Persister) t7, str, true);
    }

    public Persister(Strategy strategy, Matcher matcher, Format format) {
        this(strategy, new PlatformFilter(), matcher, format);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, File file) throws Exception {
        return (T) read((Persister) t7, file, true);
    }

    public Persister(Strategy strategy, Filter filter, Matcher matcher) {
        this(strategy, filter, matcher, new Format());
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, InputStream inputStream) throws Exception {
        return (T) read((Persister) t7, inputStream, true);
    }

    public Persister(Strategy strategy, Filter filter, Matcher matcher, Format format) {
        this.support = new Support(filter, matcher, format);
        this.manager = new SessionManager();
        this.strategy = strategy;
        this.format = format;
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, Reader reader) throws Exception {
        return (T) read((Persister) t7, reader, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, InputNode inputNode) throws Exception {
        return (T) read((Persister) t7, inputNode, true);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, String str, boolean z7) throws Exception {
        return (T) read((Persister) t7, (Reader) new StringReader(str), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, File file, boolean z7) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return (T) read((Persister) t7, (InputStream) fileInputStream, z7);
        } finally {
            fileInputStream.close();
        }
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, InputStream inputStream, boolean z7) throws Exception {
        return (T) read((Persister) t7, NodeBuilder.read(inputStream), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, Reader reader, boolean z7) throws Exception {
        return (T) read((Persister) t7, NodeBuilder.read(reader), z7);
    }

    @Override // org.simpleframework.xml.Serializer
    public <T> T read(T t7, InputNode inputNode, boolean z7) throws Exception {
        try {
            return (T) read((Persister) t7, inputNode, this.manager.open(z7));
        } finally {
            this.manager.close();
        }
    }

    private <T> T read(T t7, InputNode inputNode, Session session) throws Exception {
        return (T) read((Persister) t7, inputNode, (Context) new Source(this.strategy, this.support, session));
    }

    private <T> T read(T t7, InputNode inputNode, Context context) throws Exception {
        return (T) new Traverser(context).read(inputNode, t7);
    }
}
