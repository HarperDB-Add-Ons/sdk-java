package expert.os.harperdb;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class Template {
    private static final Set<String> ALL_ATTRIBUTES = Collections.singleton("*");
    private final String database;
    private final Server server;
    Template(String database, Server server) {
        this.database = database;
        this.server = server;
    }

    public <T> boolean insert(T entity) {
        Objects.requireNonNull(entity, "entity is required");
        var insert = new Insert(database, table(entity), Collections.singletonList(entity));
        return server.execute(insert);
    }

    public <T> boolean insert(Iterable<T> entities) {
        Objects.requireNonNull(entities, "entities is required");
        List<T> beans = StreamSupport.stream(entities.spliterator(), false)
                .toList();
        if(beans.isEmpty()){
           return false;
        }
        String name = table(beans.get(0));
        var insert = new Insert(database, name, beans);
        return server.execute(insert);
    }

    public <T> boolean update(T entity) {
        Objects.requireNonNull(entity, "entity is required");
        var insert = new Update(database, table(entity), Collections.singletonList(entity));
        return server.execute(insert);
    }

    public <T> boolean update(Iterable<T> entities) {
        Objects.requireNonNull(entities, "entities is required");
        List<T> beans = StreamSupport.stream(entities.spliterator(), false)
                .toList();
        if(beans.isEmpty()){
            return false;
        }
        String name = table(beans.get(0));
        var insert = new Update(database, name, beans);
        return server.execute(insert);
    }

    public <T> boolean upsert(T entity) {
        Objects.requireNonNull(entity, "entity is required");
        var insert = new Upsert(database, table(entity), Collections.singletonList(entity));
        return server.execute(insert);
    }

    public <T> boolean upsert(Iterable<T> entities) {
        Objects.requireNonNull(entities, "entities is required");
        List<T> beans = StreamSupport.stream(entities.spliterator(), false)
                .toList();
        if(beans.isEmpty()){
            return false;
        }
        String name = table(beans.get(0));
        var insert = new Upsert(database, name, beans);
        return server.execute(insert);
    }

    public <K> boolean delete(String table, K id) {
        Objects.requireNonNull(table, "table is required");
        Objects.requireNonNull(id, "id is required");
        var delete = new Delete<>(database, table, Collections.singleton(id), ALL_ATTRIBUTES);
        return server.execute(delete);
    }

    public <K, T> boolean delete(Class<T> type, K id) {
        Objects.requireNonNull(type, "type is required");
        Objects.requireNonNull(id, "id is required");
        var delete = new Delete<>(database, table(type), Collections.singleton(id), ALL_ATTRIBUTES);
        return server.execute(delete);
    }

    public <K, T> boolean deleteAllById(Class<T> type, Iterable<K> ids) {
        Objects.requireNonNull(type, "type is required");
        Objects.requireNonNull(ids, "ids is required");
        var keys = StreamSupport.stream(ids.spliterator(), false)
                .collect(Collectors.toSet());
        var delete = new Delete<>(database, table(type), Collections.singleton(keys), ALL_ATTRIBUTES);
        return server.execute(delete);
    }

    public <K> boolean deleteAllById(String table, Iterable<K> ids) {
        Objects.requireNonNull(table, "table is required");
        Objects.requireNonNull(ids, "ids is required");
        var keys = StreamSupport.stream(ids.spliterator(), false)
                .collect(Collectors.toSet());
        var delete = new Delete<>(database, table, keys, ALL_ATTRIBUTES);
        return server.execute(delete);
    }

    public <K, T> Optional<T> findById(K id, Class<T> type) {
        Objects.requireNonNull(id, "id is required");
        Objects.requireNonNull(type, "type is required");
        var search = new SearchById<>(database, table(type), Collections.singleton(id), ALL_ATTRIBUTES);
        return server.singleResult(search, type);
    }

    public <K, T> List<T> findAllById(Iterable<K> ids, Class<T> type) {
        Objects.requireNonNull(ids, "ids is required");
        Objects.requireNonNull(type, "type is required");
        if (ids.spliterator().getExactSizeIfKnown() == 0) {
            return Collections.emptyList();
        }
        var keys = StreamSupport.stream(ids.spliterator(), false)
                .collect(Collectors.toSet());
        var search = new SearchById<>(database, table(type), keys, ALL_ATTRIBUTES);
        return server.result(search, type);
    }

    private <T> String table(T entity) {
        return table(entity.getClass());
    }

    private <T> String table(Class<T> type) {
        return type.getSimpleName().toLowerCase(Locale.US);
    }

}
