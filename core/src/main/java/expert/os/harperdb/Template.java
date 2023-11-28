package expert.os.harperdb;

import java.util.Collections;
import java.util.List;
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
        var insert = new Insert(database, entity.getClass().getSimpleName(), Collections.singletonList(entity));
        return server.insert(insert);
    }

    public <T> boolean insert(Iterable<T> entities) {
        Objects.requireNonNull(entities, "entities is required");
        List<T> beans = StreamSupport.stream(entities.spliterator(), false)
                .toList();
        if(beans.isEmpty()){
           return false;
        }
        String name = beans.get(0).getClass().getSimpleName();
        var insert = new Insert(database, name, Collections.singletonList(beans));
        return server.insert(insert);
    }

}
