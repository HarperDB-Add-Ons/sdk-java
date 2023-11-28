package expert.os.harperdb;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.StreamSupport;

public final class Template {
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

    private <T> String table(T entity) {
        return entity.getClass().getSimpleName().toLowerCase(Locale.US);
    }

}
