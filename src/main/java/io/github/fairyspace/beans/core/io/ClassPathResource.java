package io.github.fairyspace.beans.core.io;

import io.github.fairyspace.beans.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, ((ClassLoader) null));
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) throw new FileNotFoundException(path + "文件不存在");
        return is;
    }
}
