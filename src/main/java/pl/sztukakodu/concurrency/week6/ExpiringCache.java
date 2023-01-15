package pl.sztukakodu.concurrency.week6;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExpiringCache<K, V> {
    private final ExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();
    private final ConcurrentMap<K, V> cache = new ConcurrentHashMap<>();

    public ExpiringCache() {
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(cache.get(key));
    }
}
