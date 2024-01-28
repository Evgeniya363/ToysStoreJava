package org.example.service.saving;

import java.io.IOException;

public interface SaveFormatter<T> {
    void save (T object, String path) throws IOException;
}
