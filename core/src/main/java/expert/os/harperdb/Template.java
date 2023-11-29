/*
 *
 * MIT License
 *
 * Copyright (c) 2023 Contributors to the HarperDB
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License, which accompanies
 * this distribution. The full text of the license may be found at
 * https://opensource.org/licenses/MIT.
 *
 * You may elect to redistribute this code under the MIT License.
 *
 * Contributors:
 *
 * Otavio Santana
 */

package expert.os.harperdb;

import java.util.List;
import java.util.Optional;

/**
 * A template interface for generic data manipulation operations.
 */
public interface Template {

    /**
     * Inserts a single entity into the data store.
     *
     * @param entity The entity to be inserted.
     * @param <T>    The type of the entity.
     * @return true if the insertion is successful; false otherwise.
     * @throws NullPointerException if the provided entity is null.
     */
    <T> boolean insert(T entity);

    /**
     * Inserts multiple entities into the data store.
     *
     * @param entities The entities to be inserted.
     * @param <T>      The type of the entities.
     * @return true if the insertion is successful; false otherwise.
     * @throws NullPointerException if the provided entities is null.
     */
    <T> boolean insert(Iterable<T> entities);

    /**
     * Updates a single entity in the data store.
     *
     * @param entity The entity to be updated.
     * @param <T>    The type of the entity.
     * @return true if the update is successful; false otherwise.
     * @throws NullPointerException if the provided entity is null.
     */
    <T> boolean update(T entity);

    /**
     * Updates multiple entities in the data store.
     *
     * @param entities The entities to be updated.
     * @param <T>      The type of the entities.
     * @return true if the update is successful; false otherwise.
     * @throws NullPointerException if the provided entities is null.
     */
    <T> boolean update(Iterable<T> entities);

    /**
     * Upserts (inserts or updates) a single entity into the data store.
     *
     * @param entity The entity to be upserted.
     * @param <T>    The type of the entity.
     * @return true if the upsert is successful; false otherwise.
     * @throws NullPointerException if the provided entity is null.
     */
    <T> boolean upsert(T entity);

    /**
     * Upserts (inserts or updates) multiple entities into the data store.
     *
     * @param entities The entities to be upserted.
     * @param <T>      The type of the entities.
     * @return true if the upsert is successful; false otherwise.
     * @throws NullPointerException if the provided entities is null.
     */
    <T> boolean upsert(Iterable<T> entities);

    /**
     * Deletes an entity by its identifier from the data store.
     *
     * @param table The table or entity type associated with the data.
     *              If provided as a Class or instance, it takes the simple name of the class in lowercase.
     * @param id    The identifier of the entity to be deleted.
     * @param <K>   The type of the identifier.
     * @return true if the deletion is successful; false otherwise.
     * @throws NullPointerException if the provided table or id is null.
     */
    <K> boolean delete(String table, K id);

    /**
     * Deletes an entity by its identifier and type from the data store.
     *
     * @param type The class representing the entity type.
     *             It takes the simple name of the class in lowercase.
     * @param id   The identifier of the entity to be deleted.
     * @param <K>  The type of the identifier.
     * @param <T>  The type of the entity.
     * @return true if the deletion is successful; false otherwise.
     * @throws NullPointerException if the provided type or id is null.
     */
    <K, T> boolean delete(Class<T> type, K id);

    /**
     * Deletes multiple entities by their identifiers and type from the data store.
     *
     * @param type The class representing the entity type.
     *             It takes the simple name of the class in lowercase.
     * @param ids  The identifiers of the entities to be deleted.
     * @param <K>  The type of the identifier.
     * @param <T>  The type of the entity.
     * @return true if the deletion is successful; false otherwise.
     * @throws NullPointerException if the provided type or ids is null.
     */
    <K, T> boolean deleteAllById(Class<T> type, Iterable<K> ids);

    /**
     * Deletes multiple entities by their identifiers and table from the data store.
     *
     * @param table The table or entity type associated with the data.
     *              If provided as a Class or instance, it takes the simple name of the class in lowercase.
     * @param ids   The identifiers of the entities to be deleted.
     * @param <K>   The type of the identifier.
     * @return true if the deletion is successful; false otherwise.
     * @throws NullPointerException if the provided table or ids is null.
     */
    <K> boolean deleteAllById(String table, Iterable<K> ids);

    /**
     * Finds an entity by its identifier and type in the data store.
     *
     * @param id   The identifier of the entity to be retrieved.
     * @param type The class representing the entity type.
     *             It takes the simple name of the class in lowercase.
     * @param <K>  The type of the identifier.
     * @param <T>  The type of the entity.
     * @return an Optional containing the entity if found, or an empty Optional otherwise.
     * @throws NullPointerException if the provided id or type is null.
     */
    <K, T> Optional<T> findById(Class<T> type, K id);

    /**
     * Finds multiple entities by their identifiers and type in the data store.
     *
     * @param ids  The identifiers of the entities to be retrieved.
     * @param type The class representing the entity type.
     *             It takes the simple name of the class in lowercase.
     * @param <K>  The type of the identifier.
     * @param <T>  The type of the entity.
     * @return a List containing the retrieved entities.
     * @throws NullPointerException if the provided ids or type is null.
     */
    <K, T> List<T> findAllById(Class<T> type, Iterable<K> ids);
}
