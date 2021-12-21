package be.fooda.backend.address.model.extension;

import java.util.Collection;

public interface AdderRemover<E> {

    boolean add(E e);

    boolean addAll(Collection<? extends E> c);
    
    boolean remove(E e);
}
