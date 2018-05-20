/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.diit.dao;

import java.util.List;

/**
 *
 * @author Kamrul
 */
public interface Dao<T> {

    public void save(T value);

    public void update(T value);

    public void delete(T value);

    public T find(T value);

    public List<T> getAll();
}
