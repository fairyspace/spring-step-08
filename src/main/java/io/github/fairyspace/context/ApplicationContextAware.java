package io.github.fairyspace.context;

import io.github.fairyspace.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext);
}
