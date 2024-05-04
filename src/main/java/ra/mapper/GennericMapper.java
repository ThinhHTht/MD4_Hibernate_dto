package ra.mapper;

public interface GennericMapper<S, E, R> {
    E mapperRequestToEntity(S s);
    R mapperEntityToResponse(E e);
}
