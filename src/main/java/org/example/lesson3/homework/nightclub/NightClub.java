package org.example.lesson3.homework.nightclub;

import java.util.Iterator;

/*
Внедрить итератор из задания 2 в коллекцию,
написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 */

public class NightClub<T extends Person> implements Iterable<T>{
    private T[] community;

    public NightClub(T[] community) {
        this.community = community;
    }

    public void partyForAll(){
        for (T t : community) {
            t.haveRest();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ParamIterator<T>();
    }

    class ParamIterator<T extends Person> implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < community.length;
        }

        @Override
        public T next() {
            T item = (T)community[index];
            index++;
            return item;
        }
    }
}