package org.xcolab.util.http.client.queries;

import org.xcolab.util.http.ServiceRequestUtils;
import org.xcolab.util.http.UriBuilder;
import org.xcolab.util.http.caching.CacheKey;
import org.xcolab.util.http.caching.CacheKeys;
import org.xcolab.util.http.caching.CacheName;
import org.xcolab.util.http.client.RestResource;
import org.xcolab.util.http.exceptions.EntityNotFoundException;

/**
 * Represents a GET request to retrieve a specific member from a collection.
 *
 * The constructed HTTP request has the following basic format:
 * {@code GET /resourceName/{resourceId}}.
 *
 * @param <ElementT> the type of the REST resource
 * @param <IdT> the type of the resource's identifier
 */
public class GetQuery<ElementT, IdT> implements CacheableQuery<ElementT, ElementT> {

    private final UriBuilder uriBuilder;
    private final IdT id;
    private final Class<ElementT> entityType;
    private CacheKey<ElementT, ElementT> cacheKey;
    private CacheName cacheName;

    /**
     * Creates a new instance of this query.
     *
     * In most cases, this method is not invoked directly but instead called from a convenience
     * method in the {@link RestResource} class.
     *
     * @see RestResource#get(Object)
     *
     * @param restResource the resource, on which this request is executed
     * @param entityType the type of the resource being retrieved
     * @param id the id of the resource to be retrieved
     */
    public GetQuery(RestResource<ElementT, IdT> restResource, Class<ElementT> entityType, IdT id) {
        this.id = id;
        this.entityType = entityType;
        this.uriBuilder = restResource.getResourceUrl(id);
    }

    /**
     * Executes the GET request.
     *
     * If you expect the endpoint to potentially throw a 404, use {@link #executeChecked()} instead.
     *
     * @return he result of the query
     * @throws org.xcolab.util.http.exceptions.UncheckedEntityNotFoundException if the resource is not found
     */
    @Override
    public ElementT execute() {
        if (cacheName == null) {
            return ServiceRequestUtils.getUnchecked(uriBuilder, entityType);
        } else {
            if (cacheKey == null) {
                cacheKey = CacheKeys.of(entityType, id);
            }
            return ServiceRequestUtils.getUnchecked(uriBuilder, entityType, cacheKey, cacheName);
        }
    }

    /**
     * Executes the GET request, throwing a checked exception if the resource is not found.
     *
     * An {@link EntityNotFoundException} is throw iff the HTTP endpoint returns with a 404 status.
     *
     * @return the result of the query
     * @throws EntityNotFoundException if the resource is not found
     */
    public ElementT executeChecked() throws EntityNotFoundException {
        if (cacheName == null) {
            return ServiceRequestUtils.get(uriBuilder, entityType);
        } else {
            if (cacheKey == null) {
                cacheKey = CacheKeys.withClass(entityType)
                        .withParameter("id", id)
                        .withParameter("query", uriBuilder.getParameterString())
                        .build();
            }
            return ServiceRequestUtils.get(uriBuilder, entityType, cacheKey, cacheName);
        }
    }

    public void deleteFromCache() {
        if (cacheName != null) {
            if (cacheKey == null) {
                cacheKey = CacheKeys.of(entityType, id);
            }
            ServiceRequestUtils.deleteFromCache(cacheKey, cacheName);
        }
    }

    @Override
    public GetQuery<ElementT, IdT> withCache(CacheKey<ElementT, ElementT> cacheKey,
            CacheName cacheName) {
        this.cacheKey = cacheKey;
        this.cacheName = cacheName;
        return this;
    }

    @Override
    public GetQuery<ElementT, IdT> withCache(CacheName cacheName) {
        this.cacheName = cacheName;
        return this;
    }

    @Override
    public GetQuery<ElementT, IdT> queryParam(String name, Object value) {
        uriBuilder.queryParam(name, value);
        return this;
    }

    @Override
    public GetQuery<ElementT, IdT> queryParam(String name, Object... value) {
        uriBuilder.queryParam(name, value);
        return this;
    }

    @Override
    public GetQuery<ElementT, IdT> optionalQueryParam(String name, Object value) {
        uriBuilder.optionalQueryParam(name, value);
        return this;
    }
}
